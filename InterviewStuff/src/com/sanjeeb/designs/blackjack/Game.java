package com.sanjeeb.designs.blackjack;

import java.util.LinkedList;
import java.util.List;

public class Game {
	Player[] players;
	int betAmount;
	Dealer dealer;
	CardBlackJack[] cardStack;
	
	private int cardStackIndex = 0;
	private int numOfDecks = 5;
	
	
	public Game(Player[] players, int betAmount) {
		this.betAmount = betAmount;
		this.dealer = new Dealer();
		this.players = players;
		this.cardStack = DeckBlackJack.getSchuffleDeck(numOfDecks);
	}
	
	public List<Hand> getPlayerHands() {
		List<Hand> hands = new LinkedList<>();
		for(Player player : players) {
			for(Hand hand : player.getHands()){
				hands.add(hand);
			}
		}
		return hands;
	}
	
	public void startGame() {
		dealer.initialDeal(this);
	}
	
	public void showCards() {
		System.out.println("Dealer ");
		System.out.println(dealer.getHands().get(0).toString());
		
		for(Player player : players) {
			System.out.println("Player " + player.id);
			for(Hand hand : player.getHands()) {
				System.out.println(hand.toString());
			}
		}
	}
	
	public CardBlackJack[] getCardStack() {
		return cardStack;
	}

	public void setCardStack(CardBlackJack[] cardStack) {
		this.cardStack = cardStack;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public int getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(int betAmount) {
		this.betAmount = betAmount;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	
	public CardBlackJack getCardFromDeck() {
		if(cardStackIndex == numOfDecks*52) {
			cardStack = DeckBlackJack.getSchuffleDeck(numOfDecks);
			cardStackIndex = 0;
		}
		return cardStack[cardStackIndex++];
	}
}
