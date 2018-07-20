package com.mmsg.cms.biz;

import java.util.List;

import com.mmsg.cms.dbutil.Page;
import com.mmsg.cms.vo.NewsInfo;

public interface NewsInfoBiz {

	//新闻查询显示
	List<NewsInfo> showNewsInfo();
	//新闻添加
	int addNewsInfoBiz(NewsInfo news);
	//新闻查询
	NewsInfo selectNewsInfoByTitle(String  title);
	List<NewsInfo> selectNewsInfoByType(String  type);
	//新闻得模糊查询
	List<NewsInfo> selectNewsInfoByLikeTitle(String  title);
	//获取总条数
	int selectNewsCount();
	//用于获取显示的数据内容
	List <NewsInfo> selectNewsByPage(Page p);
	//新闻的修改
	int updateNews(NewsInfo news,String title);
	//新闻删除
	int deleteNews(int id);
}
