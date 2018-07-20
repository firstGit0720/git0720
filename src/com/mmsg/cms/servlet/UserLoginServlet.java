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

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置字符编码
		request.setCharacterEncoding("utf-8");
		UserBiz userlogin = new UserBizImpl();
		//获取ajax传递过来的数据
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		//通过和数据库中的信息比较，判断用户是否存在
		boolean login = userlogin.loginCheck(name, pass);
		//创建输出流对象
		PrintWriter out = response.getWriter();
		if(login){
			out.write("ok");
		}else{
			out.write("no");
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
