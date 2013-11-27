package de.htwg.se.mastermind.model;

public class Grid extends AbstractGrid implements IGrid {
	
	public Grid(int rows, int columns) {
		this.create(rows, columns);
	}
	
	@Override
	public void create(int rows, int columns) {
		cells = new Cell[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new Cell(i,j);
			}
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
}
