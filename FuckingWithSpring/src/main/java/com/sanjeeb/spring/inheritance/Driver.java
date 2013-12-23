package com.sanjeeb.spring.inheritance;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("spring-inheritance.xml");
        //Person person = (Person)factory.getBean("realPerson");
    }
}
