package de.htwg.se.mastermind.model;

public interface IGrid {
	
	/**
	 * Sets the value of a cell
	 * @param row
	 * @param column
	 * @param value
	 */
	void setCellValue(int row, int column, String value);
	
	/**
	 * Returns the value of a cell
	 * @param row
	 * @param column
	 * @return value
	 */
	String getCellValue(int row, int column);
	
	/**
	 * Creates a new Mastermind-Game
	 */
	void create(int rows, int columns);
	
	/**
	 * Returns the amount of the rows the grid has
	 * @return amount
	 */
	int getRowsAmount();
	
	/**
	 * Returns the amount of the columns the grid has
	 * @return amount
	 */
	int getColumnsAmount();
	
	/**
	 * 
	 * @param row
	 * @param column
	 * @return the cell at the coordinates(row, column)
	 */
	ICell getCell(int row, int column);
	
	/**
	 * Returns the row that can be set
	 * @return row
	 */
	int getActualRow();
	
	/**
	 * Increments the actual row
	 */
	void incrementActualRow();
	
	/**
	 * Checks if the actual row is fully set
	 * @return
	 */
	boolean rowIsSet();
	
	/**
	 * Verifies if the value is an color
	 * @param value
	 * @return true/false
	 */
	boolean isColor(String value);
	
	/**
	 * Sets the white and black sticks
	 */
	void setSticks();
	
	/**
	 * Verifies if the user have won
	 * @return true/false
	 */
	boolean isSolved();
	
	/**
	 * Shows the solution of the mastermind game
	 */
	void showSolution();
	
	/**
	 * Solves the mastermind game
	 */
	void solve();
	
	/**
	 * Sets the mastermind colors
	 * @param masterColors
	 */
	void setMastermindColors(String [] masterColors);
}
