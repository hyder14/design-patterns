package com.hyders.collections;

import java.util.*;
import java.util.stream.Collectors;

public class Frequency {


    Map<String,Integer> getFrequencyMap(Map<String,Integer> unsortedMap){
        Map<String,Integer> sorted;
        sorted = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldvalue,newvalue)->oldvalue,
                                LinkedHashMap::new
                        ));

        return sorted;

    }


    public static void main(String[] args) {

        Map frequencyMap = new HashMap();

        frequencyMap.put("A",5);
        frequencyMap.put("B",10);
        frequencyMap.put("C",20);
        frequencyMap.put("D",15);
        frequencyMap.put("E",12);


        frequencyMap.entrySet().stream().
                sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        Frequency frequency = new Frequency();

        System.out.println("The frequency map as collected in map are : " + frequency.getFrequencyMap(frequencyMap));



        SortedSet<Map<String,Integer>> sortedSet= new TreeSet<>(frequencyMap.values());

        System.out.println("The sorted set is: " + sortedSet);


    }


}
