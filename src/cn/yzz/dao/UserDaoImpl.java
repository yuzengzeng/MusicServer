package cn.yzz.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;

import cn.yzz.domain.User;

/**
 * 数据类
 * 
 * @author YZZ
 * 
 */
public class UserDaoImpl implements UserDao{
	private String path = "F:/users.xml";

	/**
	 * 根据用户名查询
	 * 
	 * @param username
	 * @return 1.得到document 2.xpath查询 3检查结果是否为null 4如果不为null把element封装到user中
	 * 
	 */
	public User findByUsername(String username) {

		SAXReader reader = new SAXReader();
		
		try {
			Document doc = reader.read(path);
			
			Element ele = (Element) doc.selectSingleNode("//user[@username='"
					+ username + "']");
			/**
			 * 校验
			 */
			if (ele == null) {
				return null;
			}
			/**
			 * 封装
			 */
			User user = new User();
			String attrUsername = ele.attributeValue("username");
			String attrPassword = ele.attributeValue("password");
			user.setUsername(attrUsername);
			user.setPassword(attrPassword);
			return user;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(User user) {
		/**
		 * 1.得到document 2.得到root元素 使用参数user
		 */
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);
			Element root = doc.getRootElement();
			Element userEle = root.addElement("user");
			System.out.println(user);
			userEle.addAttribute("username", user.getUsername());
			userEle.addAttribute("password", user.getPassword());
			/**
			 * 保存文档
			 */

			org.dom4j.io.OutputFormat format = new org.dom4j.io.OutputFormat()
					.createPrettyPrint();

			XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(
					new FileOutputStream(path),"utf-8"), format);
			xmlWriter.write(doc);
			xmlWriter.close();
			
		} catch (DocumentException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public void changeBookedIems(String username, String bookedItems) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBookedItemsByUsernme(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
