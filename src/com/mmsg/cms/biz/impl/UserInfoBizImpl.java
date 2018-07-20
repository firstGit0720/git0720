package com.mmsg.cms.biz.impl;

import java.util.Date;
import java.util.List;

import com.mmsg.cms.biz.UserInfoBiz;
import com.mmsg.cms.dao.UserInfoDao;
import com.mmsg.cms.dao.impl.UserInfoDaoImpl;
import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.UserInfo;

public class UserInfoBizImpl implements UserInfoBiz {

	@Override
	public List<UserInfo> selectAllUserInfo() {
		UserInfoDao dao = new UserInfoDaoImpl();
		return dao.selectAll();
	}

	@Override
	public UserInfo selectByName(String name) {
		UserInfoDao dao = new UserInfoDaoImpl();
		return dao.selectByName(name);
	}

	@Override
	public int addUserInfoBiz(String username, String password, String telephone, String gender, String email,
			String borndate, String education) {
		UserInfoDao dao = new UserInfoDaoImpl();
		return dao.addUserInfo(username, password, telephone, gender, email, borndate, education);
	}

	@Override
	public int selectCount() {
		UserInfoDao dao = new UserInfoDaoImpl();
		return dao.selectCount();
	}

	@Override
	public List<UserInfo> selectByPage(Page p) {
		UserInfoDao dao = new UserInfoDaoImpl();
		return dao.selectByPage(p);
	}

	@Override
	public int selectCount(String likename) {
		UserInfoDao dao = new UserInfoDaoImpl();
		return dao.selectCount(likename);
	}

	@Override
	public List<UserInfo> selectLikeNamePage(Page p, String likename) {
		UserInfoDao dao = new UserInfoDaoImpl();
		return dao.selectLikeNameByPage(p, likename);
	}

	@Override
	public List<UserInfo> selectLikeNamePage(String likename) {
		UserInfoDao dao = new UserInfoDaoImpl();
		return dao.selectLikeName(likename);
	}

	@Override
	public int deleteUserInfoBiz(int user_id) {
		UserInfoDao dao =  new UserInfoDaoImpl();		
		return dao.deleteUserInfoDao(user_id);
	}

	@Override
	public int updataUserinfo(UserInfo user) {
		UserInfoDao dao =  new UserInfoDaoImpl();		
		return dao.updataUserinfo(user);
	}


	

	

}
