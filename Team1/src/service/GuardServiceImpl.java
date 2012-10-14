package service;

import java.util.ArrayList;
import java.util.List;



import Package.Guard;

public class GuardServiceImpl {
	

	public List<Guard> findGuardsByName(String name) {
		List<Guard> guardList = new ArrayList<Guard>();

		// Tegelikkuses küsiksime kliendikirjed andmebaasist
		Guard guard = new Guard();
		guard.setName(name);
		String address = null;
		guard.setAddress(address);
		int guards = 0;
		guard.setGuards(guards);

		return guardList;
	}

	

}
