package de.htwg.se.mastermind.view.tui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import de.htwg.se.mastermind.persistence.db4o.GridDb4oDAO;
import de.htwg.se.mastermind.view.TextUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.mastermind.controller.Controller;
import de.htwg.se.mastermind.controller.IController;

public class TextUITest {
	private IController controller;
	private TextUI tui;
	private GridDb4oDAO db4oDAO;
	
	@Before
	public void setUp() throws Exception {
		db4oDAO = new GridDb4oDAO();
		controller = new Controller(db4oDAO);
		controller.create(8, 8);
		tui = new TextUI(controller);
	}

	@After
	public void after() {
		db4oDAO.closeDb();
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
		assertEquals("Welcome to Mastermind!!", controller.getStatusLine());
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
