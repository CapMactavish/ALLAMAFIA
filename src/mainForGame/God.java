package mainForGame;

import roles.*;
//int t = (int) Math.random();

public class God {
	Person[] gamers = new Person[20];
	public void setDuties(int a) {
		int a1,a2;
		a1 = (int) a/3;
		a2 = a - a1;
		for (int i = 0; i < a1; i++) {
			gamers[i] = new Mafia();
		}
		for (int i= 0; i<a2; i++) {
			gamers[i] = new Citizen();
		}
		for (int i = 0; i < gamers.length; i++) {
			
		}
	}

	public boolean dayOrNight = true;

	public void initiateTheGame() {
		System.out.println("Game is started!");
		System.out.println("every one must sleep!!");
		if (dayOrNight) {
			dayOrNight = false;
			for (int i = 0; i < gamers.length; i++) {
				gamers[i].SetWakeOrAsleep();
			}
		}
	}

	public void wakeUpMifias() {
		for (int i = 0; i < gamers.length; i++) {
			if (gamers[i] instanceof Mafia) {
				System.out.println("Mafia bidar shodand!");
				gamers[i].SetWakeOrAsleep();
			}
		}
	}
	public God(int input) {
		setDuties(input);
	}
}
