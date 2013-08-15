package com.sanjeeb.pattern.command2;

public class CookLunch implements Order{ 
	Kitchen kitchen;
	public CookLunch(Kitchen kitchen) {
		this.kitchen = kitchen;
	}
	@Override
	public void execute() {
		kitchen.cookLunch();
	}
}
