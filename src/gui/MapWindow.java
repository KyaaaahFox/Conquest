package gui;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MapWindow extends JFrame{
	protected JPanel mainPanel = new JPanel();
	protected SquareMap mapPanel;
	private int cellWidth;	
	private int nombreDeJoueurs;
	protected JPanel parametersPanel = new JPanel();
	protected JComboBox<String> currentPlayer = new JComboBox<String>();

	
	public MapWindow(int cellWidth, int ligne, int colonne, int nombreDeJoueurs) {
		this.cellWidth = cellWidth;
		this.nombreDeJoueurs = nombreDeJoueurs;
		this.mapPanel = new SquareMap(ligne, colonne, 10);
		createLayout();
	}

	protected void createLayout() {
		String titre = "Gestion Carte";
		System.out.println(nombreDeJoueurs);
		setTitle(titre);
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		switch (nombreDeJoueurs) {
		case 4:
			currentPlayer.addItem("Empire 4");
		case 3:
			currentPlayer.addItem("Empire 3");
		case 2:
			currentPlayer.addItem("Empire 2");
			currentPlayer.addItem("Empire 1");
		default:
			break;
		}
		
		parametersPanel.setLayout(new BorderLayout());
		parametersPanel.add(currentPlayer, BorderLayout.NORTH);
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(mapPanel, BorderLayout.CENTER);
		mainPanel.add(parametersPanel, BorderLayout.EAST);
		this.getContentPane().add(mainPanel);
		this.setVisible(true);
	}

	public int getCellWidth() {
		return cellWidth;
	}

	public void setCellWidth(int cellWidth) {
		this.cellWidth = cellWidth;
	}
	
}
