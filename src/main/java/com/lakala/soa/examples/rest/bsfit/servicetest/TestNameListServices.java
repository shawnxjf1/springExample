package com.lakala.soa.examples.rest.bsfit.servicetest;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lakala.soa.examples.rest.bsfit.model.BlackNameListParam;
import com.lakala.soa.examples.rest.bsfit.model.NameListBean;
import com.lakala.soa.examples.rest.bsfit.service.impl.NameListServiceImpl;


public class TestNameListServices {
	private static ApplicationContext ctx;
	
	private static Logger log=Logger.getLogger(NameListServiceImpl.class);
	
	@Before
	public void before() throws IOException{
		String config = TestNameListServices.class.getPackage().getName().replace('.', '/') + "/applicationCtxTest.xml";
        ctx = new ClassPathXmlApplicationContext(config);
//		ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationCtxTest.xml");
	}
	
//	@Test
	public void testGetFinyByNameList(){
		log.info("testGetFinyByNameList...............");
		NameListServiceImpl userService = (NameListServiceImpl) ctx.getBean("nameListService");
		BlackNameListParam listParam=new BlackNameListParam();
		listParam.setUniqueId("110102195602132390");
		listParam.setTag("certificate");
		listParam.setPageStart(0);
		listParam.setPageSize(10);
		List<NameListBean> list=userService.getFinyByNameList(listParam);
		for (NameListBean bean : list) {
			log.info(bean.getId()+"=="+bean.getUniqueId()+"===="+"==="+bean.getType());
		}
	}
	
	
//	@Test
	public void testGetFinyByName(){
		log.info("testGetFinyByName...............");
		NameListServiceImpl userService = (NameListServiceImpl) ctx.getBean("nameListService");
		BlackNameListParam listParam=new BlackNameListParam();
		listParam.setUniqueId("110102195602132390");
		listParam.setTag("certificate");
		NameListBean bean=userService.getFinyByName(listParam);
		
			log.info(bean.getId()+"=="+bean.getUniqueId()+"===="+"==="+bean.getType());
		
	}
	
//	@Test
	public void testGetFinyByNameStatus(){
		log.info("testGetFinyByName...............");
		NameListServiceImpl userService = (NameListServiceImpl) ctx.getBean("nameListService");
		BlackNameListParam listParam=new BlackNameListParam();
		listParam.setUniqueId("110102195602132390");
		listParam.setTag("certificate");
		String str=userService.getFinyStatus(listParam);
		
			log.info("----------------"+str);
		
	}
	
	@Test
	public void testgetTestFinyByNameList(){
		log.info("testGetFinyByName...............");
		NameListServiceImpl userService = (NameListServiceImpl) ctx.getBean("nameListService");
		List<NameListBean> list=userService.getTestFinyByNameList();
		for (NameListBean bean : list) {
			log.info(bean.getId()+"=="+bean.toString());
		}
	}
	
}