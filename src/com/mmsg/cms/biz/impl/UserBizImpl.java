package com.mmsg.cms.biz.impl;
/**
 * 管理员业务逻辑层信息查询实现类
 */
import java.util.List;

import com.mmsg.cms.biz.UserBiz;
import com.mmsg.cms.dao.UserDao;
import com.mmsg.cms.dao.UserInfoDao;
import com.mmsg.cms.dao.impl.UserDaoImpl;
import com.mmsg.cms.dao.impl.UserInfoDaoImpl;
import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.User;
import com.mmsg.cms.vo.UserInfo;

public class UserBizImpl implements UserBiz {

	@Override
	public List<User> selectAllUser() {
		//直接调用Dao层的方法
		UserDao user = new UserDaoImpl();
		
		return user.selectAll();
	}

	@Override
	public boolean loginCheck(String user, String pass) {
		//直接调用Dao层的方法
		UserDao userdao = new UserDaoImpl();
		if(userdao.selectByNameAndPass(user, pass) != null){
			return true;
		}
		return false;
	}

	@Override
	public int selectCount() {
		UserDao userDao = new UserDaoImpl();
		return userDao.selectUserCount();
	}

	@Override
	public List<User> selectByPage(Page page) {
		UserDao userDao = new UserDaoImpl();
		return userDao.selectUserByPage(page);
	}

	@Override
	public int updateUser(User user) {
		UserDao userdao = new UserDaoImpl();
		return userdao.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		UserDao userdao = new UserDaoImpl();
		return userdao.deleteUser(id);
	}

	@Override
	public int addUser(User user) {
		UserDao userdao = new UserDaoImpl();
		return userdao.addUser(user);
	}

}
