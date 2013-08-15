package com.sanjeeb.pattern.command1;

public class SellOrder implements Order {
	StockMarket market;
	public SellOrder(StockMarket market) {
		this.market = market;
	}
	
	@Override
	public void execute() {
		market.sellStock();
	}
}
