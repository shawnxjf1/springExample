package com.person;

import java.math.BigDecimal;

import org.junit.Test;

public class TestBigDecimal {
	
	@Test
	public void test1()
	{
		System.out.println(new BigDecimal("5"));
		System.out.println(new BigDecimal("5").negate());
		/**
		 * 2016-12-08
		 * 5
          -5
		 */
	}
	
	@Test
	public void test2()
	{
		System.out.println(new BigDecimal(3));
		System.out.println(new BigDecimal(4).negate());
		/**
		 * 2016-12-08
		 *3
-4
		 */
	}

}
