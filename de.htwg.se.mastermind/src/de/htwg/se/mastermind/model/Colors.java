package de.htwg.se.mastermind.model;

public class Colors {
	//.
	private final String BASIC = "basic";
	private final String COUNTRY = "country";
	
	private static final String [] basicColors = {"rd", "bl", "gr", "yl", "or", "pu", "pk"};	
	private static final String [] countryColors = {"us", "de", "ch", "ru", "es", "fr", "gb"};
	
	public String [] getColor(String color){
		if(color.equals(BASIC)){
			return basicColors;
		}
		else if(color.equals(COUNTRY)){
			return countryColors;
		}
		else return basicColors;
	}
 
}