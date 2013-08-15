package com.sanjeeb.pattern.command3;

import java.util.LinkedList;
import java.util.List;

public class BrokerHouse {
	List<BrokerageCommand> commands;
	public BrokerHouse() {
		commands = new LinkedList<>();
	}
	public void relayStockOrder(BrokerageCommand command) {
		commands.add(command);
		command.execute();
	}
}