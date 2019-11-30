package mainForGame;

import roles.*;

public class God {
	public boolean dayOrNight = true;
	Person[] gamers = new Person[20];

	public God(int input) {
		setDuties(input);
	}

	public void setDuties(int a) {
		int a1, a2;
		a1 = (int) a / 3;
		a2 = a - a1;
		int[] temp = new int[8];
		boolean[] choises = new boolean[21];
		for (int i = 0; i < temp.length; i++) {
			if (i == 0) {
				temp[i] = (int) (Math.random() * 1000) % 20;
				choises[temp[i]] = true;
			} else {
				while (true) {
					if (temp[i] != temp[i - 1] && choises[i] == false)
						temp[i] = (int) (Math.random() * 1000) % 20;
					{
						choises[i] = true;
						break;
					}
				}

			}
		}
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + "\t");
		}

		for (int i = 0; i < gamers.length; i++) {
			gamers[temp[0]] = new GodFather();
			gamers[temp[1]] = new Natasha();
			gamers[temp[2]] = new Doctor();
			gamers[temp[3]] = new Detective();
			gamers[temp[4]] = new Mafia();
			gamers[temp[5]] = new Mafia();
			gamers[temp[6]] = new Mafia();
			gamers[temp[7]] = new Mafia();

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
