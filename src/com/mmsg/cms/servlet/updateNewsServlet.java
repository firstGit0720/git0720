package com.mmsg.cms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmsg.cms.biz.NewsInfoBiz;
import com.mmsg.cms.biz.impl.NewsInfoBizImpl;
import com.mmsg.cms.vo.NewsInfo;

/**
 * Servlet implementation class updateNewsServlet
 */
@WebServlet("/updateNewsServlet")
public class updateNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateNewsServlet() {
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
		
		String title =  request.getParameter("oldtitle");
/*		System.out.println(title);*/

		//获取用户输入的数据
		String news_title = request.getParameter("newstitle");
		String news_type = request.getParameter("newstype");
		String news_content = request.getParameter("editor1");
		String news_count = request.getParameter("newscount");
		
		NewsInfo news = new NewsInfo();
		news.setNews_title(news_title);
		news.setNews_content(news_content);
		news.setNews_type(news_type);
		news.setNews_count(news_count);
		
/*		System.out.println(news_title);
		System.out.println(news_type);
		System.out.println(news_count);
		System.out.println(news_content);*/
		
		newsbiz.updateNews(news,title);
		
		request.getRequestDispatcher("showNewsinfoServlet").forward(request, response);
	}

}
