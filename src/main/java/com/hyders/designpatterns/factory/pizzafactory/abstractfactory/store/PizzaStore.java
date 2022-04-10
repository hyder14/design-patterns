package com.hyders.designpatterns.factory.pizzafactory.abstractfactory.store;

import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.pizza.Pizza;

public abstract class PizzaStore {

    abstract Pizza createPizza(String item);


    public Pizza orderPizza(String type) {

        Pizza pizza = createPizza(type);
        System.out.println("Preparing ... " + pizza.getName());

        pizza.prepare();
        pizza.bake();
        pizza.cut();

        pizza.box();

        return pizza;

    }



}
