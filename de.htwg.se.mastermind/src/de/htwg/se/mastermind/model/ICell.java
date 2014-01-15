package de.htwg.se.mastermind.model;

public interface ICell {

	/**
	 * Sets the value of a cell
	 */
	void setValue(String value);
	
	/**
	 * Returns a value of a cell
	 * @return
	 */
	String getValue();

	int getRow();
	
	int getColumn();
	
}
