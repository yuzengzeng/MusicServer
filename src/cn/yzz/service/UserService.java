package cn.yzz.service;

import cn.yzz.dao.DaoFactory;
import cn.yzz.dao.UserDao;
import cn.yzz.dao.UserDaoImpl;
import cn.yzz.domain.User;
/**
 * 
 * @author YZZ
 *提供与用户相关的业务功能
 */
public class UserService {
	private UserDao userDao=DaoFactory.getUserDao();
	
	/**
	 * 注册功能
	 * 1.使用用户名去查询，如果返回nul完成添加
	 * 2.如果返回的不是null，抛出异常
	 */
	
	//注册
	public void regist(User user)throws UserException{
		User _user=userDao.findByUsername(user.getUsername());
		if(_user!=null){
			throw new UserException("用户名"
					+user.getUsername()+"已被注册!");
		}
		
		userDao.add(user);
	}
	
	//登录
	public void login(User user) throws UserException{
		String result;
		System.out.println(user);
		User _user=userDao.findByUsername(user.getUsername());
		
		if(_user!=null){
			if(_user.getPassword().equals(user.getPassword())){
				
			}else{
				throw new UserException("密码错误");
			}
		}else{
			throw new UserException("该用户名不存在");
		}
	}
	
	//订阅
	
	public void changeBookedItems(String username,String bookedItems){
		userDao.changeBookedIems(username, bookedItems);
	}
	
	
}
