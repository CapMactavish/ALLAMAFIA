package mainForGame;

public class Main {
	public static void main(String[] args) {
		System.out.println("aloha");
		God g = new God(20);
		g.initiateTheGame();
		while (true) {
			g.wakeUpMafias();
			g.doctorStuff();
			g.DetectiveCall();
			if (g.checkFinish() == -1) {
				System.out.println("Mafia Win");
				break;
			} else if (g.checkFinish() == 0) {
				System.out.println("Citizen win");
				break;
			}
			System.out.println("\n\n");
		}
	}
}
