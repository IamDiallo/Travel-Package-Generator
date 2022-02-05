package beans;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.lucene.queryparser.classic.ParseException;

import business.data.Offre;
import business.simulation.OffreCreator;
import business.simulation.OffreEntry;

@ManagedBean
@RequestScoped
public class ExcursionBean {

	
	@ManagedProperty(value = "#{searchBean}")
	private SearchBean searchBean;

	
	public ExcursionBean() {
		
	}

	public SearchBean getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(SearchBean searchBean) {
		this.searchBean = searchBean;
	}
	
	public Offre getOffre() {
        OffreEntry offreEntry = searchBean.getEntry();
        OffreCreator offreCreator = searchBean.getOffreCreator();

        try {
			return offreCreator.buildOffer();
		} catch (IOException | ParseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
	
	
	
	
}
