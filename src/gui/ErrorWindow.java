package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ErrorWindow extends JPanel {
	protected JLabel errorField = new JLabel();
	protected JButton confirmButton = new JButton("OK");
	
	private String errorMsg;
	protected JFrame thisFrame;
	
	public ErrorWindow(String errorMsg, JFrame thisFrame) {
		this.errorMsg = errorMsg;
		this.thisFrame = thisFrame;
		displayMessage();
	}
	
	public void displayMessage() {
		this.setLayout(new GridLayout(2, 1));
		
		errorField.setText(errorMsg);
		confirmButton.addActionListener(new closeWindow());
		
		this.add(errorField);
		this.add(confirmButton);
	}
	
	class closeWindow implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			thisFrame.dispose();
		}
	}
}
