package com.sanjeeb.java.concepts;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		AbstractMap<String, String> aHashMap = new HashMap<>();
		aHashMap.put(null, "abc");
		aHashMap.put("null", "def");
		aHashMap.put("", "pqr");
		Set<String> keySet = aHashMap.keySet();
		for(String key : keySet) {
			System.out.println(key + " : " + aHashMap.get(key));
		}
		
		Iterator<String> keyIterator = aHashMap.keySet().iterator();
		while(keyIterator.hasNext()) {
			System.out.println(aHashMap.get(keyIterator.next()));
		}
	}
}
