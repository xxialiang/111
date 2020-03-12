package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.Mailing;
import team.adyn.db.DBUtils;

public class MailingDAO {

	public List<Mailing> findall() {
		String sql = "select * from mailing";
		List<Mailing> Mailing = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			Mailing mailing = null;
			while (re.next()) {
				mailing = new Mailing();
				mailing.setMname(re.getString("mname"));
				Mailing.add(mailing);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return Mailing;
	}

}
