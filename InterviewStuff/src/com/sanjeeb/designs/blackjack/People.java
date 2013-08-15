package com.sanjeeb.designs.blackjack;

import java.util.LinkedList;
import java.util.List;

public abstract class People {
	List<Chips> chips = new LinkedList <>();
	List<Hand> hands = new LinkedList <>();

	public List<Chips> getChips() {
		return chips;
	}

	public void setChips(List<Chips> chips) {
		this.chips = chips;
	}


	public List<Hand> getHands() {
		return hands;
	}

	public void setHands(List<Hand> hands) {
		this.hands = hands;
	}



	public int getChipsValue() {
		if(this.chips == null || this.chips.size() == 0) return 0;
		int val = 0;
		for(Chips aChip : chips) {
			val+= aChip.getDenomination();
		}
		return val;
	}
}