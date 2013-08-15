package com.sanjeeb.problemsolving;

import java.util.List;

public class Fibo {
	public static void main(String[] args) {
		for(int i=0; i<10; ++i)
		System.out.print(getNumberAtIndex(i) +" ");
	}
	
	static int getNumberAtIndex(int index) {
		// do not accept non-zero index.
		if(index == 0) return 1;
		else if (index == 1) return 1;
		else return getNumberAtIndex(index-1)+getNumberAtIndex(index-2);
	}
	
}