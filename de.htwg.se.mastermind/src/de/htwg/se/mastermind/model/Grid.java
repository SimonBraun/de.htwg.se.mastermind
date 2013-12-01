package de.htwg.se.mastermind.model;

public class Grid extends AbstractGrid implements IGrid {
	
	private int actualRow;
	private static final int SETROWS = 4;
	private static final int MASTERCOLORS = 4;
	private static final String [] availableColors = {"rd", "bl", "gr", "yl", "or", "pu", "pk"};
	private String [] masterColors;
	private int rightColors;
	
	public Grid(int rows, int columns) {
		this.create(rows, columns);
		this.setBlockSize(2);
		this.actualRow = 0;
		this.rightColors = 0;
		this.masterColors = this.randomColors();
		this.setInvisibleMasterColors();
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

	@Override
	public boolean isColor(String value) {
		for(String s : availableColors) {
			if (s.equals(value)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void setSticks() {
		int stickIndex = this.getRowsAmount() - 1;
		for (int i = 0; i < SETROWS; i++) {
			if (this.containsColor(i)) {
				if (this.colorOnRightPlace(i)) {
					this.setCellValue(actualRow, stickIndex, "bk");
					stickIndex--;
					rightColors++;
					continue;
				}
				this.setCellValue(actualRow, stickIndex, "wh");
				stickIndex--;
				continue;
			}
		}
	}
	
	private boolean containsColor(int index) {
		for (int i = 0; i < SETROWS; i++) {
			if (this.getCellValue(this.actualRow, i).equals(masterColors[index])) {
				return true;
			}
		}
		return false;
	}
	
	private boolean colorOnRightPlace(int index) {
		for (int i = 0; i < SETROWS; i++) {
			if (this.getCellValue(this.actualRow, i).equals(masterColors[index]) && index == i) {
				return true;
			}
		}
		return false;
	}
	
	private String [] randomColors() {
		this.masterColors = new String[MASTERCOLORS];
		
		for (int i = 0; i < this.masterColors.length; i++) {
			int random = (int) (Math.random() * (availableColors.length - 0) + 0);
			this.masterColors[i] = availableColors[random];
			System.out.print(this.masterColors[i]+ "[" + i + "]" + ", ");
		}
		
		System.out.println();
		
		return this.masterColors;
	}

	@Override
	public boolean isSolved() {
		if (rightColors == MASTERCOLORS) {
			this.showSolution();
			return true;
		}
		return false;
	}
	
	@Override
	public void showSolution() {
		for (int i = 0; i < MASTERCOLORS; i++) {
			this.setCellValue(this.amountOfColumns - 1, i, masterColors[i]);
		}
	}
	
	private void setInvisibleMasterColors() {
		for (int i = 0; i < MASTERCOLORS; i++) {
			this.setCellValue(this.amountOfColumns - 1, i, "xx");
		}
	}
}
