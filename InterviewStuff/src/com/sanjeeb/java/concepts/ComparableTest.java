package com.sanjeeb.java.concepts;

public class ComparableTest implements Comparable{
	String str;
	public int compareTo(Object arg0) {
		ComparableTest comparableTest = (ComparableTest)arg0;
		String str2 = comparableTest.str;
		if(this.str == null || str2 == null)
			throw new IllegalArgumentException();
		return (str.length() > str2.length())? 1 : (str.length() == str2.length())? 0 : -1; 
	}
	public static void main(String[] args) {
		ComparableTest compTest1 = new ComparableTest();
		compTest1.str = "abcd";
		
		ComparableTest compTest2 = new ComparableTest();
		compTest2.str = "as";
		
		System.out.println(compTest1.compareTo(compTest2));
		
	}
}
