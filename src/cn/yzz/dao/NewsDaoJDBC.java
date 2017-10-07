package cn.yzz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.yzz.domain.Discuss;
import cn.yzz.domain.News;
import cn.yzz.domain.NewsList;
import cn.yzz.utils.JDBCUtils;

public class NewsDaoJDBC implements NewsDao {
	static Connection conn=null;
	static {
		//一，获得连接对象
		        conn=JDBCUtils.getConnection();
				System.out.println(conn);
	}
	@Override
	public NewsList findNewsByPageAndType( int type) {
		
		NewsList newsList=new NewsList();
		List<News> newses=new ArrayList<News>();
		// TODO Auto-generated method stub
		//创建SQL模板
		String sql="select * from news where type=?"+" order by id";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement
					(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ps.setInt(1, type);
			ResultSet rs = ps.executeQuery();
			rs.last();
			//获得总的数据条目数
			int totalNum=rs.getRow();
			//System.out.println(totalNum);
			newsList.setTotlaPageNum(totalNum);
			rs.beforeFirst();
			//rs.afterLast();
			int count=0;
			while(rs.next()){
				count++;
				News news=new News();
				news.setTitle(rs.getString("title"));
				news.setDescription(rs.getString("description"));
				news.setImageRrc(rs.getString("imageSrc"));
				news.setId(rs.getInt("id"));
				news.setUrl(rs.getString("url"));
				news.setDate(rs.getString("date"));
				news.setType(rs.getInt("type"));
				news.setDate(rs.getString("date"));
				newses.add(news);
			}
			newsList.setList(newses);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newsList;
	}

	@Override
	public void sendDiscuss(String newsUrl, String username, String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Discuss> findDiscussByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> findNewsByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//添加评论
		public void addDiscuss(Discuss message) {
			// TODO Auto-generated method stub
			//组拼SQL语句
			String sql="insert into discuss values(?,?,?,?,?)";
			try {
				//获取SQL语句执行对象
				PreparedStatement psmt = conn.prepareStatement(sql);
				
				//将JavaBean中的数据设置给SQL执行对象
				
				psmt.setString(1, null);
				
				psmt.setString(2, message.getUsername());
				
				psmt.setString(3, message.getDiscussContent());
				
				psmt.setString(4, message.getDate());
				
				psmt.setInt(5, message.getNewsId());
				psmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		//通过新闻ID获取评论
		@Override
		public List<Discuss> getDiscussById(int newsId) {
			// TODO Auto-generated method stub
			//组拼SQL语句
			String sql="select form discuss where newsId=?";
			List<Discuss> list=new ArrayList<Discuss>();
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, newsId);
				ResultSet rs = psmt.executeQuery();
				while(rs.next()){
					Discuss discuss=new Discuss();
					discuss.setDate(rs.getString("discuss_date"));
					discuss.setDiscussContent(rs.getString("content"));
					discuss.setUsername(rs.getString("username"));
					list.add(discuss);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}

		

}
