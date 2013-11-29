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
}
