package com.person.reflection;

import java.lang.reflect.Proxy;
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
	
	@Test
	public void testInvokeHanler()
	{
		IUser realUser = new UserImpl("sun");	
		Handler hand = new Handler(realUser); 
		/**
		 * Proxy.newProxyInstance 的方法参数<br>
		 * loader the class loader to define the proxy class
         * @param   interfaces the list of interfaces for the proxy class
         *          to implement
          * @param   h the invocation handler to dispatch method invocations to
		 */
		IUser proxy = (IUser) Proxy.newProxyInstance(realUser.getClass().getClassLoader(), realUser.getClass().getInterfaces(), hand); 
		proxy.getName(); //这里进到具体的实现类去执行了<br>
		/**
		 * 2016年12月08日执行结果<br>
		 * before the function "getName"
         *   sun
         *  after the function "getName"
		 */
	}
	

}
