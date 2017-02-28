package data;

import java.awt.Color;

public class Empire {
	private String name;
	private Empire[] allies;
	private Country[] countries;
	private Color color;
	
	public Empire(String name, Country[] countries) {
		super();
		this.name = name;
		this.countries = countries;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Empire[] getAllies() {
		return allies;
	}
	
	public void setAllies(Empire[] allies) {
		this.allies = allies;
	}
	
	public Country[] getCountries() {
		return countries;
	}
	
	public void setCountries(Country[] countries) {
		this.countries = countries;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
