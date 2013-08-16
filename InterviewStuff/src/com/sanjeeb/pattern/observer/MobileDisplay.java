package com.sanjeeb.pattern.observer;

public class MobileDisplay implements Display, Observer {

	@Override
	public void update(Observable observable, Object arg) {
		StockUpdate stockUpdate = (StockUpdate)observable;
		String message = "New Price for "+ arg.toString()  + " displayed on "+ this.getClass().getSimpleName() + " is " + stockUpdate.getPriceMap().get(arg);
		display(message);
	}

	@Override
	public void display(String message) {
		System.out.println(message);
	}
}