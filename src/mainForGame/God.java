package mainForGame;

import roles.Citizen;
import roles.Detective;
import roles.Doctor;
import roles.GodFather;
import roles.Mafia;
import roles.Natasha;
import roles.Person;

public class God {
	public boolean dayOrNight = true;
	Person[] gamers = new Person[20];

	public God(int input) {
		setDuties(input);
	}
	//
	public void setDuties(int a) {
		int a1, a2;
		a1 = (int) a / 3;
		a2 = a - a1;
		int j = 0;
		int[] temp = new int[8];
		boolean[] choises = new boolean[21];
		while(true) {
			if (j == 0) {
				temp[j] = (int) (Math.random() * 1000) % 20;
				choises[temp[j]] = true;
				j++;
				
			} else {
				while (true) {
					temp[j] = (int) (Math.random() * 1000) % 20;
					if (choises[temp[j]] == false)
					{
						choises[temp[j]] = true;
						j++;
						break;
					}
					
				}
				if (j == 8)
					break;
			}
		}
		gamers[temp[0]] = new GodFather();
		gamers[temp[1]] = new Natasha();
		gamers[temp[2]] = new Doctor();
		gamers[temp[3]] = new Detective();
		for (int k = 4; k < 8; k++) {
			gamers[temp[k]] = new Mafia();
			
		}
		for (int i = 0; i < gamers.length; i++) {
			if (gamers[i] == null)
				gamers[i] = new Citizen();
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
