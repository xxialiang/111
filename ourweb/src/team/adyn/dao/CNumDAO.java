package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.CNum;
import team.adyn.db.DBUtils;

public class CNumDAO {

	public List<CNum> findall() {
		String sql = "select * from cnum";
		List<CNum> CNum = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			CNum cnum = null;
			while (re.next()) {
				cnum = new CNum();
				cnum.setCcount(re.getInt("ccount"));
				CNum.add(cnum);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return CNum;
	}

}