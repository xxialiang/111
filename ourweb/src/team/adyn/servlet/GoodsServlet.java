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

import team.adyn.bean.GNum;
import team.adyn.bean.Goods;
import team.adyn.dao.GNumDAO;
import team.adyn.dao.GoodsDAO;
import team.adyn.db.DBUtils;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/Goods")
public class GoodsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private GoodsDAO GoodsDao = new GoodsDAO();
	private GNumDAO GNumDao = new GNumDAO();
	private DBUtils DBUtils = new DBUtils();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsServlet() {
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
		List<Goods> Goods = new ArrayList<Goods>();
		List<GNum> GNum = new ArrayList<GNum>();
		try {
			Goods = GoodsDao.findall();
			String[] gname = new String[Goods.size()];
			int i = 0;
			for (Goods goods : Goods) {
				gname[i] = goods.getGname();
				i++;
			}
			GNum = GNumDao.findall();
			Integer[] gcount = new Integer[GNum.size()];
			int j = 0;
			for (GNum gnum : GNum) {
				gcount[j] = gnum.getGcount();
				j++;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("gname", gname);
			map.put("gcount", gcount);
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