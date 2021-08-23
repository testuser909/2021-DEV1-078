package com.gametictactoe.tictactoe.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChangePlayerServiceTest {
	private ChangePlayerService changePlayerService;

	@BeforeEach
	public final void setUp() {
		changePlayerService = new ChangePlayerService();
	}

	@Test
	public void givenFirstTurn_thenThrowRuntimeExceptionIfXIsNotTheNextPlayer() {
		char lastPlayer = '\0';
		char newPlayer = 'O';
		Assertions.assertThrows(RuntimeException.class, () -> {
			changePlayerService.nextPlayer(lastPlayer, newPlayer);
		});
	}

	@Test
	public void givenLastTurnWasX_thenIfNextTurnIsAlsoXThrowARuntimeException() {
		char lastPlayer = 'X';
		char newPlayer = 'X';
		Assertions.assertThrows(RuntimeException.class, () -> {
			changePlayerService.nextPlayer(lastPlayer, newPlayer);
		});
	}
	
	@Test
	public void givenLastTurnWas_X_thenIfNextTurnIs_O_DoesNotThrowARuntimeException() {
		char lastPlayer = 'X';
		char newPlayer = 'O';
		Assertions.assertDoesNotThrow( () -> {
			changePlayerService.nextPlayer(lastPlayer, newPlayer);
		});
	}	
	@Test
	public void givenPreviousPlayerIsAlsoTheNewPlayer_thenThrowARuntimeException() {
		char lastPlayer = 'X';
		char newPlayer = 'X';
		Assertions.assertThrows(RuntimeException.class, () -> {
			changePlayerService.nextPlayer(lastPlayer, newPlayer);
		});
	}
}
