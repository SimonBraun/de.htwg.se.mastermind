// Gruppe 10

package de.htwg.se.mastermind;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.htwg.se.mastermind.controller.IController;
import de.htwg.se.mastermind.view.gui.MastermindFrame;
import de.htwg.se.mastermind.view.tui.TextUI;

import java.util.Scanner;

/**
 * Mastermind
 * @author sibraun
 *
 */
public final class Mastermind {
 
	private static Mastermind instance;
	private static Scanner scanner;
	private static TextUI tui;
	private static MastermindFrame gui;
	private static IController controller;
	private static final int ROWS=8;
	private static final int COLUMNS=8;

	/**
	 * Get instance provides an new instance
	 * @return instance
	 */
	public static Mastermind getInstance() {
		if (instance == null) {
			instance = new Mastermind();
		}

		return instance;
	}

	public IController getController () {
		return controller;
	}

	public TextUI getTUI() {
		return tui;
	}

	private Mastermind() {
		Injector injector = Guice.createInjector(new MastermindModule());
		controller = injector.getInstance(IController.class);
		controller.create(ROWS, COLUMNS);
		tui = new TextUI(controller);
		gui = new MastermindFrame(controller);
		gui.repaint();
		tui.print();
	}

	/**
	 * Main
	 * @param args
	 */
	public static void main (String[] args) {

		Mastermind.getInstance();

		boolean gameContinue = true;

		scanner = new Scanner(System.in);
		while(gameContinue) {
			gameContinue = tui.processInputLine(scanner.next());
		}
	}
}