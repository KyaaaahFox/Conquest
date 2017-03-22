package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.opencsv.CSVReader;

@SuppressWarnings("serial")
public class PlayerWindow extends JFrame{
	private int numberCountries;
	
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
	
	public PlayerWindow(int numberCountries) {
		this.numberCountries = numberCountries;
		initLists();
		createLayout(numberCountries);
	}

	protected void initLists() {
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
	
	class LockAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		
		}
	}

}
