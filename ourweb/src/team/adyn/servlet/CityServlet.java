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

import team.adyn.bean.CNum;
import team.adyn.bean.City;
import team.adyn.dao.CNumDAO;
import team.adyn.dao.CityDAO;
import team.adyn.db.DBUtils;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/City")
public class CityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CityDAO CityDao = new CityDAO();
	private CNumDAO CNumDao = new CNumDAO();
	private DBUtils DBUtils = new DBUtils();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CityServlet() {
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
		List<City> City = new ArrayList<City>();
		List<CNum> CNum = new ArrayList<CNum>();
		try {
			City = CityDao.findall();
			String[] cname = new String[City.size()];
			int i = 0;
			for (City city : City) {
				cname[i] = city.getCname();
				i++;
			}
			CNum = CNumDao.findall();
			Integer[] ccount = new Integer[CNum.size()];
			int j = 0;
			for (CNum cnum : CNum) {
				ccount[j] = cnum.getCcount();
				j++;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("cname", cname);
			map.put("ccount", ccount);
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
