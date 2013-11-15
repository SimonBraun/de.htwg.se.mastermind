package de.htwg.se.mastermind.model;

public abstract class AbstractGrid implements IGrid {
	
	Cell [][] cells;
	
	protected void create(int rows, int columns) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; i < columns; j++) {
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
