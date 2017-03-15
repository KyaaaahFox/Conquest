package core;

import data.Country;

public class War {
	private Country atkCountry;
	private Country defCountry;
	//We need to differantiate the atacking army and the defending Country
	
	public War(Country atkCountry, Country defCountry) {
		super();
		this.atkCountry = atkCountry;
		this.defCountry = defCountry;
	}
	//to be continued: supposed to deal with fight between two empires
	//Set Counties and armies
	public void battle(Country defending, Empire armyBelongs, Empire beingAttacked) {
		if (atkCountry<defCountry) { 
			armyBelongs[nomberOfCountriesArmyBelongs+1] = defending;
			beingAttacked[nomberOfCountriesBeingAttacked] = NULL; 
			nomberOfCountriesBeingAttacked=nomberOfCountriesBeingAttacked-1;
			if (nomberOfCountriesBeingAttacked==0){
				System.out.println("Defending Player LOST");
			}
		}
		else if (atkCountry>defCountry) {
			atkCountry = NULL;
			System.out.println("Attacking Army is DESTROYED!");
		}
		else{
			atkCountry = NULL;
			defCountry = NULL;
			System.out.println("Defending Army is DESTROYED!");
			System.out.println("Attacking Army is DESTROYED!");
		}
	}
}
