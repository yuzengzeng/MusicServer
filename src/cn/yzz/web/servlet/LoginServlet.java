package cn.yzz.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yzz.domain.User;
import cn.yzz.service.UserException;
import cn.yzz.service.UserService;

public class LoginServlet extends HttpServlet {

	private String user_agent;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user_agent = request.getHeader("User-Agent");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserService userService=new UserService();
		User form=new User();
		form.setUsername(request.getParameter("username"));
		form.setPassword(request.getParameter("password"));
		try {
			System.out.println(form);
			userService.login(form);
			
			response.getWriter().write("登录成功");
			if(user_agent.contains("Windows")){
			request.getSession().setAttribute("sessionuser", form.getUsername());
			response.sendRedirect(request.getContextPath()+"/user/welcome.jsp");
			}
		} catch (UserException e) {
			response.getWriter().write(e.getMessage());
			// TODO Auto-generated catch block
			if(user_agent.contains("Windows")){
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			request.getRequestDispatcher("user/login.jsp").forward(request, response);
			}
		}
	
	}
	 
}
