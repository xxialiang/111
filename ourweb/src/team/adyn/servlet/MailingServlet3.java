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

import team.adyn.bean.Mailing;
import team.adyn.bean.Mailingdate;
import team.adyn.bean.MdNum1;
import team.adyn.bean.MdNum2;
import team.adyn.bean.MdNum3;
import team.adyn.bean.MdNum4;
import team.adyn.dao.MailingDAO;
import team.adyn.dao.MailingdateDAO;
import team.adyn.dao.MdNumDAO1;
import team.adyn.dao.MdNumDAO2;
import team.adyn.dao.MdNumDAO3;
import team.adyn.dao.MdNumDAO4;
import team.adyn.db.DBUtils;

/**
 * Servlet implementation class MailingServlet3
 */
@WebServlet("/Mailing_line")
public class MailingServlet3 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MailingDAO MailingDao = new MailingDAO();
	private MailingdateDAO MailingdateDao = new MailingdateDAO();
	private MdNumDAO1 MdNumDao1 = new MdNumDAO1();
	private MdNumDAO2 MdNumDao2 = new MdNumDAO2();
	private MdNumDAO3 MdNumDao3 = new MdNumDAO3();
	private MdNumDAO4 MdNumDao4 = new MdNumDAO4();
	private DBUtils DBUtils = new DBUtils();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailingServlet3() {
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
		List<Mailingdate> Mailingdate = new ArrayList<Mailingdate>();
		List<MdNum1> MdNum1 = new ArrayList<MdNum1>();
		List<MdNum2> MdNum2 = new ArrayList<MdNum2>();
		List<MdNum3> MdNum3 = new ArrayList<MdNum3>();
		List<MdNum4> MdNum4 = new ArrayList<MdNum4>();
		try {
			Mailing = MailingDao.findall();
			String[] mname = new String[Mailing.size()];
			int i = 0;
			for (Mailing mailing : Mailing) {
				mname[i] = mailing.getMname();
				i++;
			}
			Mailingdate = MailingdateDao.findall();
			String[] mdate = new String[Mailingdate.size()];
			int j = 0;
			for (Mailingdate mailingdate : Mailingdate) {
				mdate[j] = mailingdate.getMdate();
				j++;
			}
			MdNum1 = MdNumDao1.findall();
			Integer[] mdcount1 = new Integer[MdNum1.size()];
			int k = 0;
			for (MdNum1 mdnum1 : MdNum1) {
				mdcount1[k] = mdnum1.getMdcount1();
				k++;
			}
			MdNum2 = MdNumDao2.findall();
			Integer[] mdcount2 = new Integer[MdNum2.size()];
			int l = 0;
			for (MdNum2 mdnum2 : MdNum2) {
				mdcount2[l] = mdnum2.getMdcount2();
				l++;
			}
			MdNum3 = MdNumDao3.findall();
			Integer[] mdcount3 = new Integer[MdNum3.size()];
			int m = 0;
			for (MdNum3 mdnum3 : MdNum3) {
				mdcount3[m] = mdnum3.getMdcount3();
				m++;
			}
			MdNum4 = MdNumDao4.findall();
			Integer[] mdcount4 = new Integer[MdNum4.size()];
			int n = 0;
			for (MdNum4 mdnum4 : MdNum4) {
				mdcount4[n] = mdnum4.getMdcount4();
				n++;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mname", mname);
			map.put("mdate", mdate);
			map.put("mdcount1", mdcount1);
			map.put("mdcount2", mdcount2);
			map.put("mdcount3", mdcount3);
			map.put("mdcount4", mdcount4);
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
