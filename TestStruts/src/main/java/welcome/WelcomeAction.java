package main.java.welcome;

public class WelcomeAction {
	private String name;
	
	public String execute(){
		System.out.println("WelcomeAction.execute()...");
		System.out.println("name:" +name);
		//用於測試
		if("monster".equalsIgnoreCase(name)){
			return "fail";
		}
		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
		
}
