package com.sanjeeb.java.concepts;

import java.util.HashMap;

public class MapTestWithCollision {
	public static void main(String[] args) {
		HashMap<Integer, Person> map = new HashMap<>();
		Integer key1 = new Integer(1);
		Integer key2 = new Integer(1);
		Person val1 = new Person("Hannah", 22);
		Person val2 = new Person("Hannah", 22);
		
		map.put(key1, val1);
		map.put(key2, val2);
		
		System.out.println(map.get(key1).equals(map.get(key2)));
		System.out.println(map.get(key2));
	}
}
