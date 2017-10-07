package cn.yzz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import cn.yzz.domain.User;
import cn.yzz.utils.JDBCUtils;
/**
 * 专门针对数据库的UserDao实现类
 * @author YZZ
 *
 */

public class UserDaoJDBC implements UserDao{
	private static  Connection conn;
	static {
		//一，获得连接对象
		        conn=JDBCUtils.getConnection();
				System.out.println(conn);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		PreparedStatement psmt;
		User user=null;
		ResultSet rs=null;
		try {
			//二，创建SQL模板
			String sql="SELECT * FROM user_info where user_name = ?";
			psmt=(PreparedStatement) conn.prepareStatement(sql);
			
			psmt.setString(1, username);
			
			rs=psmt.executeQuery();
			//rs为空
			if(rs==null){
				return null;
			}
			if(rs.next()){
				//如果找到了，进行封装
				user=new User();
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("user_password"));
				user.setVerifyCode(null);
			}else{
				//没找到
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
				//二，准备SQL模板，得到psmt
				String sql=new String();
				sql="INSERT INTO user_info VALUES(?,?,?,?,?,?)";
				PreparedStatement psmt = null;
				try {
					//三，得到psmt
					 psmt=conn.prepareStatement(sql);
					
					//四，为psmt的四个问号赋值
					psmt.setString(1, null);
					psmt.setString(2,user.getUsername());
					psmt.setString(3, user.getPassword());
					psmt.setString(4, null);
					psmt.setString(5, null);
					psmt.setString(6, null);
					//五，操作数据库
					psmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						//关闭psmt
						psmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}
	
	
			//修改用户订阅的频道
			@Override
			public void changeBookedIems(String username, String bookedItems) {
				// TODO Auto-generated method stub
				String sql="update user_info set user_booked=? where user_name=?";
				
				try {
					
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setString(1, bookedItems);
					psmt.setString(2, username);
					
					psmt.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			//通过用户名获取订阅的频道
			@Override
			public String getBookedItemsByUsernme(String username) {
				// TODO Auto-generated method stub
				return null;
			}

}
