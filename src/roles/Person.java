package roles;

public class Person {

    protected String name;
    protected int id = 139809000;
    protected boolean deadOrAlive = true;
    protected boolean wake = true;

    public void SetWakeOrAsleep() {
        this.wake = !wake;
    }
    
    public int getID() {
		return this.id;
	}

}
