package main.java.action.login.action;

import main.java.dao.login.dao.UserDao;
import main.java.entitys.login.entity.User;

public class UserAction {
	private User user;
	private UserDao userDao = new UserDao();
	
	
	
	public String execute(){
		user = userDao.newUser();
		System.out.println(user.getUserId());
		
		/*
		 * 当userId不同，转发的页面也不同
		 * 根据userId来决定转到的地址
		 */
		return "success";
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
