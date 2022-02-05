package business.data;

import java.util.ArrayList;
import java.util.List;

public class Offre {

	private double price;
	private List<Excursion> excursions;

	public Offre() {
		excursions = new ArrayList<Excursion>();
	}

	public Offre(List<Excursion> excursions) {
		this.excursions = excursions;
	}

	public double getPrice() {
		return price;
	}


	public void setPrice(double prix) {
		this.price = prix;
	}

	public List<Excursion> getExcursions() {
		return excursions;
	}

	public void setExcursions(List<Excursion> excursions) {
		this.excursions = excursions;
	}

	public void addExcursion(Excursion excursion) {
		for (Trajet trajet : excursion.getTrajets())
			setPrice(price + trajet.getPrice());
		excursions.add(excursion);
	}

}
