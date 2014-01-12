package de.htwg.se.mastermind.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
		assertFalse(grid.getCell(0, 0).equals(null));
	}
	
	@Test
	public void testGetRow() {
		assertEquals(0, grid.getCell(0, 0).getRow());
		assertEquals(1, grid.getCell(1, 0).getRow());
		assertEquals(1, grid.getCell(1, 1).getRow());
	}
	
	@Test
	public void testGetColumn() {
		assertEquals(0, grid.getCell(0, 0).getColumn());
		assertEquals(1, grid.getCell(0, 1).getColumn());
		assertEquals(1, grid.getCell(1, 1).getColumn());
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
		assertEquals(grid.getCell(0, 0), grid.getCell(0, 0));
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
		grid.getCell(0, 0).setValue("yl");
		assertEquals(false, grid.rowIsSet());
		grid.getCell(0, 1).setValue("yl");
		assertEquals(false, grid.rowIsSet());
		grid.getCell(0, 2).setValue("yl");
		assertEquals(false, grid.rowIsSet());
		grid.getCell(0, 3).setValue("yl");
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
		
		String [] masterColors = {"yl", "yl", "yl", "or"};
		grid.setMastermindColors(masterColors);
		grid.getCell(grid.getActualRow(), 0).setValue("yl");
		grid.getCell(grid.getActualRow(), 1).setValue("yl");
		grid.getCell(grid.getActualRow(), 2).setValue("yl");
		grid.getCell(grid.getActualRow(), 3).setValue("yl");
		assertTrue(grid.rowIsSet());
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
		assertFalse(grid.rowIsSet());
		grid.getCell(grid.getActualRow(), 0).setValue("yl");
		grid.getCell(grid.getActualRow(), 1).setValue("bl");
		grid.getCell(grid.getActualRow(), 2).setValue("rd");
		grid.getCell(grid.getActualRow(), 3).setValue("gr");
		assertTrue(grid.rowIsSet());

		String [] masterColors = {"bl", "rd", "gr", "rd"};
		grid.setMastermindColors(masterColors);
		grid.setSticks();
		assertEquals("wh", grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-1).getValue());
		assertEquals("wh", grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-2).getValue());
		assertEquals("wh", grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-3).getValue());
		assertEquals(null , grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-4).getValue());
		
		grid.incrementActualRow();
		String [] masterColors2 = {"bl", "bl", "bl", "or"};
		grid.setMastermindColors(masterColors2);
		grid.setSticks();
		assertEquals("bk", grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-1).getValue());
		assertEquals(null, grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-2).getValue());
		assertEquals(null, grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-3).getValue());
		assertEquals(null, grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-4).getValue());
		
		grid = new Grid(8,8);
		grid.solve();
		grid.setSticks();
		assertEquals("bk", grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-1).getValue());
		assertEquals("bk", grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-2).getValue());
		assertEquals("bk", grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-3).getValue());
		assertEquals("bk", grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-4).getValue());
		assertFalse(grid.getCell(grid.getActualRow(), grid.getColumnsAmount()-1).getValue().equals("wh"));
		
	}
	
	@Test
	public void testGetMastermindColors() {
		String [] masterColors = {"yl", "rd", "gr", "bl"};
		grid.setMastermindColors(masterColors);
		assertEquals("yl", grid.getMastermindColors()[0]);
		assertEquals("rd", grid.getMastermindColors()[1]);
		assertEquals("gr", grid.getMastermindColors()[2]);
		assertEquals("bl", grid.getMastermindColors()[3]);
	}
	
	/* Tests for Abstract Grid*/
	
	@Test
	public void testMasterBox() {
		assertEquals("              +-------------+" + newLine + 
					 "              | xx xx xx xx |" + newLine, grid.masterBox());
	}
	
	@Test
	public void testGameField() {
		assertEquals("+-------------+-------------+" + newLine + 
					 "|             |             |" + "[6]" + newLine +
					 "|             |             |" + "[5]" + newLine +
					 "|             |             |" + "[4]" + newLine +
					 "|             |             |" + "[3]" +newLine +
					 "|             |             |" + "[2]" +newLine +
					 "|             |             |" + "[1]" + newLine +
					 "|             |             |" + "[0]" +newLine +
					 "+-------------+-------------+" + newLine + 
					 "                [3][2][1][0]"   + newLine, grid.gameField());
	}
	
	@Test
	public void testGetAvailableColors() {
		String [] availableColors = this.grid.getAvailableColors();
		assertEquals("rd", availableColors[0]);
		assertEquals("bl", availableColors[1]);
		assertEquals("gr", availableColors[2]);
		assertEquals("yl", availableColors[3]);
		assertEquals("or", availableColors[4]);
		assertEquals("pu", availableColors[5]);
		assertEquals("pk", availableColors[6]);
	} 
}
