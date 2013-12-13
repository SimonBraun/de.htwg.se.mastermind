package de.htwg.se.mastermind.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.mastermind.model.IGrid;

public class ControllerTest {
	private IGrid grid;
	private IController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new Controller();
		controller.create(8, 8);
		grid = controller.getGrid();
	}
	
	@Test
	public void testGetValue() {
		controller.setValue(0, 0, "yl");
		assertEquals("yl", grid.getCellValue(0, 0));
		controller.setValue(0, 1, "bl");
		assertEquals("bl", grid.getCellValue(0, 1));
	}
	
	@Test
	public void testCreate() {
		controller.create(5,5);
		grid = controller.getGrid();
		assertFalse(grid.equals(null));
	}
}
