package com.person.exception;


public class MustThrow
{
	public void testException() throws Exception
	{
		
	}
	
	public void testException1()
	{
		//由于 该函数必须抛出异常， 调用的函数也应该抛出。
		testException();
	}

}
