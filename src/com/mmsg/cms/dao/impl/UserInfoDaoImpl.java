package com.mmsg.cms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mmsg.cms.dao.UserInfoDao;
import com.mmsg.cms.dbutil.DBUtil;
import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.UserInfo;

public class UserInfoDaoImpl implements UserInfoDao {

	//查询所有会员信息
	@Override
	public List<UserInfo> selectAll() {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String selecthy = "select * from userinfo";
		//创建存储结果的结果集
		ResultSet rs;
		//创建List列表存储信息
		List<UserInfo> userinfo = new ArrayList<UserInfo>();
		try {
			//将查询结果放入结果集
			rs = db.query(selecthy);
			//将数据存放到list列表中
			while (rs.next()) {
				userinfo.add(new UserInfo(rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("telephone"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getDate("borndate"), 
						rs.getString("education")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			db.close();
		}

		return userinfo;
	}
	//通过名字精确查询
	@Override
	public UserInfo selectByName(String selectname) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "select * from userinfo where username=?";
		//创建存储结果的结果集
		ResultSet rs;	

		try {
			rs= db.query(sql, selectname);

			while (rs.next()) {
				return (new UserInfo(rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("telephone"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getDate("borndate"), 
						rs.getString("education")));

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
	public int addUserInfo(String username,String password,
			String telephone,String gender,String email,String borndate,String education) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "insert into userinfo values(?,?,?,?,?,?,?,?)";
		//创建返回的结果集，影响的行数
		int rs = 0;
		try {
			rs = db.update(sql,null,username,password,telephone,gender, email, borndate, education);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}

		return rs;
	}

	//返回总条目数
	@Override
	public int selectCount() {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "select count(*) from userinfo";
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
	public List<UserInfo> selectByPage(Page p) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "select * from userinfo limit ?,?";
		//创建存储结果的结果集
		ResultSet rs;
		//创建List列表存储信息
		List<UserInfo> userinfolist = new ArrayList<UserInfo>();
		try {
			//将查询结果放入结果集
			rs = db.query(sql,p.getStartIndex(),p.getShowNumber());
			//将数据存放到list列表中
			while (rs.next()) {
				userinfolist.add(new UserInfo(rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("telephone"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getDate("borndate"), 
						rs.getString("education")));

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
	public List<UserInfo> selectLikeName(String likename) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "select * from userinfo where username like ?";
		//创建列表存储模糊查询的结果
		List<UserInfo> likeNameList = new ArrayList<UserInfo>();
		//创建存储结果的结果集
		ResultSet rs;	

		try {
			rs = db.query(sql,likename+"%");

			while (rs.next()) {
				likeNameList.add(new UserInfo(rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("telephone"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getDate("borndate"), 
						rs.getString("education")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return likeNameList;
	}
	@Override
	public int selectCount(String likeName) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "select count(*) from userinfo where username like ?";
		//创建存储结果的结果集
		ResultSet rs;	
		//运行sql语句
		try {
			rs = db.query(sql,likeName+"%");
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
	public List selectLikeNameByPage(Page p, String likeName) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "select * from userinfo where username like ? limit ?,?";
		//创建存储结果的结果集
		ResultSet rs;
		//创建List列表存储信息
		List<UserInfo> userinfolist = new ArrayList<UserInfo>();
		try {
			//将查询结果放入结果集
			rs = db.query(sql,likeName+"%",p.getStartIndex(),p.getShowNumber());
			//将数据存放到list列表中
			while (rs.next()) {
				userinfolist.add(new UserInfo(rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("telephone"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getDate("borndate"), 
						rs.getString("education")));

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
	public int deleteUserInfoDao(int user_id) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "delete from userinfo where user_id=?";
		int s=0;
		try {
			s = db.update(sql, user_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return s;
	}
	@Override
	public int updataUserinfo(UserInfo user) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "update userinfo "
				+ "set username =?,password =?,"
				+ "telephone =?,gender=?,email =?,"
				+ "borndate =?,education =?"
				+ "where user_id=?";
		int s=0;
		try {
			s = db.update(sql,user.getUsername(),user.getPassword(),user.getTelephone(),
					user.getGender(),user.getEmail(),user.getBorndate(),user.getEducation(),
					user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return s;
	}

}
