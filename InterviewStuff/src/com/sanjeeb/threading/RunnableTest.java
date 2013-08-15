package com.sanjeeb.threading;

public class RunnableTest {
	public static void main(String args) {
		Runnable run1 = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 26; ++i)
					System.out.print(i + "\t");
			}
		};
	}
	
	
}
