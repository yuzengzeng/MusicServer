package cn.yzz.dao;

import cn.yzz.domain.User;
/**
 * userDao接口
 * @author YZZ
 *
 */

public interface UserDao {
	public User findByUsername(String username);
	public void add(User user);
	public void changeBookedIems(String username,String bookedItems);
	
	public String getBookedItemsByUsernme(String username);
}
