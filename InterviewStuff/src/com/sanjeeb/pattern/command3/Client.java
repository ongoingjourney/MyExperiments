package com.sanjeeb.pattern.command3;

public class Client {
	public static void main(String[] args ) {
		StockMarket market = new StockMarket();
		BrokerageCommand buy1 = new BrokerageCommandBuy(market);
		BrokerageCommand buy2 = new BrokerageCommandBuy(market);
		BrokerageCommand sell = new BrokerageCommandSell(market);
		buy1.execute();
		buy2.execute();
		sell.execute();
	}
}
