package de.htwg.se.mastermind.controller;

import de.htwg.se.mastermind.observer.*;
import de.htwg.se.mastermind.model.*;

public class Controller extends Observable implements IController {
	
	private IGrid grid;

	@Override
	public void create(int rows, int columns) {
		this.grid = new Grid(rows, columns);
		notifyObservers();
	}
	
	@Override
	public void confirmRow() {
		if (this.grid.rowIsSet()) {
			this.grid.incrementActualRow();
		}
		notifyObservers();
	}
	
	@Override
	public void setValue(int row, int column, String value) {
		
		int actualRow = this.grid.getActualRow();
		if(row == actualRow && column < 4) {
			this.grid.setCellValue(row, column, value);
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
}
