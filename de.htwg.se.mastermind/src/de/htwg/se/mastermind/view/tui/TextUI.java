package de.htwg.se.mastermind.view.tui;

import de.htwg.se.mastermind.controller.IController;
import de.htwg.se.mastermind.observer.Event;
import de.htwg.se.mastermind.observer.IObserver;

import org.apache.log4j.Logger;

public class TextUI implements IObserver {

	private IController controller;
	
	private Logger logger = Logger.getLogger("de.htwg.sudoku.aview.tui");
	
	public TextUI(IController controller) {
		this.controller = controller;
		//controller.addObserver(this);
	}
	@Override
	public void update(Event e) {
		// TODO Auto-generated method stub
		
	}

}
