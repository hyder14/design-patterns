package com.hyders.queue;

import com.hyders.reactive.ObservableTest;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueTest {


    enum QueueType {
        CONCURRENTLINKEDQUEUE,
        QUEUE
    }






    private ConcurrentLinkedQueue<Integer> concurrentLinkedQueue;

    private Queue<Integer> queue;

    public ConcurrentLinkedQueue<Integer> getConcurrentLinkedQueue() {
        return this.concurrentLinkedQueue;
    }
    public void setConcurrentLinkedQueue(ConcurrentLinkedQueue<Integer> queue) {
        this.concurrentLinkedQueue = queue;
    }


    public void writeToQueue(List<Integer> intList, QueueType queueType) {

        if (concurrentLinkedQueue==null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        }

        if (queue==null) {
            queue = new LinkedList<>();
        }

        if(queueType.equals(QueueType.CONCURRENTLINKEDQUEUE))
//            concurrentLinkedQueue.addAll(intList);
            intList.forEach(concurrentLinkedQueue::add);

        if(queueType.equals(QueueType.QUEUE))
//            queue.addAll(intList);
            intList.forEach(queue::add);

    }


    private void testConcurrentLinkedQueue(QueueTest queueTest) {
        System.out.println("=====Testing for ConcurrentLinkedQueue Begin=====");

        /*Write to concurrentLinkedQueue using multiple threads */
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                queueTest.writeToQueue(Arrays.asList(1,3,5,7,9,11,13,17,19,21,23),QueueType.CONCURRENTLINKEDQUEUE);
                queueTest.writeToQueue(new ObservableTest().getIntegerGenerator(100, true).collectList().block(),QueueType.QUEUE);

            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                queueTest.writeToQueue(new ObservableTest().getIntegerGenerator(100,false).collectList().block(),QueueType.CONCURRENTLINKEDQUEUE);
            }
        });


        t1.run();
        t2.run();
        /*As expected, list of integers is added synchronously and will be printed accordingly, establishing
        the thread-safe nature of the concurrentLinkedQueue
        */
        System.out.println("Printing queue elemenets for concurrentLinkedQueue");

        queueTest.concurrentLinkedQueue.forEach(System.out::println);
        System.out.println("=====Testing for ConcurrentLinkedQueue End=====");
    }



    private void testQueue(QueueTest queueTest) {
        System.out.println("=====Testing for Queue Begin=====");

        /*Write to simple Queue using multiple threads */
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Write fixed elements
//                queueTest.writeToQueue(Arrays.asList(1,3,5,7,9,11,13,17,19,21,23),QueueType.QUEUE);

                //Write from an observable
                queueTest.writeToQueue(new ObservableTest().getIntegerGenerator(100,true).collectList().block(),QueueType.QUEUE);

            }
        });


        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                queueTest.writeToQueue(new ObservableTest().getIntegerGenerator(100,false).collectList().block(),QueueType.QUEUE);
            }
        });

        t3.run();
        t4.run();
        /*As expected, list of integers is added synchronously and will be printed accordingly, establishing
        the thread-safe nature of the concurrentLinkedQueue
        */
        System.out.println("Printing queue elemenets for plain queue");

        queueTest.queue.forEach(System.out::println);

        System.out.println("=====Testing for Queue End=====");


    }




    public static void main(String[] args) {

        QueueTest queueTest = new QueueTest();
        queueTest.testConcurrentLinkedQueue(queueTest);
        queueTest.testQueue(queueTest);
    }


}
