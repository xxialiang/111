package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.MdNum2;
import team.adyn.db.DBUtils;

public class MdNumDAO2 {

	public List<MdNum2> findall() {
		String sql = "select * from mdnum2";
		List<MdNum2> MdNum2 = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			MdNum2 mdnum2 = null;
			while (re.next()) {
				mdnum2 = new MdNum2();
				mdnum2.setMdcount2(re.getInt("mdcount2"));
				MdNum2.add(mdnum2);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return MdNum2;
	}

}