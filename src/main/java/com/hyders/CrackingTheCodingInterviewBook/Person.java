package com.hyders.CrackingTheCodingInterviewBook;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private List personList = new ArrayList<>();
    private String firstName;
    private String lastName;

    static class type{
        static String type = "Employee";

        static String getType(){
            return type;
        }

    }

    static String name = "John F Kennedy";

    public static String getName(){

        return name;
    }



    public static void main(String args[]) {

        System.out.println(Person.getName());

        System.out.println(type.getType());

    }

    @Override
    public void finalize(){


        System.out.println("Inside finalize");


    }


}
