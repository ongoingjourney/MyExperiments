package com.sanjeeb.pattern.command1copy;

public class StockActionSell implements StockAction {
	StockMarket stockMarket;
	
	public StockActionSell(StockMarket aStockMarket) {
		this.stockMarket = aStockMarket;
	}

	@Override
	public void execute() {
		stockMarket.sellStock();
	}

}