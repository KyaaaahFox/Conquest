package core;

import data.Country;

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
	public String battle() {
		int powerBalance = (int) Math.sqrt(Math.pow((atkPower - defPower), 2));
		if (atkPower < defPower) {
	 		atkCountry.suppAtkArmy();
			defCountry.defArmyLosses(powerBalance);
			return "Atacking country lost";
		}else if (atkPower > defPower) {
			defCountry.suppDefArmy();
			atkCountry.atkArmyLosses(powerBalance);
			atkCountry.getEmpire().setCountries(atkCountry.getEmpire().getCountries()+1);
			defCountry.getEmpire().setCountries(defCountry.getEmpire().getCountries()-1);
			defCountry.setEmpire(atkCountry.getEmpire());
			return "Attacking country won";
		}else{
	 		atkCountry.suppAtkArmy();
			defCountry.suppDefArmy();
			return "Draw game, both armies destroyed";
  		}
  	}
 }