package com.hyders.designpatterns.factory.pizzafactory.store;

import com.hyders.designpatterns.factory.pizzafactory.pizza.NYStyleCheesePizza;
import com.hyders.designpatterns.factory.pizzafactory.pizza.NYStyleVeggiePizza;
import com.hyders.designpatterns.factory.pizzafactory.pizza.Pizza;

public class NYPizzaStore extends PizzaStore {

    public Pizza createPizza(String type) {

        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new NYStyleVeggiePizza();
        }

        else return null;
    }

}
