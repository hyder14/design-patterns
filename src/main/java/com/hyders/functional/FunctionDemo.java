package com.hyders.functional;

import java.util.function.Function;

public class FunctionDemo {

    static Function<Integer,Integer> squareMe= num->{
        return num*num;
    };

    static Function<Integer,Integer> cubeMe = num->{
        return num*num*num;
    };

    static Function<Integer,Integer> doubleMe = num->{
        return 2*num;
    };


    public static void main(String[] args) {


        Function<Integer,Integer> squareMe= num->{
            return num*num;
        };

        Function<Integer,Integer> cubeMe = num->{
            return num*num*num;
        };

        Function<Integer,Integer> doubleMe = num->{
            return 2*num;
        };



        System.out.println("Square of 5 is: " + squareMe.apply(5));

        System.out.println("Function Chaining");


        int result = doubleMe.andThen(cubeMe).apply(2);

        System.out.println("result after andThen " + result);

        result = doubleMe.compose(cubeMe).apply(2);

        System.out.println("result after compose " + result);

    }
}
