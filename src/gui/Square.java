package gui;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Square extends JLabel{
	private int positionX;
	private int positionY;
	private String text;
	
	public Square(int positionX, int positionY, String text) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.text = text;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}