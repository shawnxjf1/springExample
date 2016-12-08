package com.person.uuid;

import java.util.UUID;

import org.junit.Test;

public class TestUUID {
	
	@Test
	public void randomUUID()
	{
	    /**	The {@code UUID} is generated using a cryptographically strong pseudo
	     random number generator.*/
		System.out.println(UUID.randomUUID());
		/**
		 * 2016年11月30日 两次执行结果：<br>
		 * 1. 407de8cd-28d2-40fc-8073-acf688d3e94d
		 * 2. ea8e5816-e9db-407f-85ef-954a7e7e1bea
		 */

	}

}
