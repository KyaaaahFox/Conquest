package data;

public class Map {
	private Empire[] empires;

	public Map(Empire[] empires) {
		super();
		this.empires = empires;
	}

	public Empire[] getEmpires() {
		return empires;
	}

	public void setEmpires(Empire[] empires) {
		this.empires = empires;
	}
}
