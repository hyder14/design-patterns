package com.hyders.designpatterns.factory.pizzafactory.pizza;

import java.util.ArrayList;

public abstract class Pizza {

    String dough;
    String name;
    String sauce;

    ArrayList<String> toppings = new ArrayList<>();

    public Pizza(){}

    public void prepare() {
        System.out.println("Preparing pizza " + getName());
        System.out.println("Tossing dough .." );
        System.out.println("Adding sauce ..");
        System.out.println("Adding toppings ..");

        for (String topping : toppings) {
            System.out.println("Adding topping : " + topping);
        }

    }

    public void bake() {
        System.out.println("Baking pizza for 25 minutes at 350 deg");
    }

    public void cut() {
        System.out.println("Cutting pizza in diagonal shapes");
    }

    public void box() {
        System.out.println("Boxing pizza in official PizzaStore boxes");
    }


    public void setName(String name) {
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
