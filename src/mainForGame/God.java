package mainForGame;

import roles.*;
//int t = (int) Math.random();

public class God {
	public boolean dayOrNight = true;
	Person[] gamers = new Person[20];

	public God(int input) {
		setDuties(input);
	}

	public void setDuties(int a) {
		int a1, a2, temp;
		a1 = (int) a / 3;
		a2 = a - a1;
		boolean Dt = false, Dc = false, Nt = false, Gf = false;
		for (int i = 0; i < 4; i++) {
			temp = ((int) Math.random()) % 20;
			if (gamers[temp] != null)
				if (!Dt) {
					gamers[temp] = new Detective();
					Dt = true;
				} else if (!Dc) {
					gamers[temp] = new Doctor();
					Dc = true;
				}
				else if (!Nt) {
					gamers[temp] = new Natasha();
					Nt = true;
				}
				else if(!Gf) {
					gamers[temp] = new GodFather();
					Gf = true;
				}
				a1 -=2;
				a2 -=2;
		}
		for (int i = 0; i < gamers.length; i++) {
			while(a1>=0) {
				temp = ((int) Math.random()) % 20;
				if (gamers[temp] != null) {
					gamers[temp] = new Mafia();
					a1--;
				}
			}
		}
		for (int i = 0; i < gamers.length; i++) {
			while(a2>=0) {
				temp = ((int) Math.random()) % 20;
				if (gamers[temp] != null) {
					gamers[temp] = new Mafia();
					a2--;
				}
			}
		}

	}

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
}
