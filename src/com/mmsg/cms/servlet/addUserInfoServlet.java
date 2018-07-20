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

/**
 * Servlet implementation class addUserInfoServlet
 */
@WebServlet("/addUserInfoServlet")
public class addUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码
		request.setCharacterEncoding("utf-8");
		//创建业务逻辑层对象
		UserInfoBiz  adduserInfo = new UserInfoBizImpl(); 
		//获取用户输入的数据
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		String telephone = request.getParameter("usertelephone");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String strdate = request.getParameter("data");
		String education = request.getParameter("education");
		
		//添加数据
		int s = adduserInfo.addUserInfoBiz(username, password, telephone, gender, email, strdate, education);
		//定义输出流
		PrintWriter out = response.getWriter();
		if(s > 0){
			out.write("ok");
		}else{
			out.write("on");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
