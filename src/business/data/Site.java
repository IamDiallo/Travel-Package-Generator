package business.data;

public class Site extends Location {
	private String type;
	
	public Site() {
	}
	
	public Site(int id,String name, double prix,String type) {
		super(id,name, prix);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	

}
