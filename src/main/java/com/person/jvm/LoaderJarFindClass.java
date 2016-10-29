package com.person.jvm;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.junit.Test;

/**
 * 遍历jar
 * @author lakala-shawn
 *
 */
public class LoaderJarFindClass
{
	public static final String FILE_PROTOCOL_PREFIX = "file:";
	@Test
	public void  testFindJar()
	{
		String path = "D:\\lakala_svn\\ssp\\trunk\\Tools\\dssp resource\\lib\\zookeeper-3.4.6.jar";
		findJar(path);
	}
	
	/**
	 * 
	 * @param path
	 */
	private void findJar(String path)
	{
		 Set<Class<?>> classes = new LinkedHashSet<Class<?>>();//所有的Class对象  
		 Map<Class<?>, Annotation[]> classAnnotationMap = new HashMap<Class<?>, Annotation[]>();//每个Class对象上的注释对象  
		 Map<Class<?>, Map<Method, Annotation[]>> classMethodAnnoMap = new HashMap<Class<?>, Map<Method,Annotation[]>>();//每个Class对象中每个方法上的注释对象
		 JarFile jarFile = null;
		 try {
		  //
		  jarFile = new JarFile(new File(path));  
		  URL url = new URL(FILE_PROTOCOL_PREFIX + path);  
		  
		  ClassLoader loader = new URLClassLoader(new URL[]{url});//自己定义的classLoader类，把外部路径也加到load路径里，使系统去该路经load对象
		  //遍历jar包
		  Enumeration<JarEntry> es = jarFile.entries();  
		  while (es.hasMoreElements()) {  
		   JarEntry jarEntry = (JarEntry) es.nextElement();  
		   String name = jarEntry.getName();  
		   if(name != null && name.endsWith(".class")){//只解析了.class文件，没有解析里面的jar包  
		    //默认去系统已经定义的路径查找对象，针对外部jar包不能用  
		    //Class<?> c = Thread.currentThread().getContextClassLoader().loadClass(name.replace("/", ".").substring(0,name.length() - 6));  
		    Class<?> c = loader.loadClass(name.replace("/", ".").substring(0,name.length() - 6));//自己定义的loader路径可以找到  
		    System.out.println(c);  
		    classes.add(c);  
		    Annotation[] classAnnos = c.getDeclaredAnnotations();  
		    classAnnotationMap.put(c, classAnnos);  
		    Method[] classMethods = c.getDeclaredMethods();  
		    
		    
		    Map<Method, Annotation[]> methodAnnoMap = new HashMap<Method, Annotation[]>();  
		    for(int i = 0;i<classMethods.length;i++){
		     Annotation[] a = classMethods[i].getDeclaredAnnotations();  
		     methodAnnoMap.put(classMethods[i], a);  
		    }  
		    classMethodAnnoMap.put(c, methodAnnoMap);  
		   }  
		  }  
		  System.out.println(classes.size());
		 } catch (IOException e) {
		  e.printStackTrace();  
		 } catch (ClassNotFoundException e) {
		  e.printStackTrace();  
		 } finally {
			 if (jarFile != null)
			 {
				 try
				{
					jarFile.close();
				} catch (IOException e)
				{
					//FIXME do what when exception throws from jarFile.close.
				}
			 }
			 
		}
	}
	
	/**
	 * Correct exception handling code can be tedious to write. Try-catch blocks also clutter the code and makes it harder to read. Look at the example below:
	 */
	public void exceptionTemplate()
	{
		Input       input            = null;
	    IOException processException = null;
	    try{
	        input = new FileInputStream(fileName);

	        //...process input stream...
	    } catch (IOException e) {
	        processException = e;
	    } finally {
	       if(input != null){
	          try {
	             input.close();
	          } catch(IOException e){
	             if(processException != null){
	                throw new MyException(processException, e,
	                  "Error message..." +
	                  fileName);
	             } else {
	                throw new MyException(e,
	                    "Error closing InputStream for file " +
	                    fileName;
	             }
	          }
	       }
	       if(processException != null){
	          throw new MyException(processException,
	            "Error processing InputStream for file " +
	                fileName;
	    }
	}

}
