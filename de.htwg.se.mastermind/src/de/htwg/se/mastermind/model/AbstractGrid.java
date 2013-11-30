package de.htwg.se.mastermind.model;

public abstract class AbstractGrid implements IGrid {
	Cell [][] cells;
	
	protected int amountOfRows;
	protected int amountOfColumns;
	private int blockSize;
	
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	
	public int getBlockSize() {
		return this.blockSize;
	}
	
	public String blockSeparator(int blockSize) {
		StringBuilder sb = new StringBuilder("+");
		
		for (int i = 0; i < blockSize; i++) {
			for (int j = 0; j < blockSize*6; j++) {
				sb.append("-");
			}
			sb.append("+");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return toString(" ");
	}
	
	public String toString(String zero) {
		String newLine = System.getProperty("line.separator");
		String result = blockSeparator(blockSize) + newLine;
		
		StringBuilder sb = new StringBuilder(result);
		
		for (int j = amountOfRows - 1; j >= 0; j--) {
			sb.append("|");
			for (int k = amountOfColumns - 1; k >= 0; k--) {
				sb.append(" ");
				
				if (getCellValue(j,k) == null) {
					sb.append("  ");
				} else {
					sb.append(getCellValue(j,k).toString());
				}
				
				if(amountOfColumns/2 == k) {
					sb.append("|");
				}
			}
			sb.append("|" + newLine);
		}
		
		sb.append(blockSeparator(blockSize));
		
		return sb.toString();
	}
	
}
