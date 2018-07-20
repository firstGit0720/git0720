package com.mmsg.cms.biz;

import java.util.List;

import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.User;
import com.mmsg.cms.vo.UserInfo;

public interface UserBiz {
	
	//业务逻辑层
	//在业务逻辑层查询管理员的所有信息
	List<User> selectAllUser();
	//在业务逻辑层通过用户名和密码进行查询
	boolean loginCheck(String user,String pass);
	//获取中条目数
	int selectCount();
	
	//分页查询显示
	List<User> selectByPage(Page page);
	
	 //添加管理员
	 int addUser(User user);
	 //修改管理员内容
	 int updateUser(User user);
	 //删除管理员
	 int deleteUser(int id);
	
	

}
