package cn.yzz.dao;

import java.util.List;

import cn.yzz.domain.Discuss;
import cn.yzz.domain.News;
import cn.yzz.domain.NewsList;

public interface NewsDao {
	public NewsList findNewsByPageAndType(int type);
	public void sendDiscuss(String newsUrl,String username,String content);
	public List<Discuss> findDiscussByUsername(String username);
	public List<News> findNewsByUsername(String username);
	public void addDiscuss(Discuss message);
	public List<Discuss> getDiscussById(int newsId);
	
	
}
