package cn.yzz.service;
import java.util.List;

import cn.yzz.*;
import cn.yzz.dao.DaoFactory;
import cn.yzz.dao.NewsDao;
import cn.yzz.domain.Discuss;
import cn.yzz.domain.News;
import cn.yzz.domain.NewsList;
public class NewsService {
	//使用工厂模式获取newsDao
	public NewsDao newsDao=DaoFactory.getNewsDao();
	//根据类型和页码查询新闻
	public NewsList findNewsByPageNumAndType(int type){
		return newsDao.findNewsByPageAndType( type);
	}
	public void addDiscuss(Discuss message) {
		// TODO Auto-generated method stub
		newsDao.addDiscuss(message);
	}
	
	//根据新闻ID获取评论
	public List<Discuss> getDiscussById(int newsId){
		return newsDao.getDiscussById(newsId);
	}
	
}
