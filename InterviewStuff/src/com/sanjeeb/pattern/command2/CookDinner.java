package com.sanjeeb.pattern.command2;

public class CookDinner implements Order{ 
	Kitchen kitchen;
	public CookDinner(Kitchen kitchen) {
		this.kitchen = kitchen;
	}
	@Override
	public void execute() {
		kitchen.cookDinner();
	}
}
