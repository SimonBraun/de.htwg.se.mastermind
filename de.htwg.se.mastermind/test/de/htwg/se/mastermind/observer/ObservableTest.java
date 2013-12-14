package de.htwg.se.mastermind.observer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.mastermind.observer.Event;
import de.htwg.se.mastermind.observer.IObserver;
import de.htwg.se.mastermind.observer.Observable;

public class ObservableTest {
	private boolean ping=false;
	private TestObserver testObserver;
	private Observable testObservable;
	private Event e;
	
	class TestObserver implements IObserver {
		//@Override
		public void update(Event e) {
			ping=true;
		}
		
	}

	@Before
	public void setUp() throws Exception {
		testObserver = new TestObserver();
		testObservable = new Observable();
		testObservable.addObserver(testObserver);
		e = new Event();
	}

	@Test
	public void testNotify() {
		assertFalse(ping);
		testObservable.notifyObservers();
		assertTrue(ping);
	}
	
	@Test
	public void testRemove() {
		assertFalse(ping);
		testObservable.removeObserver(testObserver);
		testObservable.notifyObservers();
		assertFalse(ping);
	}
	
	@Test
	public void testRemoveAll() {
		assertFalse(ping);
		testObservable.removeAllObservers();
		testObservable.notifyObservers();
		assertFalse(ping);
	}
	
	@Test
	public void testUpdate() {
		assertFalse(ping);
		testObserver.update(e);
		assertTrue(ping);
	}
}
