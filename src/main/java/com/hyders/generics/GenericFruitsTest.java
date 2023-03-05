package com.hyders.generics;

import java.util.ArrayList;
import java.util.Collection;

public class GenericFruitsTest {



    public static void main(String args[]) {

        Collection<Apple> apples = new ArrayList<>();

        Collection<Banana> bananas = new ArrayList<>();

        Collection<Fruit> applePies = new ArrayList<>();


        ApplePie applePie= new ApplePie();

        ((ArrayList<Fruit>) applePies).add(applePie);


        Collection<Fruit> fruits = new ArrayList<>();


        FruitHelper fruitHelper = new FruitHelper();

        fruitHelper.addApple(apples);

        fruitHelper.eatAll(applePies);

        ((ArrayList<Fruit>) fruits).add(new Banana());

        ((ArrayList<Fruit>) fruits).add(new Apple());

        fruitHelper.eatAll(fruits);

        ((ArrayList<Apple>) apples).add(new Apple());

        fruitHelper.addApple(applePies);











    }

}
