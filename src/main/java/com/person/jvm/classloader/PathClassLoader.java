package com.person.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.person.io.nio.core.ChannelsConcept;


/**
 * http://www.ibm.com/developerworks/java/tutorials/j-classloader/j-classloader.html<br>
 * 执行顺序：
 * Call findLoadedClass to see if we have already loaded the class.
If we haven't loaded the class, we do special magic to get the raw bytes.
If we have the raw bytes, call defineClass to turn them into a Class object.
If we don't have the raw bytes, then call findSystemClass to see if we can get the class from the local filesystem.
If the resolve parameter is true, call resolveClass to resolve the Class object.
If we still don't have a class, throw a ClassNotFoundException.
Otherwise, return the class to the caller.
 */
/**
 * http://stackoverflow.com/questions/24504549/what-is-user-defined-classloader
 * <br>
 * Your own class loader shouldn't really "load" the class by itself, usually
 * its only responsible to bring the byte stream and then call its parent's
 * method to do actual loading (all class loaders extends
 * java.lang.ClassLoader).
 * 
 * @author shawn
 *
 */

/**
 * http://www.ibm.com/developerworks/java/tutorials/j-classloader/j-classloader.html#<br>
 * Method loadClass:
1.ClassLoader.loadClass() is the entry point to the ClassLoader. Its signature is as follows:
Class loadClass( String name, boolean resolve );
The name parameter specifies the name of the class that the JVM needs, in package notation, such as Foo or java.lang.Object.
The resolve parameter tells the method whether or not the class needs to be resolved. 
You can think of class resolution as the task of completely preparing the class for execution. Resolution is not always needed.
 If the JVM needs only to determine that the class exists or to find out what its superclass is, 
 then resolution is not required.<br>
 2.Method defineClass
The defineClass method is the central mystery of the ClassLoader. This method takes a raw array of bytes and turns it into a Class object. The raw array contains the data that, for example, was loaded from the filesystem or across the network.
<br>
 * @author shawn
 *
 */
public class PathClassLoader extends ClassLoader {
	
	Logger log = Logger.getLogger(PathClassLoader.class);

	private String classPath;
	private String packageName;

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public String getPackagePrefix() {
		return packageName;
	}

	public void setPackageName(String packagePrefix) {
		this.packageName = packagePrefix;
	}

	public PathClassLoader(String classPath) {
		this.classPath = classPath;
	}

	protected Class<?> findClass(String name) throws ClassNotFoundException {
		log.info("invoke findClass,name=" + name);
		if (packageName.startsWith(name)) {
			byte[] classData = getData(name);
			log.info("load class with self");
			if (null == classData) {
				throw new ClassNotFoundException();
			} else {
				return defineClass(name, classData, 0, classData.length);
			}
		} else {
			//调用父类的加载器
			log.info("use super.loadClass,for name=" + name);
			return super.loadClass(name);
		}
	}

	private byte[] getData(String className) {
		String path = classPath + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
		log.info("path=" + path);
		try {
			InputStream is = new FileInputStream(path);
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			byte[] buffer = new byte[2048];
			int num = 0;
			while ((num = is.read(buffer)) != -1) {
				stream.write(buffer, 0, num);
			}
			return stream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
