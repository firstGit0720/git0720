package com.mmsg.cms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.search.DateTerm;

import com.mmsg.cms.dao.NewsInfoDao;
import com.mmsg.cms.dbutil.DBUtil;
import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.NewsInfo;
import com.mmsg.cms.vo.User;
import com.mmsg.cms.vo.UserInfo;

public class NewsInfoDaoImpl implements NewsInfoDao {

	@Override
	public List<NewsInfo> showNewsInfo() {
		//实例化自定义DBUtil
		DBUtil db = new DBUtil();
		//编写sql查询语句（管理员信息）
		String select = "select * from newsinfo";
		//创建结果及对象
		ResultSet rs;
		//创建List结合用于存储结果
		List<NewsInfo> newsinfo = new ArrayList<NewsInfo>();

		try {
			rs = db.query(select);
			while(rs.next()){
				newsinfo.add(new NewsInfo(rs.getInt("news_id"),
						rs.getString("news_title"),
						rs.getString("news_type"),					
						rs.getString("news_count"), 
						rs.getString("news_content"),
						rs.getDate("news_upDate")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return newsinfo;
	}

	@Override
	public int addNewsInfoDao(NewsInfo news) {
		//实例化自定义DBUtil
		DBUtil db = new DBUtil();
		//编写sql添加语句（新闻添加）
		String sql = "insert into newsinfo values(null,?,?,?,?,?)";
		//获取系统时间
		long currtenttime = System.currentTimeMillis();
		//时间格式化
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//转化为字符串类型
		String strtime = formatter.format(currtenttime);
		//创建结果及对象
		int rs = 0;
		try {
			rs = db.update(sql,news.getNews_title(),news.getNews_type(),news.getNews_count(),news.getNews_content(),strtime);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return rs;
	}
	//精确查询
	@Override
	public NewsInfo selectNewsInfoByTitle(String  title) {
		//实例化自定义DBUtil
		DBUtil db = new DBUtil();
		//编写sql添加语句（新闻查询通过标题）
		String sql = "select * from newsinfo where news_title like ?";
		//创建存储结果的结果集
		ResultSet rs;	
		try {
			rs = db.query(sql,title);
			//讲数据存到List列表中
			while(rs.next()){
				return (new NewsInfo(rs.getInt("news_id"),
						rs.getString("news_title"),
						rs.getString("news_type"),
						rs.getString("news_clickCount"), 
						rs.getString("news_content"),
						rs.getDate("news_updateTime")));
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return null;
	}

	@Override
	public List<NewsInfo> selectNewsInfoByType(String type) {
		//实例化自定义DBUtil
		DBUtil db = new DBUtil();
		//编写sql添加语句（新闻查询通过类别）
		String sql = "select * from newsinfo where news_type like ?";
		//创建存储结果的结果集
		ResultSet rs;
		//创建List列表存储信息
		List<NewsInfo> newsinfoBytype = new ArrayList<NewsInfo>();
		try {
			rs = db.query(sql,type+"%");
			//讲数据存到List列表中
			while(rs.next()){
				newsinfoBytype.add(new NewsInfo(rs.getInt("news_id"),
						rs.getString("news_title"),
						rs.getString("news_type"),
						rs.getString("news_clickCount"), 
						rs.getString("news_content"),
						rs.getDate("news_updateTime")));
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return newsinfoBytype;
	}

	@Override
	public List<NewsInfo> selectNewsInfoByLikeTitle(String title) {
		//实例化自定义DBUtil
		DBUtil db = new DBUtil();
		//编写sql添加语句（新闻查询通过类别）
		String sql = "select * from newsinfo where news_title like ?";
		//创建存储结果的结果集
		ResultSet rs;
		//创建List列表存储信息
		List<NewsInfo> newsinfoByliketitle = new ArrayList<NewsInfo>();
		try {
			rs = db.query(sql,title+"%");
			//讲数据存到List列表中
			while(rs.next()){
				newsinfoByliketitle.add(new NewsInfo(rs.getInt("news_id"),
						rs.getString("news_title"),
						rs.getString("news_type"),
						rs.getString("news_clickCount"), 
						rs.getString("news_content"),
						rs.getDate("news_updateTime")));
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return newsinfoByliketitle;
	}

	@Override
	public int selectNewsCount() {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "select count(*) from newsinfo";
		//创建存储结果的结果集
		ResultSet rs;	
		//运行sql语句
		try {
			rs = db.query(sql);
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			db.close();
		}
		return 0;
	}


	@Override
	public List<NewsInfo> selectNewsByPage(Page p) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "select * from newsinfo limit ?,?";
		//创建存储结果的结果集
		ResultSet rs;
		//创建List列表存储信息
		List<NewsInfo> userinfolist = new ArrayList<NewsInfo>();
		try {
			//将查询结果放入结果集
			rs = db.query(sql,p.getStartIndex(),p.getShowNumber());
			//将数据存放到list列表中
			while (rs.next()) {
				userinfolist.add(new NewsInfo(rs.getInt("news_id"),
						rs.getString("news_title"),
						rs.getString("news_type"),
						rs.getString("news_clickCount"),
						rs.getString("news_content"),
						rs.getDate("news_updateTime")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			db.close();
		}
		return userinfolist;
	}

	@Override
	public int updateNews(NewsInfo news,String title) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql ="update newsinfo set news_title =?,news_type =?,"
				+ "news_clickCount =?,news_content=?,news_updateTime =? where news_title = ?";
		//创建存储结果的结果集
		int s =0;
		try {
			s = db.update(sql, news.getNews_title(),news.getNews_type(),news.getNews_count(),
					news.getNews_content(),new Date(),title);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return s;
	}

	@Override
	public int deleteNews(int id) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "delete from newsinfo where news_id=?";
		//创建返回的结果集，影响的行数
		int rs = 0;
		try {
			rs = db.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return rs;
	}

}
