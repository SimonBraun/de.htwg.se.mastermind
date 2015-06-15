package de.htwg.se.mastermind.util;

public class ColorPlugin implements Plugin{

	private String name;
	public ColorPlugin(){
		name = "country";
	}

	@Override
	public String getMenuEntry() {
		return name;
	}

}
