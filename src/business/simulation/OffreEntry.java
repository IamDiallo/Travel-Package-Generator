package business.simulation;

public class OffreEntry {
	private String rythme; // 1 haut 0 bas --> rythme
	private double priceMin;
	private double priceMax; 
	private double changeRate;
	private String siteType; //0 historique 1 loisir
	private int nbDays;
	private int maxTimeperDay;
	private String keywords;
	
	public OffreEntry() {
		
	}

	/*public OffreEntry(double priceMin, double priceMax, String siteType, int nbDays,String keywords, String rythme) {
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.changeRate = changeRate;
		this.siteType = siteType;
		this.nbDays = nbDays;
		this.keywords = keywords;
		this.rythme = rythme;
	}*/

	public double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(double priceMin) {
		this.priceMin = priceMin;
	}

	public double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(double priceMax) {
		this.priceMax = priceMax;
	}

	public int getNbDays() {
		return nbDays;
	}

	public void setNbDays(int nbDays) {
		this.nbDays = nbDays;
	}

	public int getMaxTimeperDay() {
		return maxTimeperDay;
	}

	public void setMaxTimeperDay(int maxTimeperDay) {
		this.maxTimeperDay = maxTimeperDay;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getRythme() {
		return rythme;
	}

	public void setRythme(String rythme) {
		this.rythme = rythme;
	}

	public double getHotelChangeRate() {
		// TODO Auto-generated method stub
		return 0.1;
	}
	
	

}
