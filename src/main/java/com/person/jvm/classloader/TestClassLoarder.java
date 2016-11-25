package com.person.jvm.classloader;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * 背景： 学习ClassLoader.getResource()时候不知道classLoader的边界，所以有必要把java类加载机制弄清楚
 * 
 * 了解SystemClassLoader,URIClassLoader，了解交互和边界机制。
 * 
 * @author lakala-shawn
 *
 */
public class TestClassLoarder {
	Logger log = Logger.getLogger(TestClassLoarder.class);

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
		TestClassLoarder hello = new TestClassLoarder();
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
		String config = TestClassLoarder.class.getPackage().getName();
		try {
			URL url;
			url = new URL(config);
			ClassLoader myloader = new URLClassLoader(new URL[] { url });
			Class c = myloader.loadClass(config);
			System.out.println("c.className" + c.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

	}
	
	/**
	 * 写这个用例的初衷是由于datamigration系统想通过读取src/main/resource下的配置文件（在eclipse中正常但是在linux后台服务器确实不正常）
	 */
	@Test
	public void testClassLoaderGetResource()
	{
		String fileName  = ".";
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		/**
		 * getResouce()加载顺序为1.parent->getBootstrapResource->this.findResource
		 */
		log.info("current Class location=" + classLoader.getResource("."));
		/**
		 * 2016-11-16 执行输出结果如下（注意输出是带有/的）：
		 * window下：current Class location=file:/D:/eclipse_workgroup_github/J2seCodeExample/target/test-classes/
		 * linux下： /home/hadoop/xjftestDatamigration/
		*/
		
		InputStream inputStream = classLoader.getResourceAsStream(fileName);
		log.info("inputStream0=" + inputStream);
		
		//FIXME　getResourceAsStream() getSystemResource().
		inputStream = TestClassLoarder.class.getResourceAsStream(fileName);
		log.info("ClassLoarderTest.class" + TestClassLoarder.class.getResource("."));
		
		/**
		 * FIXME 
		 * 1. 为什么class.getResoure()是获取为class/com/person/jvm<br>
		 * 2. 为什么class.getClassLoader()获取的是test-class下，即时当前Test文件所处的位置。
		 *   等待下面执行结果：
		 */
		
		log.info("1.-> classLoader=" + TestClassLoarder.class.getClassLoader());
		log.info("2.-> class=" + TestClassLoarder.class);
		
		/**
		 * 2016-11-16输出：（输出当前class文件的路径）
		 * ClassLoarderTest.classfile:/D:/eclipse_workgroup_github/J2seCodeExample/target/classes/com/person/jvm/
		 */
		
		inputStream = TestClassLoarder.class.getClassLoader().getResourceAsStream(fileName);
		log.info("ClassLoarderTest.class.getClassLoader()=" + TestClassLoarder.class.getClassLoader().getResource("."));
		/**
		 * 2016-11-16输出：（输出的是test-classes）
		 * ClassLoarderTest.class.getClassLoader()=file:/D:/eclipse_workgroup_github/J2seCodeExample/target/test-classes/
		 */
		
		log.info("systemResource()=" + TestClassLoarder.class.getClassLoader().getSystemResource("."));
		/**
		 * 2016-11-16输出：
		 * systemResource()=file:/D:/eclipse_workgroup_github/J2seCodeExample/target/test-classes/
		 */
	}
	
	/**
	 * 
	 */
	@Test
	public void testPathClassLoaderWithOutClassPath()
	{
		String classPath = "/Users/shawn/eclipse_workspace_group/trunk_workspace/batch-trunk/batch-api/target/classes/";
		PathClassLoader pClassLoader = new PathClassLoader(classPath);
		String packageName = "com.youku.paycenter.batch.api.BatchIniApi";
		pClassLoader.setPackageName(packageName);
		try {
			Class<?> c = pClassLoader.loadClass(packageName);
			log.info("class name =" + c.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.error(e);
		}
		/**
		 * 2016-11-20处理的结果： class 为以前的batch文件由于不在classPath内部所以是用的自定义类加载器
		 */
//		2016-11-20 23:58:07,498 INFO  main com.person.jvm.classloader.PathClassLoader invoke findClass,name=com.youku.paycenter.batch.api.BatchIniApi
//				2016-11-20 23:58:07,499 INFO  main com.person.jvm.classloader.PathClassLoader path=/Users/shawn/eclipse_workspace_group/trunk_workspace/batch-trunk/batch-api/target/classes//com/youku/paycenter/batch/api/BatchIniApi.class
//				2016-11-20 23:58:07,500 INFO  main com.person.jvm.classloader.PathClassLoader load class with self
//				2016-11-20 23:58:07,500 INFO  main com.person.jvm.classloader.TestClassLoarder class name =com.youku.paycenter.batch.api.BatchIniApi

	}
	
	/**
	 * 
	 */
	@Test
	public void testPathClassLoaderWithClassPath()
	{
		String classPath = "/Users/shawn/eclipse_workspace_gits/J2seCodeExample/target/classes/";
		PathClassLoader pClassLoader = new PathClassLoader(classPath);
		String packageName = "com.person.jvm.classloader.TestClassLoarder";
		pClassLoader.setPackageName(packageName);
		try {
			Class<?> c = pClassLoader.loadClass(packageName);
			log.info("class name =" + c.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.error(e);
		}
		/**
		 * 2016-11-21 
		 *  1. 处理调用的是parent classLoarder
		 *  测试尝试：
		 *  2. <classpathentry excluding="**" kind="src" output="target/classes" path="src/main/resources">
                <attributes>
                        <attribute name="maven.pomderived" value="true"/>
                </attributes>
        </classpathentry>
           eclipse  没有包显示也测不下去
		 */
	}

}
