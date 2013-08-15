package com.sanjeeb.designs.blackjack;

public class Driver {
	public static void main(String[] args) {
		Player[] players = new Player[]{new Player(1), new Player(2)};
		Game game = new Game(players, 10);
		game.startGame();
		game.showCards();
	}
}
