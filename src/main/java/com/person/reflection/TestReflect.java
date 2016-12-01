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
	
	/**
	 *  As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
	 */
	@Test
	public void testClassRef()
	{
		log.info("class obj1" + TestReflect.class.hashCode());
		log.info("class obj2" + TestReflect.class.hashCode());
		/**
		 * hashCode是一样，所以地址也是同一个<br>
		 * 2016-12-01 19:20:14,764 INFO  main com.person.reflection.TestReflect class obj11963387170
2016-12-01 19:20:14,766 INFO  main com.person.reflection.TestReflect class obj21963387170
		 */
	}
	
	@Test
	public void testNewObj()
	{
		log.info("new TestReflect1" + new TestReflect());
		log.info("new TestReflect2" + new TestReflect());
		
		log.info("new TestReflect1.hashcode=" + new TestReflect().hashCode());
		log.info("new TestReflect2.hashcode=" + new TestReflect().hashCode());
		/**
		 * 执行结果:<br>
		 *2016-12-01 19:28:24,730 INFO  main com.person.reflection.TestReflect new TestReflect1com.person.reflection.TestReflect@2db0f6b2
2016-12-01 19:28:24,733 INFO  main com.person.reflection.TestReflect new TestReflect2com.person.reflection.TestReflect@3cd1f1c8
2016-12-01 19:28:24,733 INFO  main com.person.reflection.TestReflect new TestReflect1.hashcode=977993101
2016-12-01 19:28:24,734 INFO  main com.person.reflection.TestReflect new TestReflect2.hashcode=429313384
		 */
	}
	
	/**
	 * Returns a hash code for this string. The hash code for a
     * {@code String} object is computed as
     * <blockquote><pre>
     * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
	 */
	@Test
	public void testStringRef()
	{
		log.info("123456".hashCode());
		log.info("123456".hashCode());
		
		log.info(("123"+"456").hashCode());
		/**
		 * 执行结果,地址都是一样的:<br>
		2016-12-01 19:26:33,802 INFO  main com.person.reflection.TestReflect 1450575459
2016-12-01 19:26:33,803 INFO  main com.person.reflection.TestReflect 1450575459
2016-12-01 19:26:33,803 INFO  main com.person.reflection.TestReflect 1450575459
		 */
	}

}
