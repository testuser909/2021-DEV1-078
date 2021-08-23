package com.gametictactoe.tictactoe.service;

public class SelectGameBoxService {

	public void setGameBox(int rowPosition, int columnPosition, char lastPlayer, Character[][] gameBoard) {
		// table fields are starting numeration from 0, so x,y coordinates must be
		// decreased by 1
		if (gameBoard[rowPosition - 1][columnPosition - 1] != '\0') {
			throw new RuntimeException("Board position is already occupied");
		} else {
			gameBoard[rowPosition - 1][columnPosition - 1] = lastPlayer;
		}
	}

	public void checkIfWithinAxis(int rowPosition, int columnPosition) {
		if ((rowPosition < 1 || rowPosition > 3) || (columnPosition < 1 || columnPosition > 3))
			throw new java.lang.RuntimeException("Outside board range");
	}

}
