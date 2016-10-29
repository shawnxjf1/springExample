package com.person.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//http://tutorials.jenkov.com/java-exception-handling/exception-handling-templates.html
	
public abstract class InputStreamProcessingTemplate
{
	
	 public void process(String fileName){
	        IOException processException = null;
	        InputStream input = null;
	        try{
	            input = new FileInputStream(fileName);

	            doProcess(input);
	        } catch (IOException e) {
	            processException = e;
	        } finally {
	           if(input != null){
	              try {
	                 input.close();
	              } catch(IOException e){
	                 if(processException != null){
	                    throw new MyException(processException, e, "Error message..." + fileName);
	                 } else {
	                    throw new MyException(e, "Error closing InputStream for file " + fileName);
	                 }
	              }
	           }
	           if(processException != null){
	              throw new MyException(processException,"Error processing InputStream for file " + fileName);
	           }
	    }
	 }

	   //override this method in a subclass, to process the stream.
	   public abstract void doProcess(InputStream input) throws IOException;
}
