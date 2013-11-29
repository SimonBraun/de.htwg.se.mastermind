package de.htwg.se.mastermind.model;

public abstract class AbstractGrid implements IGrid {
	Cell [][] cells;
	
	protected int amountOfRows;
	protected int amountOfColumns;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 2; i++) {
			sb.append("+");
			sb.append("---------");
			sb.append("+");
		}
		
		return sb.toString();
	}
	
}
