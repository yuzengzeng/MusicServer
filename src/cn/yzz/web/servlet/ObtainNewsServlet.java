package cn.yzz.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.yzz.domain.News;
import cn.yzz.domain.NewsList;
import cn.yzz.service.NewsService;

public class ObtainNewsServlet extends HttpServlet {

	private NewsList newsList;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取用户设备信息
		String user_agent=request.getHeader("User-Agent");
		System.out.println(user_agent);
		response.setCharacterEncoding("utf-8");
		//获取newsService服务对象
		NewsService newsService=new NewsService();
		
		//从request中获取请求参数
		int type=Integer.parseInt(request.getParameter("type"));
		
		
		//根据类型获取新闻列表
		newsList=newsService.findNewsByPageNumAndType(type);
		
		List newses=newsList.getList();
		
		//封装json
		JSONArray fromObject = JSONArray.fromObject(newses);
		
		//返回
		response.getWriter().write(fromObject.toString());
		
		}
	}
