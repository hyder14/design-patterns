package com.hyders.designpatterns.factory.pizzafactory.pizza;

public class NYStyleVeggiePizza extends Pizza{


    public NYStyleVeggiePizza() {

        name = "NY Style Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Mushroom & Olive Sauce";

        toppings.add("Grated Mozzarella Cheese");

    }

    public void cut() {
        System.out.println("Cutting pizza in square shapes");
    }

    public void box() {
        System.out.println("Boxing pizza in official NYStore Veggie Pizza boxes");
    }


}
