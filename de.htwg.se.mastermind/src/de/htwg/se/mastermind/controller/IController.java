package de.htwg.se.mastermind.controller;

import java.awt.Color;

import de.htwg.se.mastermind.model.IGrid;
import de.htwg.se.mastermind.observer.IObservable;;

/**
 * Interface Controller provides methods to communicate
 * and controls with the models.
 * @author sibraun
 *
 */
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
	
	/**
	 * Sets the size of the game
	 * @param rows
	 */
	void resetSize(int rows, int columns);
	
	/**
	 * Verifies if show solution has been choosen
	 * @return true/false
	 */
	boolean getShowSolution();
	
	/**
	 * Sets show solution
	 */
	void setShowSolution(boolean value);
	
	/**
	 * Verifies if a row is confirmed
	 * @return true/false
	 */
	boolean getRowConfirmed();
	
	/**
	 * Sets a row confirmed
	 */
	void setRowConfirmed(boolean value);
	
	/**
	 * Verifies if new game was started
	 * @return true/false
	 */
	boolean getIsNewGame();
	
	/**
	 * Sets if new game was started
	 * @param value
	 */
	void setIsNewGame(boolean value);
	
	/**
	 * Converts a string color into a real color
	 * @param color
	 * @return color
	 */
	Color getColorFromString(String color);
	
	/**
	 * Sets the color chosen by the user
	 * @param ChosenColor
	 * @return void
	 */
	void setChosenColor(String [] chosenColor);

	/**
	 * Returns the color from the model
	 * @param color
	 * @return String array
	 */
	String[] getColor(String color);

	/**
	 * Calls the newMasterColors from Grid
	 * @param void
	 * @return void
	 */
	void newMasterColors();

	/**
	 * Sets the name of the user
	 * @param username The name of the user
	 */
	void setUsername (String username);

	/**
	 * Returns the name of the user
	 * @return the name of the user
	 */
	String getUsername();

	/**
	 * Returns the actual date
	 * @return
	 */
	String getDate();

	/**
	 * Sets the date
	 * @param date The actual date
	 */
	void setDate(String date);

	/**
	 * Returns the id of the grid
	 * @return the id of the grid
	 */
	String getId();

	/**
	 * Sets the id of the grid
	 * @param id the id of the grid
	 */
	void setId(String id);


	/**
	 * Saves grid to DB.
	 */
	void saveToDB();

	/**
	 * Returns field with name and score
	 * @return field with name and score
	 */
	String [][] getAllGrids();

	/**
	 * Removes all grid from db
	 */
	void removeAllGrids();

	/**
	 * Removes the entry from db with passed id
	 * @param id the id of the db entry
	 */
	void removeGridById(String id);

	/**
	 * Checks if user has made a new highscore. If yes, old value will be deleted
	 * @return the the id to delete
	 */
	String isInHighScore();
}
