package roles;

public  class Person {
protected String name;
protected boolean deadOrAlive = true;
protected boolean wake = true; 
public void SetWakeOrAsleep() {
	this.wake = !wake;
}
}
