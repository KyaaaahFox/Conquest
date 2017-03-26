package data;

public class Soldier {
	private int attack;
	private int defense;
	private int movement;
	private int level;
	private int salary;
	private int posX;
	private int posY;
	
	public Soldier(int attack, int defense, int movement, int level, int salary) {
		super();
		this.attack = attack;
		this.defense = defense;
		this.movement = movement;
		this.level = level;
		this.salary = salary;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getMovement() {
		return movement;
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
