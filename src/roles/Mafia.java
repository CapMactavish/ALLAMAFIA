package roles;

import java.util.ArrayList;

public class Mafia extends Person {
	protected static int iterator = 2;

	public Mafia() {
		super.id += iterator;
		iterator += 2;
	}
	
	public int choose(ArrayList<Integer> a) {
		int t ;
		while(true) {
			t= (int) (Math.random() * 1000) % 20;
			if (a.get(t) != 0) {
				break;
			}
		}
		return a.get(t);
	}

}
