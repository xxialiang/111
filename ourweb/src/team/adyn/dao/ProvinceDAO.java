package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.Province;
import team.adyn.db.DBUtils;

public class ProvinceDAO {

	public List<Province> findall() {
		String sql = "select * from province";
		List<Province> Province = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			Province province = null;
			while (re.next()) {
				province = new Province();
				province.setPname(re.getString("pname"));
				Province.add(province);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return Province;
	}

}
