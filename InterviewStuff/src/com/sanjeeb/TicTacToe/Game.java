package com.sanjeeb.TicTacToe;

public class Game {
	Board board;
	public Game(int N) {
		board = new Board(N);
	}
	public void play(boolean piece, int posX, int posY) {
		
		if(posX > board.getPositions().length-1 || posY > board.getPositions().length - 1)
			throw new IllegalArgumentException("Invalid position specified");
		
		if(board.getPositions()[posX][posY] != null) {
			throw new IllegalArgumentException("Specified position is not available");
		}
		board.getPositions()[posX][posY] = new Boolean(piece);
		checkGameCompletion(posX, posY);
		
	}
	
	private boolean checkGameCompletion(int posX, int posY) {
		for(int i = 0; i < board.getPositions()[0].length-1; ++i) {
			if(	board.getPositions()[posX][i] == null || 
				board.getPositions()[posX][i+1] == null ||
					board.getPositions()[posX][i] != board.getPositions()[posX][i+1]) 
				return false;
		}
		
		for(int i = 0; i < board.getPositions()[0].length-1; ++i) {
			if(	board.getPositions()[i][posY] != null || 
				board.getPositions()[i+1][posY] != null ||
				board.getPositions()[i][posY] != board.getPositions()[i+1][posY]) 
				return false;
		}
		
		if(posX == posY) {
			for(int i = 0; i < board.getPositions()[0].length-1; ++i) {
				if( board.getPositions()[i][i] == null ||
					board.getPositions()[i+1][i+1] == null ||
					board.getPositions()[i][i] != board.getPositions()[i+1][i+1]) {
					return false;
				}
			}
			int boardSize = board.getPositions().length;
			if( posX == boardSize/2) {
				for(int i = 0; i < boardSize-1; ++i) {
					if(	board.getPositions()[i][boardSize-1-i] == null ||
						board.getPositions()[i][boardSize-1-i] != board.getPositions()[i+1][boardSize-2-i]) {
						return false;
					}
						
				}
			}
		}
		return true;
	}
	
	// O(N2)
	private boolean checkGameCompletionDumb(int posX, int posY) {
		int boardSize = board.getPositions().length;
		
		for(int i = 0; i < boardSize-1; ++i)
			for(int j = 0; j < boardSize-1; ++j) {
				if(	board.getPositions()[i][j] == null || 
					board.getPositions()[i][j+1] == null ||
					board.getPositions()[i][j] != board.getPositions()[i][j+1])
					return false;
			}
		
		return true;
	}

}
	

class Board {
	Boolean[][] positions;
	
	public Board(int N){
		if(N < 0 || N%2==0) {
			throw new IllegalArgumentException();
		}
		positions = new Boolean[N][N];
	}
	public Boolean[][] getPositions() {
		return positions;
	}
	public void setPositions(Boolean[][] positions) {
		this.positions = positions;
	}
}