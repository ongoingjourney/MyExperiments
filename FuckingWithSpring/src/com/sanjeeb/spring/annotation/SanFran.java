package com.sanjeeb.spring.annotation;

import org.springframework.stereotype.Component;

//@Component
public class SanFran implements City {

	@Override
	public String getAttraction() {
		return "Golden Gate Bridge";
	}
}
