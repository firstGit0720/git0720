package com.mmsg.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmsg.cms.biz.UserBiz;
import com.mmsg.cms.biz.impl.UserBizImpl;
import com.mmsg.cms.vo.User;

/**
 * Servlet implementation class updateUserServlet
 */
@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateUserServlet() {
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
		// TODO Auto-generated method stub
		//设置字符编码
		request.setCharacterEncoding("utf-8");
		//定义Biz层对象
		UserBiz userBiz = new UserBizImpl();
		//获取输入的修改信息
		int i = Integer.parseInt(request.getParameter("id"));
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		User updateuser = new User();
		updateuser.setId(i);
		updateuser.setName(user);
		updateuser.setPassword(pass);
		System.out.println(i);

		int s= userBiz.updateUser(updateuser);
		//定义输出流
		PrintWriter out =response.getWriter();
		if(s > 0){
			out.write("ok");
		}else{
			out.write("no");
		}		

	}

}
