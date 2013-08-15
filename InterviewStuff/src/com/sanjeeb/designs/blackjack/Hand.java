package com.sanjeeb.designs.blackjack;

import java.util.LinkedList;
import java.util.List;

public class Hand {
	List<CardBlackJack> cards;
	HandStatus handStatus;
	public Hand() {
		cards = new LinkedList<>();
		handStatus = HandStatus.PLAYING;
	}
	
	public List<CardBlackJack> getCards() {
		return cards;
	}

	public void setCards(List<CardBlackJack> cards) {
		this.cards = cards;
	}


	public HandStatus getHandStatus() {
		return handStatus;
	}
	
	public void setHandStatus(HandStatus handStatus) {
		this.handStatus = handStatus;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(CardBlackJack card : cards) {
			str+=card.toString();
		}
		return str;
	}
}