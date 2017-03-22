package data;

import java.util.Arrays;

public class Country {
	private int gold;
	private int wood;
	private String name;
	private Casern[] caserns;
	private int produce;
	private int mine;
	private int forest;
	private Soldier[] offense;
	private Soldier[] defense;
	private Empire empire;
	
	public Country(int gold, int wood, String name, Empire empire) {
		super();
		this.gold = gold;
		this.wood = wood;
		this.name = name;
		this.empire = empire;
	}
		
	
	@Override
	public String toString() {
		return "Country [gold=" + gold + ", wood=" + wood + ", name=" + name + ", caserns=" + Arrays.toString(caserns)
				+ ", produce=" + produce + ", mine=" + mine + ", forest=" + forest + ", offense="
				+ Arrays.toString(offense) + ", defense=" + Arrays.toString(defense) + "]";
	}


	public int getGold() {
		return gold;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public int getWood() {
		return wood;
	}
	
	public void setWood(int wood) {
		this.wood = wood;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Casern[] getCaserns() {
		return caserns;
	}
	
	public void setCaserns(Casern[] caserns) {
		this.caserns = caserns;
	}
	
	public int getProduce() {
		return produce;
	}
	
	public void setProduce(int produce) {
		this.produce = produce;
	}
	
	public int getMine() {
		return mine;
	}
	
	public void setMine(int mine) {
		this.mine = mine;
	}
	
	public int getForest() {
		return forest;
	}
	
	public void setForest(int forest) {
		this.forest = forest;
	}
	
	public Soldier[] getOffense() {
		return offense;
	}
	
	public void setOffense(Soldier[] offense) {
		this.offense = offense;
	}
	
	public Soldier[] getDefense() {
		return defense;
	}
	
	public void setDefense(Soldier[] defense) {
		this.defense = defense;
	}


	public Empire getEmpire() {
		return empire;
	}


	public void setEmpire(Empire empire) {
		this.empire = empire;
	}
}
