// Gruppe 10

package de.htwg.se.mastermind;

import de.htwg.se.mastermind.controller.IController;
import de.htwg.se.mastermind.controller.Controller;
import de.htwg.se.mastermind.gui.MastermindFrame;
import de.htwg.se.mastermind.view.tui.TextUI;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;


public class Mastermind {
	
	private static Mastermind instance;
	private static Scanner scanner;
	private static TextUI tui;
	private static MastermindFrame gui;
	private static IController controller;
	private static final int ROWS=8;
	private static final int COLUMNS=8;

	public static Mastermind getInstance() {
		if (instance == null) {
			instance = new Mastermind();
		}
		
		return instance;
	}

	private Mastermind() {
		PropertyConfigurator.configure("log4j.properties");
		controller = new Controller();
		controller.create(ROWS, COLUMNS);
		tui = new TextUI(controller);
		gui = new MastermindFrame(controller);
		gui.repaint();
		tui.print();
	}
	
	public static void main (String[] args) {
		
		Mastermind.getInstance();
		
		boolean gameContinue = true;
		
		scanner = new Scanner(System.in);
		while(gameContinue) {
			gameContinue = tui.processInputLine(scanner.next());
		}
	}
}
