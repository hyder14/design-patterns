package com.hyders.mutability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Person {

    public String name;

    private List<String> hobbies=new ArrayList<>();

    public Person(String name) {
        this.name=name;
    }

    public Person(String name, List<String> hobbies){
        this.name = name;
        this.hobbies=new ArrayList<>(hobbies);
    }

    public List<String> getHobbies(){
        return this.hobbies;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Name= " + this.name + "\n");

        sb.append("Hobbies= " + printList(hobbies));

        return sb.toString();


    }


    private String printList(List<String> list){

        StringBuilder stringBuilder = new StringBuilder();

       Consumer<List<String>> consumerFunction = strList -> {
           strList.stream().map (x->"\n" +x).forEach(stringBuilder::append);

       };


       consumerFunction.accept(list);

       return stringBuilder.toString();

    }


    public static void main(String[] args) {

        List<String> hobbies = new ArrayList<String>();

        hobbies.addAll(Arrays.asList("Writing","Coding","Cooking","Playing football"));

        Person person = new Person("Joe", hobbies);


        hobbies.add("Playing Cricket");

        ArrayList<String> currentHobbies = (ArrayList<String>)person.getHobbies();


        System.out.println(person.printList(currentHobbies));

//        System.out.println(person.toString());

    }

}


class Employoee extends Person {


    public Employoee(String name){
        super(name);
    }



    public static void main(String args[]) {

        Employoee employee = new Employoee("Hyder");
        employee.name = "Kamran";
        System.out.println(employee.toString());
    }




}