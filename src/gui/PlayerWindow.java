package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.opencsv.CSVReader;

import data.Country;
import data.Empire;

@SuppressWarnings("serial")
public class PlayerWindow extends JFrame {
	private int ligne;
	private int colonne;
	private int nombreDeJoueurs;

	protected JPanel mainPanel = new JPanel();
	protected JPanel countryOnePanel = new JPanel();
	protected JPanel countryTwoPanel = new JPanel();
	protected JPanel countryThreePanel = new JPanel();
	protected JPanel countryFourPanel = new JPanel();
	protected JPanel lineOne = new JPanel();
	protected JPanel lineTwo = new JPanel();
	protected JPanel lineThree = new JPanel();
	protected JPanel lineFour = new JPanel();
	protected JPanel countriesPanel = new JPanel();

	protected JLabel countryOneNameLabel = new JLabel("Player 1 Empire: ");
	protected JLabel countryOneColorLabel = new JLabel("Color of your Empire: ");
	protected JLabel countryTwoNameLabel = new JLabel("Player 2 Empire: ");
	protected JLabel countryTwoColorLabel = new JLabel("Color of your Empire: ");
	protected JLabel countryThreeNameLabel = new JLabel("Player 3 Empire: ");
	protected JLabel countryThreeColorLabel = new JLabel("Color of your Empire: ");
	protected JLabel countryFourNameLabel = new JLabel("Player 4 Empire: ");
	protected JLabel countryFourColorLabel = new JLabel("Color of your Empire: ");

	protected JComboBox<String> countryOneChoice = new JComboBox<String>();
	protected JComboBox<String> countryOneColorChoice = new JComboBox<String>();
	protected JComboBox<String> countryTwoChoice = new JComboBox<String>();
	protected JComboBox<String> countryTwoColorChoice = new JComboBox<String>();
	protected JComboBox<String> countryThreeChoice = new JComboBox<String>();
	protected JComboBox<String> countryThreeColorChoice = new JComboBox<String>();
	protected JComboBox<String> countryFourChoice = new JComboBox<String>();
	protected JComboBox<String> countryFourColorChoice = new JComboBox<String>();

	protected JButton lockButton = new JButton("Valider");
	
	public HashMap<Integer, Country> countriesMap = new HashMap<>();
	
	public PlayerWindow(int ligne, int colonne, int nombreDeJoueurs) {
		this.ligne = ligne;
		this.colonne = colonne;
		this.nombreDeJoueurs = nombreDeJoueurs;
		initLists();
		createLayout(nombreDeJoueurs);
	}

	protected void initLists() {
		countryOneChoice.setMaximumSize(new Dimension(300, 200));
		countryTwoChoice.setMaximumSize(new Dimension(300, 200));
		ArrayList<String> empireList = new ArrayList<String>();
		try {
			CSVReader empires = new CSVReader(new FileReader("empires.csv"));
			String[] line;
			while ((line = empires.readNext()) != null) {
				if (!line[0].equals("Swiss Empire")) {
					empireList.add(line[0]);
				}
			}
			empires.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] empireArray = empireList.toArray(new String[] {});
		for (int i = 0; i < empireArray.length; i++) {
			countryOneChoice.addItem(empireArray[i]);
			countryTwoChoice.addItem(empireArray[i]);
			countryThreeChoice.addItem(empireArray[i]);
			countryFourChoice.addItem(empireArray[i]);
		}

		countryOneColorChoice.setMaximumSize(new Dimension(300, 200));
		countryTwoColorChoice.setMaximumSize(new Dimension(300, 200));
		ArrayList<String> colorList = new ArrayList<String>();
		try {
			CSVReader colors = new CSVReader(new FileReader("colors.csv"));
			String[] line;
			while ((line = colors.readNext()) != null) {
				colorList.add(line[0]);
			}
			colors.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] colorArray = colorList.toArray(new String[] {});
		for (int i = 0; i < colorArray.length; i++) {
			countryOneColorChoice.addItem(colorArray[i]);
			countryTwoColorChoice.addItem(colorArray[i]);
			countryThreeColorChoice.addItem(colorArray[i]);
			countryFourColorChoice.addItem(colorArray[i]);
		}

		lockButton.addActionListener(new LockAction());
	}

