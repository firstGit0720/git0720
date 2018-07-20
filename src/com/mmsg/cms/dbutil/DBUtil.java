package com.mmsg.cms.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	//属性
		public static final String USERNAME="root";
		public static final String PASSWORD="root";
		public static final String ADDRESS="jdbc:mysql://127.0.0.1:3306/";
		public static final String DBNAME="cms";
		public static final String CHARSET="?characterEncoding=utf-8";
		public static final String CLASSNAME="com.mysql.jdbc.Driver";
		private Connection conn=null;
		private Statement stmt=null;
		private PreparedStatement pstm=null;
		//方法
		//构造方法
		public DBUtil(){
			//引入驱动，创建实例
			try {
				Class.forName(CLASSNAME).newInstance();
				//创建连接对象
				this.conn=DriverManager.getConnection(ADDRESS+DBNAME+CHARSET, USERNAME, PASSWORD);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//增  删  改
		public int update(String sql) throws SQLException{
			//实例化对象
			this.stmt=this.conn.createStatement();
			return this.stmt.executeUpdate(sql);
		}
		//预编译
		public int update(String sql,Object...arr) throws SQLException{
			//创建预编译对象
			this.pstm=this.conn.prepareStatement(sql);
			//进行赋值
			for (int i = 0; i < arr.length; i++) {
				this.pstm.setObject(i+1, arr[i]);
			}
			return this.pstm.executeUpdate();
		}
		//查
		public ResultSet query(String sql) throws SQLException{
			//实例化对象
			this.stmt=this.conn.createStatement();
			//调用方法 返回结果集
			return this.stmt.executeQuery(sql);
		}
		
		//条件查询(自己编写的)
		public ResultSet selectPoint(String username) throws SQLException{
			this.stmt=this.conn.createStatement();
			String selectpointuser = "select * from userinfo where username = '?%'";
			PreparedStatement sta = this.conn.prepareStatement(selectpointuser);
			sta.setString(1, username);
			return this.stmt.executeQuery(selectpointuser);
			
		}
 		
		//预编译   sql   =  ? ? ? ?
		public ResultSet query(String sql,Object...arr) throws SQLException{
			//创建预编译对象
			this.pstm=this.conn.prepareStatement(sql);
			//进行赋值
			for (int i = 0; i < arr.length; i++) {
				this.pstm.setObject(i+1, arr[i]);
			}
			//进行查询返回结果集
			return this.pstm.executeQuery();
		}
		//关闭资源
		public void close(){
				try {
					if(this.pstm!=null && !this.pstm.isClosed())this.pstm.close();
					if(this.stmt!=null && !this.stmt.isClosed())this.stmt.close();
					if(this.conn!=null && !this.conn.isClosed())this.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
		
}
