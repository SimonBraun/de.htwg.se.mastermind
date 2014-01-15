package de.htwg.se.mastermind.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class Observer. 
 * @author sibraun
 *
 */
public class Observable implements IObservable {

	private List<IObserver> subscribers = new ArrayList<IObserver>(2);

	/**
	 * Adds an observer.
	 * @param IObserver
	 */
	public void addObserver(IObserver s) {
		subscribers.add(s);
	}

	/**
	 * Removes an observer.
	 * @param IObserver
	 */
	public void removeObserver(IObserver s) {
		subscribers.remove(s);
	}

	/**
	 * Removes all observers.
	 */
	public void removeAllObservers() {
		subscribers.clear();
	}

	/**
	 * Notifies Observers.
	 */
	public void notifyObservers() {
		notifyObservers(null);
	}

	@Override
	public void notifyObservers(Event e) {
		for ( Iterator<IObserver> iter = subscribers.iterator(); iter.hasNext();) {
			IObserver observer = iter.next();
			observer.update(e);
		}
	}
}
