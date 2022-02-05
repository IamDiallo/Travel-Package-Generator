package business.simulation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import BdeApi.TravelApiImpl;
import business.data.Bus;
import business.data.Hotel;
import business.data.Location;
import business.data.Site;
import business.data.Trajet;
import business.data.Transport;
import dao.BdeInterface;

public class FetchData {
	private String keywords;
	private double hotelPrice;
	BdeInterface bde = new TravelApiImpl("sites", "name", "/Users/mamadoubelladiallo/newEclipse/COO/agp/jsf/Description");

	public FetchData() {
	}

	public ArrayList<Hotel> searchHotel(double maxPrice) throws SQLException, IOException, ParseException {
		return (ArrayList<Hotel>) bde.getHotels(maxPrice);
	}

	public ArrayList<Site> searchPlace(String keywords) throws SQLException, IOException, ParseException {
		return (ArrayList<Site>) bde.getallSites(keywords);
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<Hotel> getHotelPrice(double hotelPrice) throws SQLException, IOException, ParseException {
		return (ArrayList<Hotel>) bde.getHotels(hotelPrice);
	}

	public void setHotelPrice(double hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	
	public Trajet getTrajet(Location source , Location destination) throws SQLException {
		return (Trajet)bde.getTrajet(source, destination);
	}

}
