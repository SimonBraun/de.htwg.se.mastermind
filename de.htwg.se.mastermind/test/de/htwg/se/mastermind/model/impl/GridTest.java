package de.htwg.se.mastermind.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GridTest {
	private Grid grid;
	
	@Before
	public void setUp() throws Exception {
		this.grid = new Grid();
	}
	
	@Test
	public void testGetCellValue() {
		grid.setCellValue(0, 0, "bl");
		assertEquals("bl", grid.getCellValue(0, 0));
	}
}
