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
 * Servlet implementation class ShowUserInfoServlet
 */
@WebServlet("/ShowUserInfoServlet")
public class ShowUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUserInfoServlet() {
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

		//创建业务逻辑层的对象,获取会员信息
		UserInfoBiz showuser = new UserInfoBizImpl();
		
		//设置page的总条目数
		page.setTotalNumber(showuser.selectCount());
		//设置现实的条目数
		page.setShowNumber(5);
		//list列表接受信息
		List<UserInfo> showUserInfo = showuser.selectByPage(page);
		//讲查询到的信息存到request中
		request.setAttribute("userlist", showUserInfo);
		//将page对象发给jsp界面
		request.setAttribute("page", page);
		//讲数据转发
		request.getRequestDispatcher("/admin/showUserInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
