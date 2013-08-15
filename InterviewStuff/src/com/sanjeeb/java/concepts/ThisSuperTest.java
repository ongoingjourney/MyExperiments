package com.sanjeeb.java.concepts;

public class ThisSuperTest {
//	public ThisSuperTest(){
//		this(8);
//		System.out.println("Hello I am constructor");
//	}
	public ThisSuperTest(int i){
		System.out.println("Hello I am constructor");
	}
	
	public void someMethod() {
		
	}
	
	public static void main(String[] args) {
		ThisSuperTest test = new ThisSuperTest(8);
		Class cl = test.getClass();
	}
}
class Child extends ThisSuperTest{
	public Child(){
		super(3);
	}
}