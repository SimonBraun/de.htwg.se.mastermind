package de.htwg.se.mastermind.model.impl;

import de.htwg.se.mastermind.model.AbstractGrid;
import de.htwg.se.mastermind.model.ICell;

public class Grid extends AbstractGrid {

	private Cell cells [][];
	private static final int ROWS = 8;
	private static final int COLUMNS = 8;
	
	public Grid() {
		this.cells = new Cell[ROWS][COLUMNS];
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				this.cells[i][j] = new Cell(i, j);
			}
		}
	}
	
	public Cell getCell(int row, int column) {
		return this.cells[row][column];
	}
	
	/**
	 * @param row
	 * @param column
	 * @return the value of cell at (row, column)
	 */
	public String getCellValue(int row, int column) {
		return this.cells[row][column].getValue();
	}
	
	/**
	 * sets the value of cell at (row, column) to a new value
	 */
	public void setCellValue(int row, int column, String value) {
		this.cells[row][column].setValue(value);
	}

	@Override
	public ICell getICell(int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}	
}
