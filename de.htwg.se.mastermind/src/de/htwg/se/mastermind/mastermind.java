// Gruppe 10

package de.htwg.se.mastermind;

import de.htwg.se.mastermind.controller.*;
import de.htwg.se.mastermind.model.Grid;

public class mastermind {
	
	private static IController controller;
	private static final int ROWS=8;
	private static final int COLUMNS=8;
	
	public static void main (String[] args) {
		
		controller = new Controller();
		controller.create(ROWS, COLUMNS);
		controller.setValue(0, 0, "yl");
		//grid = new Grid(8,8);
	}
}
