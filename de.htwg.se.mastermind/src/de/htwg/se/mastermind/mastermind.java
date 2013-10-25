package de.htwg.se.mastermind;

import de.htwg.se.mastermind.model.impl.*;

public class mastermind {
	
	public static void main (String[] args) {
		
		Grid g = new Grid();
		g.setCellValue(0, 0, "yl");
		System.out.println(g.getCellValue(0, 0));
	}
}
