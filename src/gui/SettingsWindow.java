package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LinearGradientPaint;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.text.html.HTMLDocument.Iterator;

import com.opencsv.CSVReader;

import data.Country;
import data.Empire;

@SuppressWarnings("serial")
public class SettingsWindow extends JFrame {
	private int numberCountries = 2;

	protected SquareMap mapPanel = new SquareMap(16, 16, 10);
	protected JPanel settingsPanel = new JPanel();
	protected JPanel lineOne = new JPanel();
	protected JPanel mapSizePanel = new JPanel();
	protected JPanel numberEmpirePanel = new JPanel();
	protected JPanel choiceButtonsPanel = new JPanel();
	protected JPanel countryOnePanel = new JPanel();
	protected JPanel countryTwoPanel = new JPanel();
	protected JPanel countryThreePanel = new JPanel();
	protected JPanel countryFourPanel = new JPanel();
	protected JPanel lineTwo = new JPanel();
	protected JPanel lineThree = new JPanel();
	protected JPanel lineFour = new JPanel();
	protected JPanel countriesPanel = new JPanel();
	protected JPanel lastLine = new JPanel();
	protected JPanel boxPanel = new JPanel();

	protected JLabel rowLabel = new JLabel("Number of lines: ");
	protected JLabel colLabel = new JLabel("Number of columns: ");
	protected JLabel countryOneNameLabel = new JLabel("Player 1 Empire: ");
	protected JLabel countryOneColorLabel = new JLabel("Color of your Empire: ");
	protected JLabel countryTwoNameLabel = new JLabel("Player 2 Empire: ");
	protected JLabel countryTwoColorLabel = new JLabel("Color of your Empire: ");
	protected JLabel countryThreeNameLabel = new JLabel("Player 3 Empire: ");
	protected JLabel countryThreeColorLabel = new JLabel("Color of your Empire: ");
	protected JLabel countryFourNameLabel = new JLabel("Player 4 Empire: ");
	protected JLabel countryFourColorLabel = new JLabel("Color of your Empire: ");
	protected JLabel numberEmpireLabel = new JLabel("Number of empires");

	protected JComboBox<Integer> rowChoice = new JComboBox<Integer>();
	protected JComboBox<Integer> colChoice = new JComboBox<Integer>();
	protected JComboBox<String> countryOneChoice = new JComboBox<String>();
	protected JComboBox<String> countryOneColorChoice = new JComboBox<String>();
	protected JComboBox<String> countryTwoChoice = new JComboBox<String>();
	protected JComboBox<String> countryTwoColorChoice = new JComboBox<String>();
	protected JComboBox<String> countryThreeChoice = new JComboBox<String>();
	protected JComboBox<String> countryThreeColorChoice = new JComboBox<String>();
	protected JComboBox<String> countryFourChoice = new JComboBox<String>();
	protected JComboBox<String> countryFourColorChoice = new JComboBox<String>();
	protected JComboBox<Integer> numberEmpireChoice = new JComboBox<Integer>();

	protected JButton previewButton = new JButton("Preview map");
	protected JButton lockButton = new JButton("Lock Countries and Map Size");
	
	public SettingsWindow() {
		initLists();
		createLayout(numberCountries);
	}

