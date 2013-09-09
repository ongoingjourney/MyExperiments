package com.sanjeeb.springwithannotation;

import org.springframework.stereotype.Component;

@Component
public class Seattle implements City {

	@Override
	public String getAttraction() {
		return "Green lake";
	}

}
