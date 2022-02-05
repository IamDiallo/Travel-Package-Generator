package business.data;

public abstract class Location {

	private int id;
	private String name;

	double price;
	int x;
	int y;
	
	public Location() {
	}

	public Location(int id,String name , double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public double getPrice() {
		return price;
	}

	public void setPrix(double prix) {
		this.price = prix;
	}
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
