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

import team.adyn.bean.OdNum;
import team.adyn.bean.Orderdate;
import team.adyn.dao.OdNumDAO;
import team.adyn.dao.OrderdateDAO;
import team.adyn.db.DBUtils;

/**
 * Servlet implementation class OrderdateServlet
 */
@WebServlet("/Orderdate")
public class OrderdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private OrderdateDAO OrderdateDao = new OrderdateDAO();
	private OdNumDAO OdNumDao = new OdNumDAO();
	private DBUtils DBUtils = new DBUtils();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		List<Orderdate> Orderdate = new ArrayList<Orderdate>();
		List<OdNum> OdNum = new ArrayList<OdNum>();
		try {
			Orderdate = OrderdateDao.findall();
			String[] odate = new String[Orderdate.size()];
			int i = 0;
			for (Orderdate orderdate : Orderdate) {
				odate[i] = orderdate.getOdate();
				i++;
			}
			OdNum = OdNumDao.findall();
			Integer[] odcount = new Integer[OdNum.size()];
			int j = 0;
			for (OdNum odnum : OdNum) {
				odcount[j] = odnum.getOdcount();
				j++;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("odate", odate);
			map.put("odcount", odcount);
			response.getWriter().print(JSON.toJSONString(map));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
