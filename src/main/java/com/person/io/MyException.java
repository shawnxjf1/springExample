package com.person.io;

/**
 * 
 * @author lakala-shawn
 *
 */
public class MyException extends RuntimeException
{
	public MyException(String message){
		super(message);
	}
	
	public MyException(Exception processException,Exception curException,String message){
		super(message);
	}
	
	public MyException(Exception curException,String message){
		super(message);
	}
	
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
