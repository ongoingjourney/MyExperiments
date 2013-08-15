package com.sanjeeb.aop.concern;

public class CafeOwner {
	long startMillis;
	long endMillis;
	public void LoginTime() {
		startMillis = System.currentTimeMillis(); 
		System.out.println("Record name of customer and log-in time");
	}
	public void Logout() {
		endMillis = System.currentTimeMillis();
		System.out.println("Record logout time");
	}
	public void prepareBill() {
		System.out.println("Calculate and bill customer for " + (endMillis - startMillis) + " ms.");
	}
	
	public void cancelBilling() {
		System.out.println("Canceling billing");
	}
}
