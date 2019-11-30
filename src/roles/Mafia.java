package roles;

public class Mafia extends Person {
	protected static int iterator = 2;

	public Mafia() {
        super.id += iterator;
        iterator += 2;
    }

}
