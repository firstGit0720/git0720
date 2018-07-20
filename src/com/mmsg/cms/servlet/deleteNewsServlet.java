package com.mmsg.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmsg.cms.biz.NewsInfoBiz;
import com.mmsg.cms.biz.impl.NewsInfoBizImpl;

/**
 * Servlet implementation class deleteNewsServlet
 */
@WebServlet("/deleteNewsServlet")
public class deleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteNewsServlet() {
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
		//定义Biz层对象
		NewsInfoBiz newsbiz = new NewsInfoBizImpl();
		//获取id
		int newsid = Integer.parseInt(request.getParameter("newsid"));
		//
		int s = newsbiz.deleteNews(newsid);
		PrintWriter out = response.getWriter();
		if(s>0){
			out.write("ok");
		}else{
			out.write("on");
		}
		
	}

}
