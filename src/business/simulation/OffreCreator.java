package business.simulation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import business.data.Offre;
import business.data.Constant;
import business.data.Excursion;
import business.data.Hotel;
import business.data.Site;
import business.spring.SpringIoC;

public class OffreCreator {
	//private OffreEntry offreEntry = (OffreEntry) SpringIoC.getBean("entry");
	private ExcursionBuilder excursionBuilder;
	private FetchData fetchData;

	public OffreCreator() {
		fetchData= new FetchData();
	}
	private OffreEntry entry;
	
	public void setOffreEntry(OffreEntry entry) {
		this.entry = entry;
	}

	public Offre buildOffer() throws IOException, ParseException, SQLException {
		System.out.println(entry.getSiteType()+entry.getKeywords()+entry.getRythme()); 
		Offre offre = new Offre();
		Excursion excursion;
		List<Hotel> hotels;
		List<Site> sites;

		hotels = getHotelList(entry.getPriceMax()*0.2);
		Hotel currentHotel = null;

		String keyWords = entry.getSiteType() + "";
		keyWords = keyWords.concat(entry.getKeywords());
		sites = fetchData.searchPlace(keyWords);
		System.out.println("Taille Liste : " +sites.size());

		System.out.println(sites);

		excursionBuilder = new ExcursionBuilder();

		double totalOfferPrice = 0;

		for (int nbDays = 1; nbDays <= entry.getNbDays(); nbDays++) {
			currentHotel = chooseHotel(currentHotel, hotels);
			totalOfferPrice += currentHotel.getPrice();
			for (int nbExcursions = 0; nbExcursions < nbExcursionsOfDay(); nbExcursions++) {
				if (entry.getPriceMax() - totalOfferPrice < Constant.EXCURSION_MIN_PRICE)
					return offre;
				excursion = excursionBuilder.buildExcursion(entry, currentHotel, sites);
				if (excursion != null)
					offre.addExcursion(excursion);

				excursion.displayExcursion();
				totalOfferPrice += excursion.getExcursionPrice();
				excursion.setDays(nbDays);
			}
		}
		return offre;

	}

	private List<Hotel> getHotelList(double priceHotel) throws SQLException, IOException, ParseException {
		return fetchData.searchHotel(priceHotel);
	}

	private Hotel getRandomHotel(List<Hotel> hotels) throws SQLException, IOException, ParseException {
		int randIndex = OffreUtility.getRandomNumber(0, hotels.size() - 1);
		return hotels.get(randIndex);

	}

	private Hotel chooseHotel(Hotel currentHotel, List<Hotel> nextHotelsList)
			throws SQLException, IOException, ParseException {
		if (currentHotel == null)
			return getRandomHotel(nextHotelsList);
		else {
			double random = Math.random();
			if (random < entry.getHotelChangeRate()) {
				// hotelChangeReport();
				return getRandomHotel(nextHotelsList);
			} else
				return currentHotel;
		}
	}


	private int nbExcursionsOfDay() {
		if (entry.getRythme().equals("1"))
			return 2;
		else
			return OffreUtility.getRandomNumber(0, 1);
	}

}
