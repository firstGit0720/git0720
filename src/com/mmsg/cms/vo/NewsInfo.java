package com.mmsg.cms.vo;

import java.util.Date;

public class NewsInfo {
	
	private int news_id;
	private String news_title;
	private String news_type;
	private String news_content;
	private String news_count;
	private Date news_upDate;
	
	public NewsInfo() {
		super();
	}

	public NewsInfo(int news_id, String news_title, String news_type, String news_count,String news_content ,
			Date news_upDate) {
		super();
		this.news_id = news_id;
		this.news_title = news_title;
		this.news_type = news_type;
		this.news_content = news_content;
		this.news_count = news_count;
		this.news_upDate = news_upDate;
	}

	public int getNews_id() {
		return news_id;
	}

	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}

	public String getNews_title() {
		return news_title;
	}

	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}

	public String getNews_type() {
		return news_type;
	}

	public void setNews_type(String news_type) {
		this.news_type = news_type;
	}

	public String getNews_content() {
		return news_content;
	}

	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}

	public String getNews_count() {
		return news_count;
	}

	public void setNews_count(String news_count) {
		this.news_count = news_count;
	}

	public Date getNews_upDate() {
		return news_upDate;
	}

	public void setNews_upDate(Date news_upDate) {
		this.news_upDate = news_upDate;
	}
	
	@Override
	public String toString() {
		
		return this.news_title+this.news_content;
	}

}
