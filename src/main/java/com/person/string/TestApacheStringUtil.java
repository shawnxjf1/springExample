package com.person.string;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class TestApacheStringUtil {
	
	@Test
	public void testStringLeftPad()
	{
		System.out.println(StringUtils.leftPad("abcdef", 9,
				'0')); //填充到9位
		/**
		 * 2016-11-30 输出000abcdef
		 */
		
		System.out.println(StringUtils.leftPad("abcdef", 6,
				'0')); //填充到6位
		/**
		 * 2016-11-30 11:15:02 输出 abcdef
		 */
	}

}
