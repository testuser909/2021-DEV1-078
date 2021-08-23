package com.gametictactoe.tictactoe.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameManagerTest {

	private GameManagerService gameManager;
	
	@BeforeEach
	public final void setUp() {
		gameManager = new GameManagerService();
	}

    @Test
    public void whenPlayThenNoWinner() {
        String actual = gameManager.playGame(1, 1,'X');
        Assertions.assertEquals("Game In Progress, Next Player Please!!!", actual);
    }    
        
    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        gameManager.playGame(1,1,'X'); // X
        gameManager.playGame(1,2,'O'); // O
        gameManager.playGame(2,1,'X'); // X
        gameManager.playGame(2, 2,'O'); // O
        String finalResult = gameManager.playGame(3, 1,'X'); // X
        Assertions.assertEquals("Player X Wins", finalResult);
    }
  
    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        gameManager.playGame(2,1,'X'); // X
        gameManager.playGame(1,1,'O'); // O
        gameManager.playGame(3,1,'X'); // X
        gameManager.playGame(1,2,'O'); // O
        gameManager.playGame(2,2,'X'); // X
        String actual = gameManager.playGame(1, 3,'O'); // O
        Assertions.assertEquals("Player O Wins", actual);
    }
    
    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner() {
        gameManager.playGame(1,1,'X'); // X
        gameManager.playGame(1,2,'O'); // O
        gameManager.playGame(2,2,'X'); // X
        gameManager.playGame(1,3,'O'); // O
        String actual = gameManager.playGame(3,3,'X'); // X
        Assertions.assertEquals("Player X Wins", actual);
    }
    
    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner() {
        gameManager.playGame(1,3,'X'); // X
        gameManager.playGame(1,1,'O'); // O
        gameManager.playGame(2,2,'X'); // X
        gameManager.playGame(1,2,'O'); // O
        String actual = gameManager.playGame(3,1,'X'); // X
        Assertions.assertEquals("Player X Wins", actual);
    }
    
    @Test
    public void whenAllBoxesAreFilledThenDraw() {
        gameManager.playGame(1,1,'X');
        gameManager.playGame(1,2,'O');
        gameManager.playGame(1,3,'X');
        gameManager.playGame(2,1,'O');
        gameManager.playGame(2,3,'X');
        gameManager.playGame(2,2,'O');
        gameManager.playGame(3,1,'X');
        gameManager.playGame(3,3,'O');
        String actual = gameManager.playGame(3,2,'X');
        Assertions.assertEquals("It is a draw", actual);
    }   	
	
}

