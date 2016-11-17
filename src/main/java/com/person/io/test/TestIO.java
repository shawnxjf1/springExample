package com.person.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.person.io.IOProcessTemplate;
import com.person.io.StreamToStringReader;
import com.person.io.impl.JarParseerImpl;

public class TestIO {
	
	Logger log = Logger.getLogger(TestIO.class);
	
	 /**
	  * 2016年10月30日 测试通过，文件能够输出。<br>
	  * 不足：中文乱码，英文本来就只占一个字节吧，猜测。<br>
	  */
	 @Test
	   public  void testReadByte() 
	{
			//String fullFilePath = ClassLoarderTest.class.getPackage().getName().replace('.', '/') + "/InputStreamProcessingTemplate.java";
           //com\person\jvm\InputStreamProcessingTemplate.java
			
		   String fullFilePath = "D:\\inbox\\logback.xml";
		   FileInputStream input = null;
		try
		{
			input = new FileInputStream(fullFilePath);
		} catch (FileNotFoundException e)
		{
			log.error(e);
			e.printStackTrace();
		}
	}
	 
	 /**
	  * 问题：中文也是乱码<br>
	  */
	 @Test
	 public  void testStringReader()
	 {
	 	  //String fullFilePath = ClassLoarderTest.class.getPackage().getName().replace('.', '/') + "/InputStreamProcessingTemplate.java";
	      //com\person\jvm\InputStreamProcessingTemplate.java
		 
	 	   String fullFilePath = "D:\\inbox\\logback.xml";
	 	   FileInputStream input = null;
	 	try
	 	{
	 		input = new FileInputStream(fullFilePath);
	 	} catch (FileNotFoundException e)
	 	{
	 		log.error(e);
	 		e.printStackTrace();
	 	}
	 	StreamToStringReader stringReader = new StreamToStringReader();
	 	new IOProcessTemplate().process(input,stringReader);
	 	log.info("stringReader=" + stringReader);
	 }
	 
	 /**
		 * 2016年10月30日 测试成功<br>
		 */
		@Test
		public void  testFindJar()
		{
			String path = "D:\\lakala_svn\\ssp\\trunk\\Tools\\dssp resource\\lib\\zookeeper-3.4.6.jar";
			JarParseerImpl jarProcess = new JarParseerImpl();
			jarProcess.setPath(path);
			JarFile jarFile = null;
			try
			{
				jarFile = new JarFile(new File(path));
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			jarProcess.setJarFile(jarFile);
			new IOProcessTemplate().processJar(jarProcess);
		}
}
