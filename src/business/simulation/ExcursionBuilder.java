package business.simulation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import business.data.Excursion;
import business.data.Hotel;
import business.data.Site;
import business.data.Trajet;

public class ExcursionBuilder {
	private FetchData fetchData;
	
	public ExcursionBuilder() {
		
	}

	public Excursion buildExcursion(OffreEntry entry, Hotel hotel, List<Site> sites) throws SQLException {
		fetchData = new FetchData();
		double excursionPrice = 0;
		Site lastVisitedSite = null;
		Trajet nextTrajet = new Trajet();

		Excursion excursion =new Excursion();
		Site destination = getRandomSite(sites, null);
		if(destination == null ) return null;
		excursionPrice += destination.getPrice();
		//sites.remove(destination);
		nextTrajet = fetchData.getTrajet(hotel, destination);
		
		excursion.addTrajet(nextTrajet);
		excursionPrice += nextTrajet.getPrice();

		lastVisitedSite = destination;

		int nbActivity = getNbActivity(entry.getRythme());
		System.out.println("NbActivity : " + nbActivity);
		for (int currentNbActivity = 0; (currentNbActivity < nbActivity && sites.size() > 0 ); currentNbActivity++) {
			destination = getRandomSite(sites,lastVisitedSite);
			excursionPrice += destination.getPrice();

			nextTrajet = fetchData.getTrajet(lastVisitedSite, destination);
			if(nextTrajet == null) break;
			excursionPrice += nextTrajet.getPrice();
			

			excursion.addTrajet(nextTrajet);
			lastVisitedSite = destination;
		}

		nextTrajet = fetchData.getTrajet(lastVisitedSite, hotel);
		excursionPrice += nextTrajet.getPrice();
		excursion.addTrajet(nextTrajet);
		excursion.setExcursionPrice(excursionPrice);
		return excursion;
	}

	private int getNbActivity(String confort) {
		if (confort.equals("1"))
			return OffreUtility.getRandomNumber(2, 3);
		else
			return OffreUtility.getRandomNumber(0, 1);
	}

	public Site getRandomSite(List<Site> sites, Site source) {
		if (source == null) return sites.get(OffreUtility.getRandomNumber(0, sites.size()-1));
		else {
			Site destination = new Site();
			do {
				destination = sites.get(OffreUtility.getRandomNumber(0, sites.size()-1));
			}while(destination.equals(source)); 
			return destination;
		}
	}
}
