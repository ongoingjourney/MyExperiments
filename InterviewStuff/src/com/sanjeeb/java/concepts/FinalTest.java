package com.sanjeeb.java.concepts;

import java.util.ArrayList;
import java.util.List;

public class FinalTest {
	int temp;
	final int i = 2;
	final int j;
	FinalTest(){
		j = 7;
	}
	private final void sayHello(){
		
	}
	final void sayHi() {
		System.out.println("hi");
	}
	public static void main(String[] args){
		FinalTest test = new FinalTest();
	}
}

class finalTestExtended extends FinalTest{
//	@Override
//	void sayHi(){
//		
//	}
	private final void sayHello(){
		
	}
	
}