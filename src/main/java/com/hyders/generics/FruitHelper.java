package com.hyders.generics;

import java.util.Collection;

public class FruitHelper {

    public FruitHelper(){

    }

    public void eatAll(Collection<? extends Fruit> fruits) {
        System.out.println("Eating all fruits");
        fruits.stream().forEach(System.out::println);
    }

    public void addApple(Collection<? super Apple> apple) {
        System.out.println("Adding " + apple);
    }
}
