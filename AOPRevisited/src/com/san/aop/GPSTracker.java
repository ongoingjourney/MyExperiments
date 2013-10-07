package com.san.aop;

public class GPSTracker implements Tracker { 
	public void startRouteTracking() {
		System.out.println("Starting tracking your ride route");
	}
	
	public void stopRouteTracking() {
		System.out.println("Stopping route tracking");
	}
	
	public void resetRouteTracking(){
		System.out.println("Resetting route tracking");
	}
}