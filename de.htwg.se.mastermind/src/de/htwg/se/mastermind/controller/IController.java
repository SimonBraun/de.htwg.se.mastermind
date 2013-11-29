package de.htwg.se.mastermind.controller;

import de.htwg.se.mastermind.model.IGrid;

public interface IController {
	
	/**
	 * Sets a value.
	 * @param row The row of the grid
	 * @param column The column of the grid
	 * @param value The value which is set
	 */
	void setValue(int row, int column, String value);
	
	/**
	 * Returns the value.
	 * @param row The row of the grid
	 * @param column The column of the grid
	 * @return value
	 */
	String getValue(int row, int column);
	
	/**
	 * Creates a new Mastermind-Game
	 */
	void create(int rows, int columns);
	
	/**
	 * Returns a grid
	 * @return grid
	 */
	IGrid getGrid();
	
	/**
	 * Returns the amount of rows the grid has
	 * @return row
	 */
	int getRowsAmount();
	
	/**
	 * Returns the amount of columns
	 * @return columns
	 */
	int getColumnsAmount();
}
