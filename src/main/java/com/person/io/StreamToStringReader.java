package com.person.io;

public class StreamToStringReader implements IStreamProcessor{
	  private StringBuffer buffer = new StringBuffer();
	  
	  public StringBuffer getBuffer(){
	     return this.buffer;
	  }

	  public void process(int input){
	     this.buffer.append((char) input);
	  }
	  
	  @Override
	public String toString()
	{
		return buffer.toString();
	}
}