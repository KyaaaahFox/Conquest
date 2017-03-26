package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SquareMap extends JPanel{
	private JLabel[][] squareGrid;
	private int cols;
	private int rows;
	private Dimension caseSize;
	private Color[][] squareColors;
	private Color currentColor;

	public SquareMap(int rows, int cols, int squareSize) {
		this.caseSize = new Dimension(squareSize, squareSize);
		this.rows = rows;
		this.cols = cols;
		squareColors =  new Color[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.squareColors[i][j] = Color.WHITE;
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
				add(currentCase);
				squareGrid[row][column] = currentCase;
			}
		}
	}
	
	public void createClickableGrid(Color color){
		this.currentColor = color;
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
				currentCase.addMouseListener(new ColorChanger());
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
				selectedCaseJLabel.setBackground(currentColor);
				selectedCaseJLabel.setText("Casern");
			}else{
				squareColors[selectedCaseJLabel.getPositionX()][selectedCaseJLabel.getPositionY()] = Color.WHITE;
				selectedCaseJLabel.setBackground(Color.WHITE);
				int num = 1 + selectedCaseJLabel.getPositionX() + selectedCaseJLabel.getPositionY();
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
}