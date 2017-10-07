package cn.yzz.web.servlet;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.utils.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VerifyCode verifyCode=new VerifyCode();
		BufferedImage image = verifyCode.getImage();
		String text = verifyCode.getText();
		HttpSession session = request.getSession();
		session.setAttribute("verifyCode", text);
		VerifyCode.output(image, response.getOutputStream());
	}

}
