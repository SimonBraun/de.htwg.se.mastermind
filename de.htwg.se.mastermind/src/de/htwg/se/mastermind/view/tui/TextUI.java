package de.htwg.se.mastermind.view.tui;

import de.htwg.se.mastermind.controller.IController;
import de.htwg.se.mastermind.observer.Event;
import de.htwg.se.mastermind.observer.IObserver;

import org.apache.log4j.Logger;

public class TextUI implements IObserver {

	private String newLine = System.getProperty("line.separator");
	
	private IController controller;
	
	private Logger logger = Logger.getLogger("de.htwg.se.mastermind.view.tui");
	
	public TextUI(IController controller) {
		this.controller = controller;
		this.controller.addObserver(this);
	}
	
	@Override
	public void update(Event e) {
		print();
	}
	
	public boolean processInputLine(String input) {
		
		char [] inputChar = new char[input.length()];
		
		for (int i = 0; i < input.length(); i++) {
			inputChar[i] = input.charAt(i);
		}
		
		for (int i = 0; i < inputChar.length; i++) {
			switch(inputChar[i]) {
				case 'n':
					int rowsAmount = controller.getRowsAmount();
					controller.resetSize(rowsAmount);
					break;
					
				case 'q':
					return false;
					
				case 'c':
					controller.confirmRow();
					break;
					
				case 's':
					controller.showSolution();
			}
		}
		
		if(input.matches("[0-9][0-9][a-z][a-z]")) {
			String [] args = readToArray(input);
			controller.setValue(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2] + args[2+1]);
		}
		
		if(input.matches("[z][4]") || input.matches("[z][8]")) {
			String [] args = readToArray(input);
			controller.resetSize(Integer.parseInt(args[1]));
		}
		
		if(input.matches("[z][1][2]")) {
			String [] args = readToArray(input);
			StringBuilder sb = new StringBuilder(args[1] + args[2]);
			controller.resetSize(Integer.parseInt(sb.toString()));
		}
		
		return true;
	}
	
	private String [] readToArray(String input) {
		String [] args = new String[input.length()];
		
		for (int i = 0; i < args.length; i++) {
			
			args[i] = input.substring(i, i+1);
		}
		
		return args;
	}
	
	public void print() {
		logger.info(newLine + controller.getGridString());
		logger.info(newLine + controller.getStatusLine());
		logger.info(newLine + "Available Colors: yl, gr, rd, bl, or, pk, pu");
		logger.info(newLine + "Possible Commands: n-new, q-quit, c-confirm row, xyco-set a color at x, y, s-show solution, zn-sets the size");
		logger.info(newLine + "Please enter command: ");
	}
}
