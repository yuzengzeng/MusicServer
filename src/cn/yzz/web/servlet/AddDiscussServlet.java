package cn.yzz.web.servlet;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yzz.domain.Discuss;
import cn.yzz.service.NewsService;

/**
 * 接受用户提交的评论并存储
 * @author YZZ
 *
 */

public class AddDiscussServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		//获取用户提交的留言数据
		int newsId=Integer.parseInt(req.getParameter("newsId"));
		String username=req.getParameter("username");
		String content=req.getParameter("content");
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		String currentTime=dateFormat.format(date);
		
		//将留言数据封装至JavaBean中
		Discuss message=new Discuss();
		message.setDiscussContent(content);
		message.setDate(currentTime);
		message.setNewsId(newsId);
		message.setUsername(username);
		
		//将留言存入数据库
		
		//获取newsService
		NewsService newsService=new NewsService();
		//存
		newsService.addDiscuss(message);
		
		System.out.println(message);
		
		resp.getWriter().write("评论添加成功");
		
	}
}
