package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.PNum;
import team.adyn.db.DBUtils;

public class PNumDAO {

	public List<PNum> findall() {
		String sql = "select * from pnum";
		List<PNum> PNum = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			PNum pnum = null;
			while (re.next()) {
				pnum = new PNum();
				pnum.setPcount(re.getInt("pcount"));
				PNum.add(pnum);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return PNum;
	}

}
