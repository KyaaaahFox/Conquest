package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class WelcomeWindow extends JFrame {

	protected JPanel mainPanel = new JPanel();
	protected JPanel parametersPanel = new JPanel();
	protected JPanel mapSizePanel = new JPanel();
	protected JPanel numberEmpirePanel = new JPanel();
	protected JPanel choiceButtonsPanel = new JPanel();
	protected JPanel confirmationPanel = new JPanel();

	protected JLabel msgLabel = new JLabel("BIENVENUE");
	protected JLabel rowLabel = new JLabel("Number of lines: ");
	protected JLabel colLabel = new JLabel("Number of columns: ");
	protected JLabel numberEmpireLabel = new JLabel("Number of empires");

	protected JComboBox<Integer> rowChoice = new JComboBox<Integer>();
	protected JComboBox<Integer> colChoice = new JComboBox<Integer>();
	protected JComboBox<Integer> numberEmpireChoice = new JComboBox<Integer>();

	protected JButton confirmButton = new JButton("Valider");

	public WelcomeWindow() {
		initLists();
		createLayout();
	}

	protected void createLayout() {
		String titre = "Accueil";

		setTitle(titre);
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		mapSizePanel.setLayout(new BoxLayout(mapSizePanel, BoxLayout.LINE_AXIS));
		mapSizePanel.add(rowLabel);
		mapSizePanel.add(rowChoice);
		mapSizePanel.add(colLabel);
		mapSizePanel.add(colChoice);

		numberEmpirePanel.setLayout(new BoxLayout(numberEmpirePanel, BoxLayout.LINE_AXIS));
		numberEmpirePanel.add(numberEmpireLabel);
		numberEmpirePanel.add(numberEmpireChoice);

		parametersPanel.setLayout(new BorderLayout());
		parametersPanel.add(mapSizePanel, BorderLayout.NORTH);
		parametersPanel.add(numberEmpirePanel, BorderLayout.CENTER);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(msgLabel, BorderLayout.NORTH);
		mainPanel.add(parametersPanel, BorderLayout.CENTER);
		mainPanel.add(confirmButton, BorderLayout.SOUTH);
		this.getContentPane().add(mainPanel);
		this.setVisible(true);
	}

	protected void initLists() {
		confirmButton.addActionListener(new ValidAction());

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

		numberEmpireChoice.setMaximumSize(new Dimension(300, 200));
		for (int i = 2; i <= 4; i++) {
			numberEmpireChoice.addItem(i);
		}
	}

	class ValidAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					int cellWidth = 40;
					int numberCountries = (int) numberEmpireChoice.getSelectedItem();
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (Exception e) {
						e.printStackTrace();
					}
					new PlayerWindow(numberCountries);
					dispose();
				}
			});
		}
	}
}
