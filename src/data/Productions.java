package data;

public class Productions {
	private int produce;
	private int mine;
	private int forest;
	
	public Productions() {
		super();
	}
	
	/**
	 * Production bonus, depending on the country
	 * @return
	 */
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
}
