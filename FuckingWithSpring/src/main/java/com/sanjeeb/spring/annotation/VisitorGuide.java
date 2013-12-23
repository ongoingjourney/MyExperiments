package com.sanjeeb.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisitorGuide {
    @Autowired
    City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCurrentCityGuide() {
        return "Visitor info for the city of " + city.getClass().getSimpleName() + " is " + city.getAttraction();
    }


}
