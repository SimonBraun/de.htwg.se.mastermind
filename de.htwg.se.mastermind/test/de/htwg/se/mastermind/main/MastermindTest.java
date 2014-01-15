package de.htwg.se.mastermind.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.mastermind.Mastermind;

public class MastermindTest {
	
	private Mastermind instance;
	
	@Before
	public void setUp() throws Exception {
		assertEquals(null, instance);
		instance = Mastermind.getInstance();
	}
	
	@Test
	public void testGetInstance() {
		assertFalse(instance.equals(null));
		instance = Mastermind.getInstance();
		assertFalse(instance.equals(null));
	}
}
