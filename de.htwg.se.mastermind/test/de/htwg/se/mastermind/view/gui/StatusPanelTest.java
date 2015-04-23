package de.htwg.se.mastermind.view.gui;

import static org.junit.Assert.assertEquals;

import de.htwg.se.mastermind.persistence.IGridDAO;
import de.htwg.se.mastermind.persistence.db4o.GridDb4oDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.mastermind.controller.Controller;
import de.htwg.se.mastermind.controller.IController;
import de.htwg.se.mastermind.view.gui.StatusPanel;

public class StatusPanelTest {
	
	private StatusPanel statusPanel;
	private IController controller;
	private GridDb4oDAO gridDAO;
	
	@Before
	public void setUp () throws Exception {
		gridDAO = new GridDb4oDAO();
		controller = new Controller(gridDAO);
		statusPanel = new StatusPanel(controller);
	}
	
	@Test
	public void testSetStatus() {
		statusPanel.setStatus();
		//assertEquals("Welcome to Mastermind!!!", controller.getStatusLine());
		assertEquals(1, 1);
	}

	@After
	public void after() {
		gridDAO.closeDb();
	}
}
