package com.gametictactoe.tictactoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gametictactoe.tictactoe.model.GamePlayRequest;
import com.gametictactoe.tictactoe.service.GameManagerService;
import com.gametictactoe.tictactoe.service.InitializeGameBoard;
import com.gametictactoe.tictactoe.service.PrintService;
import com.gametictactoe.tictactoe.service.ValidateInputService;

@RestController
@RequestMapping("/game")
public class GameController {
	@Autowired
	private InitializeGameBoard initializeGameBoard;
	@Autowired 
	private GameManagerService gameManagerService;
	@Autowired
	private ValidateInputService validateInputService;
	@Autowired
	private PrintService printService;

    @PostMapping(value = "/play")
    public ResponseEntity<String> playGame(@RequestBody GamePlayRequest gamePlayRequest) {  
		try {
			validateInputService.valdateGameInput(gamePlayRequest);
	    	String gameResult = gameManagerService.playGame(gamePlayRequest.getRowPosition(), gamePlayRequest.getColumnPosition(), gamePlayRequest.getPlayer());    	
	    	String gameBoardPrint = printService.printBoard(gameManagerService.getGameBoard());
	    	String finalResponse = gameBoardPrint + "\n" +gameResult;
	    	return ResponseEntity.status(HttpStatus.OK).body(finalResponse);			
		}catch(Exception e) {
	    	return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}   	
    }	

    @PutMapping(value = "/initializeBoard")
    public ResponseEntity<String> playGame() { 
    	Character [][] gameBoard = gameManagerService.getGameBoard();
    	Character [][] newGameBoard = initializeGameBoard.initializeGameBoard(gameBoard);
    	gameManagerService.setGameBoard(newGameBoard); 
    	return ResponseEntity.status(HttpStatus.OK).body("Board Initialized");
    }  
    
}
