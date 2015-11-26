package main.java.entitys;

import java.util.Date;

public class Emp {
	private Integer id;
	private String name;
	private double salary;
	private Date fireDate;
	
	public Emp(){
		
	}
	
	public Emp(Integer id,String name,double salary,Date fireDate){
		super();
		this.id=id;
		this.name=name;
		this.salary = salary;
		this.fireDate = fireDate;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getFireDate() {
		return fireDate;
	}

	public void setFireDate(Date fireDate) {
		this.fireDate = fireDate;
	}
	
	
}
