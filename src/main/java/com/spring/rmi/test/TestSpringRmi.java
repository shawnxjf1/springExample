package com.spring.rmi.test;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.character.SpringContextHolder;
import com.spring.rmi.PersonService;
import com.spring.rmi.model.PersonEntity;

/**
 * 参考这个博客不错<br>
 * https://segmentfault.com/a/1190000004494341#articleHeader10
 */
/**
 * 以下测试用例没有成功<br>
 * spring的代码参考如下<br>http://www.studytrails.com/frameworks/spring/spring-remoting-rmi/
 * git 代码如下：https://github.com/MithilShah/Spring-Examples <br>
 * @author lakala-shawn
 *
 */
public class TestSpringRmi {
	
	@Test
	public void testRmiServer()
	{
		SpringContextHolder springHolder = new SpringContextHolder();
		springHolder.setApplicationContext(new ClassPathXmlApplicationContext("/spring/applicationContext.xml"));
		try {
			Thread.sleep(5000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRmiClient()
	{
		SpringContextHolder springHolder = new SpringContextHolder();
		springHolder.setApplicationContext(new ClassPathXmlApplicationContext("/test/applicationContext.xml"));
		PersonService personService= SpringContextHolder.getBean("personService");//注意名字elasticTemplate
		try {
			List<PersonEntity> personList = personService.GetList();
			System.out.println("personList=" + personList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
