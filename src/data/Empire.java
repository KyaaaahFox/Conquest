package data;

import java.awt.Color;
import java.util.Arrays;

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
	
	@Override
	public String toString() {
		return "Empire [name=" + name + ", allies=" + Arrays.toString(allies) + ", countries="
				+ Arrays.toString(countries) + ", color=" + color + "]";
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
	
	public void colorChoice(String colorName) {
		switch (colorName) {
		case "Red":
			setColor(Color.RED);
		break;
		case "Green":
			setColor(Color.GREEN);
		break;
		case "Blue":
			setColor(Color.BLUE);
		break;
		default:
			setColor(null);
		break;
		}
	}
}
