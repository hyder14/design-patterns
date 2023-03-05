package com.hyders.beanoverriding;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.hyders.beanoverriding")
public class TestBeanOverriding {


    @Autowired
    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonService.class);

/*    @Autowired
    private PersonService personService;*/



        public static void main(String args[]){

            PersonService personService = (PersonService) applicationContext.getBean(PersonService.class);


            Person person = (Person)applicationContext.getBean(Person.class);


//            TestBeanOverriding testBeanOverriding = new TestBeanOverriding();

//            Person person = testBeanOverriding.getPerson();


            System.out.println("First Name: " + person.getFirstName() + "; Last Name: " + person.getLastName());

        }

}
