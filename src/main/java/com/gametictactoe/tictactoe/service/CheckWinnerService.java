package com.gametictactoe.tictactoe.service;

public class CheckWinnerService {

	private static final int SIZE = 3;

	public boolean isAGameWin(int rowPosition, int columnPosition, char previousPlayer, Character[][] gameBoard) {
		int playerTotal = previousPlayer * SIZE;
		char horizontalWin, verticalWin, rightToLeftDiagonalWin, leftToRightDiagonalWin;

		horizontalWin = verticalWin = rightToLeftDiagonalWin = leftToRightDiagonalWin = '\0';

		for (int i = 0; i < SIZE; i++) {
			horizontalWin += gameBoard[i][columnPosition - 1];
			verticalWin += gameBoard[rowPosition - 1][i];
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
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				if (gameBoard[row][column] == '\0') {
					return false;
				}
			}
		}
		return true;
	}

}
