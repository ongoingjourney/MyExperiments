package com.sanjeeb.pattern.command1;

public class Client {
	public static void main(String[] args) {
		StockMarket market = new StockMarket();
		Broker broker = new Broker();
		BuyOrder bo1 = new BuyOrder(market);
		BuyOrder bo2 = new BuyOrder(market);
		SellOrder so1 = new SellOrder(market);
		SellOrder so2 = new SellOrder(market);
		broker.relayOrder(bo1);
		broker.relayOrder(bo2);
		broker.relayOrder(so1);
		broker.relayOrder(so2);
	}
}
