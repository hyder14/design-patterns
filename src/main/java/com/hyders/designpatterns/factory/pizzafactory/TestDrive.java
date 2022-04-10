package com.hyders.designpatterns.factory.pizzafactory;

import com.hyders.designpatterns.factory.pizzafactory.store.NYPizzaStore;
import com.hyders.designpatterns.factory.pizzafactory.store.PizzaStore;

public class TestDrive {

    public static void main(String[] args) {
        PizzaStore  pizzaStore = new NYPizzaStore();

        System.out.println("Ordering NY Style cheese Pizza");
        pizzaStore.orderPizza("cheese");


        System.out.println("Ordering NY Style veggie Pizza");
        pizzaStore.orderPizza("veggie");



    }


}
