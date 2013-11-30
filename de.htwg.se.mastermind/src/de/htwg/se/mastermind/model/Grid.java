package de.htwg.se.mastermind.model;

public class Grid extends AbstractGrid implements IGrid {
	
	private int actualRow;
	private static final int SETROWS = 4;
	
	public Grid(int rows, int columns) {
		this.create(rows, columns);
		this.setBlockSize(2);
		this.actualRow = 0;
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
	
	@Override
	public ICell getCell(int row, int column) {
		return this.cells[row][column];
	}

	@Override
	public int getActualRow() {
		return this.actualRow;
	}
	
	@Override
	public void incrementActualRow() {
		this.actualRow++;
	}

	@Override
	public boolean rowIsSet() {
		for (int i = 0; i < SETROWS; i++) {
			if (this.cells[actualRow][i].getValue() == null) {
				return false;
			}
		}
		
		return true;
	}
}
