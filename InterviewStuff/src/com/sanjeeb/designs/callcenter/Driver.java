package com.sanjeeb.designs.callcenter;

public class Driver {
	public static void main(String[] args) {
		CallHandlerSystem system = CallHandlerSystem.getInstance();
		for(int i = 0; i < 50; ++i) {
			system.addCallToTheQueue("caller" + i);
		}
		system.startBusiness(1, 1);
	}
}
