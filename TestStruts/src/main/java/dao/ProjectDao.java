package main.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import main.java.entitys.ProjectEntity;
import main.java.util.ConnectionUtils;

public class ProjectDao {
	private static final String findAll = "select id,name,startdate,endDate from t_project";
	
	private static final String findAll2 = "select id ,name,startdate,enddate from t_project limit ?,?";
	
	private static final String getTotalPages = "select count(*) from t_project ";
	
	private static final String delete = "delect from t_project where t_id=? ";
	
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
				project.setEndDate(rs.getDate(4));
				list.add(project);
			}
			return list;
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public List<ProjectEntity> findAll(int page,int rowsPerPage){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = (Connection) ConnectionUtils.openConnection();
			stmt = con.prepareStatement(findAll2);
			stmt.setInt(1,(page-1)*rowsPerPage);
			stmt.setInt(2, rowsPerPage);
			rs = stmt.executeQuery();
			List<ProjectEntity> list = new ArrayList<ProjectEntity>();
			while(rs.next()){
				ProjectEntity project = new ProjectEntity();
				project.setId(rs.getInt(1));
				project.setName(rs.getString(2));
				project.setStartDate(rs.getDate(3));
				project.setEndDate(rs.getDate(4));
				list.add(project);
			}
			return list;
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public int getTotalPages(int rowsPerPage){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = (Connection)ConnectionUtils.openConnection();
			stmt = con.prepareStatement(getTotalPages);
			rs = stmt.executeQuery();
			rs.next();
			int totalRows = rs.getInt(1);
			if(totalRows%rowsPerPage == 0){
				return totalRows / rowsPerPage;
			}else {
				return totalRows / rowsPerPage + 1;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void delete (Integer[] projects){
		Connection con = null;
		PreparedStatement stmt = null;
		try{
			con = (Connection) ConnectionUtils.openConnection();
			con.setAutoCommit(false);
			stmt = con.prepareStatement(delete);
			for(int i=0;i<projects.length;i++){
				stmt.setInt(1, projects[i]);
				stmt.addBatch();
			}
			stmt.executeBatch();
			con.commit();
			
		}catch(Exception e){
			try{
				con.rollback();
			}catch(SQLException e1){
				
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			ConnectionUtils.closeConnection(con);
		}
		
	}
	
	//测试
	public static void main(String[] args){
		ProjectDao dao = new ProjectDao();
//		List<ProjectEntity> list = dao.findAll();
//		List<ProjectEntity> list = dao.findAll(2,5);
//		for(ProjectEntity p : list){
//			System.out.println(p.getEndDate());
//		}
		System.out.println(dao.getTotalPages(3));
	}
}
