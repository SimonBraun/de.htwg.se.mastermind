package de.htwg.se.mastermind.model;

public abstract class AbstractGrid implements IGrid {
	Cell [][] cells;
	
	protected int amountOfRows;
	protected int amountOfColumns;
	
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
		
		for (int i = 0; i < 14; i++) {
			sb.append(" ");
		}
		sb.append("+");
		
		for (int i = 0; i < 13; i++) {
			sb.append("-");
		}
		sb.append("+").append(newLine);
		
		for (int i = 0; i < 14; i++) {
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
		
		for (int i = 0; i < 26; i++) {
			sb.append("-");
			
			if (i == 12) {
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
		
		for (int i = 0; i < 26; i++) {
			sb.append("-");
			
			if (i == 12) {
				sb.append("+");
			}
		}
		sb.append("+" + newLine);
		
		for (int i = 0; i < 16; i++) {
			sb.append(" ");
		}
		
		for (int i = amountOfColumns/2 - 1; i >= 0; i--) {
			sb.append("[").append(i).append("]");
		}
		
		sb.append(newLine);
		
		return sb.toString();
		
	}
}
