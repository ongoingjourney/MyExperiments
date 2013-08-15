package com.sanjeeb.pattern.command2;

import java.util.LinkedList;
import java.util.List;

public class Server {
	List<Order> orders = new LinkedList<>();
	public void takeOrders(Order order) {
		order.execute();
	}
}
