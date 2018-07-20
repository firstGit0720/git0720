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
 * Servlet implementation class deleteUserServlet
 */
@WebServlet("/deleteUserServlet")
public class deleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUserServlet() {
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
		//创建对象
		UserBiz userBiz = new UserBizImpl();
		//获取要删除的id
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		int s = userBiz.deleteUser(id);
		if(s >0){
			response.sendRedirect("showUserServlet");
	/*		request.getRequestDispatcher("showUserServlet").forward(request, response);*/
		}
		//定义输出流
		/*PrintWriter out =response.getWriter();
		if(s > 0){
			out.write("ok");
		}else{
			out.write("no");
		}		*/
	}

}
