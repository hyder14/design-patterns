package com.hyders.designpatterns.factory.pizzafactory.store;

import com.hyders.designpatterns.factory.pizzafactory.pizza.Pizza;

public abstract class PizzaStore {

    Pizza pizza;


    public Pizza orderPizza(String type) {

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();


        return pizza;

    }



    protected abstract Pizza createPizza(String type);


}
