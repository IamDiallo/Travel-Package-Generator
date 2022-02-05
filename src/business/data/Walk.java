package business.data;

public class Walk extends Transport{

	public Walk() {
	}

	public Walk(double price, int confort, float vitesse) {
		super(price, confort, vitesse);
	}
	
	public double getPrice() {
		return 0;
	}
	
	@Override
	public String getName() {
		return "Walk";
	}
	
@Override
	public int getConfort() {
		return 0;
	}

 @Override
public float getSpeed() {
	return 6;
}
}
