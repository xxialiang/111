package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.Orderdate;
import team.adyn.db.DBUtils;

public class OrderdateDAO {

	public List<Orderdate> findall() {
		String sql = "select * from orderdate";
		List<Orderdate> Orderdate = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			Orderdate orderdate = null;
			while (re.next()) {
				orderdate = new Orderdate();
				orderdate.setOdate(re.getString("odate"));
				Orderdate.add(orderdate);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return Orderdate;
	}

}
