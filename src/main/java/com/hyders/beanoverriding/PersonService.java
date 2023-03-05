package com.hyders.beanoverriding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



public class PersonService {


    @Bean
    public Person getPerson1(){
        Person p = new Person("John", "Doe");
        return p;
    }

    @Primary
    @Bean
    public Person getPerson2(){
        Person p = new Person("Abraham", "Lincoln");
        return p;
    }


}
