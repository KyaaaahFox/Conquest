package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ErrorWindow extends JFrame {
	protected JPanel mainPanel = new JPanel();
	
	protected JLabel errorField = new JLabel();
	protected JButton confirmButton = new JButton("OK");
	
	private String errorMsg;
	
	public ErrorWindow(String errorMsg) {
		this.errorMsg = errorMsg;
		displayMessage();
	}
	
	public void displayMessage() {
		String titre = "Accueil";

		setTitle(titre);
		setSize(400, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		errorField.setText(errorMsg);
		confirmButton.addActionListener(new closeWindow());
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(errorField, BorderLayout.CENTER);
		mainPanel.add(confirmButton, BorderLayout.SOUTH);
		this.getContentPane().add(mainPanel);
		this.setVisible(true);
	}
	
	class closeWindow implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
