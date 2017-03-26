package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import data.Country;

@SuppressWarnings("serial")
public class MapWindow extends JFrame{
	protected JPanel mainPanel = new JPanel();
	protected JPanel parametersPanel = new JPanel();
	
	protected SquareMap mapPanel;
	
	protected JComboBox<String> currentPlayer = new JComboBox<String>();
	
	private Color currentColor;
	
	private int cellWidth;	
	private int nombreDeJoueurs;
	
	public HashMap<Integer, Country> countriesMap = new HashMap<>();

	
	public MapWindow(int cellWidth, int ligne, int colonne, int nombreDeJoueurs, HashMap<Integer, Country> countriesMap) {
		this.cellWidth = cellWidth;
		this.nombreDeJoueurs = nombreDeJoueurs;
		this.mapPanel = new SquareMap(ligne, colonne, 10);
		this.countriesMap.putAll(countriesMap);
		initLists();
		createLayout();
	}

	protected void initLists(){
		switch (nombreDeJoueurs) {
		case 2:
			currentPlayer.addItem(countriesMap.get(0).getEmpire().getName());
			currentPlayer.addItem(countriesMap.get(2).getEmpire().getName());
			break;
		case 3:
			currentPlayer.addItem(countriesMap.get(0).getEmpire().getName());
			currentPlayer.addItem(countriesMap.get(2).getEmpire().getName());
			currentPlayer.addItem(countriesMap.get(4).getEmpire().getName());
			break;
		case 4:
			currentPlayer.addItem(countriesMap.get(0).getEmpire().getName());
			currentPlayer.addItem(countriesMap.get(2).getEmpire().getName());
			currentPlayer.addItem(countriesMap.get(4).getEmpire().getName());
			currentPlayer.addItem(countriesMap.get(6).getEmpire().getName());
			break;
		}
		
		currentColor = countriesMap.get(0).getEmpire().getColor();
	}
	
	protected void createLayout() {
		String titre = "Gestion Carte";
		setTitle(titre);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		mapPanel.removeAll();

		currentPlayer.addActionListener(new Selector());
		
		parametersPanel.setLayout(new BorderLayout());
		parametersPanel.add(currentPlayer, BorderLayout.NORTH);
		
		mapPanel.createClickableGrid(currentColor);
		
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
	
	class Selector implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selectedCountry = currentPlayer.getSelectedIndex() * 2;
			currentColor = countriesMap.get(selectedCountry).getEmpire().getColor();
			createLayout();
		}
	}
}
