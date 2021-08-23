package com.gametictactoe.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameManagerTest {

	private GameManager gameManager;
	
	@BeforeEach
	public final void setUp() {
		gameManager = new GameManager();
	}

	@Test
	public void whenXAxisIsOutsideBoard_thenThrowRuntimeException() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			gameManager.playGame(4, 2, 'X');
		});
	}
	@Test
	public void whenYAxisOutsideBoard_thenTrowRuntimeException() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			gameManager.playGame(2, 4, 'O');
		});
	}
	
	public void whenTheBoxIsOccupied_thenThrowRuntimeException() {
		gameManager.playGame(1, 3, 'X');
		Assertions.assertThrows(RuntimeException.class, () -> {
			gameManager.playGame(1, 3, 'O');
		});
	}	
	@Test
	public void givenPreviousPlayerIsAlsoTheNewPlayer_thenThrowARuntimeException() {
		char lastPlayer = 'X';
		char newPlayer = 'X';
		Assertions.assertThrows(RuntimeException.class, () -> {
			gameManager.nextPlayer(lastPlayer, newPlayer);
		});
	}
	@Test
	public void givenLastTurnWas_X_thenIfNextTurnIs_O_DoesNotThrowARuntimeException() {
		char lastPlayer = 'X';
		char newPlayer = 'O';
		Assertions.assertDoesNotThrow( () -> {
			gameManager.nextPlayer(lastPlayer, newPlayer);
		});
	}
	@Test
	public void givenFirstTurn_thenThrowRuntimeExceptionIfXIsNotTheNextPlayer() {
		char lastPlayer = '\0';
		char newPlayer = 'O';
		Assertions.assertThrows(RuntimeException.class, () -> {
			gameManager.nextPlayer(lastPlayer, newPlayer);
		});
	}	
}

