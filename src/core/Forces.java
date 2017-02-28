package core;

import java.util.Scanner;

import data.Country;
import data.Juggernaut;
import data.SwordMaster;

public class Forces {
	private Country country;
	private Juggernaut tank;
	private SwordMaster zoro;
	
	public Forces(Country country, Juggernaut tank, SwordMaster zoro) {
		this.country = country;
		this.tank = tank;
		this.zoro = zoro;
	}
	
	public void fastUnitMove(int newPosX, int newPosY) {
		int movement = zoro.getBonusMvt() + zoro.getMovement();
		int X = (int) Math.pow(newPosX - zoro.getPosX(), 2);
		int Y = (int) Math.pow(newPosY - zoro.getPosY(), 2);
		int travel = (X + Y);
		//to be continued: if movement is not allowed because too long.
		if (travel > movement) {
			System.out.println("Vous ne pouvez pas vous deplacer aussi loin, reessayer ? (y/n)");
			Scanner scan = new Scanner(System.in);
			String answer = scan.nextLine();
			scan.close();
			if (answer.contains("y") || answer.contains("o")) {
				
			} else {
				System.out.println("Vous avez choisi de ne pas bouger");
			}
		} else {
			zoro.setPosX(newPosX);
			zoro.setPosY(newPosY);
		}
	}
	
	public void SlowUnitMove(int newPosX, int newPosY) {
		int movement = tank.getMovement();
		int X = (int) Math.pow(newPosX - tank.getPosX(), 2);
		int Y = (int) Math.pow(newPosY - tank.getPosY(), 2);
		int travel = (X + Y);
		
		if (travel > movement) {
			
		} else {
			tank.setPosX(newPosX);
			tank.setPosY(newPosY);
		}
	}
}
