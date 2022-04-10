package com.hyders.designpatterns.factory.pizzafactory.abstractfactory.store;

import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.PizzaIngredientFactory;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.impl.NYPizzaIngredientFactory;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.ingredients.impl.SlicedPepperoni;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.pizza.CheesePizza;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.pizza.ClamPizza;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.pizza.PepperoniPizza;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.pizza.VeggiePizza;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.pizza.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {

        Pizza pizza = null;

        //Initialize PizzaIngredientFactory

        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();

        if (type.equalsIgnoreCase("cheese")) {
            Pizza cheesePizza  = new CheesePizza(pizzaIngredientFactory);
            cheesePizza.setName("New York Style Cheese Pizza");
            return cheesePizza;

        } else if (type.equals("veggie")) {

            Pizza veggiePizza = new VeggiePizza(pizzaIngredientFactory);
            veggiePizza.setName("New York Style Veggie Pizza");
            return veggiePizza;

        } else if (type.equals("clam")) {
            Pizza clamPizza = new ClamPizza(pizzaIngredientFactory);
            clamPizza.setName("New York Style Clam Pizza");
            return clamPizza;

        } else if (type.equals("pepperoni")) {

            PepperoniPizza slicedPepperoniPizza = new PepperoniPizza(pizzaIngredientFactory);
            slicedPepperoniPizza.setName("New York Style Pepperoni Pizza");
            return slicedPepperoniPizza;
        }

            return pizza;
    }

}
