package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.OdNum2;
import team.adyn.db.DBUtils;

public class OdNumDAO2 {

	public List<OdNum2> findall() {
		String sql = "select * from odnum2";
		List<OdNum2> OdNum2 = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			OdNum2 odnum2 = null;
			while (re.next()) {
				odnum2 = new OdNum2();
				odnum2.setOdcount2(re.getInt("odcount2"));
				OdNum2.add(odnum2);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return OdNum2;
	}

}