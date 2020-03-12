package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.MNum;
import team.adyn.db.DBUtils;

public class MNumDAO {

	public List<MNum> findall() {
		String sql = "select * from mnum";
		List<MNum> MNum = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			MNum mnum = null;
			while (re.next()) {
				mnum = new MNum();
				mnum.setMcount(re.getInt("mcount"));
				MNum.add(mnum);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return MNum;
	}

}
