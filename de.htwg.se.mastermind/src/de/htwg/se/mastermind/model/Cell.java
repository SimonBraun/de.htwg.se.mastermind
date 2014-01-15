package de.htwg.se.mastermind.model;

/**
 * Class cell. Initializes an new Cell.
 * @author sibraun
 *
 */
public class Cell extends AbstractCell  {
	
	/**
	 * Initializes an new Cell.
	 * @param row
	 * @param column
	 */
	public Cell(int row, int column) {
		setRow(row);
		setColumn(column);
	}
}
