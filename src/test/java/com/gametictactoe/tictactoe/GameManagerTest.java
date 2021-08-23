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
}
