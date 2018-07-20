package com.mmsg.cms.vo;
/**
 * 管理员的JavaBean模型
 * @author C2-305
 *
 */
public class User {
	private int id;
	private String user;
	private String password;
	
	public User() {
		super();
	}
	
	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.user = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return user;
	}
	public void setName(String name) {
		this.user = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"---"+this.user+"---"+this.password;
	}


}
