package com.sanjeeb.pattern.command3;

public class BrokerageCommandSell implements BrokerageCommand{
	StockMarket market;
	
	public BrokerageCommandSell(StockMarket market) {
		this.market = market;
	}
	@Override
	public void execute() {
		market.sellStock();		
	}

}
