package com.hyders.annotations.custom;


import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;

public class TestDriver {

    public static void main(String[] args) {
        CompanyAnnotatedEmployee cae = new CompanyAnnotatedEmployee();
        cae.setId("1");
        cae.setName("Hasan");


        Annotation companyAnnotation = cae.getClass().getAnnotation(Company.class);


        Company company = (Company)companyAnnotation;

        System.out.println("Company: " + company.name() + "\n" +
                "City: " + company.city());


        System.out.println("Checking annotation for NonAnnotated class");

        NonAnnotatedManager nonAnnotatedManager = new NonAnnotatedManager("Ali","5","Development");

        Annotation annotation = nonAnnotatedManager.getClass().getAnnotation(Company.class);

        if (annotation!= null) {
            Company company1 = (Company) annotation;

            System.out.println("Company: " + company1.name() + "\n" +
                    "City: " + company1.city());
        } else {
            System.out.println("No such annotation: " + Company.class.getName());
        }











    }



}
