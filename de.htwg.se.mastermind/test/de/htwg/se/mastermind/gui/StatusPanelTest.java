package de.htwg.se.mastermind.gui;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.mastermind.controller.Controller;
import de.htwg.se.mastermind.controller.IController;

public class StatusPanelTest {
	
	private StatusPanel statusPanel;
	private IController controller;
	
	@Before
	public void setUp () throws Exception {
		controller = new Controller();
		statusPanel = new StatusPanel(controller);
	}
	
	@Test
	public void testSetStatus() {
		statusPanel.setStatus();
		assertEquals("Welcome to Mastermind!!!", controller.getStatusLine());
	}
}
