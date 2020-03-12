package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.MdNum4;
import team.adyn.db.DBUtils;

public class MdNumDAO4 {

	public List<MdNum4> findall() {
		String sql = "select * from mdnum4";
		List<MdNum4> MdNum4 = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			MdNum4 mdnum4 = null;
			while (re.next()) {
				mdnum4 = new MdNum4();
				mdnum4.setMdcount4(re.getInt("mdcount4"));
				MdNum4.add(mdnum4);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return MdNum4;
	}

}