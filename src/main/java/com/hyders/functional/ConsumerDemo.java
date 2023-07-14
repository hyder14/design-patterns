package com.hyders.functional;

import java.util.function.Consumer;

import com.hyders.functional.FunctionDemo.*;

public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<Integer> doubleAndThenCube= i-> System.out.println(FunctionDemo.doubleMe.andThen(FunctionDemo.cubeMe).apply(i));
//        doubleAndThenCube.accept(5);


        Consumer<Integer> halfTheResult = i-> System.out.println(i/2);


        doubleAndThenCube.andThen(halfTheResult).accept(6);

    }




}
