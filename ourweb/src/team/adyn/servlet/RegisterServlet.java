package team.adyn.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.adyn.bean.Users;
import team.adyn.dao.UsersDAO;
import team.adyn.db.DBUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = new String();
		uname = new String( uname.getBytes("iso-8859-1"),"gb2312");
		uname = request.getParameter("uname");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		Users user = new Users(uname, password1, password2);
		UsersDAO dao = new UsersDAO();
		try {
			Connection con = DBUtils.getconn();
			if (dao.register(con, user)) {
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("login&register.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
