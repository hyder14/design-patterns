package com.hyders.generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestGenerics {


 public static <T extends Comparable<T>> T getMaximum(List<T> listItems) {

     T max = listItems.get(0);
     for (T item : listItems) {

         if (item.compareTo(max)>0) {
             max = item;
         }
     }

     return max;
 }




    public static void main(String[] args) {
        List intList = Arrays.asList(4,2,6);
        System.out.println(getMaximum(intList));


        char[] charArray = new char[]{'a','b','c','A'};
        List<Character> characterList = new String(charArray)
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());


        System.out.println(getMaximum(characterList));


    }




}
