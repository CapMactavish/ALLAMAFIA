package mainForGame;

public class Main {
	public static void main(String[] args) {
		System.out.println("aloha");
		God g = new God(20);
		while (true) {
			g.initiateTheGame();
			g.wakeUpMifias();
			g.doctorStuff();
			g.DetectiveCall();
			if (g.checkFinish() == -1) {
				System.out.println("mafia bord");
				break;
			} else if (g.checkFinish() == 0) {
				System.out.println("ct bord");
				break;
			}

		}
	}
}
