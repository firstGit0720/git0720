package com.mmsg.cms.dao.impl;
/**
 * Dao层实现
 * 管理员的数据库数据查询
 * @author C2-305
 *
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mmsg.cms.dao.UserDao;
import com.mmsg.cms.dbutil.DBUtil;
import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.User;
import com.mmsg.cms.vo.UserInfo;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> selectAll() {
		//实例化自定义DBUtil
		DBUtil db = new DBUtil();
		//编写sql查询语句（管理员信息）
		String select = "select * from user";
		//创建结果及对象
		ResultSet rs;
		//创建List结合用于存储结果
		List<User> user = new ArrayList<User>();
		try {
			//返回结果集对象
			rs = db.query(select);
			//利用While循环把数据存到List集合中
			while(rs.next()){
				user.add(new User(rs.getInt("id"),rs.getString("user"),rs.getString("password")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			db.close();
		}
		//返回结果
		return user;

	}

	@Override
	public User selectByNameAndPass(String user, String pass) {
		//实例化自定义DBUtil
		DBUtil db = new DBUtil();
		//编写sql查询语句（管理员信息）
		String select = "select * from user where user=? and password=?";
		//创建结果及对象
		ResultSet rs;
		//创建List结合用于存储结果
		List<User> userlist = new ArrayList<User>();
		try {
			//查询用户和密码是否存在数据库中
			rs = db.query(select, user,pass);
			if(rs.next()){
				return (new User(rs.getInt("id"), rs.getString("user"), rs.getString("password")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addUser(User user) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "insert into user values(null,?,?)";
		//创建返回的结果集，影响的行数
		int rs = 0;
		try {
			rs = db.update(sql, user.getName(),user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return rs;
	}

	@Override
	public int selectUserCount() {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "select count(*) from user";
		//创建存储结果的结果集
		ResultSet rs;	
		//运行sql语句
		try {
			rs = db.query(sql);
			if(rs.next()){
				return rs.getInt(1);
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		finally{
			db.close();
		}
		return 0;
	}

	@Override
	public List<User> selectUserByPage(Page p) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "select * from user limit ?,?";
		//创建存储结果的结果集
		ResultSet rs;
		//创建List列表存储信息
		List<User> userlist = new ArrayList<User>();
		try {
			//将查询结果放入结果集
			rs = db.query(sql,p.getStartIndex(),p.getShowNumber());
			//将数据存放到list列表中
			while (rs.next()) {
				userlist.add(new User(rs.getInt("id"),
						rs.getString("user"),
						rs.getString("password")
						));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			db.close();
		}
		return userlist;
	}

	@Override
	public int updateUser(User user) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "update user "
				+ "set user =?,password =?"
				+ "where id=?";
		//创建返回的结果集，影响的行数
		int rs = 0;
		try {
			rs = db.update(sql,user.getName(),user.getPassword(),user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close();
		}
		return rs;
	}

	@Override
	public int deleteUser(int id) {
		//调用自定义工具类，查询所有会员信息
		DBUtil db = new DBUtil();
		//创建查询会员信息的sql语句
		String sql = "delete from user where id=?";
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
