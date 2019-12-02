package roles;

public class Mafia extends Person {
	protected static int iterator = 2;

	public Mafia() {
		super.id += iterator;
		iterator += 2;
	}
	
	public int choose(int[] a) {
		int t ;
		while(true) {
			t= (int) (Math.random() * 1000) % 20;
			if (a[t] != 0) {
				break;
			}
		}
		return a[t];
	}

}
