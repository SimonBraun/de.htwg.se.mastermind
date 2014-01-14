package de.htwg.se.mastermind.view.tui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import org.apache.log4j.Logger;
import de.htwg.se.mastermind.controller.Controller;
import de.htwg.se.mastermind.controller.IController;
import de.htwg.se.mastermind.model.Grid;
import de.htwg.se.mastermind.model.IGrid;
//import org.apache.log4j.PropertyConfigurator;

public class TextUITest {
	IGrid grid;
	private IController controller;
	private TextUI tui;
	static Logger logger = Logger.getLogger(TextUI.class);
	
	@Before
	public void setUp() throws Exception {
		grid = new Grid(8,8);
		controller = new Controller();
		tui = new TextUI(controller);
		controller.create(8, 8);
	}
	
	@Test
	public void testProcessInputLine1() {
		tui.processInputLine("00yl");
		assertEquals("yl", controller.getValue(0, 0));
		assertFalse(tui.processInputLine("q"));
	}
	
	@Test
	public void testProcessInputLine2() {
		tui.processInputLine("n");
		assertEquals("New game has been created!", controller.getStatusLine());
	}
	
	@Test
	public void testProcessInputLine3() {
		int actualRow = controller.getActualRow();
		controller.setValue(0, 0, "yl");
		controller.setValue(0, 1, "yl");
		controller.setValue(0, 2, "yl");
		controller.setValue(0, 3, "yl");
		tui.processInputLine("c");
		assertEquals("Row [" + actualRow + "] confirmed!", controller.getStatusLine());
	}
	
	@Test
	public void testProcessInputLine4() {
		tui.processInputLine("s");
		assertEquals("Solution is shown", controller.getStatusLine());
	}
	
	@Test
	public void testProcessInputLine5() {
		tui.processInputLine("z4");
		assertEquals(4, controller.getRowsAmount());
		tui.processInputLine("z8");
		assertEquals(8, controller.getRowsAmount());
		tui.processInputLine("z12");
		assertEquals(12, controller.getRowsAmount());
	}
}
