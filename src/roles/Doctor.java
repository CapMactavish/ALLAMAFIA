package roles;

import java.util.ArrayList;

public class Doctor extends Citizen {

	public void selectPerson() {
		super.deadOrAlive = true;

	}

	public boolean doctorOperation(ArrayList<Integer> a,int f) {
		int temp = (int) (Math.random() * 1000) % (a.size());
		if(f == a.get(temp)) {
			return true;
		}
		return false;
	}
}
