package com.san.aop;

public class BikeRider implements Rider{

	@Override
	public void ride() {
		System.out.println("\tGo ride your bike");
	}
}