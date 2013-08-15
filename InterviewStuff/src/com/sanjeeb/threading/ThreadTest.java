package com.sanjeeb.threading;

public class ThreadTest {
	public static void main(String[] args) {
		MyClass mc1 = new MyClass('n');
		MyClass mc2 = new MyClass('c');
		mc1.start();
		mc2.start();
	}
}
class MyClass extends Thread {
	char flag;
	public MyClass(char aFlag){
		this.flag = aFlag;
	}
	@Override
	public void run() {
		if(flag == 'n')
			for(int i = 0; i < 26; ++i) 
				System.out.print(i + "\t");
		
		else if(flag == 'c') {
			for(int i = 0; i < 26; ++i) 
				System.out.println((char)(i + 'a') + "\t ");
		}
	}
}