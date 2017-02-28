package data;

public class Country {
	private int gold;
	private int wood;
	private String name;
	private Casern[] caserns;
	private Productions producer;
	private Soldier[] offense;
	private Soldier[] defense;
	
	public Country(int gold, int wood, String name) {
		super();
		this.gold = gold;
		this.wood = wood;
		this.name = name;
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
	
	public Productions getProducer() {
		return producer;
	}
	
	public void setProducer(Productions producer) {
		this.producer = producer;
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
}
