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

import team.adyn.bean.Goods;
import team.adyn.bean.OdNum1;
import team.adyn.bean.OdNum2;
import team.adyn.bean.OdNum3;
import team.adyn.bean.Orderdate;
import team.adyn.dao.GoodsDAO;
import team.adyn.dao.OdNumDAO1;
import team.adyn.dao.OdNumDAO2;
import team.adyn.dao.OdNumDAO3;
import team.adyn.dao.OrderdateDAO;
import team.adyn.db.DBUtils;

/**
 * Servlet implementation class GoodsServlet3
 */
@WebServlet("/Goods_line")
public class GoodsServlet3 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private GoodsDAO GoodsDao = new GoodsDAO();
	private OrderdateDAO OrderdateDao = new OrderdateDAO();
	private OdNumDAO1 OdNumDao1 = new OdNumDAO1();
	private OdNumDAO2 OdNumDao2 = new OdNumDAO2();
	private OdNumDAO3 OdNumDao3 = new OdNumDAO3();
	private DBUtils DBUtils = new DBUtils();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsServlet3() {
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
		List<Orderdate> Orderdate = new ArrayList<Orderdate>();
		List<OdNum1> OdNum1 = new ArrayList<OdNum1>();
		List<OdNum2> OdNum2 = new ArrayList<OdNum2>();
		List<OdNum3> OdNum3 = new ArrayList<OdNum3>();
		try {
			Goods = GoodsDao.findall();
			String[] gname = new String[Goods.size()];
			int i = 0;
			for (Goods goods : Goods) {
				gname[i] = goods.getGname();
				i++;
			}
			Orderdate = OrderdateDao.findall();
			String[] odate = new String[Orderdate.size()];
			int j = 0;
			for (Orderdate orderdate : Orderdate) {
				odate[j] = orderdate.getOdate();
				j++;
			}
			OdNum1 = OdNumDao1.findall();
			Integer[] odcount1 = new Integer[OdNum1.size()];
			int k = 0;
			for (OdNum1 odnum1 : OdNum1) {
				odcount1[k] = odnum1.getOdcount1();
				k++;
			}
			OdNum2 = OdNumDao2.findall();
			Integer[] odcount2 = new Integer[OdNum2.size()];
			int l = 0;
			for (OdNum2 odnum2 : OdNum2) {
				odcount2[l] = odnum2.getOdcount2();
				l++;
			}
			OdNum3 = OdNumDao3.findall();
			Integer[] odcount3 = new Integer[OdNum3.size()];
			int m = 0;
			for (OdNum3 odnum3 : OdNum3) {
				odcount3[m] = odnum3.getOdcount3();
				m++;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("gname", gname);
			map.put("odate", odate);
			map.put("odcount1", odcount1);
			map.put("odcount2", odcount2);
			map.put("odcount3", odcount3);
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
