package BdeApi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import business.data.Site;


public class MixteOperator extends CustomOperator{
	private HashMap<String, Float> luceneResult;
	private SqlOperator sqlOperator =new SqlOperator();
	
	private int cursor = -1;
	private ArrayList<Site> siteList = new ArrayList<>();

	public MixteOperator(HashMap<String, Float> luceneResult, String sqlQuery) throws SQLException {
		super();
		this.luceneResult = luceneResult;
		ResultSet sqlRes= sqlOperator.execute(sqlQuery);
		// score , site
		HashMap<Float, Site> mixList = new HashMap<>();

		while (sqlRes.next()) {
			//compare the key 
			if (luceneResult.containsKey((sqlRes.getString("name").replaceAll("\\s", "")))) {

				mixList.put(luceneResult.get(sqlRes.getString("name").replaceAll("\\s", "")),
						new Site(sqlRes.getInt("idLocation"),sqlRes.getString("name"),
								sqlRes.getFloat("price"), sqlRes.getString("type")));
			}
		}
		while (!mixList.isEmpty()) {
			Set key = mixList.keySet();
			Iterator it = key.iterator();

			float scoreMax = 0;

			while (it.hasNext()) {
				float score = (float) it.next();
				if (score > scoreMax) {
					scoreMax = score;
				}
			}
			Site site = mixList.get(scoreMax);

			siteList.add(site);
			mixList.remove(scoreMax);
		}
	}

	public ArrayList<Site> getSiteList() {
		return siteList;
	}

	public Site next() {
		cursor++;
		return siteList.get(cursor);
	}

	public void init() {
		cursor = -1;
	}

	public boolean hasNext() {
		if (cursor == siteList.size() - 1) {
			return false;
		} else {
			return true;
		}
	}

	
	

}

