package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.OdNum;
import team.adyn.db.DBUtils;

public class OdNumDAO {

	public List<OdNum> findall() {
		String sql = "select * from odnum";
		List<OdNum> OdNum = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			OdNum odnum = null;
			while (re.next()) {
				odnum = new OdNum();
				odnum.setOdcount(re.getInt("odcount"));
				OdNum.add(odnum);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return OdNum;
	}

}
