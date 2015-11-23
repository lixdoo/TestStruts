package main.java.action;

import java.util.List;

import main.java.dao.ProjectDao;
import main.java.entitys.ProjectEntity;

public class ProjectListAction {
	private List<ProjectEntity> projectList;
	
	public String execute(){
		ProjectDao projectDao = new ProjectDao();
		projectList = projectDao.findAll();
		return "success";
	}

	public List<ProjectEntity> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectEntity> projectList) {
		this.projectList = projectList;
	}
	
	
	
}
