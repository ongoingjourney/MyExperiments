package com.sanjeeb.spring.annotation;

//@Component
public class SanFran implements City {

    @Override
    public String getAttraction() {
        return "Golden Gate Bridge";
    }
}
