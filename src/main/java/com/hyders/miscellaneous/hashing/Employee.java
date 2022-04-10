package com.hyders.miscellaneous.hashing;

public class Employee {

    private String firstName;
    private String lastName;
    private String dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object obj){

        if (!(obj instanceof Employee) || obj==null) {
            return false;
        }

        Employee other = (Employee) obj;

        return firstName.equals(other.firstName) &&
                lastName.equals(other.lastName) &&
                dateOfBirth.equals(other.dateOfBirth);
    }

    @Override
    public int hashCode(){

        int prime =31;
        int result =1;

        result = result * prime + firstName.hashCode() + lastName.hashCode() + dateOfBirth.hashCode();

        return result;

    }

    @Override
    public String toString(){

        return "First Name: " + firstName + "\n" +
                "Second Name: " + lastName + "\n" +
                "Date of Birth: " + dateOfBirth;
    }


    public static void main (String[] args) {

        Employee employee1 = new Employee();
        employee1.setFirstName("John");
        employee1.setLastName("Doe");
        employee1.setDateOfBirth("01/01/1990");

        Employee employee2 = new Employee();
        employee2.setFirstName("John");
        employee2.setLastName("Doe");
        employee2.setDateOfBirth("01/01/1991");


        System.out.println("The employee instances are equal: " + employee1.equals(employee2));

        System.out.println(String.format("Hash codes are for the two employees are Employee1: %1d; Employee2: %2d",+ employee1.hashCode(),employee2.hashCode()));


        System.out.println(employee1.toString());
        System.out.println(employee2.toString());

    }


}
