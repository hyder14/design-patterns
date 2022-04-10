package com.hyders.designpatterns.factory.pizzafactory.abstractfactory.pizza;

import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.ingredients.*;
import com.hyders.designpatterns.factory.pizzafactory.abstractfactory.ingredients.impl.*;

public abstract class Pizza {

    String name;

    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;


    public abstract void prepare();


    public void bake(){
        System.out.println("Bake the pizza for 25 min at 350 deg");
    }

    public void cut(){
        System.out.println("Cutting the pizza in diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza official PizzaStore box");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("----"+ name + "----\n");

        if (dough!=null) {
            stringBuffer.append(dough);
            stringBuffer.append("\n");
        }

        if (sauce!=null) {
            stringBuffer.append(sauce);
            stringBuffer.append(("\n"));
        }
        if (veggies!=null && veggies.length>0) {
            for (int i=0; i< veggies.length; i++) {
                stringBuffer.append(veggies[i]);
                if (i<veggies.length-1) {
                    stringBuffer.append(", ");
                }
            }
            stringBuffer.append("\n");
        }

        if(cheese!=null) {
            stringBuffer.append(cheese);
        }

        if (pepperoni!=null) {
            stringBuffer.append(pepperoni);
        }

        if (clam!=null) {
            stringBuffer.append(clam);
        }

        return stringBuffer.toString();
    }

}
