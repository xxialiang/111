package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.OdNum3;
import team.adyn.db.DBUtils;

public class OdNumDAO3 {

	public List<OdNum3> findall() {
		String sql = "select * from odnum3";
		List<OdNum3> OdNum3 = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			OdNum3 odnum3 = null;
			while (re.next()) {
				odnum3 = new OdNum3();
				odnum3.setOdcount3(re.getInt("odcount3"));
				OdNum3.add(odnum3);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return OdNum3;
	}

}