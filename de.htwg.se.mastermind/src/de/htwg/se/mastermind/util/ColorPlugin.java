package de.htwg.se.mastermind.util;

public class ColorPlugin implements Plugin{

	private boolean menuEnabled = false;
	public ColorPlugin(){
		menuEnabled = true;
	}

	@Override
	public boolean getMenuEntry() {
		return menuEnabled;
	}

}
