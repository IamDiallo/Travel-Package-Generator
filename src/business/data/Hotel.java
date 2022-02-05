package business.data;

public class Hotel extends Location {

	private String beach;
	
	public Hotel() {
	}

	public Hotel( int id,String name, double prix,String beach) {
		super(id,name,prix);
		this.beach = beach;
	}
	
}
