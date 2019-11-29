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
        int a1, a2;
        a1 = (int) a / 3;
        a2 = a - a1;
        gamers[0] = new GodFather();
        gamers[1] = new Natasha();

        for (int i = 2; i < a1; i++) {
            gamers[i] = new Mafia();
        }

        gamers[a1] = new Detective();
        gamers[a1 + 1] = new Doctor();

        for (int i = a1 + 2; i < a1 + a2; i++) {
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
