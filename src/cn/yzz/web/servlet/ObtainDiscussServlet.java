package cn.yzz.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import cn.yzz.domain.Discuss;
import cn.yzz.service.NewsService;

public class ObtainDiscussServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		//拿到需要获取评论的新闻ID
		int newsId=Integer.parseInt(req.getParameter("newsId"));
		//获取新闻服务并通过新闻服务获取评论
		NewsService newsService=new NewsService();
		List<Discuss> dicuss_list = newsService.getDiscussById(newsId);
		
		//封装
		JSONArray jsonArray=JSONArray.fromObject(dicuss_list);
		
		//返回
		resp.getWriter().write(jsonArray.toString());
		}
}
