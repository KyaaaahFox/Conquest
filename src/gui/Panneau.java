package gui;

import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panneau extends JPanel{
	
		public void paintComponent(Graphics g) {
			int longueur = 1;
			int x1 = 500;
			int y1 = 500;
			
			int x2 = (int) (x1 + longueur * Math.cos(45));
			int y2 = (int) (y1 + longueur * Math.sin(45));
			System.out.println("x2 = "+x2 + "  y2 = " + y2);
			
			int x3 = x2 + longueur;
			int y3 = y2;
			System.out.println("x3 = "+x3 + "  y3 = " + y3);
			
			int x4 = (int) (x3 + longueur * Math.cos(45));
			int y4 = y1;
			System.out.println("x4 = "+x4 + "  y4 = " + y4);
			
			int x5 = x3;
			int y5 = (int) (y4 - longueur * Math.sin(45));
			System.out.println("x5 = "+ x5 + "  y5 = " + y5);
			
			int x6 = x5 - longueur;
			int y6 = y5;
			System.out.println("x6 = "+ x6 + "  y6 = " + y6);
			
			int x[] = {x1,x2,x3,x4,x5,x6};
			int y[] = {y1,y2,y3,y4,y5,y6};
		
			g.drawPolygon(x, y, 6);
		}
}
