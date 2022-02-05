package beans;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.lucene.queryparser.classic.ParseException;

import business.simulation.OffreCreator;
import business.simulation.OffreEntry;


@ManagedBean
@SessionScoped
public class  SearchBean implements Serializable{
	

	
	private static final long serialVersionUID = 4541988893302790713L;
	private OffreEntry entry = new OffreEntry();
	private OffreCreator offreCreator = new OffreCreator();
	
    public SearchBean() {	
		
	}
    
    public String start() {

        if(entry.getPriceMax() < 100) {
            return "errorPage";
        }else if(entry.getPriceMax() < entry.getPriceMin()) {
            return "errorPage";
        }else if(entry.getKeywords().equals("")) {
            return "errorPage";
        }else if(entry.getNbDays() <=0) {
            return "errorPage";
        }

        offreCreator.setOffreEntry(entry);
        return "result";
    }

    public String retour() {

        return "search";
    }
	
	public OffreCreator getOffreCreator() {
		return offreCreator;
	}

	public void setOffreCreator(OffreCreator offreCreator) {
		this.offreCreator = offreCreator;
	}

	public OffreEntry getEntry() {
		return entry;
	}

	public void setEntry(OffreEntry entry) {
		this.entry = entry;
	}


	public String getRythme() {
		return entry.getRythme();
	}

	public void setRythme(String rythme) {
		entry.setRythme(rythme);
	}

	public String getKeywords() {
		return entry.getKeywords();
	}

	public void setKeywords(String keywords) {
		entry.setKeywords(keywords);
	}

	public String getSiteType() {
		return entry.getSiteType();
		
	}

	public void setSiteType(String siteType) {
		entry.setSiteType(siteType);
	}
	
	public double getPriceMin() {
		return entry.getPriceMin();
	}

	public void setPriceMin(double budgetMin) {
		entry.setPriceMin(budgetMin);
	}

	public double getPriceMax() {
		return entry.getPriceMax();
	}

	public void setPriceMax(double budgetMax) {
		entry.setPriceMax(budgetMax);
	}

	public int getNbDays() {
		return entry.getNbDays();
	}

	public void setNbDays(int nbDays) {
		entry.setNbDays(nbDays);
	}
	
	
	


}
