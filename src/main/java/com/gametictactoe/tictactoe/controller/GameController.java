package com.gametictactoe.tictactoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gametictactoe.tictactoe.model.GamePlayRequest;
import com.gametictactoe.tictactoe.service.GameManagerService;
import com.gametictactoe.tictactoe.service.ValidateInputService;

@RestController
@RequestMapping("/game")
public class GameController {

	@Autowired 
	private GameManagerService gameManagerService;
	@Autowired
	private ValidateInputService validateInputService;

    @PostMapping(value = "/play")
    public ResponseEntity<String> playGame(@RequestBody GamePlayRequest gamePlayRequest) {  
		try {
			validateInputService.valdateGameInput(gamePlayRequest);
	    	String result = gameManagerService.playGame(gamePlayRequest.getRowPosition(), gamePlayRequest.getColumnPosition(), gamePlayRequest.getPlayer());    	
	    	return ResponseEntity.status(HttpStatus.OK).body(result);			
		}catch(Exception e) {
	    	return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}   	
    }	

}
