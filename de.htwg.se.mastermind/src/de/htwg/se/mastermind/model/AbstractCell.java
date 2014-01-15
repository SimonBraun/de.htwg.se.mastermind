package de.htwg.se.mastermind.model;

/**
 * Abstract class Cell provides further methods which allows
 * to control the Cell.
 * @author sibraun
 *
 */
public abstract class AbstractCell implements ICell {
	
	private String value = null;
	private int row;
	private int column;
	
	/**
	 * Sets the value of a cell
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Returns a value of a cell
	 * @return value
	 */
	public String getValue() {
		return this.value;
	}
	
	/**
	 * Sets a row.
	 * @param row
	 */
	protected void setRow(int row) {
		this.row = row;
	}
	
	/**
	 * Sets a column
	 * @param column
	 */
	protected void setColumn(int column) {
		this.column = column;
	}
	
	/**
	 * Returns the row
	 * @return row
	 */
	public int getRow() {
		return this.row;
	}
	
	/**
	 * Returns the column
	 * @return column
	 */
	public int getColumn() {
		return this.column;
	}
}
