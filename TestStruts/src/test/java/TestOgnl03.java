package test.java;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import main.java.entitys.Bar;
import ognl.Ognl;

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

}
