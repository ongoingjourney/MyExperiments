package com.sanjeeb.designs.blackjack;

public class Card {
	suit suit;
	rank rank;
	public Card(suit aSuit, rank aRank) {
		this.suit = aSuit;
		this.rank = aRank;
	}
	public suit getSuit() {
		return suit;
	}
	public void setSuit(suit suit) {
		this.suit = suit;
	}
	public rank getRank() {
		return rank;
	}
	public void setRank(rank rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return this.suit.name() + ":" + this.rank.name();
	}
}
enum suit {SPADE, HEART, DIAMOND, CLUB};
enum rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}