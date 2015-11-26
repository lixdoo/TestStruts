package test.java;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

import main.java.entitys.Foo;
import ognl.Ognl;

public class TestOgnl {

	@Test
	/**
	 * OGNL的基础语法
	 */
	
	public void tst1() throws Exception{
		Foo foo = new Foo();
		
		foo.setId(100);
		foo.setName("java");
		foo.setArray(new String[] {"one","two","three"});
		foo.setList(Arrays.asList("A","B","C"));
		
	    HashMap<String,String> map = new HashMap<String,String>();
	    map.put("one", "java");
	    map.put("two", "javajava");
	    map.put("three","javajavajava");
	    
	    foo.setMap(map);
	    
	    /*Ognl引擎访问对象的格式：
	     * Ognl.getValue("OGNL表达式",root对象);//root是OGNL要操作的对象
	     */
	    
	    //1.基本类型属性(包括String)
	    System.out.println("##1基本类型属性##");
	    System.out.println(Ognl.getValue("id", foo));
	    System.out.println(Ognl.getValue("name", foo));
	    
	    //2.数组、List属性：属性名[下标]
	    System.out.println(Ognl.getValue("array[0]", foo));
	    System.out.println(Ognl.getValue("list[1]", foo));
	    
	    //3.map属性
	    System.out.println("##3Map属性");
	    System.out.println(Ognl.getValue("map.one", foo));
	    System.out.println(Ognl.getValue("map['two']", foo));
	    //map['two']中的two是key
	    
	    //4.基本运算
	    System.out.println("##4基本运算");
	    System.out.println(Ognl.getValue("id+100", foo));
	    System.out.println(Ognl.getValue("\"What is \"+name", foo));
	    System.out.println(Ognl.getValue("\"name:\"+name+\" id:\"+id", foo));
	    System.out.println(Ognl.getValue("id>150", foo));
	    
	    //5.调用方法
	    System.out.println("##5调用方法");
	    System.out.println(Ognl.getValue("name.toUpperCase()", foo));
	    System.out.println(Ognl.getValue("list.size()", foo));
	    //注意:方法的参数也可以使属性
	    
	    System.out.println(Ognl.getValue("map['three'].lastIndexOf(name)", foo));
	    
	    //6.调用静态方法，以取出的属性为参数
	    //调用静态方法的格式：@类名@方法名
	    System.out.println("##6调用静态方法");
	    System.out.println(Ognl.getValue("@java.util.Arrays@toString(array)", foo));
	    
	    //7.创建的List对象
	    //这种方法更方便的临时创建一个list对象
	    System.out.println("##7创建的List对象##");
	    Object obj = Ognl.getValue("{1,2,3,4,5}", null);
	    System.out.println(obj.getClass().getName());
	    System.out.println(obj);
	    
	    //8.创建的Map对象
	    //注意：#不能丢
	    System.out.println("##8创建的Map对象##");
	    obj = Ognl.getValue("#{1:'java',2:'javajava',3:'javajavajava'}", null);
	    System.out.println(obj.getClass().getName());
	    System.out.println(obj);
	    
	    
	}
}
