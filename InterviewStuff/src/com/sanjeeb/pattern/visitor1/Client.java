package com.sanjeeb.pattern.visitor1;

public class Client {
	public static void main(String[] args) {
		new Car().accept(new PrintVisitor());
	}
}
