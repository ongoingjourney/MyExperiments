package com.sanjeeb.java.multithreading;

public class JoinTest {
	public static void main(String[] args) {
		joinTest();
	}
	
	public static void joinTest() {
		ThreadTest t1 = new ThreadTest("A", 5);
		t1.start();
		try  {
			t1.join();
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		ThreadTest t2 = new ThreadTest("B", 5);
		t2.start();
	}
}


class ThreadTest extends Thread {
	String name;
	int maxCount ;
	public ThreadTest(String aName, int aMaxCount) {
		this.name = aName; 
		this.maxCount = aMaxCount;
	}
	public void run() {
		for(int i = 0; i < maxCount; ++i) {
			System.out.println(this.name + " : " + i);
		}
	}
	
}