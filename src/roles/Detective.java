package roles;

import java.util.ArrayList;

public class Detective extends Person{
	public boolean findMafia(ArrayList<Integer> a) {
		int temp = (int) (Math.random() * 1000) % (a.size());
		if (temp %2 == 0)
			return true;
		return false;		
	}
}
