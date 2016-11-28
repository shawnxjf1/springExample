package com.person.io;

/**
 * 
 * @author lakala-shawn
 *
 */
public class IOCustomException extends RuntimeException
{
	private Exception processException;
	private Exception closeExceptiion;
	
	public IOCustomException(String message){
		super(message);
	}
	
	public IOCustomException(Exception processException,Exception closeException,String message){
		super(message);
		this.processException = processException;
		this.closeExceptiion = closeException;
	}
	
	public IOCustomException(Exception closeException,String message){
		super(message);
		this.closeExceptiion  = closeException;
	}
	
    public IOCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
