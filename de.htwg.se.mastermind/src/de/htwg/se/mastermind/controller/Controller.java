package de.htwg.se.mastermind.controller;

import de.htwg.se.mastermind.observer.*;
import de.htwg.se.mastermind.model.*;

public class Controller extends Observable implements IController {
	
	private IGrid grid;

	@Override
	public void setValue(int row, int column, String value) {
		grid.setCellValue(row, column, value);
		
	}

	@Override
	public String getValue(int row, int column) {
		return grid.getCellValue(row, column);
	}

	@Override
	public void create(int rows, int columns) {
		grid.create(rows, columns);
	}

}
