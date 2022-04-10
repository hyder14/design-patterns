package com.hyders.designpatterns.factory.pizzafactory.abstractfactory;

import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.ingredients.impl.*;

public interface PizzaIngredientFactory {

    Dough createDough();
    Cheese createCheese();
    Sauce createSauce();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClam();



}
