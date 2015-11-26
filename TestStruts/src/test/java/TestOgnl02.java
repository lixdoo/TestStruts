package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import main.java.entitys.Dept;
import main.java.entitys.Emp;
import ognl.Ognl;

public class TestOgnl02 {

	@Test
	public void tst2() throws Exception{
		Dept dept = new Dept();
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp(100,"emp1",10000,new Date()));
		list.add(new Emp(200,"emp2",15000,new Date()));
		list.add(new Emp(300,"emp3",12000,new Date()));
		dept.setEmpList(list);
		
		dept.setName("dept1");
		
		//演示1 ：
		String name = (String)Ognl.getValue("empList[0].name", dept);
		
		Double salary =(Double)Ognl.getValue("empList[0].salary", dept);
		
		System.out.println("##演示1##");
		System.out.println(name+","+salary);
		
		/*演示2：
		 * list.{attr}表示把list中的每一个元素的attr属性取出,
		 * 组合为一个ArrayList,并返回。
		 */
		Object obj = Ognl.getValue("empList.{salary}", dept);
		System.out.println("##演示2##");
		System.out.println(obj.getClass().getName());
		System.out.println(obj);
		
		/*演示3
		 * 过滤
		 * 找出薪水大于12000的员工姓名
		 * 过滤的格式：对象集合的子集.{符合子集的条件}
		 */
		obj = Ognl.getValue("empList.{?#this.salary >=12000}.{name}", dept);
		System.out.println("##演示3##");
		System.out.println(obj.getClass().getName());
		System.out.println(obj);
		
				
		
	}

}
