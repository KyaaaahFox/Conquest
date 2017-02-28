package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Country;
import data.Empire;

@SuppressWarnings("serial")
public class SettingsWindow extends JFrame {

	protected SquareMap mapPanel = new SquareMap(16, 16, 10);
	protected JPanel settingsPanel = new JPanel();
	protected JPanel lineOne = new JPanel();
	protected JPanel lineTwo = new JPanel();
	protected JPanel lastLine = new JPanel();
	protected JPanel boxPanel = new JPanel();

	protected JLabel rowLabel = new JLabel("Number of lines: ");
	protected JLabel colLabel = new JLabel("Number of columns: ");
	protected JLabel countryNameLabel = new JLabel("Choose Player 1 empire: ");
	protected JLabel countryColorLabel = new JLabel("Color of your empire: ");

	protected JComboBox<Integer> rowChoice = new JComboBox<Integer>();
	protected JComboBox<Integer> colChoice = new JComboBox<Integer>();
	protected JComboBox<String> countryChoice = new JComboBox<String>();
	protected JComboBox<String> countryColorChoice = new JComboBox<String>();

	protected JButton startButton = new JButton("Enter");

	public SettingsWindow() {
		initLists();
		createLayout();
	}

	protected void initLists() {
		startButton.addActionListener(new StartAction());

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

		countryChoice.setMaximumSize(new Dimension(300, 200));
		countryChoice.addItem("Corée du Nord");
		countryChoice.addItem("Chine");
		countryChoice.addItem("Japon");
		countryChoice.addItem("Corée du Sud");
		/*
		 * A finir si CSV utilisé Iterator iterFindList = .iterator(); while
		 * (iterFindList.hasNext()) { Map.Entry pair =
		 * (Map.Entry)iterFindList.next(); countryChoice.addItem((Country)
		 * pair.getKey()); }
		 */

		countryColorChoice.setMaximumSize(new Dimension(300, 200));
		countryColorChoice.addItem("Red");
		countryColorChoice.addItem("Green");
		countryColorChoice.addItem("Blue");
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

		lineTwo.setLayout(new BoxLayout(lineTwo, BoxLayout.LINE_AXIS));
		lineTwo.add(countryNameLabel);
		lineTwo.add(countryChoice);
		lineTwo.add(countryColorLabel);
		lineTwo.add(countryColorChoice);

		lastLine.setLayout(new BorderLayout());
		lastLine.add(startButton, BorderLayout.CENTER);

		settingsPanel.setLayout(new BorderLayout());
		settingsPanel.add(lineOne, BorderLayout.NORTH);
		settingsPanel.add(lineTwo, BorderLayout.CENTER);
		settingsPanel.add(lastLine, BorderLayout.SOUTH);

		boxPanel.setLayout(new BorderLayout());
		boxPanel.add(mapPanel, BorderLayout.CENTER);
		boxPanel.add(settingsPanel, BorderLayout.EAST);

		this.getContentPane().add(boxPanel);
		this.setVisible(true);
	}

	class StartAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Country pays1 = new Country(5, 5, "Séoul");
			Country[] paysTab1 = {pays1};
			Empire bonjour = new Empire((String) countryChoice.getSelectedItem(), paysTab1);
			mapPanel.setRows((int) rowChoice.getSelectedItem());
			mapPanel.setCols((int) colChoice.getSelectedItem());
			createLayout();
		}
	}
}