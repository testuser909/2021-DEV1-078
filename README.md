# 2021-DEV1-TicTacToe

## General info
TicTAcToe Game application
	
## Technologies
Project is created with:
* Java 11
* SpringBoot
	
## Setup
To setup this project:  
clone the project from this [repository](https://github.com/testuser909/2021-DEV1-TicTacToe)  
git clone https://github.com/testuser909/2021-DEV1-TicTacToe.git  
cd 2021-DEV1-TicTacToe/
Build the project by running:    
mvn clean install  


## Running the application

Project exposes 2 Endpoints:
* /game/play      Method:POST accepts application/json Plays the game  
* /game/initializeBoard      Method:PUT accepts application/json initializes the gameBoard to its initial state    


To run the application you need to have:
* JRE installed minimum JRE.11  
* An API testing tool like postman or command line  

Go to the target directory after (mvn clean install):  
cd target/
Then execute the command below to run the application:  
java -jar tictactoe-0.0.1-SNAPSHOT.jar  

Application exposes port 8080  when it starts  

## If running on localhost the below endpoints are exposed:  
localhost:8080/game/initializeBoard  
localhost:8080/game/play  

Initialize path: /game/initializeBoard is a PUT operation with no body.  
Play path: /game/play is a POST operation and it Expects a Json object containing the player (can only be either 'X or O')
and a board (x,y) position  you want to place your piece.   
Expected json body can be used as a request body in postman
{  
    "player" : "O",  
    "rowPosition" : 3,  
    "columnPosition" : 1  
}  
There is a limit to the numbers accepted for pieces only 1 to 3 for rows and columns, Below shows the full set of numbers   
accepted for the whole board and their positions on the board. The example request above will occupy the (3.1) position  
| 1.1 | 1.2 | 1.3 |  
| 2.1 | 2.2 | 2.3 |  
| 3.1 | 3.2 | 3.3 |  

The Game expects 2 players to take turns to play, there is no automated computer option.  

Responses will be shown, if a piece is successfully placed on the board, the state of the GameBoard at the time is also displayed.  












