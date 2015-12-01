package test.java;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.opensymphony.xwork2.ognl.accessor.CompoundRootAccessor;
import com.opensymphony.xwork2.util.CompoundRoot;

import main.java.entitys.Bar;
import ognl.Ognl;
import ognl.OgnlRuntime;

public class TestOgnl03 {

	@Test
	public void tst3() throws Exception{
		//自定义context对象，如果不写，系统会自动加一个
		Map ctx = new HashMap();
		ctx.put("num",10);
		
		//root对象
		Bar root =  new Bar();
		root.setName("bar");
		
		//不加"#",表示从业务对象root中取数据
		System.out.println(Ognl.getValue("name", ctx,root));
		//加"#",表示从公共对象context中取数据
		System.out.println(Ognl.getValue("#num",ctx, root));
	}
	@Test
	public void tst4() throws Exception{
		//创建一个CompoundRoot对象
		CompoundRoot root = new CompoundRoot();
		Bar bar1 = new Bar();
		bar1.setName("hahaha bar1");
		//root.add(bar1);
	    root.push(bar1);
	    
	    Bar bar2 = new Bar();
	    bar2.setName("hehehe bar2");
	    //root.add(bar2);
	    root.push(bar2);
	    
	    //定制OGNL的Root机制为CompoundRoot机制
	    OgnlRuntime.setPropertyAccessor(CompoundRoot.class, new CompoundRootAccessor());
		
	    String name = (String)Ognl.getValue("name", root);
	    System.out.println(name);
		
	}

}
