package business.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Excursion {
	private List<Trajet> trajets = new ArrayList<Trajet>();
	private double excursionPrice; 
	private int days;

	
	public Excursion() {
		super();
	}

	public Excursion(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}
	
	
	public void addTrajet(Trajet trajetBacktoHotel) {
		trajets.add(trajetBacktoHotel);
		
	}
	
	public double getExcursionPrice() {
		return excursionPrice;
	}
	
	public void setExcursionPrice(double price) {
		this.excursionPrice = price;
	}
	
	public void addTrajetPrice(float priceToAdd) {
		excursionPrice += priceToAdd;
	}

	public void displayExcursion() {
		Iterator<Trajet> itTrajets = trajets.iterator();
		while(itTrajets.hasNext()) {
			Trajet t = itTrajets.next();

			System.out.println(t.getSource().getName() + "\t"+ t.getTransport() + "\t"+  t.getDestination().getName() + "\t" + t.getPrice()+"\n");
		}
		//trajets.removeAll(trajets);
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
}
