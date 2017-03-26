package core;

import data.Country;
import data.Empire;
import data.Soldier;

public class War {
  	private Country atkCountry;
  	private Country defCountry;
  	private int atkPower;
  	private int defPower;
	//We need to differantiate the atacking army and the defending Country
  	
  	public War(Country atkCountry, Country defCountry) {
  		super();
  		this.atkCountry = atkCountry;
  		this.defCountry = defCountry;
  		atkPower = 0;
  		defPower = 0;
  		for (int i = 0; i < atkCountry.getOffense().length; i++) {
  			atkPower += atkCountry.getOffense()[i].getAttack();
		}
  		for (int i = 0; i < defCountry.getDefense().length; i++) {
			defPower += defCountry.getOffense()[i].getAttack();
		}
  	}
  	
	//Set Counties and armies
	public void battle() {
		if (atkPower < defPower) {
			defCountry.getEmpire().setCountries(defCountry.getEmpire().getCountries()+1);
	 		for (int i = 0; i < atkCountry.getOffense().length; i++) {
				atkCountry.suppAtkArmy();
				defCountry.
			}
			beingAttacked[nomberOfCountriesBeingAttacked] = NULL; 
			nomberOfCountriesBeingAttacked=nomberOfCountriesBeingAttacked-1;
			if (nomberOfCountriesBeingAttacked==0){
				System.out.println("Defending Player LOST");
			}
		}
		else if (atkPower>defPower) {
			atkCountry.setOffense() = NULL;
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