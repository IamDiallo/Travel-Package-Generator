package business.simulation;

import business.data.Location;
import business.data.Transport;

public class OffreUtility {

	public OffreUtility() {

	}

	public static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}

	public static double calculateTrajectoryTime(int distance, Transport vehicule) {
		return distance / vehicule.getSpeed();
	}
	
	public static double calculateTrajectoryPrice(int distance, Transport vehicule) {
		return distance * vehicule.getPrice();
	}
}
