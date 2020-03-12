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

import team.adyn.bean.PNum;
import team.adyn.bean.Province;
import team.adyn.dao.PNumDAO;
import team.adyn.dao.ProvinceDAO;
import team.adyn.db.DBUtils;

/**
 * Servlet implementation class ProvinceServlet
 */
@WebServlet("/Province")
public class ProvinceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProvinceDAO ProvinceDao = new ProvinceDAO();
	private PNumDAO PNumDao = new PNumDAO();
	private DBUtils DBUtils = new DBUtils();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProvinceServlet() {
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
		List<Province> Province = new ArrayList<Province>();
		List<PNum> PNum = new ArrayList<PNum>();
		try {
			Province = ProvinceDao.findall();
			String[] pname = new String[Province.size()];
			int i = 0;
			for (Province province : Province) {
				pname[i] = province.getPname();
				i++;
			}
			PNum = PNumDao.findall();
			Integer[] pcount = new Integer[PNum.size()];
			int j = 0;
			for (PNum pnum : PNum) {
				pcount[j] = pnum.getPcount();
				j++;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pname", pname);
			map.put("pcount", pcount);
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
