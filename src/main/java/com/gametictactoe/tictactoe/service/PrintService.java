package com.gametictactoe.tictactoe.service;

import org.springframework.stereotype.Service;

@Service
public class PrintService {

    public String printBoard(Character [][] gameBoard) {
    	StringBuilder builder = new StringBuilder();
    	for(int i=0;i<gameBoard.length;i++) {
    		for(int j=0;j<gameBoard[i].length;j++) {
    			builder.append(gameBoard[i][j]);
    			builder.append(" ");
    			builder.append('|');
    		}
    		builder.append("\n");
    	}
    	return builder.toString();
    }
	
}
