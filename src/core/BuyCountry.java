package core;

import java.util.Scanner;

import data.Country;

public class BuyCountry {

public void addCountryNeutural(Empire empire, Country country, Country neutral) {
	costCountryNeutral=50000000000000000000000000000*country.getNumberCases();
	if (country.getGold() > costCountryNeutral) {
		country.setGold(country.getGold() - costCountryNeutral;
		neutral.seNumberCases(country.getNumberCases()+1);
	}else{
		System.out.println("You do not have enough GOLD");
	}
}

}
