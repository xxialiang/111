package team.adyn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import team.adyn.bean.Users;

public class UsersDAO {

	public Users login(Connection con, Users user) throws Exception {
		Users resultUser = null;
		String sql = "select * from users where uname=? and password1=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, user.getUname());
		st.setString(2, user.getPassword1());
		ResultSet re = st.executeQuery();
		if (re.next()) {
			resultUser = new Users();
			resultUser.setUname(re.getString("uname"));
			resultUser.setPassword1(re.getString("password1"));
		}
		return resultUser;
	}

	public boolean register(Connection con, Users user) throws Exception {
		boolean flag = false;
		PreparedStatement st = null;
		String sql = "insert into users(uname,password1,password2)values(?,?,?)";
		st = con.prepareStatement(sql);
		st.setString(1, user.getUname());
		st.setString(2, user.getPassword1());
		st.setString(3, user.getPassword2());
		if (st.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

}
