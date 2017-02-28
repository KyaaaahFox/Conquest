package core;

import data.Casern;
import data.Country;

public class LevelUp {
	private Country country;
	private Casern casern;
	private int currentLevel;
	private int costLevel;

	public LevelUp(Country country, Casern casern) {
		this.country = country;
		this.casern = casern;
		this.currentLevel = casern.getLevel();
		this.costLevel = casern.getCostLevel();
	}
	
	public int lvlUp() {
		return currentLevel++;
	}
	
	public void richEnough() {
		if (country.getGold() >= costLevel) {
			country.setGold(country.getGold() - costLevel);
			casern.setLevel(lvlUp());
		}
	}
}