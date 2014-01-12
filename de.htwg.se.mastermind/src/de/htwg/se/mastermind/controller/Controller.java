package de.htwg.se.mastermind.controller;

import de.htwg.se.mastermind.observer.Observable;
import de.htwg.se.mastermind.model.IGrid;
import de.htwg.se.mastermind.model.Grid;
import de.htwg.se.mastermind.observer.Event;

public class Controller extends Observable implements IController {
	
	private IGrid grid;
	private String statusLine = "Welcome to Mastermind!!!";
	private static final int COLUMNS = 8;

	@Override
	public void create(int rows, int columns) {
		this.grid = new Grid(rows, columns);
		statusLine = "New game has been created!";
		notifyObservers();
	}
	
	@Override
	public boolean confirmRow() {
		if (this.grid.rowIsSet()) {
			statusLine = "Row [" + this.grid.getActualRow() + "] confirmed!";
			this.grid.setSticks();
			
			if (this.grid.isSolved()) {
				statusLine = "You have won!!";
				this.grid.showSolution();
			} else {
				if (this.grid.getActualRow() == this.grid.getRowsAmount() - 2) {
					this.grid.showSolution();
					statusLine = "You have lost!!";
				}
			}
			
			this.grid.incrementActualRow();
			notifyObservers();
			return true;
		}
		return false;
	}
	
	@Override
	public void setValue(int row, int column, String value) {
		int actualRow = this.grid.getActualRow();
		int maxColumns = this.grid.getColumnsAmount()/2;

		if(this.grid.isColor(value) && row == actualRow && column < maxColumns) {
			this.grid.setCellValue(row, column, value);
			statusLine = "The cell at [" + row + "],[" + column + "] has been set!";
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
		statusLine = "The solution of the game:";
		this.grid.showSolution();
		notifyObservers();
	}

	@Override
	public String[] getMastermindColors() {
		return this.grid.getMastermindColors();
	}

	@Override
	public int getActualRow() {
		return this.grid.getActualRow();
	}

	@Override
	public String[] getAvailableColors() {
		return this.grid.getAvailableColors();
	}
	
	@Override
	public boolean isSolved() {
		return this.grid.isSolved();
	}

	@Override
	public void resetSize(int rows) {
		this.grid = new Grid(rows, COLUMNS);
		Event event = new SizeChangedEvent();
		notifyObservers(event);
	}
}
