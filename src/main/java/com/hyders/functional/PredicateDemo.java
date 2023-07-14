package com.hyders.functional;

import java.util.function.Predicate;

public class PredicateDemo {

    Predicate<String> testStringLength = s->{

        return s.length()>5;
    };

    Predicate<String> checkEvenLength=s->{
        return s.length()%2==0;
    };


    public static void main(String[] args) {

        String testStr = "test code";
        PredicateDemo predicateDemo = new PredicateDemo();
        System.out.println("length is greater than 5" + predicateDemo.testStringLength.test (testStr));
        System.out.println("length is even" + predicateDemo.checkEvenLength.test (testStr));

        System.out.println("length greater than 5 and even" + predicateDemo.testStringLength.and(predicateDemo.checkEvenLength).test(testStr));



    }


}
