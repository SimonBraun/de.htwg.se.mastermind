package de.htwg.se.mastermind.model;

/**
 * Interface Cell provides methods to set and
 * get the actual value and column.
 * @author sibraun
 *
 */
public interface ICell {

	/**
	 * Sets the value of a cell
	 * @param value
	 */
	void setValue(String value);
	
	/**
	 * Returns a value of a cell
	 * @return
	 */
	String getValue();

	/**
	 * Returns the row
	 * @return row
	 */
	int getRow();
	
	/**
	 * Returns the column
	 * @return column
	 */
	int getColumn();
	
}
