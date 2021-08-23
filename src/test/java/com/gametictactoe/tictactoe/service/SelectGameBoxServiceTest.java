package com.gametictactoe.tictactoe.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SelectGameBoxServiceTest {

	@Autowired
	GameManagerService gameManager;

	@Test
	public void whenXAxisIsOutsideBoard_thenThrowRuntimeException() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			gameManager.playGame(4, 2, 'X');
		});
	}
	@Test
	public void whenYAxisIsOutsideBoard_thenTrowRuntimeException() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			gameManager.playGame(2, 4, 'O');
		});
	}

	@Test
	public void whenTheBoxIsOccupied_thenThrowRuntimeException() {
		gameManager.playGame(1, 3, 'X');
		Assertions.assertThrows(RuntimeException.class, () -> {
			gameManager.playGame(1, 3, 'O');
		});
	}	
}
