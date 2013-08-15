package com.sanjeeb.designs.blackjack;

import java.util.List;

public class Dealer extends People {

	public void initialDeal(Game game) {
		assert (game != null) : "input game cannot be null";
		Player[] players = game.getPlayers();
		assert (players.length > 0) : "there has to be players to play";
		assert (game.getBetAmount() > 0 ) : "bet amount has to be positive integer";
		
		preparePlayers(game);
		
		List<Hand> hands = game.getPlayerHands();
		for(Hand hand : hands) {
			hand.getCards().add(game.getCardFromDeck());
		}
		
		this.getHands().get(0).getCards().add(game.getCardFromDeck());
		
		for(Hand hand : hands) {
			hand.getCards().add(game.getCardFromDeck());
		}
		
		this.getHands().get(0).getCards().add(game.getCardFromDeck());
	}
	
	public void validateAction(Player aPlayer) {
		
	}
	
	public void dealAfterValidation() {
		
	}
	
	public void selfServCardToWrap() {
		
	}
	
	public void DecideHand() {
		
	}
	public void DistributeMoney() {
		
	}
	
	private void preparePlayers(Game game) {
		game.getDealer().getHands().add(new Hand());
		for(Player player : game.players) {
			player.getHands().add(new Hand());
		}
	}
}