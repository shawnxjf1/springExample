package com.person.reflection;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestReflect {
	
	Logger log = Logger.getLogger(TestReflect.class);
	
	/**
	 * 在函数上定义反射变量T<br>
	 * @param map
	 */
	public <T> void  voidWithT(Map<T,T> map)
	{
		log.info("map= " + map);
	}
	
	
	@Test
	public void test1()
	{
		Map<String,String> map1 = new HashMap<String, String>();
		map1.put("a", "b");
		map1.put("c", "d");
		
		voidWithT(map1);
	}

}
