package business.data;

import business.simulation.OffreUtility;

public class Trajet {
	private Location source;
	private Location destination;
	private String transport;
	private double price;
	private double distance;
	
	public Trajet() {
	}

	public Trajet(Location source, Location destination, String transport,double price, double distance) {
		this.source = source;
		this.destination = destination;
		this.transport = transport;
		this.price = price;
		this.distance = distance;
	}

	public Trajet(Location source, Location destination, String transport) {
		super();
		this.source = source;
		this.destination = destination;
		this.transport = transport;
	}

	public Location getSource() {
		return source;
	}

	public void setSource(Location source) {
		this.source = source;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public double getPrice() {
		return price;
	}

	public void setTrajetPrice(double price) {
		this.price = price;
	}
	
	//This setters calculates automatically the price between 2 locations
	public void setTrajetPrice() {
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	 
	
}
