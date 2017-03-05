package core;

import data.Country;

public class Farming {
	private static int GOLD_PER_TURN = 10;
	private static int WOOD_PER_TURN = 10;
	private Country country;
	private int nbmine;
	private int nbforest;
	private int prod;
	
	public Farming(Country country) {
		this.country = country;
		nbmine = country.getMine();
		nbforest = country.getForest();
	}
	
	public void farmingWood() {
		prod = nbforest * country.getProduce() * WOOD_PER_TURN;
		country.setWood(prod);
	}
	
	public void farmingGold() {
		prod = nbmine * country.getProduce() * GOLD_PER_TURN;
		country.setGold(prod);
	}
}
