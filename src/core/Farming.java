package core;

import data.Country;
import data.Productions;

public class Farming {
	private static int GOLD_PER_TURN = 10;
	private static int WOOD_PER_TURN = 10;
	private Country country;
	private Productions production;
	private int nbmine;
	private int nbforest;
	private int prod;
	
	public Farming(Country country, Productions production) {
		this.country = country;
		nbmine = production.getMine();
		nbforest = production.getForest();
	}
	
	public void farmingWood() {
		prod = nbforest * production.getProduce() * WOOD_PER_TURN;
		country.setWood(prod);
	}
	
	public void farmingGold() {
		prod = nbmine * production.getProduce() * GOLD_PER_TURN;
		country.setGold(prod);
	}
}
