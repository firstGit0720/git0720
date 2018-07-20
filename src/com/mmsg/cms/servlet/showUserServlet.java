package com.mmsg.cms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmsg.cms.biz.UserBiz;
import com.mmsg.cms.biz.UserInfoBiz;
import com.mmsg.cms.biz.impl.UserBizImpl;
import com.mmsg.cms.biz.impl.UserInfoBizImpl;
import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.User;
import com.mmsg.cms.vo.UserInfo;

/**
 * Servlet implementation class showUserServlet
 */
@WebServlet("/showUserServlet")
public class showUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码
		request.setCharacterEncoding("utf-8");
		//创建业务逻辑层的对象,获取会员信息
		UserBiz showuser = new UserBizImpl();


		List<User> showUser = showuser.selectAllUser();
		//讲查询到的信息存到request中
		request.setAttribute("userlist", showUser);
		//将page对象发给jsp界面
	
		//讲数据转发
		request.getRequestDispatcher("/admin/showUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
