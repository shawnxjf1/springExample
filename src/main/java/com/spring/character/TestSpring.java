package com.spring.character;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

public class TestSpring {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	/**
	 * 2016年11月10日 测试通过，能够获取bean
	 */
	@Before
	public void initBean()
	{
		SpringContextHolder springHolder = new SpringContextHolder();
		springHolder.setApplicationContext(new ClassPathXmlApplicationContext("/test/applicationContext.xml"));
		elasticsearchTemplate = SpringContextHolder.getBean("elasticTemplate");//注意名字elasticTemplate
		
	}
}
