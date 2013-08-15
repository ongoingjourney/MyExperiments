package com.sanjeeb.java.jmock;

public class Driver {
	RemoteService remoteService;
	int a;
	int b;
	public Driver(RemoteService remoteService, int a, int b) {
		this.remoteService = remoteService;
		this.a = a;
		this.b = b;
	}
	public void executeService() {
		System.out.println(remoteService.addition(a, b));
		System.out.println(remoteService.subtraction(a, b));
		System.out.println(remoteService.multiplication(a, b));
	}
	
	public static void main(String[] args) {
		new Driver(new RemoteServiceImpl(), 4, 2).executeService();
	}
}
