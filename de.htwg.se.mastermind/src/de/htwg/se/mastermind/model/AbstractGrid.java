package de.htwg.se.mastermind.model;

public abstract class AbstractGrid implements IGrid {
	public Cell [][] cells;
	
	protected int amountOfRows;
	protected int amountOfColumns;
	
	private final static int SPACESAMOUNT = 14;
	private final static int MINUSAMOUNT = 26;
	private final static int PLUSINDEX = 12;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String masterBox = masterBox();
		String gameField = gameField();
		
		sb.append(masterBox).append(gameField);
		return sb.toString();
	}
	
	public String masterBox() {
		String newLine = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < SPACESAMOUNT; i++) {
			sb.append(" ");
		}
		sb.append("+");
		
		for (int i = 0; i < SPACESAMOUNT-1; i++) {
			sb.append("-");
		}
		sb.append("+").append(newLine);
		
		for (int i = 0; i < SPACESAMOUNT; i++) {
			sb.append(" ");
		}
		sb.append("| ");
		
		for (int i = amountOfColumns/2 - 1; i >=0 ; i--) {
			sb.append(getCellValue(getRowsAmount()-1,i)).append(" ");
		}
		sb.append("|").append(newLine);
		
		return sb.toString();
	}
	
	public String gameField() {
		String newLine = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder("+");
		
		for (int i = 0; i < MINUSAMOUNT; i++) {
			sb.append("-");
			
			if (i == PLUSINDEX) {
				sb.append("+");
			}
			
		}
		sb.append("+" + newLine);
		
		for (int j = amountOfRows - 2; j >= 0; j--) {
			sb.append("|");
			for (int k = amountOfColumns - 1; k >= 0; k--) {
				sb.append(" ");
				
				if (getCellValue(j,k) == null) {
					sb.append("  ");
				} else {
					sb.append(getCellValue(j,k).toString());
				}
				
				if(amountOfColumns/2 == k) {
					sb.append(" |");
				}
			}
			sb.append(" |[" + j  + "]" + newLine);
		}
		
		sb.append("+");
		
		for (int i = 0; i < MINUSAMOUNT; i++) {
			sb.append("-");
			
			if (i == PLUSINDEX) {
				sb.append("+");
			}
		}
		sb.append("+" + newLine);
		
		for (int i = 0; i < SPACESAMOUNT + 2; i++) {
			sb.append(" ");
		}
		
		for (int i = amountOfColumns/2 - 1; i >= 0; i--) {
			sb.append("[").append(i).append("]");
		}
		
		sb.append(newLine);
		
		return sb.toString();
	}
}
