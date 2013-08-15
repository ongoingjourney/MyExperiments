package com.sanjeeb.designs.blackjack;

public class Deck {
	public static Card[] getNewDeck() {
		return CardUtils.getNewDeck();
	}
	
	public static Card[] getSchuffleDeck() {
		return CardUtils.getSchuffledDeck();
	}
}
