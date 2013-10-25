package de.htwg.se.mastermind.model.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import de.htwg.se.mastermind.model.impl.Cell;

public class CellTest {
	
	Cell cell;
	
	@Before
	public void setUp() throws Exception {
		this.cell = new Cell(8,8);
	}
	
	@Test
	public void testGetValue() {
		this.cell.setValue("yl");
		assertEquals("yl", this.cell.getValue());
		
		this.cell.setValue("bl");
		assertEquals("bl", this.cell.getValue());
		
	}
	
	@Test
	public void testGetRow() {
		assertEquals(8, this.cell.getRow());
	}
	
	@Test
	public void testGetColumn() {
		assertEquals(8, this.cell.getColumn());
	}
}
