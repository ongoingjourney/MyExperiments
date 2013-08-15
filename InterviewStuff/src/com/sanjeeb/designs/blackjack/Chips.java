package com.sanjeeb.designs.blackjack;

public enum Chips {
	WHITE (1),
	RED (5),
	GREEN (10),
	BROWN(20),
	BLUE(50),
	BLACK(100);
	private final int denomination;
	private Chips(int aDenomination) {
		this.denomination = aDenomination;
	}
	public int getDenomination() {
		return this.denomination;
	}
}