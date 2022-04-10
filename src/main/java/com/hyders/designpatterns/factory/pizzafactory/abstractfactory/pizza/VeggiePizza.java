package com.hyders.designpatterns.factory.pizzafactory.abstractfactory.pizza;

import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;
    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.pizzaIngredientFactory = ingredientFactory;

    }

    @Override
    public void prepare() {

        System.out.println("Preparing pizza .." + name);
        dough =pizzaIngredientFactory.createDough();
        cheese =pizzaIngredientFactory.createCheese();
        sauce=pizzaIngredientFactory.createSauce();
        veggies = pizzaIngredientFactory.createVeggies();

    }
}


