package main.java.action.login.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/*
 * 通过实现SessionAware接口访问session
 */
public class BaseAction implements SessionAware{
	//为了让子类也能使用，所以访问控制符为protected
	protected Map<String,Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
