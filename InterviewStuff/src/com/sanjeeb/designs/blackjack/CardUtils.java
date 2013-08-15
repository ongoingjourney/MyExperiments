package com.sanjeeb.designs.blackjack;

import java.util.Arrays;
import java.util.Random;

public class CardUtils {
	static Random random = new Random();
	
	public static Card[] getNewDeck() {
		return createDeck();
	}
	
	public static Card[] getSchuffledDeck() {
		return schuffleDeck();
	}
	
	public static CardBlackJack[] getNewBJDeck() {
		return createBJDeck();
	}
	
	public static CardBlackJack[] getSchuffledBJDeck() {
		return schuffleBJDeck();
	}
	
	public static CardBlackJack[] getSchuffledBJDeck(int n) {
		assert(n>0):"Please specify number of stacks. Should me > 0";
		return schuffleBJDeck(n);
	}
	
	private static Card[] schuffleDeck() {
		Card[] cards = createDeck();
		int numberOfCards = cards.length;
		for(int i = 0; i < numberOfCards; ++i) {
			int indexA = getRandomNumberForCard(numberOfCards);
			int indexB = getRandomNumberForCard(numberOfCards);
			Card temp = new Card(cards[indexA].getSuit(), cards[indexA].getRank());
			cards[indexA] = cards[indexB];
			cards[indexB] = temp;
		}
		return cards;
	}
	
	private static Card[] createDeck() {
		Card[] cards = new Card[52];
		int i = 0;
		for(suit aSuit : suit.values())
			for(rank aRank : rank.values()) 
				cards[i++] = new Card(aSuit, aRank);
		return cards;
	}
	
	private static CardBlackJack[] schuffleBJDeck() {
		CardBlackJack[] cards = createBJDeck();
		int numberOfCards = cards.length;
		for(int i = 0; i < numberOfCards; ++i) {
			int indexA = getRandomNumberForCard(numberOfCards);
			int indexB = getRandomNumberForCard(numberOfCards);
			CardBlackJack temp = new CardBlackJack(cards[indexA].getSuit(), cards[indexA].getRank());
			cards[indexA] = cards[indexB];
			cards[indexB] = temp;
		}
		return cards;
	}
	
	private static CardBlackJack[] schuffleBJDeck(int n) {
		CardBlackJack[] cards = new CardBlackJack[52*n];
		for(int i = 0; i < n; ++i) {
			
			System.arraycopy(schuffleBJDeck(), 0, cards, 52*i, 52);
		}
		return cards;
	}
	private static CardBlackJack[] createBJDeck() {
		CardBlackJack[] cards = new CardBlackJack[52];
		int i = 0;
		for(suit aSuit : suit.values())
			for(rank aRank : rank.values()) 
				cards[i++] = new CardBlackJack(aSuit, aRank);
		return cards;
	}
	
	private static int getRandomNumberForCard(int n) {
		return random.nextInt(n);
	}
}