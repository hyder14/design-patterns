package com.hyders.designpatterns.builder;

import static com.hyders.designpatterns.builder.NYPizza.Size.Small;

public class Main {

    public static void main(String[] args) {
        NYPizza pizza = new NYPizza.Builder(Small).addTopping(Pizza.Topping.ONION).addTopping(Pizza.Topping.SAUSAGE).build();
        System.out.println(pizza.toString());
    }
}
