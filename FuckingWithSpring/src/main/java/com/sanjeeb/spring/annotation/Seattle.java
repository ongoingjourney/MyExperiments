package com.sanjeeb.spring.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Seattle implements City {

    @Override
    @Value("Greenlake")
    public String getAttraction() {
        return "Green lake";
    }

}
