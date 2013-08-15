package com.sanjeeb.designs.blackjack;

public class DeckBlackJack {
	public static CardBlackJack[] getNewDeck() {
		return CardUtils.getNewBJDeck();
	}
	
	public static CardBlackJack[] getSchuffleDeck() {
		return CardUtils.getSchuffledBJDeck();
	}
	
	public static CardBlackJack[] getSchuffleDeck(int n) {
		return CardUtils.getSchuffledBJDeck(n);
	}
}
