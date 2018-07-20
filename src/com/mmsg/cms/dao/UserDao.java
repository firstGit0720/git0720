package com.mmsg.cms.dao;

import java.util.List;

import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.User;
import com.mmsg.cms.vo.UserInfo;

public interface UserDao {
	//管理员数据层链接数据库接口
	//查询管理员的所有信息
	 List<User> selectAll();
	 //查询管理员的用户名和密码
	 User selectByNameAndPass(String user,String pass);
	 //添加管理员
	 int addUser(User user);
	 //创建一个方法   用于获取总条目数
	 int selectUserCount();
	 //用于获取显示的数据内容
	 List <User> selectUserByPage(Page p);
	 //修改管理员内容
	 int updateUser(User user);
	 //删除管理员
	 int deleteUser(int id);

}
