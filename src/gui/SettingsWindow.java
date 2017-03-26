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
	
	protected JPanel lastLine = new JPanel();
	protected JPanel boxPanel = new JPanel();

	protected JButton previewButton = new JButton("Preview map");
	protected JButton lockButton = new JButton("Lock Countries and Map Size");
	
	public SettingsWindow(int nbEmpire) {
		createLayout(numberCountries);
	}

	protected void createLayout(int numberCountries) {
		String titre = "Pre-game Settings";

		setTitle(titre);
		setSize(2000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0, 0);

		mapPanel.removeAll();
		lineTwo.removeAll();
		lineThree.removeAll();
		lastLine.removeAll();
		settingsPanel.removeAll();
		boxPanel.removeAll();

		mapPanel.createGrid();
		
		
		
		lastLine.setLayout(new BorderLayout());
		lastLine.add(previewButton, BorderLayout.WEST);
		lastLine.add(lockButton, BorderLayout.CENTER);

		settingsPanel.setLayout(new BorderLayout());
		settingsPanel.add(countriesPanel, BorderLayout.CENTER);
		settingsPanel.add(lastLine, BorderLayout.SOUTH);

		boxPanel.setLayout(new BorderLayout());
		boxPanel.add(mapPanel, BorderLayout.CENTER);
		boxPanel.add(settingsPanel, BorderLayout.EAST);

		this.getContentPane().add(boxPanel);
		this.setVisible(true);
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