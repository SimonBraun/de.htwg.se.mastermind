package de.htwg.se.mastermind.model;

public abstract class AbstractCell implements ICell {
	
	private String value;
	private int row;
	private int column;
	
	@Override
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return this.value;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public int getColumn() {
		return this.column;
	}
}
