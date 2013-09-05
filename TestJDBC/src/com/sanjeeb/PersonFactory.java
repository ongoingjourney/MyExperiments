package com.sanjeeb;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PersonFactory {
	
	public static Map<String, String> getPerson() {
		Map<String, String> person = new HashMap<String, String>();
		person.put("LastName", getRandomString(8));
		person.put("FirstName", getRandomString(12));
		person.put("Address ", getRandomString(30));
		person.put("City", getRandomString(15));
		return person;
	}
	
	private static String getRandomString(int lengthOfName) {
		Random ran = new Random();
		StringBuilder bldr = new StringBuilder();
		for(int i = 0; i < lengthOfName; ++i) {
			int ranInt = ran.nextInt()%25;
			ranInt = ranInt < 0 ? -1*ranInt : ranInt;
			char ranChar = (char)((int)((char)'a') + ranInt);
			bldr.append(ranChar);
		}
		return bldr.toString();		
	}
}