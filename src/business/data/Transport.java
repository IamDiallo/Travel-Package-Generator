package business.data;

public abstract class Transport {
	private double price;
	private int confort;
	private float speed;
	
	
	public Transport() {
	}

	public Transport(double price, int confort, float speed) {
		this.price = price;
		this.confort = confort;
		this.speed = speed;
	}

	
	public abstract String getName();
	
	public abstract double getPrice();
	
	public abstract int getConfort();
	
	public abstract float getSpeed();
}
