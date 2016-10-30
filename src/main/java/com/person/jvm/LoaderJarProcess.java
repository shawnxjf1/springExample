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
import org.springframework.remoting.jaxrpc.JaxRpcServicePostProcessor;

import com.person.constants.FileConstants;
import com.person.io.InputStreamProcessingTemplate;
import com.person.io.JarProcessor;

/**
 * 遍历jar
 * @author lakala-shawn
 *
 */
public class LoaderJarProcess implements JarProcessor
{
	String path = "";
	JarFile jarFile =null;
	
	public String getPath()
	{
		return path;
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	public JarFile getJarFile()
	{
		return jarFile;
	}
	
	public void setJarFile(JarFile jarFile)
	{
		this.jarFile = jarFile;
	}

	/**
	 * 2016年10月30日 测试成功<br>
	 */
	@Test
	public void  testFindJar()
	{
		String path = "D:\\lakala_svn\\ssp\\trunk\\Tools\\dssp resource\\lib\\zookeeper-3.4.6.jar";
		LoaderJarProcess jarProcess = new LoaderJarProcess();
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
		new InputStreamProcessingTemplate().processJar(jarProcess);
	}
	
	@Override
	public void process() throws IOException, ClassNotFoundException
	{
		 Set<Class<?>> classes = new LinkedHashSet<Class<?>>();//所有的Class对象  
		 Map<Class<?>, Annotation[]> classAnnotationMap = new HashMap<Class<?>, Annotation[]>();//每个Class对象上的注释对象  
		 Map<Class<?>, Map<Method, Annotation[]>> classMethodAnnoMap = new HashMap<Class<?>, Map<Method,Annotation[]>>();//每个Class对象中每个方法上的注释对象
		 
		  URL url = new URL(FileConstants.FILE_PROTOCOL_PREFIX + path);  
		  
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
	}
}
