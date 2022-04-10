package com.hyders.designpatterns.factory.pizzafactory.abstractfactory.pizza;

import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.PizzaIngredientFactory;

public class ClamPizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.pizzaIngredientFactory=ingredientFactory;
    }

    @Override
    public void prepare() {

        dough=pizzaIngredientFactory.createDough();
        cheese=pizzaIngredientFactory.createCheese();
        sauce=pizzaIngredientFactory.createSauce();
        clam=pizzaIngredientFactory.createClam();

    }
}
