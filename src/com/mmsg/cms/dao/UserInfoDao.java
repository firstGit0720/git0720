package com.mmsg.cms.dao;

import java.util.Date;
import java.util.List;

import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.UserInfo;

public interface UserInfoDao {

	//会员数据层连接数据库接口
	 List<UserInfo> selectAll();
	 //通过名字查询
	 UserInfo selectByName(String selectname);
	 //添加数据
	 int addUserInfo(String username,String password,
			 String telephone,String gender,String email,String borndate,String education);
	 //创建一个方法   用于获取总条目数
	 int selectCount();
	 //用于获取显示的数据内容
	 List <UserInfo> selectByPage(Page p);
	//创建一个方法   用于显示模糊查询的总条目数
	int selectCount(String likeName);
	 //通过名字进行牧户查询病进行分页
	List<UserInfo> selectLikeNameByPage(Page p ,String likeName);
	//模糊查询
	List<UserInfo> selectLikeName(String likename);
	//会员删除
	int deleteUserInfoDao(int user_id);
	//会员内容修改
	int updataUserinfo(UserInfo user);
	
	
	
}
