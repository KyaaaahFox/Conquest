package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
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

	protected SquareMap mapPanel = new SquareMap(16, 16, 10);
	protected JPanel settingsPanel = new JPanel();
	protected JPanel lineOne = new JPanel();
	protected JPanel choiceButtonsPanel = new JPanel();
	protected JPanel countryOneNamePanel = new JPanel();
	protected JPanel countryTwoNamePanel = new JPanel();
	protected JPanel countryOneColorPanel = new JPanel();
	protected JPanel countryTwoColorPanel = new JPanel();
	protected JPanel lineTwo = new JPanel();
	protected JPanel lineThree = new JPanel();
	protected JPanel countriesPanel = new JPanel();
	protected JPanel lastLine = new JPanel();
	protected JPanel boxPanel = new JPanel();

	protected JLabel rowLabel = new JLabel("Number of lines: ");
	protected JLabel colLabel = new JLabel("Number of columns: ");
	protected JLabel countryOneNameLabel = new JLabel("Player 1 Empire: ");
	protected JLabel countryOneColorLabel = new JLabel("Color of your Empire: ");
	protected JLabel countryTwoNameLabel = new JLabel("Player 2 Empire: ");
	protected JLabel countryTwoColorLabel = new JLabel("Color of your Empire: ");

	protected JComboBox<Integer> rowChoice = new JComboBox<Integer>();
	protected JComboBox<Integer> colChoice = new JComboBox<Integer>();
	protected JComboBox<String> countryOneChoice = new JComboBox<String>();
	protected JComboBox<String> countryOneColorChoice = new JComboBox<String>();
	protected JComboBox<String> countryTwoChoice = new JComboBox<String>();
	protected JComboBox<String> countryTwoColorChoice = new JComboBox<String>();

	protected JButton lockButton = new JButton("Lock Countries and Map Size");

	protected JRadioButton countryOneRadioButton = new JRadioButton();
	protected JRadioButton countryTwoRadioButton = new JRadioButton();

	protected ButtonGroup countryRadioGroup = new ButtonGroup();

	public SettingsWindow() {
		initLists();
		createLayout();
	}

	protected void initLists() {
		// previewButton.addActionListener(new StartAction());

		countryOneRadioButton.addActionListener(new RadioChoice());
		countryTwoRadioButton.addActionListener(new RadioChoice());
		countryRadioGroup.add(countryOneRadioButton);
		countryRadioGroup.add(countryTwoRadioButton);

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
		String[] lineArray = empireList.toArray(new String[] {});
		for (int i = 0; i < lineArray.length; i++) {
			countryOneChoice.addItem(lineArray[i]);
			countryTwoChoice.addItem(lineArray[i]);
		}

		countryOneColorChoice.setMaximumSize(new Dimension(300, 200));
		countryOneColorChoice.addItem("Blue");
		countryOneColorChoice.addItem("Red");
		countryOneColorChoice.addItem("Green");

		countryTwoColorChoice.setMaximumSize(new Dimension(300, 200));
		countryTwoColorChoice.addItem("Red");
		countryTwoColorChoice.addItem("Green");
		countryTwoColorChoice.addItem("Blue");

		lockButton.addActionListener(new LockAction());

		countryOneChoice.addActionListener(new Selector());
		countryOneColorChoice.addActionListener(new Selector());
		countryTwoChoice.addActionListener(new Selector());
		countryTwoColorChoice.addActionListener(new Selector());
	}

	protected void createLayout() {
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

		lineOne.setLayout(new BoxLayout(lineOne, BoxLayout.LINE_AXIS));
		lineOne.add(rowLabel);
		lineOne.add(rowChoice);
		lineOne.add(colLabel);
		lineOne.add(colChoice);

		countryOneNamePanel.setLayout(new BoxLayout(countryOneNamePanel, BoxLayout.LINE_AXIS));
		countryOneNamePanel.add(countryOneRadioButton);
		countryOneNamePanel.add(countryOneNameLabel);
		countryOneNamePanel.add(countryOneChoice);

		countryTwoNamePanel.setLayout(new BoxLayout(countryTwoNamePanel, BoxLayout.LINE_AXIS));
		countryTwoNamePanel.add(countryTwoRadioButton);
		countryTwoNamePanel.add(countryTwoNameLabel);
		countryTwoNamePanel.add(countryTwoChoice);

		lineTwo.setLayout(new BoxLayout(lineTwo, BoxLayout.Y_AXIS));
		lineTwo.add(countryOneNamePanel);
		lineTwo.add(countryTwoNamePanel);

		countryOneColorPanel.setLayout(new BoxLayout(countryOneColorPanel, BoxLayout.LINE_AXIS));
		countryOneColorPanel.add(countryOneColorLabel);
		countryOneColorPanel.add(countryOneColorChoice);

		countryTwoColorPanel.setLayout(new BoxLayout(countryTwoColorPanel, BoxLayout.LINE_AXIS));
		countryTwoColorPanel.add(countryTwoColorLabel);
		countryTwoColorPanel.add(countryTwoColorChoice);

		lineThree.setLayout(new BoxLayout(lineThree, BoxLayout.Y_AXIS));
		lineThree.add(countryOneColorPanel);
		lineThree.add(countryTwoColorPanel);

		countriesPanel.setLayout(new BorderLayout());
		countriesPanel.add(lineTwo, BorderLayout.WEST);
		countriesPanel.add(lineThree, BorderLayout.CENTER);

		lastLine.setLayout(new BorderLayout());
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

	public Empire empireReader(String empireName) {
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
		for (int j = 0; j < countries.length; j++) {
			System.out.println(countries[j]);
		}
		Empire empire = new Empire(empireName, countries);
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
			if ((countryOne.equals("Name"))||(countryTwo.equals("Name"))) {
				EventQueue.invokeLater(new Runnable(){
		            public void run(){
						int cellWidth = 40;
					    try{
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
			}else{
				Empire playerOne = empireReader(countryOne);
				playerOne.colorChoice(colorOne);
				Empire playerTwo = empireReader(countryTwo);
				playerTwo.colorChoice(colorTwo);
				mapPanel.setRows((int) rowChoice.getSelectedItem());
				mapPanel.setCols((int) colChoice.getSelectedItem());
				createLayout();
			}
		}
	}

	class Selector implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object currentCountryOne = countryOneChoice.getSelectedItem();
			Object currentCountryTwo = countryTwoChoice.getSelectedItem();
			Object currentColorOne = countryOneColorChoice.getSelectedItem();
			Object currentColorTwo = countryTwoColorChoice.getSelectedItem();
			int indexCountryOne = countryOneChoice.getSelectedIndex();
			int indexCountryTwo = countryTwoChoice.getSelectedIndex();
			int indexColorOne = countryOneColorChoice.getSelectedIndex();
			int indexColorTwo = countryTwoColorChoice.getSelectedIndex();

			if ((currentCountryOne).equals(currentCountryTwo)) {
				if (indexCountryTwo < countryTwoChoice.getItemCount() - 1) {
					countryTwoChoice.setSelectedItem(countryTwoChoice.getItemAt(indexCountryTwo + 1));
				} else {
					countryTwoChoice.setSelectedItem(countryTwoChoice.getItemAt(0));
				}
			} else if ((currentColorOne).equals(currentColorTwo)) {
				if (indexColorTwo < countryTwoColorChoice.getItemCount() - 1) {
					countryTwoColorChoice.setSelectedItem(countryTwoColorChoice.getItemAt(indexColorTwo + 1));
				} else {
					countryTwoColorChoice.setSelectedItem(countryTwoColorChoice.getItemAt(0));
				}
			}
		}
	}

	class RadioChoice implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}
}