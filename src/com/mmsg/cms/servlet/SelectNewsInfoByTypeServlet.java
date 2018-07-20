package com.mmsg.cms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmsg.cms.biz.NewsInfoBiz;
import com.mmsg.cms.biz.impl.NewsInfoBizImpl;
import com.mmsg.cms.vo.NewsInfo;

/**
 * Servlet implementation class SelectNewsInfoByTypeServlet
 */
@WebServlet("/SelectNewsInfoByTypeServlet")
public class SelectNewsInfoByTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNewsInfoByTypeServlet() {
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
		NewsInfoBiz selectNewsByType = new NewsInfoBizImpl();
		//获取超链接带过来的信息
		String typeName  = request.getParameter("news_type");
		//将结果存到list列表中
		List<NewsInfo> newsList = selectNewsByType.selectNewsInfoByType(typeName);
		//将结果存到request中
		request.setAttribute("newsList", newsList);
		//将结果进行转发
		request.getRequestDispatcher("showselecttitle.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
