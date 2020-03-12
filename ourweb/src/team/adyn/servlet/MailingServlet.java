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

import team.adyn.bean.MNum;
import team.adyn.bean.Mailing;
import team.adyn.dao.MNumDAO;
import team.adyn.dao.MailingDAO;
import team.adyn.db.DBUtils;

/**
 * Servlet implementation class MailingServlet
 */
@WebServlet("/Mailing")
public class MailingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MailingDAO MailingDao = new MailingDAO();
	private MNumDAO MNumDao = new MNumDAO();
	private DBUtils DBUtils = new DBUtils();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailingServlet() {
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
		List<Mailing> Mailing = new ArrayList<Mailing>();
		List<MNum> MNum = new ArrayList<MNum>();
		try {
			Mailing = MailingDao.findall();
			String[] mname = new String[Mailing.size()];
			int i = 0;
			for (Mailing mailing : Mailing) {
				mname[i] = mailing.getMname();
				i++;
			}
			MNum = MNumDao.findall();
			Integer[] mcount = new Integer[MNum.size()];
			int j = 0;
			for (MNum mnum : MNum) {
				mcount[j] = mnum.getMcount();
				j++;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mname", mname);
			map.put("mcount", mcount);
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