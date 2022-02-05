package dao;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.lucene.queryparser.classic.ParseException;

import business.data.Location;



public interface BdeInterface {
	
	public void setApiParameters(String table,String key,String pathFolder);
	
	public void persistText(String key,String text);
	
	public void createIndex() throws IOException, ParseException;

	public Object getallSites(String keywords) throws IOException, ParseException, SQLException ;

	public Object getHotels(Double prixMax)throws IOException, ParseException, SQLException;
	
	public Object getTrajet(Location idSrc,Location idDst) throws SQLException ;

	
}