	protected void createLayout(int numberCountries) {
		String titre = "Gestion Empires";

		setTitle(titre);
		setSize(800, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		countryOnePanel.setLayout(new BoxLayout(countryOnePanel, BoxLayout.LINE_AXIS));
		countryOnePanel.add(countryOneNameLabel);
		countryOnePanel.add(countryOneChoice);
		countryOnePanel.add(countryOneColorLabel);
		countryOnePanel.add(countryOneColorChoice);

		countryTwoPanel.setLayout(new BoxLayout(countryTwoPanel, BoxLayout.LINE_AXIS));
		countryTwoPanel.add(countryTwoNameLabel);
		countryTwoPanel.add(countryTwoChoice);
		countryTwoPanel.add(countryTwoColorLabel);
		countryTwoPanel.add(countryTwoColorChoice);

		if (numberCountries >= 2) {
			lineTwo.setLayout(new BoxLayout(lineTwo, BoxLayout.Y_AXIS));
			lineTwo.add(countryOnePanel);
			lineTwo.add(countryTwoPanel);

			countriesPanel.setLayout(new BorderLayout());
			countriesPanel.add(lineTwo, BorderLayout.NORTH);
			if (numberCountries >= 3) {
				countryThreePanel.setLayout(new BoxLayout(countryThreePanel, BoxLayout.LINE_AXIS));
				countryThreePanel.add(countryThreeNameLabel);
				countryThreePanel.add(countryThreeChoice);
				countryThreePanel.add(countryThreeColorLabel);
				countryThreePanel.add(countryThreeColorChoice);

				lineTwo.setLayout(new BoxLayout(lineTwo, BoxLayout.Y_AXIS));
				lineTwo.add(countryOnePanel);
				lineTwo.add(countryTwoPanel);
				lineTwo.add(countryThreePanel);

				countriesPanel.setLayout(new BorderLayout());
				countriesPanel.add(lineTwo, BorderLayout.NORTH);
				countriesPanel.add(lineThree, BorderLayout.CENTER);
				if (numberCountries == 4) {
					countryFourPanel.setLayout(new BoxLayout(countryFourPanel, BoxLayout.LINE_AXIS));
					countryFourPanel.add(countryFourNameLabel);
					countryFourPanel.add(countryFourChoice);
					countryFourPanel.add(countryFourColorLabel);
					countryFourPanel.add(countryFourColorChoice);

					lineTwo.setLayout(new BoxLayout(lineTwo, BoxLayout.Y_AXIS));
					lineTwo.add(countryOnePanel);
					lineTwo.add(countryTwoPanel);
					lineTwo.add(countryThreePanel);
					lineTwo.add(countryFourPanel);

					countriesPanel.setLayout(new BorderLayout());
					countriesPanel.add(lineTwo, BorderLayout.NORTH);
					countriesPanel.add(lineThree, BorderLayout.CENTER);
					countriesPanel.add(lineFour, BorderLayout.SOUTH);
				}
			}
		}

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(countriesPanel, BorderLayout.NORTH);
		mainPanel.add(lockButton, BorderLayout.SOUTH);
		this.getContentPane().add(mainPanel);
		this.setVisible(true);
	}

	public void createEmpire() {
		Empire empirePlayerOne = new Empire((String) countryOneChoice.getSelectedItem());
		empirePlayerOne.colorChoice((String) countryOneColorChoice.getSelectedItem());
		Empire empirePlayerTwo = new Empire((String) countryTwoChoice.getSelectedItem());
		empirePlayerTwo.colorChoice((String) countryTwoColorChoice.getSelectedItem());
		Empire empirePlayerThree = new Empire((String) countryThreeChoice.getSelectedItem());
		empirePlayerThree.colorChoice((String) countryThreeColorChoice.getSelectedItem());
		Empire empirePlayerFour = new Empire((String) countryFourChoice.getSelectedItem());
		empirePlayerFour.colorChoice((String) countryFourColorChoice.getSelectedItem());
		Empire empireNeutre = new Empire("Swiss Empire");
		empireNeutre.colorChoice("White");
		
		try {
			CSVReader empireFile = new CSVReader(new FileReader("empires.csv"));
			String[] nextLine;
			while ((nextLine = empireFile.readNext()) != null) {
				if (nextLine[0].equals(empirePlayerOne.getName())) {
					Country countryOnePlayerOne = countryReader(nextLine[1], empirePlayerOne);
					Country countryTwoPlayerOne = countryReader(nextLine[2], empirePlayerOne);
					countriesMap.put(0, countryOnePlayerOne);
					countriesMap.put(1, countryTwoPlayerOne);
				}
				if (nextLine[0].equals(empirePlayerTwo.getName())) {
					Country countryOnePlayerTwo = countryReader(nextLine[1], empirePlayerTwo);
					Country countryTwoPlayerTwo = countryReader(nextLine[2], empirePlayerTwo);
					countriesMap.put(2, countryOnePlayerTwo);
					countriesMap.put(3, countryTwoPlayerTwo);
				}
				if (nextLine[0].equals(empirePlayerThree.getName())) {
					Country countryOnePlayerThree = countryReader(nextLine[1], empirePlayerThree);
					Country countryTwoPlayerThree = countryReader(nextLine[2], empirePlayerThree);
					countriesMap.put(4, countryOnePlayerThree);
					countriesMap.put(5, countryTwoPlayerThree);
				}
				if (nextLine[0].equals(empirePlayerFour.getName())) {
					Country countryOnePlayerFour = countryReader(nextLine[1], empirePlayerFour);
					Country countryTwoPlayerFour = countryReader(nextLine[2], empirePlayerFour);
					countriesMap.put(6, countryOnePlayerFour);
					countriesMap.put(7, countryTwoPlayerFour);
				}
				if (nextLine[0].equals(empireNeutre.getName())) {
					Country countryOneSuisse = countryReader(nextLine[1], empireNeutre);
					Country countryTwoSuisse = countryReader(nextLine[2], empireNeutre);
					countriesMap.put(8, countryOneSuisse);
					countriesMap.put(9, countryTwoSuisse);
				}
			}
			empireFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public Country countryReader(String countryName, Empire empire) {
		Country country = null;
		try {
			CSVReader countryFile = new CSVReader(new FileReader("countries.csv"));
			String[] nextLine;
			while ((nextLine = countryFile.readNext()) != null) {
				if (nextLine[0].equals(countryName)) {
					int gold = Integer.parseInt(nextLine[1]);
					int wood = Integer.parseInt(nextLine[2]);
					String name = nextLine[0];
					int producer = Integer.parseInt(nextLine[4]);
					Country countryTMP = new Country(gold, wood, name, empire);
					countryTMP.setProduce(producer);
					country = countryTMP;
				}
			}
			countryFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return country;
	}
	
	class LockAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int indexCountryOne = countryOneChoice.getSelectedIndex();
			int indexCountryTwo = countryTwoChoice.getSelectedIndex();
			int indexColorOne = countryOneColorChoice.getSelectedIndex();
			int indexColorTwo = countryTwoColorChoice.getSelectedIndex();
			int indexCountryThree = -1;
			int indexColorThree = -1;
			int indexCountryFour = -2;
			int indexColorFour = -2;
			
			if (nombreDeJoueurs >= 3) {
				indexCountryThree = countryThreeChoice.getSelectedIndex();
				indexColorThree = countryThreeColorChoice.getSelectedIndex();
			}
			
			if (nombreDeJoueurs == 4) {
				indexCountryFour = countryFourChoice.getSelectedIndex();
				indexColorFour = countryFourColorChoice.getSelectedIndex();
			}

			if ((((indexCountryOne == indexCountryTwo) || (indexCountryOne == indexCountryThree)
					|| (indexCountryOne == indexCountryFour)) || (indexCountryOne == 0))
					|| (((indexColorOne == indexColorTwo) || (indexColorOne == indexColorThree)
							|| (indexColorOne == indexColorFour)) || (indexColorOne == 0))
					|| (((indexCountryTwo == indexCountryThree) || (indexCountryTwo == indexCountryFour))
							|| (indexCountryTwo == 0))
					|| (((indexColorTwo == indexColorThree) || (indexColorTwo == indexColorFour))
							|| (indexColorTwo == 0))
					|| ((indexCountryThree == indexCountryFour) || (indexCountryThree == 0))
					|| ((indexColorThree == indexColorFour) || (indexColorThree == 0)) || (indexCountryFour == 0)
					|| (indexColorFour == 0)) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						} catch (Exception e) {
							e.printStackTrace();
						}
						new ErrorWindow("Veuillez sélectionner des empires et couleurs différents");
					}
				});
			} else {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						int cellWidth = 40;
						try {
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						} catch (Exception e) {
							e.printStackTrace();
						}
						createEmpire();
						new MapWindow(cellWidth, ligne, colonne, nombreDeJoueurs, countriesMap);
						dispose();
					}
				});
			}
		}
	}

}
