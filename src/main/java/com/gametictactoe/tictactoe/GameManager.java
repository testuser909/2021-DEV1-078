package com.gametictactoe.tictactoe;

public class GameManager {

	public void playGame(int i, int j, char c) {
		
        if (i < 1 || j > 3) {
            throw new RuntimeException("Pawn is outside the board");
        }
        
        if (i > 3 || j < 1) {
            throw new RuntimeException("Pawn is outside the board");
        }
		
	}

}
