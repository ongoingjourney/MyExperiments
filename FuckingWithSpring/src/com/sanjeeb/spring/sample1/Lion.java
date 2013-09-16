package com.sanjeeb.spring.sample1;

import org.springframework.stereotype.Service;

//@Service
public class Lion implements WildAnimal {
	public String sound() {
		return "Roar";
	}
}