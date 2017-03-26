package data;

public class SwordMaster extends Soldier{
	private int bonusAtk;
	private int bonusMvt;
	
	public SwordMaster(int attack, int defense, int movement, int level, int salary) {
		super(attack, defense, movement, level, salary);
	}
	
	public int getBonusAtk() {
		return bonusAtk;
	}
	
	public void setBonusAtk(int bonusAtk) {
		this.bonusAtk = bonusAtk;
	}
	
	public int getBonusMvt() {
		return bonusMvt;
	}
	
	public void setBonusMvt(int bonusMvt) {
		this.bonusMvt = bonusMvt;
	}
}
