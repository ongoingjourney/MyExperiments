package com.sanjeeb.spring;

import org.springframework.stereotype.Service;

//@Service
public class Lion implements WildAnimal {
	public String sound() {
		return "Roar";
	}
}