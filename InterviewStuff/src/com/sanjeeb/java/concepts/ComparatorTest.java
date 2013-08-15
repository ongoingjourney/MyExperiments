package com.sanjeeb.java.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ComparatorTest implements Comparator<String>{

	public int compare(String o1, String o2) {
		if(o1 == null || o2 == null) 
			throw new IllegalArgumentException();
		return (o1.length() > o2.length()) ? -1 : (o1.length()== o2.length()) ? 0 : 1; 
	}
	
	public static void main(String[] args) {
		List<String> stringArray = new ArrayList<String>(Arrays.asList("abc", "dd", "adfasd", "", "sdfiosdf", "a"));
		Collections.sort(stringArray, new ComparatorTest());
		Iterator<String> ite = stringArray.iterator();
		while(ite.hasNext())
		{
			System.out.println(ite.next());
		}
	}
}