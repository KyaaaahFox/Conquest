package gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {
	
	public Fenetre(){
		this.setTitle("ImaginationLand");
		this.setSize(1600, 900);
		this.setLocationRelativeTo(null); //Mon écran(1600,900)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		this.setContentPane(new Panneau());
	}
}