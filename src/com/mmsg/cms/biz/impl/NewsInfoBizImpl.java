package com.mmsg.cms.biz.impl;

import java.util.List;

import com.mmsg.cms.biz.NewsInfoBiz;
import com.mmsg.cms.dao.NewsInfoDao;
import com.mmsg.cms.dao.impl.NewsInfoDaoImpl;
import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.NewsInfo;

public class NewsInfoBizImpl implements NewsInfoBiz {

	@Override
	public List<NewsInfo> showNewsInfo() {
		NewsInfoDao newsInfoDao = new NewsInfoDaoImpl();
		return newsInfoDao.showNewsInfo();
	}

	@Override
	public int addNewsInfoBiz(NewsInfo news) {
		//创建Dao层对象
		NewsInfoDao newsInfoDao = new NewsInfoDaoImpl();
		return newsInfoDao.addNewsInfoDao(news);
	}

	@Override
	public NewsInfo selectNewsInfoByTitle(String title) {
		//创建Dao层对象
		NewsInfoDao newsInfoDao = new NewsInfoDaoImpl();
		return newsInfoDao.selectNewsInfoByTitle(title);
	}

	@Override
	public List<NewsInfo> selectNewsInfoByType(String type) {
		//创建Dao层对象
		NewsInfoDao newsInfoDao = new NewsInfoDaoImpl();
		return newsInfoDao.selectNewsInfoByType(type);
	}

	@Override
	public List<NewsInfo> selectNewsInfoByLikeTitle(String title) {
		NewsInfoDao newsInfoDao = new NewsInfoDaoImpl();
		return newsInfoDao.selectNewsInfoByLikeTitle(title);
	}

	@Override
	public int selectNewsCount() {
		NewsInfoDao newsInfoDao = new NewsInfoDaoImpl();
		return newsInfoDao.selectNewsCount();
	}

	@Override
	public List<NewsInfo> selectNewsByPage(Page p) {
		NewsInfoDao newsInfoDao = new NewsInfoDaoImpl();
		return newsInfoDao.selectNewsByPage(p);
	}

	@Override
	public int updateNews(NewsInfo news,String title) {
		NewsInfoDao newsInfoDao = new NewsInfoDaoImpl();
		return newsInfoDao.updateNews(news,title);
	}

	@Override
	public int deleteNews(int id) {
		NewsInfoDao newsInfoDao = new NewsInfoDaoImpl();
		return newsInfoDao.deleteNews(id);
	}

}
