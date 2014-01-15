package de.htwg.se.mastermind.observer;

/**
 * Interface observable provides methods to
 * control the observer.
 * @author sibraun
 *
 */
public interface IObservable {
	
	/**
	 * Add observer
	 * @param s
	 */
	void addObserver(IObserver s);
	
	/**
	 * Remove Observer
	 * @param s
	 */
	void removeObserver(IObserver s);
	
	/**
	 * Remove all observers
	 */
	void removeAllObservers();
	
	/**
	 * Notify observer
	 */
	void notifyObservers();
	
	/**
	 * Notify all observers
	 * @param e
	 */
	void notifyObservers(Event e);
}
