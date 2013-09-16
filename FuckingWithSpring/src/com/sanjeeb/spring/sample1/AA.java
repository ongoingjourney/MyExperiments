package com.sanjeeb.spring.sample1;

import java.util.HashMap;
import java.util.Map;

public class AA {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("one", new Integer(1));
		map.put("two", new Integer(2));
		map.put("two", new Integer(22));
		
		System.out.println(map.get("two"));
	}
}
