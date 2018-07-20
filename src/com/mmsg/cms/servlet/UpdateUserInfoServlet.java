package com.mmsg.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmsg.cms.biz.UserInfoBiz;
import com.mmsg.cms.biz.impl.UserInfoBizImpl;
import com.mmsg.cms.vo.UserInfo;

/**
 * Servlet implementation class UpdateUserInfoServlet
 */
@WebServlet("/UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码
		request.setCharacterEncoding("utf-8");
		//创建业务逻辑层对象
		UserInfoBiz biz = new UserInfoBizImpl();
		//获取用户输入的信息
		int userid =Integer.parseInt(request.getParameter("updateid").replaceAll(" ", ""));
		String username = request.getParameter("updatename");
		String userpass = request.getParameter("updatepass");
		String usertel = request.getParameter("updatetel");
		String usersex = request.getParameter("updatesex");
		String useremail = request.getParameter("updatemian");
		String usercsri = request.getParameter("updatedata");
		String useredu = request.getParameter("updateedu");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sf.parse(usercsri);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserInfo updateuser = new UserInfo();
		updateuser.setId(userid);
		updateuser.setUsername(username);
		updateuser.setPassword(userpass);
		updateuser.setTelephone(usertel);
		updateuser.setGender(usersex);
		updateuser.setEmail(useremail);
		updateuser.setBorndate(date);
		updateuser.setEducation(useredu);
		int s = biz.updataUserinfo(updateuser);
		//定义输出流
		PrintWriter out = response.getWriter();
		//返回前端的判断信息
		if(s > 0){
			out.write("ok");
		}else{
			out.write("on");
		}
		
		/*System.out.println(userid);
		System.out.println(username);
		System.out.println(userpass);
		System.out.println(usersex);
		System.out.println(usertel);
		System.out.println(useremail);
		System.out.println(usercsri);
		System.out.println(useredu);*/
		

	}

}
