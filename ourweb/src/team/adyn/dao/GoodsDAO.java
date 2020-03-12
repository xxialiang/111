package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.Goods;
import team.adyn.db.DBUtils;

public class GoodsDAO {

	public List<Goods> findall() {
		String sql = "select * from goods";
		List<Goods> Goods = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			Goods goods = null;
			while (re.next()) {
				goods = new Goods();
				goods.setGname(re.getString("gname"));
				Goods.add(goods);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return Goods;
	}

}