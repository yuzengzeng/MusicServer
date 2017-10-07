package cn.yzz.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yzz.service.UserService;

public class BookNewsServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取用户名和订阅条目
		String username=request.getParameter("username");
		String bookedItems=request.getParameter("items");
		
		UserService userService=new UserService();
		userService.changeBookedItems(username, bookedItems);
		
		response.getWriter().write("订阅成功");
		
	}

}
