package com.gametictactoe.tictactoe.service;

import org.springframework.stereotype.Service;

@Service
public class GameManagerService {
	private Character[][] gameBoard = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char previousPlayer = '\0';
	private CheckWinnerService checkWinnerService;
	private SelectGameBoxService selectGameBoxService;
	private ChangePlayerService changePlayerService;

	public String playGame(int rowPosition, int columnPosition, char nextPlayer) {

		checkWinnerService = new CheckWinnerService();
		selectGameBoxService = new SelectGameBoxService();
		changePlayerService = new ChangePlayerService();

		selectGameBoxService.checkIfWithinAxis(rowPosition, columnPosition);
		changePlayerService.nextPlayer(previousPlayer, nextPlayer);
		selectGameBoxService.setGameBox(rowPosition, columnPosition, nextPlayer, gameBoard);
		
		previousPlayer = nextPlayer;

		if (checkWinnerService.isAGameWin(rowPosition, columnPosition, previousPlayer, gameBoard)) {
			return "Player " + previousPlayer + " Wins";
			
		} else if (checkWinnerService.gameIsADraw(gameBoard)) {
			return "It is a draw";
			
		} else {
			return "Game In Progress, Next Player Please!!!";
		}
	}

	public Character[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Character[][] gameBoard) {
		this.gameBoard = gameBoard;
	}
}
