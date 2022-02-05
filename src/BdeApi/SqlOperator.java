package BdeApi;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlOperator extends CustomOperator{
	Jdbc jdbc= new Jdbc();
	ResultSet res;
	
	public ResultSet execute(String sqlQuery) throws SQLException {
		res=jdbc.execute(sqlQuery);
		return res;
	}

	@Override
	public void init() {
		res=null;
	}

	@Override
	public Object next() {
		try {
			if(res.next()) {
				return res.next();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
