package com.sanjeeb.spring.awareinterfaces;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearningAwareIntefaces {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-awareinterfaces.xml");
        BeanNameAwareClass bean = (BeanNameAwareClass) context.getBean("beanNameAwareClass");
        bean.sayVariable();
    }
}
