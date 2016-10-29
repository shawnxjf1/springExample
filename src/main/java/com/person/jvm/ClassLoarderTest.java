package com.person.jvm;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Test;

import com.lakala.soa.reserve.rest.TestRPCDemoConsumer;

/**
 * 背景： 学习ClassLoader.getResource()时候不知道classLoader的边界，所以有必要把java类加载机制弄清楚
 * 
 * 了解SystemClassLoader,URIClassLoader，了解交互和边界机制。
 * 
 * @author lakala-shawn
 *
 */
public class ClassLoarderTest {

	/**
	 * 加载过程为：
	 * 
	 * 命令的时候，JVM会将HelloWorld.class加载到内存中，并形成一个Class的对象HelloWorld.class。
	 * 其中的过程就是类加载过程： 1、寻找jre目录，寻找jvm.dll，并初始化JVM； 2、产生一个Bootstrap
	 * Loader（启动类加载器）； 3、Bootstrap Loader自动加载Extended
	 * Loader（标准扩展类加载器），并将其父Loader设为Bootstrap Loader。 4、Bootstrap
	 * Loader自动加载AppClass Loader（系统类加载器），并将其父Loader设为Extended Loader。
	 * 5、最后由AppClass Loader加载HelloWorld类。
	 */
	/**
	 * 二、类加载器各自搜索的目录 为了弄清楚这个问题，首先还要看看System类的API doc文档。
	 * 
	 * 1、Bootstrap
	 * Loader（启动类加载器）：加载System.getProperty("sun.boot.class.path")所指定的路径或jar。<br>
	 * 2、Extended
	 * Loader（标准扩展类加载器ExtClassLoader）：加载System.getProperty("java.ext.dirs")所指定的路径或jar。在使用Java运行程序时，也可以指定其搜索路径，例如：java
	 * -Djava.ext.dirs=d:/projects/testproj/classes HelloWorld <br> 
	 * 3、AppClass
	 * Loader（系统类加载器AppClassLoader）：加载System.getProperty("java.class.path")所指定的路径或jar。在使用Java运行程序时，也可以加上-cp来覆盖原有的Classpath设置，例如：
	 * java -cp ./lavasoft/classes HelloWorld
	 * ExtClassLoader和AppClassLoader在JVM启动后，会在JVM中保存一份，并且在程序运行中无法改变其搜索路径。如果想在运行时从其他搜索路径加载类，就要产生新的类加载器。
	 * 
	 * @param args
	 */
	@Test
	public void testClassLoaderLevel() {
		ClassLoarderTest hello = new ClassLoarderTest();
		Class c = hello.getClass();
		ClassLoader loader = c.getClassLoader();
		System.out.println("classLoader" + loader);
		System.out.println(loader+ ".getParent()=" + loader.getParent());
		System.out.println(loader.getParent()+".getParent()=" + loader.getParent().getParent());

		// classLoadersun.misc.Launcher$AppClassLoader@73d16e93
		// classLoader.getParent()=sun.misc.Launcher$ExtClassLoader@15db9742
		// classLoader.getParent().getParent()=null
		System.out.println("appclassLoader的加载器为：" + loader.getClass().getClassLoader());

		System.out.println("appclassLoader的loader.getSystemClassLoader()为：" + loader.getSystemClassLoader());
		// 系统类加载器为appClassLoader:appclassLoader的loader.getSystemClassLoader()为：sun.misc.Launcher$AppClassLoader@37a71e93

	}

	@Test
	public void testLoaderStyle() {
//		-- 参考：http://blog.csdn.net/wan368500/article/details/8215668
////		---运行失败 --需要整理
		String config = ClassLoarderTest.class.getPackage().getName().replace('.', '/') + "/rest-demo-consumer.xml";

		try {
			URL url;
			url = new URL("./");
			ClassLoader myloader = new URLClassLoader(new URL[] { url });
			Class c;
			c = myloader.loadClass("test.Test3");
			TestClassLoder t3 = (TestClassLoder) c.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

	}

}
