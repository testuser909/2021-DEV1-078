package com.gametictactoe.tictactoe.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gametictactoe.tictactoe.model.GamePlayRequest;

@SpringBootTest
public class ValidateInputServiceTest {

	@Autowired
	ValidateInputService validateInputService;
	
	@Test
	public void whenRequestIsReceived_thenAllowOnly_X_Or_O_AsPlayersElseThrowRuntimeException() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			GamePlayRequest gamePlay = new GamePlayRequest('Y',1,2);
			validateInputService.valdateGameInput(gamePlay);
		});
	}	
}
