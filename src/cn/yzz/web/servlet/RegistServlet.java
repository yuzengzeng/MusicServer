package cn.yzz.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.sun.org.apache.commons.beanutils.ConvertUtils;

import cn.yzz.domain.User;
import cn.yzz.service.UserException;
import cn.yzz.service.UserService;
public class RegistServlet extends HttpServlet {

	private String user_agent;
	private String verifyCode;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserService userService=new UserService();
		user_agent = request.getHeader("User-Agent");
		
		//获取表单数据并保存到bean中
		User form=new User();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(user_agent.contains("Windows")){
		verifyCode = request.getParameter("verifyCode");
		}
		HttpSession session = request.getSession();
		String text=(String) session.getAttribute("verifyCode");
		
		form.setUsername(username);
		form.setPassword(password);
		//对表单数据进行校验
		System.out.println(username);
		if(user_agent.contains("Windows")){
		Map errors=new HashMap();
		if(username==null||username.trim().isEmpty()){
			errors.put("username","用户名不能为空");
		}else if(username.length()<3||username.length()>15){
			errors.put("username", "用户名长度必须在3~15之间!");
		}
		
		if(password==null||password.trim().isEmpty()){
			errors.put("password", "密码不能为空");
		}else if(password.length()<3||password.length()>15){
			errors.put("password", "密码长度必须在3~15之间");
		}
		
		
		if(!text.equals(verifyCode)){
			errors.put("verifyCode", "验证码错误");
		}
		
		//判断map errors是否为空，如果不为空，则说明表单数据不正确，需要转发回注册页面，并将错误信息保存在request域中
		if(errors!=null&&errors.size()>0){
			request.setAttribute("errors", errors);
			request.setAttribute("username", username);
			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
			return;
		}
		
		}
		
		try{
			
		userService.regist(form);
		session.setAttribute("username_login", username);
		session.setAttribute("password_login", password);
		
		
		if(user_agent.contains("Windows")){
		response.getWriter().print("<h1>恭喜你"+form.getUsername()+"注册成功</h1><a href='/day14/user/login.jsp'>点击这里去登录</a>");
		}else{
			response.getWriter().print("恭喜您"+form.getUsername()+"注册成功");
		}
		/*HttpSession session = request.getSession();
		session.setAttribute("username", form.getUsername());
		request.getRequestDispatcher("/user/index.jsp");
		*/
		
		}catch(UserException e){
			//获取异常信息，保存到request域并转发
			
			if(user_agent.contains("Windows")){
			request.setAttribute("username", form.getUsername());
			request.setAttribute("password", form.getPassword());
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
			}else{
			response.getWriter().print(e.getMessage());
			}
		}
	}
}
