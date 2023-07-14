package com.hyders.datastructures;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;


public class MapImplementation {




        public static void main(String[] args) {
            Map<String,String> anOrderedMap = new LinkedHashMap<>();
            Map<String,String> aMap = Collections.synchronizedMap(new HashMap<>());
            Set<String> aHashSet = new HashSet();

            Map<String,String> aHashTable = new Hashtable<>();

            getValueFromMap();

        }


        public static void getValueFromMap() {

            Map<String, Integer> fruits = new LinkedHashMap<>();
            fruits.put("APPLE", 3);
            fruits.put("WATERMELON", 5);
            fruits.put("STRAWBERRY", 10);


            Optional<Map.Entry<String,Integer>> mapEntry = fruits.entrySet().stream().filter(x-> x.getKey().equalsIgnoreCase("APPLE")).findFirst();

            if (mapEntry.isPresent()) {
                System.out.println(mapEntry.get().getValue());
            }



        }


}
