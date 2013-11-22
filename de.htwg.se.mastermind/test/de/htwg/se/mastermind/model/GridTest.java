package de.htwg.se.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.mastermind.model.Grid;

public class GridTest {
	private Grid grid;
	
	@Before
	public void setUp() throws Exception {
		grid = new Grid();
		grid.create(8, 8);
	}
	
	@Test
	public void getCellValueTest() {
		grid.setCellValue(0, 0, "rd");
		assertEquals("rd", grid.getCellValue(0, 0));
	}
}
