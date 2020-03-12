package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.GNum;
import team.adyn.db.DBUtils;

public class GNumDAO {

	public List<GNum> findall() {
		String sql = "select * from gnum";
		List<GNum> GNum = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			GNum gnum = null;
			while (re.next()) {
				gnum = new GNum();
				gnum.setGcount(re.getInt("gcount"));
				GNum.add(gnum);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return GNum;
	}

}