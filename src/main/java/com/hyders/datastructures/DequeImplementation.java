package com.hyders.datastructures;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DequeImplementation {


    public static void addToDeque(){
        Deque<Integer> integerDeque = new ArrayDeque<>();

        List<Integer> intList = IntStream.rangeClosed(1,1000).mapToObj(i-> i+0).collect(Collectors.toList());

        integerDeque.addAll(new ArrayList<>(intList));

        integerDeque.removeIf(x->x%10==0);

        System.out.println(integerDeque);

    }


    public static void main(String[] args) {

        int[] inputArray = new int[]{2,3,4,5,6};

        List<Integer> integerList = Arrays.stream(inputArray).mapToObj(x->x).collect(Collectors.toList());
//        rotateArray(inputArray,5);

        List<Integer> queries = Arrays.asList(0,1,2,3,4);

//        circularArrayRotation(integerList,2,queries);

        circularArrayRotationDeque(integerList,5,queries);

        for (int i=0;i<queries.size();i++){
            System.out.println(queries.get(i));
        }

    }


    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        // Write your code here

        getRotatedList(a, k);

        for (int q=0;q<queries.size();q++) {
            queries.set(q, a.get(queries.get(q)));
        }

        return queries;
    }


    public static List<Integer> circularArrayRotationDeque(List<Integer> a, int k, List<Integer> queries) {
        // Write your code here

       Deque<Integer> rotatedDeque = getRotatedListDeque(a,k);

       List<Integer> rotatedList = rotatedDeque.stream().collect(Collectors.toList());

        for (int q=0;q<queries.size();q++) {
            queries.set(q, rotatedList.get(queries.get(q)));
        }

        return queries;
    }


    public static Deque<Integer> getRotatedListDeque(List<Integer> listForRotation, int k) {

        Deque<Integer> integerDeque = new ArrayDeque<>(listForRotation);

        for (int i=0;i<k;i++) {
            int last =  integerDeque.removeLast();
            integerDeque.addFirst(last);
        }

        return integerDeque;

    }


    public static void getRotatedList(List<Integer> listForRotation, int k) {

        List<Integer> copyOfList= new ArrayList<>(listForRotation);

        if (k>0) {

            int sizeList= copyOfList.size();
            listForRotation.set(0,copyOfList.get(sizeList-1)); //= arrForRotation[size-1];

            for (int i =1;i<copyOfList.size();i++) {
                listForRotation.set(i,copyOfList.get(i-1)); //=arrForRotation[i-1];

            }

            getRotatedList(listForRotation,--k);

        }


    }

    /**
     * [2,3,4,5,6] ; k=1-> [6,2,3,4,5]
     *
     *
     *
     *
     */
    public static void rotateArray(int[] arrForRotation, int num ) {
        int copyOf[] =  Arrays.copyOf(arrForRotation,arrForRotation.length);
        //recursive approach
        if (num>0) {

//            int copyOf[] =  Arrays.copyOf(arrForRotation,arrForRotation.length);

            int size = copyOf.length;
            copyOf[0]= arrForRotation[size-1];

            for (int i =1;i<copyOf.length;i++) {
                copyOf[i]=arrForRotation[i-1];

            }

            rotateArray(copyOf,--num);
            if (num==0) {
                Arrays.stream(copyOf).forEach(System.out::println);
            }

        }


    }

}
