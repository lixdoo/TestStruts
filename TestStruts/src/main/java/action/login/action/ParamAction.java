package main.java.action.login.action;

public class ParamAction {
	/*input属性*/
	/*output属性*/
	
	
	
	
	/*参数*/
	private String param1;
	private int param2;
	
	
	
	
	public String getParam1() {
		return param1;
	}




	public void setParam1(String param1) {
		this.param1 = param1;
	}




	public int getParam2() {
		return param2;
	}




	public void setParam2(int param2) {
		this.param2 = param2;
	}




	public String execute(){
		System.out.println("param1:"+param1);
		System.out.println("param2"+param2);
		return null;
	}
	
	
}
