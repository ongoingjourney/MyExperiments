package com.sanjeeb.java.concepts;

public class ExceptionTest {
	public static void main(String[] args) {
		ExceptionTest exTest = new ExceptionTest();
		exTest.runtimeExceptionMethod(4);
	}

	public void runtimeExceptionMethod (int n){
		if(n == 6) 
			throw new MyRuntimeException();
	}
	
	public void compileTimeExceptionMethod (int n) throws MyCompileTimeException {
		if(n == 6) 
			throw new MyCompileTimeException();
	}
	
}

class MyRuntimeException extends RuntimeException {
	
}

class MyCompileTimeException extends Exception {
	
}