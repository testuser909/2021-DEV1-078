package com.gametictactoe.tictactoe.model;

public enum GamePlayers {
    X('X'), O('O');

    public char asChar() {
        return asChar;
    }

    private final char asChar;

    GamePlayers(char asChar) {
        this.asChar = asChar;
    }
}