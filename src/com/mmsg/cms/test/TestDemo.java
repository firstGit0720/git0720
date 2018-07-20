package com.mmsg.cms.test;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.mmsg.cms.biz.NewsInfoBiz;
import com.mmsg.cms.biz.UserBiz;
import com.mmsg.cms.biz.UserInfoBiz;
import com.mmsg.cms.biz.impl.NewsInfoBizImpl;
import com.mmsg.cms.biz.impl.UserBizImpl;
import com.mmsg.cms.biz.impl.UserInfoBizImpl;
import com.mmsg.cms.dao.UserInfoDao;
import com.mmsg.cms.dao.impl.UserInfoDaoImpl;
import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.NewsInfo;
import com.mmsg.cms.vo.User;
import com.mmsg.cms.vo.UserInfo;

public class TestDemo {
	
	@Test
	public void ttttt(){
		UserInfoBiz i = new UserInfoBizImpl();
		System.out.println(i.deleteUserInfoBiz(1));
	}
	@Test
	public void tt(){
		UserBiz b = new UserBizImpl();
		int a = b.deleteUser(3);
		System.out.println(a);		
	}
	@Test
	public void ttt(){
		UserBiz b = new UserBizImpl();
		User user = new User();
		user.setId(4);
		user.setName("ssx2");
		user.setPassword("123456");
		int a = b.updateUser(user);
		System.out.println(a);		
	}
	
	@Test
	public  void test(){
		UserBiz biz = new UserBizImpl();
		List<User> list = biz.selectAllUser();
		for (User user : list) {
			System.out.println(user);
		}
	} 
	//测试会员修改
	@Test
	public void updateTest(){
		UserInfoBiz user = new UserInfoBizImpl();
		UserInfo userinfo = new UserInfo(5,"123","123456","12345678909","女","3141654@qq.com",new Date(),"专科");
		int o = user.updataUserinfo(userinfo);
		System.out.println(o);
	}
	//测试新闻查询title
	@Test
	public void findnewsinfobutitle(){
		NewsInfoBiz biz = new NewsInfoBizImpl();
		System.out.println(biz.selectNewsCount());
	}
	@Test
	public void findnewsinfobytype(){
		NewsInfoBiz biz = new NewsInfoBizImpl();
		List<NewsInfo> list = biz.selectNewsInfoByType("体育");
		for (NewsInfo newsInfo : list) {
			System.out.println(newsInfo);
		}
	}
	
	//测试模糊查询
	@Test
	public void testlink(){
		UserInfoBiz user = new UserInfoBizImpl();
		List<UserInfo> list = user.selectLikeNamePage("fg");
		for (UserInfo userInfo : list) {
			System.out.println(userInfo.toString());
		}
	}
	
	//测试新闻添加
	@Test
	public void testAddnews(){
		NewsInfoBiz newsInfoBiz = new NewsInfoBizImpl();
		NewsInfo news = new NewsInfo();
		news.setNews_title("你好");
		news.setNews_type("体育");
		news.setNews_content("大家好，才是真的好");
		news.setNews_count("100");
		int a = newsInfoBiz.addNewsInfoBiz(news);
		System.out.println(a);
		
	}
	@Test
	public void testUser(){
		UserBiz user = new UserBizImpl();
		List<User> listUser = user.selectAllUser();
		for (User user2 : listUser) {
			System.out.println(user2);
		}
	}
	@Test
	public void testUserInfo(){
		UserInfoBiz user = new UserInfoBizImpl();
		List<UserInfo> listUser = user.selectAllUserInfo();
		for (UserInfo user2 : listUser) {
			System.out.println(user2);
		}
	}
	
	@Test
	public void testLoginCheck(){
		UserBiz user = new UserBizImpl();
		System.out.println(user.loginCheck("lg", "123456"));
	}
	
	@Test
	public void testselectByName(){
		UserInfoBiz uiz = new UserInfoBizImpl();
		UserInfo listUser = uiz.selectByName("李刚");
	
			System.out.println(listUser);
		
	}
	@Test
	public void addUserInfo(){
		UserInfoBiz uiz = new UserInfoBizImpl();
		String data ="2016-5-8";
		int i = uiz.addUserInfoBiz("li", "123456", "12345678904", "女", "123456@qq.com", data, "本科");
		System.out.println(i);	
	}
	@Test
	public void getContent(){
		UserInfoDao uid = new UserInfoDaoImpl();
		
		System.out.println(uid.selectCount());
		Page page = new Page(6,uid.selectCount(),3);
		List<UserInfo> userList = uid.selectByPage(page);
		//循环遍历
		for (UserInfo userInfo : userList) {
			System.out.println(userInfo);
		}
		System.out.println(page.getStartIndex());
	}
	

}
