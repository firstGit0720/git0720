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
 * Servlet implementation class selectNewsLikeTitleServlet
 */
@WebServlet("/selectNewsLikeTitleServlet")
public class selectNewsLikeTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectNewsLikeTitleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码
		request.setCharacterEncoding("utf-8");
		//创建Biz层对象
		NewsInfoBiz newbiz =new NewsInfoBizImpl();
		//获取用户输入的模糊查询的关键字
		String liketitle = request.getParameter("liketitle");
		System.out.println(liketitle);
		List<NewsInfo>  newsList = newbiz.selectNewsInfoByLikeTitle(liketitle);
		//将数据存入request
		request.setAttribute("newsList", newsList);
		//转发
		request.getRequestDispatcher("showselecttitle.jsp").forward(request, response);
		
	}

}