	protected void initLists() {
		rowChoice.setMaximumSize(new Dimension(300, 200));
		rowChoice.addItem(16);
		rowChoice.addItem(32);
		rowChoice.addItem(64);
		rowChoice.addItem(128);

		colChoice.setMaximumSize(new Dimension(300, 200));
		colChoice.addItem(16);
		colChoice.addItem(32);
		colChoice.addItem(64);
		colChoice.addItem(128);

		countryOneChoice.setMaximumSize(new Dimension(300, 200));
		countryTwoChoice.setMaximumSize(new Dimension(300, 200));
		ArrayList<String> empireList = new ArrayList<String>();
		try {
			CSVReader empires = new CSVReader(new FileReader("empires.csv"));
			String[] line;
			while ((line = empires.readNext()) != null) {
				empireList.add(line[0]);
			}
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
		
		countryOneChoice.addActionListener(new Selector());
		countryOneColorChoice.addActionListener(new Selector());
		countryTwoChoice.addActionListener(new Selector());
		countryTwoColorChoice.addActionListener(new Selector());
		
		countryOneColorChoice.setMaximumSize(new Dimension(300, 200));
		countryTwoColorChoice.setMaximumSize(new Dimension(300, 200));
		ArrayList<String> colorList = new ArrayList<String>();
		try {
			CSVReader colors = new CSVReader(new FileReader("colors.csv"));
			String[] line;
			while ((line = colors.readNext()) != null) {
				colorList.add(line[0]);
			}
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
		
		numberEmpireChoice.setMaximumSize(new Dimension(300, 200));
		for (int i = 2; i <= 4; i++) {
			numberEmpireChoice.addItem(i);
		}
		
		previewButton.addActionListener(new PreviewAction());
		lockButton.addActionListener(new LockAction());
	}

	protected void createLayout(int numberCountries) {
		String titre = "Pre-game Settings";

		setTitle(titre);
		setSize(2000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0, 0);

		mapPanel.removeAll();
		lineOne.removeAll();
		lineTwo.removeAll();
		lineThree.removeAll();
		lastLine.removeAll();
		settingsPanel.removeAll();
		boxPanel.removeAll();

		mapPanel.createGrid();
		repaint();

		mapSizePanel.setLayout(new BoxLayout(mapSizePanel, BoxLayout.LINE_AXIS));
		mapSizePanel.add(rowLabel);
		mapSizePanel.add(rowChoice);
		mapSizePanel.add(colLabel);
		mapSizePanel.add(colChoice);
		
		numberEmpirePanel.setLayout(new BoxLayout(numberEmpirePanel, BoxLayout.LINE_AXIS));
		numberEmpirePanel.add(numberEmpireLabel);
		numberEmpirePanel.add(numberEmpireChoice);
		
		lineOne.setLayout(new BorderLayout());
		lineOne.add(mapSizePanel, BorderLayout.NORTH);
		lineOne.add(numberEmpirePanel, BorderLayout.CENTER);

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
		
		lastLine.setLayout(new BorderLayout());
		lastLine.add(previewButton, BorderLayout.WEST);
		lastLine.add(lockButton, BorderLayout.CENTER);

		settingsPanel.setLayout(new BorderLayout());
		settingsPanel.add(lineOne, BorderLayout.NORTH);
		settingsPanel.add(countriesPanel, BorderLayout.CENTER);
		settingsPanel.add(lastLine, BorderLayout.SOUTH);

		boxPanel.setLayout(new BorderLayout());
		boxPanel.add(mapPanel, BorderLayout.CENTER);
		boxPanel.add(settingsPanel, BorderLayout.EAST);

		this.getContentPane().add(boxPanel);
		this.setVisible(true);
	}

	public Empire empireReader(String empireName, int numbEmpire) {
		Country[] countries = new Country[2];
		try {
			CSVReader empireFile = new CSVReader(new FileReader("empires.csv"));
			String[] nextLine;
			while ((nextLine = empireFile.readNext()) != null) {
				if (nextLine[0].equals(empireName)) {
					countries[0] = countryReader(nextLine[1]);
					countries[1] = countryReader(nextLine[2]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Empire empire = new Empire(empireName, countries);
		if (numbEmpire==1) {
			empire.colorChoice((String)countryOneColorChoice.getSelectedItem());
		}else if (numbEmpire==2) {
			empire.colorChoice((String)countryTwoColorChoice.getSelectedItem());
		}
		System.out.println(empire.toString());
		for (int j = 0; j < countries.length; j++) {
			System.out.println(empireName + " : " + countries[j]);
		}
		return empire;
	}

	public Country countryReader(String countryName) {
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
					Country countryTMP = new Country(gold, wood, name);
					countryTMP.setProduce(producer);
					country = countryTMP;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return country;
	}

	class LockAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String countryOne = (String) countryOneChoice.getSelectedItem();
			String countryTwo = (String) countryTwoChoice.getSelectedItem();
			String colorOne = (String) countryOneColorChoice.getSelectedItem();
			String colorTwo = (String) countryTwoColorChoice.getSelectedItem();
			if ((countryOne.equals("Name")) || (countryTwo.equals("Name"))) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						int cellWidth = 40;
						try {
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						} catch (Exception e) {
							e.printStackTrace();
						}
						JFrame errorFrame = new JFrame("Error");
						ErrorWindow errorPanel = new ErrorWindow("Choose countries please", errorFrame);
						errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						errorFrame.getContentPane().add(errorPanel);
						errorFrame.setLocationRelativeTo(null);
						errorFrame.pack();
						errorFrame.setVisible(true);
					}
				});
			} else {
				Empire playerOne = empireReader(countryOne, 1);
				playerOne.colorChoice(colorOne);
				Empire playerTwo = empireReader(countryTwo, 2);
				playerTwo.colorChoice(colorTwo);
				mapPanel.setRows((int) rowChoice.getSelectedItem());
				mapPanel.setCols((int) colChoice.getSelectedItem());
				createLayout(numberCountries);
			}
		}
	}

