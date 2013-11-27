package de.htwg.se.mastermind.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class GridTest {
	private Grid grid;
	
	@Before
	public void setUp() throws Exception {
		grid = new Grid(8,8);
	}
	
	@Test
	public void testCreate() {
		grid.create(8, 8);
		assertFalse(grid.cells[0][0] == null);
	}
	
	@Test
	public void testGetRow() {
		assertEquals(0, grid.cells[0][0].getRow());
		assertEquals(1, grid.cells[1][0].getRow());
		assertEquals(1, grid.cells[1][1].getRow());
	}
	
	@Test
	public void testSetRow() {
		grid.cells[0][0].setRow(4);
		assertEquals(4, grid.cells[0][0].getRow());
	}
	
	@Test
	public void testGetColumn() {
		assertEquals(0, grid.cells[0][0].getColumn());
		assertEquals(1, grid.cells[0][1].getColumn());
		assertEquals(1, grid.cells[1][1].getColumn());
	}
	
	@Test
	public void testSetColumn() {
		grid.cells[0][0].setColumn(8);
		assertEquals(8, grid.cells[0][0].getColumn());
	}
	
	@Test
	public void testGetRowValue() {
		grid.setCellValue(0, 0, "yl");
		assertEquals("yl", grid.getCellValue(0, 0));
		grid.setCellValue(1, 5, "bl");
		assertEquals("bl", grid.getCellValue(1, 5));
	}
}
