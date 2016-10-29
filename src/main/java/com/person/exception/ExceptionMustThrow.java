package com.person.exception;

/**
 * A函数调用B，如果B函数抛出异常则A必须Catch或者生命抛出
 * @author lakala-shawn
 *
 */
public class ExceptionMustThrow
{
	public void testException() throws Exception
	{
		
	}
	
	/**
	 * 把testException的注释 取消就可以测试了。
	 */
	public void testException1()
	{
		//由于 该函数必须抛出异常， 调用的函数也应该抛出。
		//testException();
	}

}
