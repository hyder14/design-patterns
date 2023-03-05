package com.hyders.beanoverriding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hyders.beanoverriding.Person;


@Configuration
public class PersonDITest {


       @Autowired
        PersonService personService;

       @Autowired
       Person person;

       @Bean
        PersonService getPersonService(){
           return new PersonService();
       }




}
