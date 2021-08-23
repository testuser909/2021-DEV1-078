package com.gametictactoe.tictactoe.model;

public class GamePlayRequest {

	private char player;
	private int rowPosition;
	private int columnPosition;

	public GamePlayRequest() {
		super();
	}
	public GamePlayRequest(char player, int rowPosition, int columnPosition) {
		super();
		this.player = player;
		this.rowPosition = rowPosition;
		this.columnPosition = columnPosition;
	}
	public char getPlayer() {
		return player;
	}
	public void setPlayer(char player) {
		this.player = player;
	}
	public int getRowPosition() {
		return rowPosition;
	}
	public void setRowPosition(int rowPosition) {
		this.rowPosition = rowPosition;
	}
	public int getColumnPosition() {
		return columnPosition;
	}
	public void setColumnPosition(int columnPosition) {
		this.columnPosition = columnPosition;
	}
	@Override
	public String toString() {
		return "GamePlay [player=" + player + ", rowPosition=" + rowPosition + ", columnPosition=" + columnPosition
				+ "]";
	}	
}