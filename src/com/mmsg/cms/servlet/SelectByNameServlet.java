package com.mmsg.cms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmsg.cms.biz.UserInfoBiz;
import com.mmsg.cms.biz.impl.UserInfoBizImpl;
import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.UserInfo;

/**
 * Servlet implementation class SelectByNameServlet
 */
@WebServlet("/SelectByNameServlet")
public class SelectByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectByNameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//设置字符编码
		request.setCharacterEncoding("utf-8");
		//接受用户传递过来的值，用于显示第几页信息
		String cp = request.getParameter("cp");
		//创建page对象
		Page page = new Page();
		if(cp == null){
			page.setCurrentNumber(1);
		}else{
			page.setCurrentNumber(Integer.parseInt(cp));
		}
		
		//创建业务逻辑层对象
		UserInfoBiz selectByName = new UserInfoBizImpl();
		//获取用户输入的信息
		String name = request.getParameter("selectname");
		request.setAttribute("selectname", name);
		//设置page的总条目数
		page.setTotalNumber(selectByName.selectCount(name));
		//设置现实的条目数
		page.setShowNumber(5);
		//List列表用于存储结果信息
		List<UserInfo> selectByNameList = selectByName.selectLikeNamePage(page, name);
		//System.out.println(selectByNameList);

		//将结果存入到request中
		request.setAttribute("selectNameList", selectByNameList);
		//将page对象发给jsp界面
		request.setAttribute("page", page);
		//将结果进行转发
		request.getRequestDispatcher("/admin/selectUserInfo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
