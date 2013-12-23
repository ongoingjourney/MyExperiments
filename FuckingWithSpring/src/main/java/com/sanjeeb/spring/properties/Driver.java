package com.sanjeeb.spring.properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("spring-properties.xml");
        Person person = (Person) factory.getBean("person");
        System.out.println(person.toString());
    }
}