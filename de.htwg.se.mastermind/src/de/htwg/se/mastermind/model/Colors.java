package de.htwg.se.mastermind.model;

public class Colors {
	private static final String basic = "basic";
	private static final String country = "country";
	
	private static final String [] BASIC_COLORS = {"rd", "bl", "gr", "yl", "or", "pu", "pk"};
	private static final String [] COUNTRY_COLORS = {"us", "de", "ch", "ru", "es", "fr", "gb"};
	
	public String [] getColor(String color){
		if(color.equals(basic)){
			return BASIC_COLORS;
		}
		else if(color.equals(country)){
			return COUNTRY_COLORS;
		}
		else {
			return BASIC_COLORS;
		}
	}
 
}