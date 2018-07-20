package com.mmsg.cms.vo;

import java.util.Date;

public class UserInfo {
	/*user_id	int primary key auto_increment,
	username  varchar(30) not null,
	password  varchar(32) not null,
	telephone  varchar(11) not null,
	gender	char(2),
	email	varchar(30),
	borndate	date,
	education varchar(10)
	*/
	private int user_id;
	private String username;
	private String password;
	private String telephone;
	private String gender;
	private String email;
	private Date borndate;
	private String education;
	//构造方法
	public UserInfo() {
		super();
	}
	public UserInfo(int id, String username, String password, String telephone, String gender, String email,
			Date borndate, String education) {
		super();
		this.user_id = id;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.gender = gender;
		this.email = email;
		this.borndate = borndate;
		this.education = education;
	}
	//get|set方法
	public int getId() {
		return user_id;
	}
	public void setId(int id) {
		this.user_id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBorndate() {
		return borndate;
	}
	public void setBorndate(Date borndate) {
		this.borndate = borndate;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	//重写toString（）
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.user_id+","+this.username;
	}

}
