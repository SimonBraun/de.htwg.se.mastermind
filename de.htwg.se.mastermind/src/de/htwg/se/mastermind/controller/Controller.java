package de.htwg.se.mastermind.controller;

import de.htwg.se.mastermind.observer.Observable;
import de.htwg.se.mastermind.model.IGrid;
import de.htwg.se.mastermind.model.Grid;

public class Controller extends Observable implements IController {
	
	private IGrid grid;
	private String statusLine = "Welcome to Mastermind!!!";

	@Override
	public void create(int rows, int columns) {
		this.grid = new Grid(rows, columns);
		statusLine = "New game has been created!";
		notifyObservers();
	}
	
	@Override
	public void confirmRow() {
		if (this.grid.rowIsSet()) {
			this.grid.setSticks();
			
			if (this.grid.isSolved()) {
				statusLine = "You have won!!";
			}
			
			this.grid.incrementActualRow();
		}
		notifyObservers();
	}
	
	@Override
	public void setValue(int row, int column, String value) {
		int actualRow = this.grid.getActualRow();
		int maxColumns = this.grid.getColumnsAmount()/2;
		if (this.grid.isColor(value)) {
			if(row == actualRow && column < maxColumns) {
				this.grid.setCellValue(row, column, value);
				statusLine = "The cell at [" + row + "],[" + column + "] has been set!";
			}
		}
		notifyObservers();
	}

	@Override
	public String getValue(int row, int column) {
		return this.grid.getCellValue(row, column);
	}
	
	@Override
	public IGrid getGrid() {
		return this.grid;
	}

	@Override
	public int getRowsAmount() {
		return grid.getRowsAmount();
	}

	@Override
	public int getColumnsAmount() {
		return grid.getColumnsAmount();
	}

	@Override
	public String getGridString() {
		return grid.toString();
	}
	
	@Override
	public String getStatusLine() {
		return this.statusLine;
	}

	@Override
	public void showSolution() {
		this.grid.showSolution();
		notifyObservers();
	}
}
