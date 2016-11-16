package com.person.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.person.jvm.TestClassLoarder;
/**
 * 这篇文章重点是有 context 和 action ，action pluginto context的思想。
 */
//http://tutorials.jenkov.com/java-exception-handling/exception-handling-templates.html
/**
 * 1.Below is shown how the above examples can be separated into a context plus actions.<br>
 * 2.http://tutorials.jenkov.com/ood/code-reuse-action-and-context-reuse.html  ,这篇文章说了action reuse和context reuse。<br>
 * Context reuse is quite powerful and can be used in many other contexts than stream processing.
 *  An obvious use case is the correct handling of database connections and transactions (open - process - commit()/rollback() - close()).
 *  Other use cases are NIO channel processing, and thread synchronization in critical sections (lock() - access shared resource - unlock()). 
 *  It could also just be something as simple as turning checked exceptions of an API into unchecked exceptions. <br>
 * 
 * 3.context reuse：  That way users will never have to worry about correctly opening or closing connections, or committing or rolling back transactions. 
 * Mr. Persister provides contexts that the users can<b>  plug their actions into </b>.
 * These contexts take care of the opening, closing, committing and rolling back.
 * @author lakala-shawn
 *
 */
//the stream processing context class
public class InputStreamProcessingTemplate
{
	Logger log = Logger.getLogger(InputStreamProcessingTemplate.class);
	//当然这里可以把inputStream逻辑划分出来<br>
	
	 public void processJar(IJarProcessor jarProcess)
	 {
		 JarFile jarFile = jarProcess.getJarFile();
		 IOException processException = null;
	        try{
			  jarProcess.process();
	        } catch (IOException e) {
	        	log.error("IoException",e);
	            processException = e;
	        }catch (ClassNotFoundException e)
			{
	        	log.error("ClassNotFoundException",e);
	        	e.printStackTrace();
			}   
	        finally {
	           if(jarFile != null){
	              try {
	            	  //这里是一个模板，外面只需要调用new InputStreamProcessingTemplate(...).process()就可以
	            	  jarFile.close();
	              } catch(IOException e){
	                 if(processException != null){
	                    throw new IOCustomException(processException, e, "Error message...");
	                 } else {
	                    throw new IOCustomException(e, "Error closing InputStream for file ");
	                 }
	              }
	           }
	           if(processException != null){
	              throw new IOCustomException(processException,"Error processing InputStream for file ");
	           }
	    }
	 }
	
	 public void process(InputStream inputStream ,IStreamProcessor processor){
	        IOException processException = null;
	        try{
	           
	        	int character = inputStream.read();

	            while(character != -1){ 
	               processor.process(character);
	               character = inputStream.read();
	            }
	        } catch (IOException e) {
	        	log.error("IoException",e);
	            processException = e;
	        } finally {
	           if(inputStream != null){
	              try {
	            	  //这里是一个模板，外面只需要调用new InputStreamProcessingTemplate(...).process()就可以
	            	  inputStream.close();
	              } catch(IOException e){
	                 if(processException != null){
	                    throw new IOCustomException(processException, e, "Error message...");
	                 } else {
	                    throw new IOCustomException(e, "Error closing InputStream for file ");
	                 }
	              }
	           }
	           if(processException != null){
	              throw new IOCustomException(processException,"Error processing InputStream for file ");
	           }
	    }
	 }
	 
}
	   
	


