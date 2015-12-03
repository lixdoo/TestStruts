package main.java.action;

import main.java.action.login.action.BaseAction;
import main.java.dao.ProjectDao;

public class ProjectDeleteAction extends BaseAction {
	//用于存放数据的id
	
	private Integer[] projects;
	
	private ProjectDao projectDao = new ProjectDao();
	
	public String execute(){
		projectDao.delete(projects);
		return "success";
	}

	public Integer[] getProjects() {
		return projects;
	}

	public void setProjects(Integer[] projects) {
		this.projects = projects;
	}

}
