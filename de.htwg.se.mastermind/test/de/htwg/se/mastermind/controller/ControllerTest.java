package de.htwg.se.mastermind.controller;

import static org.junit.Assert.assertArrayEquals;

import java.awt.Color;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import de.htwg.se.mastermind.persistence.db4o.GridDb4oDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.mastermind.model.IGrid;


public class ControllerTest {
	private IGrid grid;
	private IController controller;
	private GridDb4oDAO db4oDAO;
	
	@Before
	public void setUp() throws Exception {
		db4oDAO = new GridDb4oDAO();
		controller = new Controller(db4oDAO);
		controller.create(8, 8);
		grid = controller.getGrid();
	}

	@After
	public void after() {
		db4oDAO.closeDb();
	}
	
	@Test
	public void testGetValue() {
		controller.setValue(0, 0, "yl");
		assertEquals("yl", controller.getValue(0, 0));
		controller.setValue(0, 1, "bl");
		assertEquals("bl", controller.getValue(0, 1));
		controller.setValue(10, 0, "yl");
		controller.setValue(0, 10, "yl");
		controller.setValue(0, 0, "ut");
	}
	
	@Test
	public void testCreate() {
		controller.create(5,5);
		grid = controller.getGrid();
		assertFalse(grid.equals(null));
	}
	
	@Test
	public void testGetRowsAmount() {
		assertEquals(8, controller.getRowsAmount());
	}
	
	@Test
	public void testGetColumnsAmount() {
		assertEquals(8, controller.getColumnsAmount());
	}
	
	@Test
	public void testGetStatusLine() {
		assertEquals("New game has been created!", controller.getStatusLine());
	}
	
	@Test
	public void testConfirmRow() {
		controller.confirmRow();
		controller.setValue(grid.getActualRow(), 0, "yl");
		controller.setValue(grid.getActualRow(), 1, "yl");
		controller.setValue(grid.getActualRow(), 2, "yl");
		controller.setValue(grid.getActualRow(), 3, "yl");
		controller.confirmRow();
		String [] masterColors = {"yl", "yl", "yl", "yl"};
		grid.setMastermindColors(masterColors);
		grid.solve();
		controller.setValue(grid.getActualRow(), 0, "yl");
		controller.setValue(grid.getActualRow(), 1, "yl");
		controller.setValue(grid.getActualRow(), 2, "yl");
		controller.setValue(grid.getActualRow(), 3, "yl");
		controller.confirmRow();
	}
	
	@Test 
	public void testConfirmRow2() {
		String [] masterColors = {"yl", "yl", "yl", "yl"};
		grid.setMastermindColors(masterColors);	
		int lastRow = this.grid.getRowsAmount() - 1;
		for (int i = 0; i < lastRow; i++) {
			controller.setValue(grid.getActualRow(), 0, "rd");
			controller.setValue(grid.getActualRow(), 1, "yl");
			controller.setValue(grid.getActualRow(), 2, "yl");
			controller.setValue(grid.getActualRow(), 3, "yl");
			controller.confirmRow();
		}
	}
	
	@Test
	public void testGetMastermindColors() {
		String [] masterColors = {"yl", "yl", "yl", "yl"};
		grid.setMastermindColors(masterColors);
		masterColors = controller.getMastermindColors();
		for (int i = 0; i < masterColors.length; i++) {
			assertEquals("yl", masterColors[i]);
		}
	}
	
	@Test
	public void testGetAvailableColors() {
		String [] availableColors = this.controller.getAvailableColors();
		assertEquals("rd", availableColors[0]);
		assertEquals("bl", availableColors[1]);
		assertEquals("gr", availableColors[2]);
		assertEquals("yl", availableColors[3]);
		assertEquals("or", availableColors[4]);
		assertEquals("pu", availableColors[5]);
		assertEquals("pk", availableColors[6]);
	}
	
	@Test
	public void testSetShowSolution() {
		assertEquals(false, controller.getShowSolution());
		controller.setShowSolution(true);
		assertEquals(true, controller.getShowSolution());
	}
	
	@Test
	public void testGetIsNewGame() {
		assertEquals(true, controller.getIsNewGame());
		controller.setIsNewGame(false);
		assertEquals(false, controller.getIsNewGame());
	}
	
	@Test
	public void testnewMasterColors() {
		String [] masterColors = this.grid.getMastermindColors();
		controller.newMasterColors();
		assertNotEquals(masterColors, this.grid.getMastermindColors());
	}
	
	@Test
	public void testisSolved() {
		assertNotEquals(true, controller.isSolved());
	}
	
	@Test
	public void testGetRowConfirmed() {
		this.grid.setRowConfirmed(true);
		assertEquals(true, controller.getRowConfirmed());
	}
	
	@Test
	public void testsetChosenColor() {
		String [] basicColors = {"rd", "bl", "gr", "yl", "or", "pu", "pk"};
		controller.setChosenColor(basicColors);
		assertArrayEquals(basicColors, controller.getAvailableColors());
	}
	
	@Test
	public void testGetColor() {
		String [] basicColors = {"rd", "bl", "gr", "yl", "or", "pu", "pk"};	
		assertArrayEquals(basicColors, controller.getColor("basic"));
	}
	
	@Test
	public void testGetColorFromString() {
		assertEquals(Color.red, controller.getColorFromString("rd"));
	}
}
