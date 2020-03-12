package team.adyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.adyn.bean.Orders;
import team.adyn.db.DBUtils;

public class OrdersDAO {

	public List<Orders> findall() {
		String sql = "select * from orders";
		List<Orders> Orders = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtils.getconn().prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			Orders orders = null;
			while (re.next()) {
				orders = new Orders();
				orders.setGname(re.getString("gname"));
				Orders.add(orders);
			}
			System.out.println("SearchLink");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close();
		}
		return Orders;
	}

}
