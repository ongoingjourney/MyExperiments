package com.sanjeeb.pattern.command1;

import java.util.ArrayList;
import java.util.List;

public class Broker {
	List<Order> orderQueue = new ArrayList<>();
	public Broker() {
	}
	public void relayOrder(Order order) {
		orderQueue.add(order);
		order.execute();
	}
}
