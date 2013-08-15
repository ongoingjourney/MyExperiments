package com.sanjeeb.pattern.command1;

public class BuyOrder implements Order {
	StockMarket market;
	public BuyOrder(StockMarket market) {
		this.market = market;
	}
	
	@Override
	public void execute() {
		market.buyStock();
	}
}