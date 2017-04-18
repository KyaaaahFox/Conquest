package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import data.Country;

@SuppressWarnings("serial")
public class MapWindow extends JFrame {
	protected JPanel mainPanel = new JPanel();
	protected JPanel parametersPanel = new JPanel();
	protected JPanel buttonsPanel = new JPanel();
	protected JPanel countryOnePanel = new JPanel();
	protected JPanel countryTwoPanel = new JPanel();
	protected JPanel countriesPanel = new JPanel();

	protected JButton clearMapButton = new JButton("Clear the map");
	protected JButton lockMapButton = new JButton("Confirm Map");

	protected JTextArea countryOneText = new JTextArea();
	protected JTextArea countryTwoText = new JTextArea();

	ButtonGroup radioCountryGroup = new ButtonGroup();

	protected JRadioButton countryOne;
	protected JRadioButton countryTwo;

	protected SquareMap mapPanel;

	protected JComboBox<String> currentPlayer = new JComboBox<String>();

	private Country currentCountry;

	private int cellWidth;
	private int nombreDeJoueurs;

	public HashMap<Integer, Country> countriesMap = new HashMap<>();

	public MapWindow(int cellWidth, int ligne, int colonne, int nombreDeJoueurs,
			HashMap<Integer, Country> countriesMap) {
		this.cellWidth = cellWidth;
		this.nombreDeJoueurs = nombreDeJoueurs;
		this.mapPanel = new SquareMap(ligne, colonne, countriesMap);
		this.countriesMap.putAll(countriesMap);
		initLists();
		createInitLayout();
	}

	protected void initLists() {
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

		currentCountry = countriesMap.get(0);

		clearMapButton.addActionListener(new ClearMap());
		lockMapButton.addActionListener(new LockMap());
	}

	protected void createInitLayout() {
		String titre = "Gestion Carte";
		setTitle(titre);
		setMinimumSize(new Dimension(800, 800));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		countriesPanel.removeAll();
		buttonsPanel.removeAll();
		parametersPanel.removeAll();
		mapPanel.removeAll();
		mainPanel.removeAll();

		currentPlayer.addActionListener(new Selector());

		countriesPanel.setLayout(new BorderLayout());
		countryOnePanel.setLayout(new BorderLayout());
		countryTwoPanel.setLayout(new BorderLayout());
		createCountryPanel();

		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.add(clearMapButton, BorderLayout.WEST);
		buttonsPanel.add(lockMapButton, BorderLayout.EAST);

		parametersPanel.setLayout(new BorderLayout());
		parametersPanel.add(currentPlayer, BorderLayout.NORTH);
		parametersPanel.add(countriesPanel, BorderLayout.CENTER);
		parametersPanel.add(buttonsPanel, BorderLayout.SOUTH);

		mapPanel.createClickableGrid(currentCountry);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(mapPanel, BorderLayout.CENTER);
		mainPanel.add(parametersPanel, BorderLayout.EAST);
		this.getContentPane().add(mainPanel);
		this.setVisible(true);
	}

	protected void createGameLayout() {
		String titre = "Gestion Carte";
		setTitle(titre);
		setMinimumSize(new Dimension(800, 800));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		buttonsPanel.removeAll();
		parametersPanel.removeAll();
		mapPanel.removeAll();
		mainPanel.removeAll();

		currentPlayer.addActionListener(new Selector());

		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.add(clearMapButton, BorderLayout.WEST);
		buttonsPanel.add(lockMapButton, BorderLayout.EAST);

		parametersPanel.setLayout(new BorderLayout());

		mapPanel.createGameGrid();

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

	protected void createCountryPanel(){
		countryOnePanel.removeAll();
		countryTwoPanel.removeAll();
		countriesPanel.removeAll();
		int nbCountry = 0;
		for (int i = 0; i < nombreDeJoueurs * 2; i++) {
			if (countriesMap.get(i).getEmpire().getName()==currentCountry.getEmpire().getName() && nbCountry==0) {
				countryOne = new JRadioButton(countriesMap.get(i).getName());
				countryOne.addActionListener(new CountrySelect());
				countryOneText.setText("Gold Production: " + countriesMap.get(i).getGold() + "\n"
						+ "Wood Production: " + countriesMap.get(i).getWood());
				countryOneText.setEditable(false);
				radioCountryGroup.add(countryOne);
				countryOnePanel.add(countryOne, BorderLayout.NORTH);
				countryOnePanel.add(countryOneText, BorderLayout.CENTER);
				countryOnePanel.revalidate();
				countryOnePanel.repaint();
				
				nbCountry++;
			}else if (countriesMap.get(i).getEmpire().getName()==currentCountry.getEmpire().getName() && nbCountry==1) {
				countryTwo = new JRadioButton(countriesMap.get(i).getName());
				countryTwo.addActionListener(new CountrySelect());
				countryTwoText.setText("Gold Production: " + countriesMap.get(i).getGold() + "\n"
						+ "Wood Production: " + countriesMap.get(i).getWood());
				countryTwoText.setEditable(false);
				radioCountryGroup.add(countryTwo);
				countryTwoPanel.add(countryTwo, BorderLayout.NORTH);
				countryTwoPanel.add(countryTwoText, BorderLayout.CENTER);
				countryTwoPanel.revalidate();
				countryTwoPanel.repaint();
			}
		}
		countryOne.setSelected(true);
		countriesPanel.add(countryOnePanel, BorderLayout.NORTH);
		countriesPanel.add(countryTwoPanel, BorderLayout.CENTER);
		countriesPanel.revalidate();
		countriesPanel.repaint();
	}

	class Selector implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selectedCountry = currentPlayer.getSelectedIndex() * 2;
			currentCountry = countriesMap.get(selectedCountry);
			mapPanel.setCurrentCountry(currentCountry);
			mapPanel.setCurrentColor(currentCountry.getEmpire().getColor());
			createCountryPanel();
		}
	}

	class CountrySelect implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String selectedCountry = currentCountry.getName();
			for (Enumeration<AbstractButton> buttons = radioCountryGroup.getElements(); buttons.hasMoreElements();) {
				AbstractButton button = buttons.nextElement();
				if (button.isSelected()) {
					selectedCountry = button.getText();
				}
			}
			for (int i = 0; i < nombreDeJoueurs * 2; i++) {
				if (countriesMap.get(i).getName() == selectedCountry) {
					currentCountry = countriesMap.get(i);
				}
			}
			mapPanel.setCurrentCountry(currentCountry);
			mapPanel.setCurrentColor(currentCountry.getEmpire().getColor());
		}
	}

	class ClearMap implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mapPanel.removeMap();
			createInitLayout();
		}
	}

	class LockMap implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			createGameLayout();
		}
	}
}
