package team.adyn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import team.adyn.bean.Orders;
import team.adyn.dao.OrdersDAO;

/**
 * Servlet implementation class OrdersqryServlet
 */
@WebServlet("/Orders")
public class OrdersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private OrdersDAO OrdersDao = new OrdersDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrdersServlet() {
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
		response.setContentType("text/html; charset=utf-8");
		List<Orders> Orders = new ArrayList<Orders>();
		try {
			Orders = OrdersDao.findall();
			String[] gname = new String[Orders.size()];
			int i = 0;
			for (Orders order : Orders) {
				gname[i] = order.getGname();
				i++;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("gname", gname);
			response.getWriter().print(JSON.toJSONString(map));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

}
