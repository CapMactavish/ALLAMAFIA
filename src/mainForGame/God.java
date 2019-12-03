package mainForGame;

import java.util.ArrayList;

import javax.print.Doc;

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
	ArrayList<Integer> IDs = new ArrayList<>();
	int choosenTodead;

	public God(int input) {
		setDuties(input);
	}

	//
	public void setDuties(int a) {
		int a1;
		a1 = (int) a / 3;
		int j = 0;
		int[] temp = new int[8];
		boolean[] choises = new boolean[21];
		while (true) {
			if (j == 0) {
				temp[j] = (int) (Math.random() * 1000) % 20;
				choises[temp[j]] = true;
				j++;

			} else {
				while (true) {
					temp[j] = (int) (Math.random() * 1000) % 20;
					if (choises[temp[j]] == false) {
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
		for (int i = 0; i < gamers.length; i++) {
			IDs.add(gamers[i].getID());
		}
	}

	public void wakeUpMifias() {
		int treatment = 0;
		for (int i = 0; i < gamers.length; i++) {
			if (gamers[i] instanceof Mafia) {
				gamers[i].SetWakeOrAsleep();
			}
		}
		System.out.println("Mafia bidar shodand!");

		// --------------------------------------------
		ArrayList<Integer> election = new ArrayList<>();
		for (int i = 0; i < gamers.length; i++) {
			if (gamers[i] instanceof Mafia && IDs.get(i) != 0) {
				election.add(((Mafia) gamers[i]).choose(IDs));
			}
		}

		for (Integer i : election) {
			System.out.println(i);
		}

		for (int i = 0; i < gamers.length; i++) {
			if (gamers[i] instanceof GodFather) {
				treatment = ((GodFather) gamers[i]).finalChoose(election);

			}
		}
		choosenTodead = treatment;
	}

	public void doctorStuff() {
		outer: for (int i = 0; i < gamers.length; i++) {
			if (gamers[i] instanceof Doctor) {
				if (!((Doctor) gamers[i]).doctorOperation(IDs, choosenTodead)) {
					for (int j = 0; j < IDs.size(); j++) {
						if (IDs.get(j) == choosenTodead) {
							IDs.remove(j);
							System.err.println("taraf hazf shod");
							break outer;
						}
					}
				} else if (i == gamers.length - 1)
					System.out.println("taraf nejat dadeh shod");
			}
		}
	}

	public void DetectiveCall() {
		outer: for (int i = 0; i < gamers.length; i++) {
			if (gamers[i] instanceof Detective) {
				int t = ((Detective) gamers[i]).findMafia(IDs);
				if (t != 0) {
					System.err.println("this one is a mafia\t" + t);
					break outer;
				}
			}
			if (i == gamers.length - 1) {
				System.out.println("couldnt get it");
			}
		}
	}
	
	public int checkFinish() {
		int iterM =0;
		int iterC = 0;
		for (int i = 0; i < IDs.size(); i++) {
			if(IDs.get(i)%2==0)
				iterM++;
			else if (IDs.get(i)%2==1)
				iterC++;
		}
		if(iterM == iterC)
			return -1;
		else if (iterM == 0)
			return 0;
		else
			return 1;
	}
}
