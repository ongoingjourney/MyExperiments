package com.sanjeeb.arithmetic;

public class Driver {
	Operation operation;
	public Driver(Operation operation) {
		this.operation = operation;
	}
	public void method() {
		int i = 4;
		int j = 5;
		int k = operation.add(i, j);
	}
}