package com.hyders.functional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TestDriverFunctionalUtility {


    public static void main(String[] args) {

        Consumer<Integer> displaySquare = (Integer x)->
                System.out.println(square(x));

        Consumer<Integer> square = (Integer x) -> square(x);

        Consumer<List<Integer>>squareList = list -> {
            for (int i=0; i<list.size(); i++) {
                list.set(i,square(list.get(i)));
            }
        };


        Consumer<List<Integer>> addUnitToList = (list) -> {
          for (int i=0; i<list.size(); i++) {
              list.set(i,addOne(list.get(i)));
          }
        };




        Consumer<String> displayItem = (x) -> System.out.println(x);

        Consumer<List<Integer>> displayIntegerList = list -> {
            for (int val : list
                 ) {
                System.out.println(val);
            }
        };

        Consumer<List<Integer>> compositeFunction = squareList.andThen(addUnitToList).andThen(displayIntegerList);

        List<Integer> intList = new ArrayList();


        intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<String> strList = intList.stream().map(x-> x.toString()).collect(Collectors.toList());

        System.out.println("Display items....");
        forEach(strList,displayItem);

        System.out.println("Dislaying squares");
        forEach(intList,displaySquare);


        System.out.println("Squaring and then adding one...");
        compositeFunction.accept(intList);

    }


    public static <T> void forEach(List<T> itemList, Consumer<T> function) {
        for(T item : itemList) {
            function.accept(item);
        }

    }

    public static Integer square(Integer x) {
        return x*x;
    }

    public static Integer addOne(Integer x) {
        return x+1;
    }





}
