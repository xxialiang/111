package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.Mailingdate;
import team.adyn.db.DBUtils;

public class MailingdateDAO {

	public List<Mailingdate> findall() {
		String sql = "select * from mailingdate";
		List<Mailingdate> Mailingdate = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			Mailingdate mailingdate = null;
			while (re.next()) {
				mailingdate = new Mailingdate();
				mailingdate.setMdate(re.getString("mdate"));
				Mailingdate.add(mailingdate);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return Mailingdate;
	}

}