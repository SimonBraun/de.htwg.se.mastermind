package de.htwg.se.mastermind.observer;

/**
 * Interface observer
 * @author sibraun
 *
 */
public interface IObserver {
	
	/**
	 * Update at event.
	 * @param e
	 */
	void update(Event e);
}
