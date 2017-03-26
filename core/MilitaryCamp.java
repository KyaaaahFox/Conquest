package core;

import java.util.Scanner;

import data.Casern;
import data.Country;
import data.Soldier;

public class MilitaryCamp {
	//to be continued: supposed to affect soldiers to atk or def
	public void addSoldiers(Country country, Casern casern) {
		if (country.getGold() > casern.getCostSoldier()) {
			Soldier soldiers = casern.getSoldiers();
			country.setGold(country.getGold() - casern.getCostSoldier());
			affectSoldiers(country, casern, soldiers);
		}else{
			System.out.println("Vous n'avez pas assez de GOLD");
		}
	}
	
	public void affectSoldiers(Country country, Casern casern, Soldier soldier) {
		System.out.println("Where do you want to affect the new unit ? (atk/def)");
		Scanner scan = new Scanner(System.in);
		String answer = scan.nextLine();
		scan.close();
		if (answer.equals("atk")) {
			country.addAtkSoldier(soldier);
		}else if (answer.equals("def")) {
			country.addDefSoldier(soldier);
		}
	}
}
