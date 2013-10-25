package de.htwg.se.mastermind.model;

public interface IGrid {
	
	/**
	 * @param row
	 * @param column
	 * @return the cell at coordinates (row, column)
	 */
	ICell getICell(int row, int column);
	
	
}
