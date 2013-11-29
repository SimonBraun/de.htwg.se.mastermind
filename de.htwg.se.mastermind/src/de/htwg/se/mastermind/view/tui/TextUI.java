package de.htwg.se.mastermind.view.tui;

import de.htwg.se.mastermind.controller.IController;
import de.htwg.se.mastermind.observer.Event;
import de.htwg.se.mastermind.observer.IObserver;

import org.apache.log4j.Logger;

public class TextUI implements IObserver {

	private static final int ROWS=8;
	private static final int COLUMNS=8;
	
	private IController controller;
	
	private Logger logger = Logger.getLogger("de.htwg.sudoku.aview.tui");
	
	public TextUI(IController controller) {
		this.controller = controller;
		//this.controller.addObserver(this);
	}
	@Override
	public void update(Event e) {
		// TODO Auto-generated method stub
	}
	
	public boolean processInputLine(String input) {
		
		switch(input) {
			case "n":
				controller.create(ROWS, COLUMNS);
				break;
				
			case "q":
				return false;
		}
		
		return true;
	}

}
