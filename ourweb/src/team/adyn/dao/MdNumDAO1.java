package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.MdNum1;
import team.adyn.db.DBUtils;

public class MdNumDAO1 {

	public List<MdNum1> findall() {
		String sql = "select * from mdnum1";
		List<MdNum1> MdNum1 = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			MdNum1 mdnum1 = null;
			while (re.next()) {
				mdnum1 = new MdNum1();
				mdnum1.setMdcount1(re.getInt("mdcount1"));
				MdNum1.add(mdnum1);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return MdNum1;
	}

}