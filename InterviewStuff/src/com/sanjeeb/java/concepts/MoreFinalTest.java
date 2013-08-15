package com.sanjeeb.java.concepts;

import java.util.ArrayList;
import java.util.List;

public class MoreFinalTest {
	private final int i = 8;
	public static void main(String[] args) {
		final List list = new ArrayList();
		list.add("value");
		
		final FinalTest finTest = new FinalTest();
		finTest.temp = 3;
		
	}
}
