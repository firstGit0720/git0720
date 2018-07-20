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
 * Servlet implementation class addUserServlet
 */
@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUserServlet() {
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
		//定义对象
		UserBiz userbiz = new UserBizImpl();
		//获取用户注册信息
		String user = request.getParameter("user");
		String pass = request.getParameter("pass"); 
		System.out.println(user);
		System.out.println(pass);
		//定义管理员
		User add = new  User();
		add.setName(user);
		add.setPassword(pass);
		int s = userbiz.addUser(add);
		//定义输出流
		PrintWriter out = response.getWriter();
		if(s > 0){
			out.write("ok");
		}else{
			out.write("no");
		}
	}

}
