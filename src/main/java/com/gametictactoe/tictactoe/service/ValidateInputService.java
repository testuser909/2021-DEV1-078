package com.gametictactoe.tictactoe.service;

import org.springframework.stereotype.Service;
import com.gametictactoe.tictactoe.model.GamePlayRequest;
import com.gametictactoe.tictactoe.model.GamePlayers;


@Service
public class ValidateInputService {
	//Restrict game play to player X and player O any other Character is not allowed
    public void valdateGameInput(GamePlayRequest gamePlayRequest) {
        if (!(gamePlayRequest.getPlayer() == GamePlayers.O.asChar()  || gamePlayRequest.getPlayer()==GamePlayers.X.asChar())) {
        	throw new RuntimeException("Expecting Either X or O for Player value");
        }
    }	
	
}
