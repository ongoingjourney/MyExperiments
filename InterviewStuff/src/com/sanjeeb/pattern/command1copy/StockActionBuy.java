package com.sanjeeb.pattern.command1copy;

public class StockActionBuy implements StockAction {
	StockMarket stockMarket;
	
	public StockActionBuy(StockMarket aStockMarket) {
		this.stockMarket = aStockMarket;
	}

	@Override
	public void execute() {
		stockMarket.buyStock();
	}

}
