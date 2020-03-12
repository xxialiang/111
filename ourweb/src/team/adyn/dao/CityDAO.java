package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.City;
import team.adyn.db.DBUtils;

public class CityDAO {

	public List<City> findall() {
		String sql = "select * from city";
		List<City> City = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			City city = null;
			while (re.next()) {
				city = new City();
				city.setCname(re.getString("cname"));
				City.add(city);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return City;
	}

}