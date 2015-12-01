package main.java.dao.login.dao;

import main.java.entitys.login.entity.User;

public class UserDao {
	public User validate(String userName,String password){
		/*模拟业务逻辑
		 * 如果用户名为“whatisjava”则可以登录
		 */
		if("whatisjava".equals(userName)){
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			return user;
		}	
		return null;
	}
}