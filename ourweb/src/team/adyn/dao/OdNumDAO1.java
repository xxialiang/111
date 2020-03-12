package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.OdNum1;
import team.adyn.db.DBUtils;

public class OdNumDAO1 {

	public List<OdNum1> findall() {
		String sql = "select * from odnum1";
		List<OdNum1> OdNum1 = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			OdNum1 odnum1 = null;
			while (re.next()) {
				odnum1 = new OdNum1();
				odnum1.setOdcount1(re.getInt("odcount1"));
				OdNum1.add(odnum1);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return OdNum1;
	}

}
