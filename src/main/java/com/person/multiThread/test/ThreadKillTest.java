package com.person.multiThread.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.person.multiThread.ThreadKillService;

public class ThreadKillTest {

	private static ApplicationContext ctx;

	private static final String SYSNAME_DSSP = "dssp";

	@Before
	public void before() throws IOException {
		ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	/**
	 * 测试通过
	 */
	@Test
	public void testThreadKill() {
		ThreadKillService ruleService = (ThreadKillService) ctx.getBean("threadKillService");
		try {
			Thread.sleep(3000 * 60);
		} catch (InterruptedException e) {
			System.out.println("aaaa========================>");
			e.printStackTrace();
		}
		try {
			ruleService.destroy();
		} catch (Exception e) {
			System.out.println("bbbb========================>");
			e.printStackTrace();
		}
	}

}
