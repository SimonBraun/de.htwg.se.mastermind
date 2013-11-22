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
	}
	
	@Test
	public void createTest() {
		grid.create(8, 8);
		assertTrue(grid.cells[0][0].equals(null));
	}
}
