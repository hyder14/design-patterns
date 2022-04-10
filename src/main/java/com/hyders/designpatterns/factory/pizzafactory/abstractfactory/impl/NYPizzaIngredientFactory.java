package com.hyders.designpatterns.factory.pizzafactory.abstractfactory.impl;

import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.PizzaIngredientFactory;
//import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.ingredients.impl.Cheese;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.ingredients.impl.Dough;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.ingredients.impl.Sauce;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.ingredients.impl.Cheese;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.ingredients.impl.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {


    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
