package com.gametictactoe.tictactoe;

public class GameManager {
	private Character[][] gameBoard = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };

	private char previousPlayer='\0';
	public void playGame(int i, int j, char c) {
		
        if (i < 1 || j > 3) {
            throw new RuntimeException("Pawn is outside the board");
        }
        
        if (i > 3 || j < 1) {
            throw new RuntimeException("Pawn is outside the board");
        }
        setGameBox(i,j,previousPlayer,gameBoard);  
        previousPlayer= c;
        
	}
	
    public void nextPlayer(char lastPlayer, char newPlayer) {
    	if(lastPlayer=='\0' && newPlayer=='O') {
    		throw new RuntimeException("Player X is the first to play");
    	}
        if ((lastPlayer == 'X' && newPlayer == 'X') || lastPlayer=='O' && newPlayer=='O') {
        	throw new RuntimeException("Different Player Expected");
        }

    }		
	
	public void setGameBox(int x, int y, char lastPlayer, Character[][] gameBoard) {
		// table fields are starting numeration from 0, so x,y coordinates must be
		// decreased by 1
		if (gameBoard[x - 1][y - 1] != '\0') {
			throw new RuntimeException("Field is occupied");
		} else {
			gameBoard[x - 1][y - 1] = lastPlayer;
		}
	}    
    
}
