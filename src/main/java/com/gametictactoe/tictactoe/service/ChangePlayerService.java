package com.gametictactoe.tictactoe.service;


public class ChangePlayerService {

    public void nextPlayer(char PreviousPlayer, char newPlayer) {
    	if(PreviousPlayer=='\0' && newPlayer=='O') {
    		throw new RuntimeException("Player X is the first to play");
    	}
        if ((PreviousPlayer == 'X' && newPlayer == 'X') || PreviousPlayer=='O' && newPlayer=='O') {
        	throw new RuntimeException("Different Player Expected");
        }

    }	
	
	
}
