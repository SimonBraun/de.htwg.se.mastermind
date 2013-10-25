package de.htwg.se.mastermind.model;

public interface ICell {
	
	/**
	 * Set the value of a cell.
	 * @param value
	 */
	void setValue(String value);
	
	/**
	 * @return the value of a cell.
	 */
	String getValue();
}
