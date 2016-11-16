package com.person.io;

/**
 * 
 * @author lakala-shawn
 *
 */
public class IOCustomException extends RuntimeException
{
	public IOCustomException(String message){
		super(message);
	}
	
	public IOCustomException(Exception processException,Exception curException,String message){
		super(message);
	}
	
	public IOCustomException(Exception curException,String message){
		super(message);
	}
	
    public IOCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
