package de.htwg.se.mastermind.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * class grid. Initializes a new grid an implements methods.
 * @author sibraun
 *
 */
public class Grid extends AbstractGrid implements IGrid {
	
	private int actualRow;
	private final String [] availableColors = {"rd", "bl", "gr", "yl", "or", "pu", "pk"};
	private String [] masterColors;
	private String [] settedColors;
	private int amountOfRows;
	private int amountOfColumns;
	private Cell [][] cells;
	private boolean showSolution;
	private boolean rowConfirmed;
	private boolean isNewGame;
	private String username;
	private String date;
	private String id;
	
	/**
	 * Initializes a new grid.
	 * @param rows Amount of the grid rows
	 * @param columns Amount of the grid columns
	 */
	public Grid(int rows, int columns) {
		this.create(rows, columns);
		this.actualRow = 0;
		this.masterColors = this.randomMastermindColors();
		this.settedColors = new String [columns/2];
		this.setInvisibleMasterColors();
		this.showSolution = false;
		this.rowConfirmed = false;
		this.username = "(No username)";
		this.date = "(No date)";
	}
	
	@Override
	public final void create(int rows, int columns) {
		isNewGame = true;
		cells = new Cell[rows][columns];
		amountOfColumns = columns;
		amountOfRows = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new Cell(i,j);
			}
			amountOfRows++;
		}
	}
	
	@Override
	public final void setCellValue(int row, int column, String value) {
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
		
		for (int i = 0; i < settedColors.length; i++) {
			if (colorOnRightPlace(i)) {
				blackSticks++;
			}
		}
		
		ArrayList<Integer> alreadyProcessed = new ArrayList<Integer>();
	    for (String color : masterColors) {
	    	for (int j = 0; j < settedColors.length; j++) {
	    		if (color.equals(settedColors[j]) && !alreadyProcessed.contains(j)) {
	    			alreadyProcessed.add(j);
	    			whiteSticks++;
	    			break;
	    		}
	    	}
	 	}
	    
	    whiteSticks -= blackSticks;
		
		int indexSticks = this.amountOfColumns - 1;
		
		for (int i = 0; i < blackSticks; i++) {
			this.cells[actualRow][indexSticks].setValue("bk");
			indexSticks--;
			
		}
		
		for (int i = 0; i < whiteSticks; i++) {
			this.cells[actualRow][indexSticks].setValue("wh");
			indexSticks--;
		}
	}
	
	private boolean colorOnRightPlace(int index) {
		return settedColors[index].equals(masterColors[index]);

	}
	
	private String [] randomMastermindColors() {
		this.masterColors = new String[this.amountOfColumns/2];
		for (int i = 0; i < this.masterColors.length; i++) {
			int random = (int) (Math.random() * (availableColors.length) + 0);
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
		this.setShowSolution(true);
		for (int i = 0; i < this.amountOfColumns/2; i++) {
			this.setCellValue(this.amountOfRows - 1, i, masterColors[i]);
		}
	}
	
	@Override
	public void solve() {
		this.settedColors = Arrays.copyOf(masterColors, masterColors.length); 
	}
	
	private void setInvisibleMasterColors() {
		for (int i = 0; i < this.amountOfColumns/2; i++) {
			this.setCellValue(this.amountOfRows - 1, i, "xx");
		}
	}

	@Override
	public void setMastermindColors(String[] masterColors) {
		System.arraycopy(masterColors, 0, this.masterColors, 0, masterColors.length);
	}
	
	@Override
	public String [] getMastermindColors() {
		return this.masterColors;
	}

	@Override
	public String[] getAvailableColors() {
		return this.availableColors;
	}

	@Override
	public boolean getShowSolution() {
		return this.showSolution;
	}

	@Override
	public void setShowSolution(boolean value) {
		this.showSolution = value;
	}
	
	@Override
	public boolean getRowConfirmed() {
		return this.rowConfirmed;
	}

	@Override
	public void setRowConfirmed(boolean value) {
		this.rowConfirmed = value;
	}

	@Override
	public boolean getIsNewGame() {
		return this.isNewGame;
	}

	@Override
	public void setIsNewGame(boolean value) {
		this.isNewGame = value;
	}

	@Override
	public Color getColorFromString(String color) {
		
		if (color == null) {
			return Color.gray;
		}
		
		if (color.equals("gy")) {
			return Color.gray;
		}
		
		if (color.equals("yl")) {
			return Color.yellow;
		}
		
		if (color.equals("bl")) {
			return Color.blue;
		}
		
		if (color.equals("rd")) {
			return Color.red;
		}
		
		if (color.equals("gr")) {
			return Color.green;
		}
		
		if (color.equals("or")) {
			return Color.orange;
		}
		
		if (color.equals("pk")) {
			return Color.pink;
		}
		
		if (color.equals("pu")) {
			return Color.magenta;
		}
		
		return null;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public String getDate() {
		return this.date;
	}

	@Override
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
}
