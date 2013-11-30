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
	void confirmRow();
	
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
}
