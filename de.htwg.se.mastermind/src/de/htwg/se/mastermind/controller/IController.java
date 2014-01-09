package de.htwg.se.mastermind.controller;

import de.htwg.se.mastermind.model.IGrid;
import de.htwg.se.mastermind.observer.IObservable;;

public interface IController extends IObservable {
	
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
	 * User confirms that actual row is set
	 * @param row
	 */
	boolean confirmRow();
	
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
	
	/**
	 * Returns a string grid
	 * @return grid
	 */
	String getGridString();
	
	/**
	 * Returns the status line
	 * @return status line
	 */
	String getStatusLine();
	
	/**
	 * Shows the solution of the mastermind game
	 */
	void showSolution();
	
	/**
	 * Returns an array with the mastermind colors
	 * @return an array with the mastermind colors
	 */
	String [] getMastermindColors();
	
	/**
	 * Returns an array with the available colors
	 * @return an array with the available colors
	 */
	String [] getAvailableColors();
	
	/**
	 * Returns the actual row of the grid
	 * @return actual row
	 */
	int getActualRow();
	
	/**
	 * Returns if the game is solved or not
	 * @return true/false
	 */
	boolean isSolved();
}
