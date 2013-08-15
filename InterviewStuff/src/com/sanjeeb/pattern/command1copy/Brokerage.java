package com.sanjeeb.pattern.command1copy;

import java.util.LinkedList;
import java.util.List;

public class Brokerage {
	List<StockAction> transactions;
	public Brokerage(){
		transactions = new LinkedList<>();
	}
	
	void executeOrder(StockAction stockTransaction) {
		transactions.add(stockTransaction);
		stockTransaction.execute();
	}
	
}