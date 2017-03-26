package gui;

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
public class DemoWindow extends JFrame{
	
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
	
	public static void main(String[] args) {
		new DemoWindow();
	}
	
	public DemoWindow() {
		initLists();
		createLayout();
	}
	
	protected void initLists(){
		startButton.addActionListener(new StartAction());
		
		rowChoice.setPreferredSize(new Dimension(300, 20));
		rowChoice.addItem(16);
		rowChoice.addItem(32);
		rowChoice.addItem(64);
		rowChoice.addItem(128);
		
		colChoice.setPreferredSize(new Dimension(300, 20));
		colChoice.addItem(16);
		colChoice.addItem(32);
		colChoice.addItem(64);
		colChoice.addItem(128);
		
		countryChoice.setPreferredSize(new Dimension(300, 20));
		countryChoice.addItem("Corée du Nord");
		countryChoice.addItem("Chine");
		countryChoice.addItem("Japon");
		countryChoice.addItem("Corée du Sud");
		/* A finir si CSV utilis��
		Iterator iterFindList = .iterator();
		while (iterFindList.hasNext()) {
			Map.Entry pair = (Map.Entry)iterFindList.next();
			countryChoice.addItem((Country) pair.getKey());
		}
		*/
		
		countryColorChoice.setPreferredSize(new Dimension(300, 20));
		countryColorChoice.addItem("Red");
		countryColorChoice.addItem("Green");
		countryColorChoice.addItem("Blue");
	}
	
	protected void createLayout() {
		String titre = "Pre-game Settings";

		setTitle(titre);
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0, 0);
				
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
		
		lastLine.setLayout(new BoxLayout(lastLine, BoxLayout.LINE_AXIS));
		lastLine.add(startButton);

		boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.PAGE_AXIS));
		boxPanel.add(lineOne);
		boxPanel.add(lineTwo);
		boxPanel.add(lastLine);

		this.getContentPane().add(boxPanel);
		this.setVisible(true);
	}
	
	class StartAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			EventQueue.invokeLater(new Runnable(){
	            public void run(){
					int cellWidth = 40;
				    try{
	                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	                } catch (Exception e) {
	                   e.printStackTrace();
	                }
				    JFrame map = new JFrame("My Map");
				    SquareMap mainPanel = new SquareMap((int)rowChoice.getSelectedItem(), (int)colChoice.getSelectedItem(), cellWidth);
				    map.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    map.getContentPane().add(mainPanel);
				    map.pack();
				    map.setVisible(true);
				    
	            }
	        });
		}
	}
}