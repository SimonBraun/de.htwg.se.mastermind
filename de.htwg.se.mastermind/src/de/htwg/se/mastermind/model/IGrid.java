package de.htwg.se.mastermind.model;

public interface IGrid {
	
	void setCellValue(int row, int column, String value);
	
	String getCellValue(int row, int column);
	
	
	
}
