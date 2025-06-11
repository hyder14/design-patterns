package com.hyders.miscellaneous.problems;

public class DoubleAsString {


    public static void main(String[] args) {

//        Double consumedLimit = 5.0;
        int consumedLimit = 5;

//        Double customLimit = 100000.0;
        int customLimit = 100000;

        Integer remaining = customLimit - consumedLimit;

        int decIndex = remaining.toString().indexOf(".");

        if (decIndex<0) {
            decIndex=remaining.toString().length();
        }

        String remainStr = remaining.toString().substring(0, decIndex);


        System.out.println(remainStr);


    }




}
