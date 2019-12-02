package roles;

import java.util.ArrayList;

public class GodFather extends Mafia{
	
	public int finalChoose(ArrayList<Integer> a) {
		int temp =(int) (Math.random() * 1000) % 6;
		
		System.out.println("\nthis is:\t"+a.get(temp));
		return a.indexOf(temp);
	}
}
