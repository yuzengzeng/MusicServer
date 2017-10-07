package cn.yzz.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import cn.yzz.domain.News;
import cn.yzz.domain.NewsList;
import cn.yzz.domain.User;
import cn.yzz.utils.JDBCUtils;

public class UserDaoTest {
	/**
	 * UserDao的测试
	 */
	@Test
	public void testFindByUsername(){
		UserDaoImpl userDao=new UserDaoImpl();
		User user = userDao.findByUsername("王五");
		System.out.println(user);
	}
	
	@Test
	public void testAdd(){
		UserDaoImpl userDao=new UserDaoImpl();
		User user=new User();
		
		user.setUsername("庾增增");
		user.setPassword("123");
		
		userDao.add(user);
		}
	@Test
	public void testConn(){
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
	}
	
	@Test
	public void testNews(){
		NewsDaoJDBC dao=new NewsDaoJDBC();
		
		NewsList newses = dao.findNewsByPageAndType(1);
		for (News news : newses.getList()) {
			System.out.println(news);
		}
		
	}
}
