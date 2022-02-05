package business.data;

public class Boat extends Transport{

	public Boat() {
	}

	public Boat(double price, int confort, float speed) {
		super(price, confort, speed);
	}
	
	public double getPrice() {
		return 0.8;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Boat";
	}
	
	@Override
	public int getConfort() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	@Override
	public float getSpeed() {
		// TODO Auto-generated method stub
		return 40;
	}
}
