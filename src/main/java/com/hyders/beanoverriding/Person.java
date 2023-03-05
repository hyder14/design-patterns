package com.hyders.beanoverriding;

public class Person {
    private String firstName;
    private String lastName;

    public Person(String fName,String lName) {
        this.firstName=fName;
        this.lastName=lName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("First Name: " + firstName + ", /n" );
        sb.append("Last Name: " + lastName);

        return sb.toString();

    }
}
