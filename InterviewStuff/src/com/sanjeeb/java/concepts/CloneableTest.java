package com.sanjeeb.java.concepts;

public class CloneableTest implements Cloneable {
	int i; 
	RED red;
	final int testFinalInt = 5;
//	@Override
//	public CloneableTest clone(){
//		return new CloneableTest(i*i);
//	}
	
	public CloneableTest(int param, int redParam){
		i = param;
		red = new RED(redParam);
	}
	
	public static void main(String[] args) {
		Object ob = null;
		CloneableTest cloneableTest = new CloneableTest(3,5);
		try {
			CloneableTest clone = (CloneableTest)cloneableTest.clone();
			System.out.println(clone.i);
			System.out.println(clone.testFinalInt);
			//System.out.println(clone.red.j);
		} catch (CloneNotSupportedException ex){
		}
	} 
}

class RED {
	int j;
	RED(int num) {num = j;}
}