	class Selector implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object currentCountryOne = countryOneChoice.getSelectedItem();
			Object currentCountryTwo = countryTwoChoice.getSelectedItem();
			Object currentCountryThree = countryThreeChoice.getSelectedItem();
			Object currentCountryFour = countryFourChoice.getSelectedItem();
			Object currentColorOne = countryOneColorChoice.getSelectedItem();
			Object currentColorTwo = countryTwoColorChoice.getSelectedItem();
			Object currentColorThree = countryThreeColorChoice.getSelectedItem();
			Object currentColorFour = countryFourColorChoice.getSelectedItem();
			int indexCountryOne = countryOneChoice.getSelectedIndex();
			int indexCountryTwo = countryTwoChoice.getSelectedIndex();
			int indexCountryThree = countryThreeChoice.getSelectedIndex();
			int indexCountryFour = countryFourChoice.getSelectedIndex();
			int indexColorOne = countryOneColorChoice.getSelectedIndex();
			int indexColorTwo = countryTwoColorChoice.getSelectedIndex();
			int indexColorThree = countryThreeColorChoice.getSelectedIndex();
			int indexColorFour = countryFourColorChoice.getSelectedIndex();
			//a finir
			System.out.println(numberCountries);
			
			if ((currentCountryTwo).equals(currentCountryOne) || ((currentCountryTwo).equals(currentCountryThree)) || ((currentCountryTwo).equals(currentCountryFour))) {
				if (indexCountryTwo < countryTwoChoice.getItemCount() - 1) {
					countryTwoChoice.setSelectedItem(countryTwoChoice.getItemAt(indexCountryTwo + 1));
				} else {
					countryTwoChoice.setSelectedItem(countryTwoChoice.getItemAt(0));
				}
			}
			
			if ((currentCountryThree).equals(currentCountryOne) || ((currentCountryThree).equals(currentCountryFour))) {
				if (indexCountryThree < countryThreeChoice.getItemCount() - 1) {
					countryThreeChoice.setSelectedItem(countryThreeChoice.getItemAt(indexCountryThree + 1));
				} else {
					countryThreeChoice.setSelectedItem(countryThreeChoice.getItemAt(0));
				}
			}
			
			if ((currentCountryFour).equals(currentCountryOne)) {
				if (indexCountryFour < countryFourChoice.getItemCount() - 1) {
					countryFourChoice.setSelectedItem(countryFourChoice.getItemAt(indexCountryFour + 1));
				} else {
					countryFourChoice.setSelectedItem(countryFourChoice.getItemAt(0));
				}
			}
			
			if ((currentColorOne).equals(currentColorTwo)) {
				if (indexColorTwo < countryTwoColorChoice.getItemCount() - 1) {
					countryTwoColorChoice.setSelectedItem(countryTwoColorChoice.getItemAt(indexColorTwo + 1));
				} else {
					countryTwoColorChoice.setSelectedItem(countryTwoColorChoice.getItemAt(0));
				}
			}
			
			
		}
	}

	class PreviewAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			numberCountries = (int) numberEmpireChoice.getSelectedItem();
			mapPanel.setRows((int) rowChoice.getSelectedItem());
			mapPanel.setCols((int) colChoice.getSelectedItem());
			createLayout(numberCountries);
		}
	}
}