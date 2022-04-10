package com.hyders.designpatterns.factory.pizzafactory.abstractfactory.pizza;

import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.PizzaIngredientFactory;

public class PepperoniPizza extends Pizza{

    private PizzaIngredientFactory ingredientFactory;


    public PepperoniPizza(PizzaIngredientFactory  pizzaIngredientFactory) {
        this.ingredientFactory = pizzaIngredientFactory;
    }


    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
        pepperoni = ingredientFactory.createPepperoni();
    }
}
