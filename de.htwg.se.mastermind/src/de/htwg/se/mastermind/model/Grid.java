package de.htwg.se.mastermind.model;

public class Grid extends AbstractGrid implements IGrid {
	
	public Grid(int rows, int columns) {
		this.create(rows, columns);
		this.setBlockSize(2);
	}
	
	@Override
	public void create(int rows, int columns) {
		cells = new Cell[rows][columns];
		amountOfColumns = 0;
		amountOfRows = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new Cell(i,j);
			}
			amountOfRows++;
			amountOfColumns++;
		}
	}
	
	@Override
	public void setCellValue(int row, int column, String value) {
		cells[row][column].setValue(value);
		
	}

	@Override
	public String getCellValue(int row, int column) {
		return cells[row][column].getValue();
	}

	@Override
	public int getRowsAmount() {
		return this.amountOfRows;
	}

	@Override
	public int getColumnsAmount() {
		return this.amountOfColumns;
	}
}
