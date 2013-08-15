package com.sanjeeb.pattern.command2;

public class Driver {
	public static void main(String[] args) {
		Kitchen kitchen = new Kitchen();
		Server server = new Server();
		Order lunch1 = new CookLunch(kitchen);
		Order lunch2 = new CookLunch(kitchen);
		Order dinner1 = new CookDinner(kitchen);
		Order dinner2 = new CookDinner(kitchen);
		server.takeOrders(lunch1);
		server.takeOrders(lunch2);
		server.takeOrders(dinner1);
		server.takeOrders(dinner2);
	}
}