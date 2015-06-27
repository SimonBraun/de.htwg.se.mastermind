package de.htwg.se.mastermind.model;

public class Colors {
	private static final String BASIC = "basic";
	private static final String COUNTRY = "country";
	
	private static final String [] BASIC_COLORS = {"rd", "bl", "gr", "yl", "or", "pu", "pk"};
	private static final String [] COUNTRY_COLORS = {"us", "de", "ch", "ru", "es", "fr", "gb"};
	
	public String [] getColor(String color){
		if(color.equals(BASIC)){
			return BASIC_COLORS;
		}
		else if(color.equals(COUNTRY)){
			return COUNTRY_COLORS;
		}
		else {
			return BASIC_COLORS;
		}
	}
 
}