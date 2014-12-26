package de.htwg.se.mastermind.model;

/**
 * Abstract class Grid provides further methods which allows
 * to control the grid.
 * @author sibraun
 *
 */
public abstract class AbstractGrid implements IGrid {
	
	private int amountOfRows;
	private int amountOfColumns;
	
	@Override
	public String toString() {
		amountOfRows = getRowsAmount();
		amountOfColumns = getColumnsAmount();
		StringBuilder sb = new StringBuilder();
		String masterBox = masterBox();
		String gameField = gameField();
		
		sb.append(masterBox).append(gameField);
		return sb.toString();
	}
	
	/**
	 * Builds a string of the master box.
	 * @return string
	 */
	public String masterBox() {
		amountOfRows = getRowsAmount();
		amountOfColumns = getColumnsAmount();
		int spacesAmount = amountOfColumns * 2 - (amountOfColumns/2 - 2);
		String newLine = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < spacesAmount; i++) {
			sb.append(" ");
		}
		sb.append("+");
		
		for (int i = 0; i < spacesAmount-1; i++) {
			sb.append("-");
		}
		sb.append("+").append(newLine);
		
		for (int i = 0; i < spacesAmount; i++) {
			sb.append(" ");
		}
		sb.append("| ");
		
		for (int i = amountOfColumns/2 - 1; i >=0 ; i--) {
			sb.append(getCellValue(getRowsAmount()-1,i)).append(" ");
		}
		sb.append("|").append(newLine);
		
		return sb.toString();
	}
	
	/**
	 * Builds a string of the game field.
	 * @return string
	 */
	public String gameField() {
		amountOfRows = getRowsAmount();
		amountOfColumns = getColumnsAmount();
		int minusAmount = amountOfColumns*2 - (amountOfColumns/2 - 1);
		int spacesAmount = amountOfColumns * 2 - (amountOfColumns/2 - 2);
		String newLine = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder("+");
		
		for (int i = 0; i < minusAmount; i++) {
			sb.append("-");
		}
		
		sb.append("+");
		
		for (int i = 0; i < minusAmount; i++) {
			sb.append("-");
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
		
		for (int i = 0; i < minusAmount; i++) {
			sb.append("-");
		}
		
		sb.append("+");
		
		for (int i = 0; i < minusAmount; i++) {
			sb.append("-");
		}
		
		sb.append("+" + newLine);
		
		for (int i = 0; i < spacesAmount + 2; i++) {
			sb.append(" ");
		}
		
		for (int i = amountOfColumns/2 - 1; i >= 0; i--) {
			sb.append("[").append(i).append("]");
		}
		
		sb.append(newLine);
		
		return sb.toString();
	}
}
