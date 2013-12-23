package com.sanjeeb.spring.awareinterfaces;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNameAwareClass implements BeanNameAware {
    String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public void sayVariable() {
        System.out.println("Name is " + name);
    }
}
