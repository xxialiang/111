package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.MdNum3;
import team.adyn.db.DBUtils;

public class MdNumDAO3 {

	public List<MdNum3> findall() {
		String sql = "select * from mdnum3";
		List<MdNum3> MdNum3 = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			MdNum3 mdnum3 = null;
			while (re.next()) {
				mdnum3 = new MdNum3();
				mdnum3.setMdcount3(re.getInt("mdcount3"));
				MdNum3.add(mdnum3);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return MdNum3;
	}

}