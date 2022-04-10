package com.hyders.reactive;

//import java.util.Observable;
import io.reactivex.Observable;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import reactor.core.publisher.Mono;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;


public class ObservableTest {


    public static void main(String[] args) {

        Observable<Integer> numbers = Observable.just(1,2,3,4,5,6,7,8,9);

        Observable<Integer> filter = numbers.filter(c-> c%2==0);

//        filter.subscribe(System.out::println);

//        printSources();

        System.out.println("Executing printOnChange");
//        printOnChange();

        System.out.println("Executing monoTest");
//        monoTest();


        System.out.println("Executing fluxTest");
//        fluxTest();

        System.out.println("Running odds flux test");
        testNumberGeneration(1000);
    }


    public static void printSources() {

        Path resources = Paths.get("src", "main", "resources");

        try(DirectoryStream<Path> dStream = Files.newDirectoryStream(resources))
        {
            Observable<Path> pathObservable = Observable.<Path>fromIterable(dStream);

            pathObservable.subscribe(System.out::println);

        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }


    private void subscribePrint(Observable observable, String message) {
        System.out.println(message);
        observable.subscribe(System.out:: println);
    }

     public static void printOnChange() {
        List<Integer> integerList = Arrays.asList(2,5,8,12,35,67,89);
         ArrayList<Integer> integerArrayList = new ArrayList<>(integerList);

         Observable observable= Observable.fromIterable(integerArrayList);

        observable.subscribe(x-> System.out.println(x));

         integerArrayList.add(7,100);

     }

     static Integer a = 5;

     public static void monoTest() {

        Mono<Integer> monoJust = Mono.just(a);
        Mono<Integer> monoDefer = Mono.defer(()-> Mono.just(a));
        monoJust.subscribe(integer1-> System.out.println(integer1));

        a=7;
        monoJust.subscribe(integer2-> System.out.println(integer2));

        monoDefer.subscribe(integer3-> System.out.println(integer3));

     }

    public static void fluxTest () {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9);

//        Flux<Integer> integerFlux = Flux.generate(()-> Flux.just(Arrays.asList(1,2,3));

        AtomicInteger atomicInteger = new AtomicInteger();

        Flux<Integer> integerFlux = Flux.generate((SynchronousSink<Integer> synchcronousSink)-> {
//                    System.out.println("Flux Generate");
                    synchcronousSink.next(atomicInteger.getAndIncrement());
                }
        );

//        integerFlux.delayElements(Duration.ofMillis(200))
        integerFlux.delayElements(Duration.ofMillis(5000))
                .subscribe(System.out::println);
//                .subscribe(i-> System.out.println("First consumed :: " + i ));


        Flux<Integer> integerFlux2 = Flux.range(1,4).map(x->x*5).flatMap(value-> Mono.just(value*2));

        integerFlux2.subscribe((i)-> System.out.println(i));

    }

    public boolean isAnOddNumber(int num) {
         return num%2!=0;
    }

    /**
     *
     * @param num
     * @param isOdd
     * @return
     */
    public Flux<Integer> getIntegerGenerator(int num, boolean isOdd) {

         AtomicInteger nextInt = new AtomicInteger();



        Flux<Integer> integerFlux = Flux.generate(
                (SynchronousSink<Integer> sink) -> {
                    int n=nextInt.get();


                    if (n>num) {
                        System.out.println("n: " + n);
                        sink.complete();
                    } else {
                        if (isOdd) {
                            if (!isAnOddNumber(nextInt.getAndIncrement())) {
                                sink.next(nextInt.getAndIncrement());
                                n++; //increment for odd number
                            }
                        } else {
                            if (isAnOddNumber(nextInt.getAndIncrement())) {
                                sink.next(nextInt.getAndIncrement());
                                n++; //increment for even number
                                }
                            }
                        }
                    }
                );

        return integerFlux;
    }


    public void subscribePrintFluxElements(Flux<?> flux ) {
         flux.subscribe((i)-> System.out.println(i));
    }

    public static void testNumberGeneration(int limit) {
         ObservableTest test = new ObservableTest();
         test.subscribePrintFluxElements(test.getIntegerGenerator(limit, true));

         //Now print even numbers
        test.subscribePrintFluxElements(test.getIntegerGenerator(limit,false));
    }

}

class TestDriver{

    public static void main(String[] args) {

        ObservableTest observableTest = new ObservableTest();

        observableTest.subscribePrintFluxElements(observableTest.getIntegerGenerator(20,true));
    }



}
