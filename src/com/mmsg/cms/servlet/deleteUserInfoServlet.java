package com.mmsg.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmsg.cms.biz.UserInfoBiz;
import com.mmsg.cms.biz.impl.UserInfoBizImpl;

/**
 * Servlet implementation class deleteUserInfoServlet
 */
@WebServlet("/deleteUserInfoServlet")
public class deleteUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码
		request.setCharacterEncoding("utf-8");
		//定义biz成对象
		UserInfoBiz biz = new UserInfoBizImpl();
		//获取前台传递过来的用户ID
		int user_id = Integer.parseInt(request.getParameter("id"));

		//调用语句删除
		int s = biz.deleteUserInfoBiz(user_id);
		//定义输出流对象
		PrintWriter out = response.getWriter();
		if(s >0){
			response.sendRedirect("ShowUserInfoServlet");
			/*request.getRequestDispatcher("ShowUserInfoServlet").forward(request, response);*/
		}else{
			out.write("删除失败");
			response.sendRedirect("ShowUserInfoServlet");
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
