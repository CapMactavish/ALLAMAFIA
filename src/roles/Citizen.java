package roles;

public class Citizen extends Person {
    protected static int iterator = 1;

    public Citizen() {
        super.id += iterator;
        iterator += 2;
    }
}
