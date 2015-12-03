package main.java.action.login.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

/*
 * 通过实现SessionAware接口访问session
 */
public class BaseAction implements SessionAware,ServletRequestAware,ServletResponseAware,ServletContextAware{
	//为了让子类也能使用，所以访问控制符为protected
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext application;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute(){
		return "success";
	}
	
}
