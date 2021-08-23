package com.gametictactoe.tictactoe;

public class GameManager {
	private Character[][] gameBoard = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private static final int SIZE = 3;
	private char previousPlayer='\0';
	public String playGame(int i, int j, char c) {
		
        if (i < 1 || j > 3) {
            throw new RuntimeException("Pawn is outside the board");
        }
        
        if (i > 3 || j < 1) {
            throw new RuntimeException("Pawn is outside the board");
        }
        
        setGameBox(i,j,previousPlayer,gameBoard);  
        previousPlayer= c;
        
		if (isAGameWin(i, j, previousPlayer, gameBoard)) {
			return "Player " + previousPlayer + " Wins";
		} else if (gameIsADraw(gameBoard)) {
			return "It is a draw";
		} else {
			return "Game In Progress, Next Player Please!!!";
		}       
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
	public boolean isAGameWin(int x, int y, char lastPlayer, Character[][] gameBoard) {
		int playerTotal = lastPlayer * SIZE;
		char horizontalWin, verticalWin, rightToLeftDiagonalWin, leftToRightDiagonalWin;

		horizontalWin = verticalWin = rightToLeftDiagonalWin = leftToRightDiagonalWin = '\0';

		for (int i = 0; i < SIZE; i++) {
			horizontalWin += gameBoard[i][y - 1];
			verticalWin += gameBoard[x - 1][i];
			rightToLeftDiagonalWin += gameBoard[i][i];
			leftToRightDiagonalWin += gameBoard[i][SIZE - i - 1];
		}
		if (horizontalWin == playerTotal || verticalWin == playerTotal || rightToLeftDiagonalWin == playerTotal
				|| leftToRightDiagonalWin == playerTotal) {
			return true;
		}
		return false;
	}

	public boolean gameIsADraw(Character[][] gameBoard) {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				if (gameBoard[x][y] == '\0') {
					return false;
				}
			}
		}
		return true;
	}    
}
