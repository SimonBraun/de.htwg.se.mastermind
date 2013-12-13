package de.htwg.se.mastermind.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class GridTest {
	String newLine = System.getProperty("line.separator");
	private Grid grid;
	
	@Before
	public void setUp() throws Exception {
		grid = new Grid(8,8);
	}
	
	/* Tests for Grid*/
	
	@Test
	public void testCreate() {
		grid.create(8, 8);
		assertFalse(grid.cells[0][0].equals(null));
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
		assertEquals(false, grid.rowIsSet());
		grid.cells[0][0].setValue("yl");
		assertEquals(false, grid.rowIsSet());
		grid.cells[0][1].setValue("yl");
		assertEquals(false, grid.rowIsSet());
		grid.cells[0][2].setValue("yl");
		assertEquals(false, grid.rowIsSet());
		grid.cells[0][3].setValue("yl");
		assertEquals(true, grid.rowIsSet());
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
		grid.solve();
		assertEquals(true, grid.isSolved());
	}
	
	@Test
	public void testShowSolution() {
		assertEquals("xx", grid.getCellValue(grid.getRowsAmount() - 1, 0));
		grid.showSolution();
		assertFalse(grid.getCellValue(grid.getRowsAmount() - 1, 0).equals("xx"));
	}
	
	@Test
	public void testSetSticks() {
		/*grid.cells[0][0].setValue("yl");
		grid.cells[0][1].setValue("yl");
		grid.cells[0][1].setValue("yl");
		grid.cells[0][0].setValue("yl");*/
		/*grid.showSolution();
		String value = grid.cells[0][grid.amountOfRows-1].getValue();*/
		
		
		grid.solve();
		grid.setSticks();
		assertEquals("bk", grid.cells[grid.getActualRow()][grid.amountOfRows-1].getValue());
		assertEquals("bk", grid.cells[grid.getActualRow()][grid.amountOfRows-2].getValue());
		assertEquals("bk", grid.cells[grid.getActualRow()][grid.amountOfRows-3].getValue());
		assertEquals("bk", grid.cells[grid.getActualRow()][grid.amountOfRows-4].getValue());
		assertFalse(grid.cells[grid.getActualRow()][grid.amountOfRows-1].getValue().equals("wh"));
		
	}
	
	/* Tests for Abstract Grid*/
	
	@Test
	public void setBlockSize() {
		grid.setBlockSize(0);
		assertEquals(0, grid.getBlockSize());
		grid.setBlockSize(2);
		assertEquals(2, grid.getBlockSize());
	}
	
	@Test
	public void testBlockSeparator() {
		grid.setBlockSize(0);
		assertEquals("+", grid.blockSeparator(grid.getBlockSize()));
		grid.setBlockSize(1);
		assertEquals("+------+", grid.blockSeparator(grid.getBlockSize()));
		grid.setBlockSize(2);
		assertEquals("+------------+------------+", grid.blockSeparator(grid.getBlockSize()));
	}
	
	/*@Test
	public void testToString() {
		grid.setBlockSize(1);
		assertEquals("+-----+"+ newLine + "|   |" +newLine+ "+------+" + newLine, grid.toString());
		grid.setCellValue(0, 0, "yl");
		//assertEquals("+---+"+newLine+"| yl |"+newLine+"+---+"+newLine, grid.toString());
	}*/
	
}
