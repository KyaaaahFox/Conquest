package data;

public class Juggernaut extends Soldier{
	private int bonusDef;

	public Juggernaut(int attack, int defense, int movement, int level, int salary) {
		super(attack, defense, movement, level, salary);
	}

	public int getBonusDef() {
		return bonusDef;
	}

	public void setBonusDef(int bonusDef) {
		this.bonusDef = bonusDef;
	}
}
