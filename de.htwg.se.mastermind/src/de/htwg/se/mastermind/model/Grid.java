package de.htwg.se.mastermind.model;

import java.util.Map;
import java.util.TreeMap;

public class Grid extends AbstractGrid implements IGrid {
	
	private int actualRow;
	private static final int MASTERCOLORS = 4;
	private static final String [] availableColors = {"rd", "bl", "gr", "yl", "or", "pu", "pk"};
	private String [] masterColors;
	private String [] settedColors;
	//private boolean [] checkedColors;
	
	public Grid(int rows, int columns) {
		this.create(rows, columns);
		//this.setBlockSize(2);
		this.actualRow = 0;
		this.masterColors = this.randomMastermindColors();
		this.settedColors = new String [MASTERCOLORS];
		//this.checkedColors = new boolean[MASTERCOLORS];
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
		
		for (int i = 0; i < settedColors.length; i++) {
			settedColors[i] = this.cells[actualRow][i].getValue();
			if (settedColors[i] == null) {
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
		int blackSticks = 0;
		int whiteSticks = 0;
		Map<String, Integer> mapSettedColors = new TreeMap<>();
		
		for (int i = 0; i < settedColors.length; i++) {
			if (mapSettedColors.containsKey(settedColors[i])) {
				int value = mapSettedColors.get(settedColors[i]);
				value++;
				mapSettedColors.put(settedColors[i], value);
			} else {
				mapSettedColors.put(settedColors[i], 1);
			}
		}
		
		for (int i = 0; i < settedColors.length; i++) {
			if (colorOnRightPlace(i)) {
				//checkedColors[i] = true;
				blackSticks++;
				continue;
			} else if (colorsEqual(mapSettedColors, i)) { // && !checkedColors[i] && colorOnWrongPlace(i)) {
				//checkedColors[i] = true;
				whiteSticks++;
			}
		}
		
		int indexSticks = this.amountOfColumns - 1;
		
		for (int i = 0; i < blackSticks; i++) {
			this.cells[actualRow][indexSticks].setValue("bk");
			indexSticks--;
			
		}
		
		for (int i = 0; i < whiteSticks; i++) {
			this.cells[actualRow][indexSticks].setValue("wh");
			indexSticks--;
		}
		
		//this.checkedColors = new boolean [MASTERCOLORS];
	}
	
	private boolean colorOnRightPlace(int index) {
		if (settedColors[index].equals(masterColors[index])) {
			return true;
		}
		
		return false;
	}
	
	/*private boolean colorOnWrongPlace(int index) {
		for (int i = 0; i < masterColors.length; i++) {
			if (settedColors[index].equals(masterColors[i])) {
					return true;
			}
		}
		return false;
	}*/
	
	private boolean colorsEqual(Map<String, Integer> mapSettedColors, int index) {
		Map<String, Integer> mapMasterColors = new TreeMap<>();
		for (int i = 0; i < masterColors.length; i++) {
			if (mapMasterColors.containsKey(masterColors[i])) {
				int value = mapMasterColors.get(masterColors[i]);
				value++;
				mapMasterColors.put(masterColors[i], value);
			} else {
				mapMasterColors.put(masterColors[i], 1);
			}
		}
		
		if (mapMasterColors.containsKey((settedColors[index]))) {
			int value1 = mapMasterColors.get(settedColors[index]);
			int value2 = mapSettedColors.get(settedColors[index]);
			
			if (value1 != value2) {
				return false;
			}
		} else {
			return false;
		}
		
		return true;
	}
	
	private String [] randomMastermindColors() {
		this.masterColors = new String[MASTERCOLORS];
		for (int i = 0; i < this.masterColors.length; i++) {
			int random = (int) (Math.random() * (availableColors.length - 0) + 0);
			this.masterColors[i] = availableColors[random];
		}
		
		return this.masterColors;
	}

	@Override
	public boolean isSolved() {
		for (int i = 0; i < settedColors.length; i++) {
			if (settedColors[i] == null || !settedColors[i].equals(masterColors[i])) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void showSolution() {
		for (int i = 0; i < MASTERCOLORS; i++) {
			this.setCellValue(this.amountOfColumns - 1, i, masterColors[i]);
		}
	}
	
	@Override
	public void solve() {
		for (int i = 0; i < settedColors.length; i++) {
			settedColors[i] = masterColors[i];
		}
	}
	
	private void setInvisibleMasterColors() {
		for (int i = 0; i < MASTERCOLORS; i++) {
			this.setCellValue(this.amountOfColumns - 1, i, "xx");
		}
	}

	@Override
	public void setMastermindColors(String[] masterColors) {
		this.masterColors = masterColors;
	}
}
