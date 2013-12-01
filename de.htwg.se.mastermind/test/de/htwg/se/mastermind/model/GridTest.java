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
	
	@Test
	public void testGetRowAmount() {
		assertEquals(8, grid.getRowsAmount());
	}
	
	@Test
	public void testColumnAmount() {
		assertEquals(8, grid.getColumnsAmount());
	}
	
	@Test
	public void testGetICell() {
		assertEquals(grid.cells[0][0], grid.getCell(0, 0));
	}
	
	@Test
	public void testGetActualRow() {
		assertEquals(0, grid.getActualRow());
		grid.incrementActualRow();
		assertEquals(1, grid.getActualRow());
	}
	
	@Test
	public void rowIsSet() {
		assertEquals(null, grid.cells[0][0].getValue());
		grid.cells[0][0].setValue("yl");
		assertEquals("yl", grid.cells[0][0].getValue());
	}
	
	@Test
	public void testIsColor() {
		assertEquals(true, grid.isColor("yl"));
		assertEquals(true, grid.isColor("bl"));
		assertEquals(true, grid.isColor("rd"));
		assertEquals(true, grid.isColor("pk"));
		assertEquals(true, grid.isColor("gr"));
		assertEquals(true, grid.isColor("pu"));
		assertEquals(true, grid.isColor("or"));
		assertEquals(false, grid.isColor("pp"));
		assertEquals(false, grid.isColor("bk"));
	}
	
	@Test
	public void testIsSolved() {
		assertEquals(false, grid.isSolved());
	}
	
	@Test
	public void testShowSolution() {
		assertEquals("xx", grid.getCellValue(grid.getRowsAmount() - 1, 0));
		grid.showSolution();
		assertFalse(grid.getCellValue(grid.getRowsAmount() - 1, 0) == "xx");
	}
	
}
