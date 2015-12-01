package main.java.action.login.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import main.java.dao.login.dao.UserDao;
import main.java.entitys.login.entity.User;

public class LoginAction extends BaseAction{
	private User user;
	
	//良好的编程习惯：将dao作为属性使用
	private UserDao userDao = new UserDao();
	
	
	public String form(){
		return "success";
	}
	
	public String login(){
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		
		user = userDao.validate(user.getUserName(), user.getPassword());
		
		if(user!=null){
			//登陆成功
			//获得session的方法
			/**
			 * 这种访问Session的方式“侵入性”较强。因为ActionContext是struts2的API
			 */
//			ActionContext ctx = ActionContext.getContext();
//			Map<String,Object> session = ctx.getSession();
//			session.put("LoginAction",user);
			
			
			
			/*
			 * 直接使用父类中的session
			 */
			session.put("001", user);
			return "success";
		}else{
			//登陆失败
			return "fail";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
