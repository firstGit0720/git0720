package com.mmsg.cms.biz;

import java.util.Date;
import java.util.List;

import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.UserInfo;

public interface UserInfoBiz {

	//会员业务逻辑层信息查询接口
	List<UserInfo> selectAllUserInfo();
	//业务逻辑层通过姓名查询信息
	UserInfo selectByName(String name);
	//添加会员信息
	int addUserInfoBiz(String username,String password,
			String telephone,String gender,String email,String borndate,String education);
	//获取所有条目
	int selectCount();
	//所有条目分页显示
	List<UserInfo> selectByPage(Page p );
	
	//获取模糊所有条目
	int selectCount(String likename);
	//模糊查询病分页
	List<UserInfo> selectLikeNamePage(Page p ,String likename);
	//模糊查询
	List<UserInfo> selectLikeNamePage(String likename);
	
	//会员删除
	int deleteUserInfoBiz(int user_id);
	
	//会员内容修改
	int updataUserinfo(UserInfo user);

}
