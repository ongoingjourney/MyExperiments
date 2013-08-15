package com.sanjeeb.pattern.command3;

public class BrokerageCommandBuy implements BrokerageCommand{
	StockMarket market;
	
	public BrokerageCommandBuy(StockMarket market) {
		this.market = market;
	}
	@Override
	public void execute() {
		market.buyStock();
	}

}
