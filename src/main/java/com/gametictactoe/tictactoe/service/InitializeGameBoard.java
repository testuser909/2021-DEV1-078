package com.gametictactoe.tictactoe.service;

import org.springframework.stereotype.Service;

@Service
public class InitializeGameBoard {
		
	public Character [][] initializeGameBoard(Character [][] gameBoard) {
		for(int row=0; row<gameBoard.length;row++) {
			for(int column=0; column<gameBoard.length;column++) {
				gameBoard[row][column] = '\0';
			}
		}
		return gameBoard;
	}

}
