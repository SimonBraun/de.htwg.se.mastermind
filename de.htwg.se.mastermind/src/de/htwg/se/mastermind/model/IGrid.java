package de.htwg.se.mastermind.model;

public interface IGrid {
	
	void setCellValue(int row, int column, String value);
	
	String getCellValue(int row, int column);
	
	/**
	 * Creates a new Mastermind-Game
	 */
	void create(int rows, int columns);
}
