package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.border.Border;
import data.Country;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SquareMap extends JPanel{
	
	protected JLabel[][] squareGrid;
	
	private int cols;
	private int rows;
	
	private Dimension caseSize;
	
	private Color[][] squareColors;
	private Color currentColor;
	
	private String[][] squareNames;
	
	private Country currentCountry;
	private Country[][] squareCountry;
	HashMap<Integer, Country> countriesMap = new HashMap<>();

	public SquareMap(int rows, int cols, HashMap<Integer, Country> countriesMap) {
		this.caseSize = new Dimension(10, 10);
		this.rows = rows;
		this.cols = cols;
		this.countriesMap.putAll(countriesMap);
		squareColors =  new Color[rows][cols];
		squareNames = new String[rows][cols];
		squareCountry = new Country[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.squareColors[i][j] = Color.WHITE;
				this.squareNames[i][j] = Integer.toString(1 + i + j);
				this.squareCountry[i][j] = countriesMap.get(8);
			}
		}
		createGrid();
		
	}
	
	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public Dimension getCaseSize() {
		return caseSize;
	}

	public void setCaseSize(Dimension caseSize) {
		this.caseSize = caseSize;
	}

	public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}

	public Country getCurrentCountry() {
		return currentCountry;
	}

	public void setCurrentCountry(Country currentCountry) {
		this.currentCountry = currentCountry;
	}

	public void removeMap() {
		squareColors =  new Color[rows][cols];
		squareNames = new String[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.squareColors[i][j] = Color.WHITE;
				this.squareNames[i][j] = Integer.toString(1 + i + j);
			}
		}
	}
	
	public void createGrid(){
		this.removeAll();
		this.setLayout(new GridLayout(rows, cols));
		squareGrid = new JLabel[rows][cols];
		for (int row = 0; row < squareGrid.length; row++) {
			for (int column = 0; column < squareGrid[row].length; column++) {
				int num = 1 + column + row;
				Square currentCase = new Square(row, column, Integer.toString(num));
				currentCase.setOpaque(true);
				Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				currentCase.setBorder(border);
				currentCase.setMaximumSize(caseSize);
				currentCase.setBackground(squareColors[row][column]);
				currentCase.setCountry(squareCountry[row][column]);
				add(currentCase);
				squareGrid[row][column] = currentCase;
			}
		}
	}
	
	public void createClickableGrid(Country country){
		this.currentColor = country.getEmpire().getColor();
		this.currentCountry = country;
		this.removeAll();
		this.setLayout(new GridLayout(rows, cols));
		squareGrid = new JLabel[rows][cols];
		for (int row = 0; row < squareGrid.length; row++) {
			for (int column = 0; column < squareGrid[row].length; column++) {
				Square currentCase = new Square(row, column, squareNames[row][column]);
				currentCase.setOpaque(true);
				Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				currentCase.setBorder(border);
				currentCase.setMaximumSize(caseSize);
				currentCase.setBackground(squareColors[row][column]);
				currentCase.setCountry(squareCountry[row][column]);
				currentCase.addMouseListener(new ColorChanger());
				add(currentCase);
				squareGrid[row][column] = currentCase;
			}
		}
	}
	
	public void createGameGrid() {
		this.removeAll();
		this.setLayout(new GridLayout(rows, cols));
		squareGrid = new JLabel[rows][cols];
		
		for (int row = 0; row < squareGrid.length; row++) {
			for (int column = 0; column < squareGrid[row].length; column++) {
				Square currentCase = new Square(row, column, squareNames[row][column]);
				currentCase.setOpaque(true);
				if (squareColors[row][column] != Color.WHITE) {
					int top;
					int left;
					int bot;
					int right;
					if ((row > 0) && (squareCountry[row - 1][column] == squareCountry[row][column])) {
						top = 0;
					} else {
						top = 5;
					} 
					if ((column > 0) && (squareCountry[row][column - 1] == squareCountry[row][column])) {
						left = 0; 
					} else {
						left = 5;
					} 
					if ((column < cols - 1) && (squareCountry[row][column + 1] == squareCountry[row][column])) {
						right = 0;
					} else {
						right = 5;
					} 
					if ((row < rows - 1) && (squareCountry[row + 1][column] == squareCountry[row][column])) {
							bot = 0;
					} else {
						bot = 5;
					} 
					currentCase.setBorder(BorderFactory.createMatteBorder(top, left, bot, right, squareColors[row][column]));
				}
				currentCase.setMaximumSize(caseSize);
				currentCase.setIcon(new ImageIcon("src/ressources/ground-zero.jpg"));
				currentCase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				currentCase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
				currentCase.setCountry(squareCountry[row][column]);
				currentCase.addMouseListener(new GameMaker());
				add(currentCase);
				squareGrid[row][column] = currentCase;
			}
		}
	}
	
	class ColorChanger implements MouseListener{
		
		public ColorChanger() {
			// TODO Auto-generated constructor stub
		}
		
		public void mouseClicked(MouseEvent e) {
			Square selectedCaseJLabel = (Square) e.getSource();
			
			if (selectedCaseJLabel.getBackground().equals(Color.WHITE)) {
				squareColors[selectedCaseJLabel.getPositionX()][selectedCaseJLabel.getPositionY()] = currentColor;
				squareNames[selectedCaseJLabel.getPositionX()][selectedCaseJLabel.getPositionY()] = currentCountry.getName();
				squareCountry[selectedCaseJLabel.getPositionX()][selectedCaseJLabel.getPositionY()] = currentCountry;
				selectedCaseJLabel.setBackground(currentColor);
				selectedCaseJLabel.setText(currentCountry.getName());
			}else{
				squareColors[selectedCaseJLabel.getPositionX()][selectedCaseJLabel.getPositionY()] = countriesMap.get(8).getEmpire().getColor();
				selectedCaseJLabel.setBackground(Color.WHITE);
				int num = 1 + selectedCaseJLabel.getPositionX() + selectedCaseJLabel.getPositionY();
				squareNames[selectedCaseJLabel.getPositionX()][selectedCaseJLabel.getPositionY()] = Integer.toString(num);
				squareCountry[selectedCaseJLabel.getPositionX()][selectedCaseJLabel.getPositionY()] = countriesMap.get(8);
				selectedCaseJLabel.setText(Integer.toString(num));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

	class GameMaker implements MouseListener{
		
		public GameMaker() {
			// TODO Auto-generated constructor stub
		}

		public void mouseClicked(MouseEvent e) {
			Square selectedCase = (Square) e.getSource();
			String abs = Integer.toString(selectedCase.getPositionX());
			String ord = Integer.toString(selectedCase.getPositionY());
			String name = selectedCase.getCountry().getName();
			System.out.println("(" + abs + " ; " + ord + "): " + name);
			if (selectedCase.getCountry().getEmpire().getName()==currentCountry.getEmpire().getName()) {
				System.out.println("Allie");
			}else if (selectedCase.getCountry().getEmpire().getName()=="Swiss Empire") {
				System.out.println("Meh");
			}else{
				System.out.println("Foe");
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}