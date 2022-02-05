package BdeApi;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import business.data.Hotel;
import business.data.Location;
import business.data.Trajet;
import dao.BdeInterface;

public class TravelApiImpl implements BdeInterface {

	private String table;
	private String key;
	private String folder;
	Jdbc jdbc = new Jdbc();
	LuceneOperator luceneOp;

	
public TravelApiImpl() {
}
	public TravelApiImpl(String table, String key, String folder) {
		this.folder = folder;
		this.table = table;
		this.key = key;
		try {
			this.luceneOp = new LuceneOperator(folder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void setApiParameters(String table, String key, String pathFolder) {
		this.folder = folder;
		this.table = table;
		this.key = key;

	}

	@Override
	public void createIndex() throws IOException {
		luceneOp.createIndex();
	}

	public HashMap<String, Float> executeLuceneQuery(String query) throws SQLException, IOException, ParseException {
		return luceneOp.execute(query);
	}

	public Object executeMixQuery(String query) throws IOException, ParseException, SQLException {

		String sqlQuery = getSQL(query);
		String luceneQuery = getLucene(query);
		HashMap<String, Float> result = luceneOp.execute(luceneQuery);
		MixteOperator rm = new MixteOperator(result, sqlQuery);

		return rm.getSiteList();

	}

	public Object executeSQLQuery(String query) throws SQLException {

		ResultSet sqlResult = jdbc.execute(query);
		String affich = "";
		System.out.println(sqlResult);
		ResultSet res2 = sqlResult;
		java.sql.ResultSetMetaData rsmd = res2.getMetaData();

		int colNum = rsmd.getColumnCount();
		int compteur = 0;
		while (res2.next()) {
			for (int i = 1; i <= colNum; i++) {

				affich += res2.getString(i) + "\t";
				if (i == 1)
					affich += ("  ||  ");
			}
			affich += "  \n  ";

		}
		System.out.println(affich);
		return sqlResult;
	}

	public Object getallSites(String keywords) throws IOException, ParseException, SQLException {

		String finalRequest = "SELECT * FROM sites ";
		
			if (keywords.contains("historique")) {
				finalRequest += "WHERE ";
				finalRequest += "type='historique' ";
				String finalKeywords = "";
				finalKeywords = keywords.copyValueOf("historique".toCharArray());
				System.out.println(finalKeywords);
				keywords = keywords.replace(finalKeywords, "");
				System.out.println(keywords);

			} else if (keywords.contains("activite")) {
				finalRequest += "WHERE ";
				finalRequest += "type='activite' ";
				String finalKeywords = "";
				finalKeywords = keywords.copyValueOf("activite".toCharArray());
				keywords = keywords.replace(finalKeywords, "");
			}
			if (!keywords.replaceAll("\\s", "").isEmpty()) {
				finalRequest += "with " + keywords + " ;";
			}
		
		
		return execute(finalRequest);
		
	}

	@Override
	public Object getHotels(Double prixMax) throws IOException, ParseException, SQLException {
		String finalRequest = "SELECT * FROM hotel WHERE price <= " + prixMax.toString();
		SqlOperator sqlop = new SqlOperator();
		List<Hotel> listhotels = new ArrayList<Hotel>();
		ResultSet res = sqlop.execute(finalRequest);

		while (res.next()) {
			listhotels.add(new Hotel(res.getInt("idLocation"), res.getString("hotelName"), res.getDouble("price"),
					res.getString("beachName")));
		}
		return listhotels;
	}

	@Override
	public Object getTrajet(Location Src, Location Dst) throws SQLException {

		String finalRequest = "SELECT * FROM trajet WHERE idLocationSrc = "+String.valueOf(Src.getId())+" and idLocationDst ="+String.valueOf(Dst.getId());
		SqlOperator sqlop= new SqlOperator();
		Trajet trj =null;
		ResultSet res = sqlop.execute(finalRequest);
		
		if(res.isFirst()) {
			trj=new Trajet(Src,Dst,res.getString("transport"),res.getDouble("price"),res.getDouble("distance"));
		}
		return trj;
	}

	@Override
	public void persistText(String key, String text) {
		// TODO Auto-generated method stub

	}

	public String getSQL(String query) {
		String[] output = query.split("with ");

		return output[0];
	}

	public String getLucene(String query) {
		String[] output = query.split("with ");

		return output[1];
	}
	public Object execute(String query) throws IOException, ParseException, SQLException {
		Object result;
		if (query.contains("with")) {
			result = executeMixQuery(query);
			return result;
		} else {
			result = executeSQLQuery(query);
			return result;
		}
	}


}
