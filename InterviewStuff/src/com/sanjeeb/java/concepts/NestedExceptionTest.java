package com.sanjeeb.java.concepts;

public class NestedExceptionTest {
	public static void main(String[] args) {
		HorseShit horseShit = new HorseShit();
		horseShit.divide(23, 0);
	}
	
	
}
class HorseShit {
	public void divide(int a, int b) {
		divideLevel0(a, b);
	}
	
	private void divideLevel0(int a, int b) {
		try {
			divideLevel1(a, b);
		} catch (IllegalArgumentException ex) {
			throw new IllegalStateException(ex);
		}
	}
	
	private void divideLevel1(int a, int b) {
		try {
			divideLevel2(a, b);
		} catch (ArithmeticException ex) {
			throw new IllegalArgumentException(ex);
		}
	}
	
	private void divideLevel2(int a, int b) {
		try {
			int c = a/b;
		} catch(ArithmeticException ex) {
			throw ex;
		}
	}
}