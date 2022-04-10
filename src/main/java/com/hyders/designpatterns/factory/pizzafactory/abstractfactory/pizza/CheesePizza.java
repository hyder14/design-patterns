package com.hyders.designpatterns.factory.pizzafactory.abstractfactory.pizza;

import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.PizzaIngredientFactory;

public class CheesePizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.pizzaIngredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing ... " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }




}
