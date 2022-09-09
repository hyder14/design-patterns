package com.hyders.jdk8;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapTest {


    private Map<String,Integer> fruitMap = new HashMap<>();


    public MapTest(){
        fruitMap.put("Apples",10);
        fruitMap.put("Oranges",20);
        fruitMap.put("Mangoes",50);

    }

    public static void main(String[] args) {

        MapTest mapTest = new MapTest();
        Optional<Map.Entry<String,Integer>> num = mapTest.fruitMap.entrySet().stream().filter(entry->entry.getKey().equals("Apple")).findAny();

        System.out.println(num.isPresent()?num.get().getValue():"DOES NOT EXIST");

    }

}
