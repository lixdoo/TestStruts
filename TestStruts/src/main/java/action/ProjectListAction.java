package main.java.action;

import java.util.List;

import main.java.dao.ProjectDao;
import main.java.entitys.ProjectEntity;

public class ProjectListAction {
	//input
	private int page = 1;
	
	//output
	private List<ProjectEntity> projectList;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String execute(){
		ProjectDao projectDao = new ProjectDao();
		projectList = projectDao.findAll(page,5);
		return "success";
	}

	public List<ProjectEntity> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectEntity> projectList) {
		this.projectList = projectList;
	}
	
	
	
}
