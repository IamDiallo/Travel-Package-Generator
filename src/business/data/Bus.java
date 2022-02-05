package business.data;

public class Bus extends Transport{

	public Bus() {
	}

	public Bus(double price, int confort, float vitesse) {
		super(price, confort, vitesse);
	}
	
	public double getPrice() {
		return 0.5;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Bus";
	}
	
	@Override
	public int getConfort() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	@Override
	public float getSpeed() {
		return 20;
	}
}
