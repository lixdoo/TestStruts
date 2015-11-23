package main.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import main.java.entitys.ProjectEntity;
import main.java.util.ConnectionUtils;

public class ProjectDao {
	private static final String findAll = "select id,name,startdate,endDate from t_project";
	
	public List<ProjectEntity> findAll(){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = (Connection) ConnectionUtils.openConnection();
			stmt = con.prepareStatement(findAll);
			rs = stmt.executeQuery();
			List<ProjectEntity> list = new ArrayList<ProjectEntity>();
			while(rs.next()){
				ProjectEntity project = new ProjectEntity();
				project.setId(rs.getInt(1));
				project.setName(rs.getString(2));
				project.setStartDate(rs.getDate(3));
				project.setStartDate(rs.getDate(4));
				list.add(project);
			}
			return list;
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	//测试
	public static void main(String[] args){
		ProjectDao dao = new ProjectDao();
		List<ProjectEntity> list = dao.findAll();
		for(ProjectEntity p : list){
			System.out.println(p.getName());
		}
	}
}
