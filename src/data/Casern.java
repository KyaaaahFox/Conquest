package data;

public class Casern {
	private int level;
	private int costLevel;
	private int costSoldier;
	private Soldier soldiers;
	
	public Casern(int level, int costLevel, int costSoldier, Soldier soldiers) {
		super();
		this.level = level;
		this.costLevel = costLevel;
		this.costSoldier = costSoldier;
		this.soldiers = soldiers;
	}

	/**
	 * Returns the level of the casern
	 * 
	 * @return The casern's level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Change the level of the casern
	 * <br/>
	 * The level is only supposed to be raised
	 * 
	 * @param level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Return the cost (in gold) needed to upgrade this casern
	 * 
	 * @return golds needed to level up the casern
	 */
	public int getCostLevel() {
		return costLevel;
	}
	
	/**
	 * Change the cost (in gold) needed to produce a unit with this casern after a level up of the casern
	 * 
	 * @param costLevel
	 */
	public void setCostLevel(int costLevel) {
		this.costLevel = costLevel;
	}

	/**
	 * Return the cost (in gold) needed to produce a unit with this casern
	 * 
	 * @return golds needed to create a soldier unit
	 */
	public int getCostSoldier() {
		return costSoldier;
	}

	/**
	 * Change the cost (in gold) needed to produce a unit with this casern after a level up of the casern
	 * 
	 * @param costSoldier
	 */
	public void setCostSoldier(int costSoldier) {
		this.costSoldier = costSoldier;
	}

	/**
	 * return the type of soldiers produced by this casern
	 * 
	 * @return {@link Soldier}
	 * @see Juggernaut
	 * @see SwordMaster
	 */
	public Soldier getSoldiers() {
		return soldiers;
	}
}
