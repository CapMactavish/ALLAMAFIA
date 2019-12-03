package roles;

import java.util.ArrayList;

public class Detective extends Citizen{
	public int findMafia(ArrayList<Integer> a) {
		int temp = (int) (Math.random() * 1000) % (a.size());
		if ((a.get(temp)%2) == 0)
			return a.get(temp);
		return 0;		
	}
}
