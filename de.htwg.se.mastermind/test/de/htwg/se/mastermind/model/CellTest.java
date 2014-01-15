package de.htwg.se.mastermind.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.mastermind.model.Cell;

public class CellTest {

	private Cell cell;
	
	@Before
	public void setUp() throws Exception {
		cell = new Cell(1,2);
	}
	
	@Test
	public void getValueTest() {
		cell.setValue("yl");
		assertEquals("yl", cell.getValue());
		cell.setValue("rd");
		assertEquals("rd", cell.getValue());
	}
	
	@Test
	public void setRowTest() {
		this.cell.setRow(0);
		assertEquals(0, cell.getRow());
		this.cell.setRow(2);
		assertEquals(2, cell.getRow());
	}
	
	@Test
	public void getRowTest() {
		assertEquals(1, cell.getRow());
	}
	
	@Test
	public void setColumnTest() {
		this.cell.setColumn(0);
		assertEquals(0, cell.getColumn());
		this.cell.setColumn(2);
		assertEquals(2, cell.getColumn());
	}
	
	@Test
	public void getColumnTest() {
		assertEquals(2, cell.getColumn());
	}
}
