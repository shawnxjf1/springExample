package com.person.io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试场景：<br>
 * 2016-11-16:1. 在datamigration工程下执行mvn clean package(pom.xml添加了maven-shade-plugin插件生成 fat jar)<br>
 * 2.把datamigration-fat.jar copy到linux服务器上.<br>
 * 3.linux 上文件层次必须如下(虽然jar包里包含jdbc.properties， java -jar ./datamigration-0.0.1-SNAPSHOT-fat.jar 读取不到jar包里的properties文件。)：
 *   ./datamigration-fat.jar
 *   ./jdbc.properties
 *   ./log4j.properties <br>
 * 
 * 属性 工具操作类
 * @author lakala-shawn
 */
public class PropertiesUtil {
	static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

	static final String CONFIG_FILE = "conf/dataMigration.properties";

	static Properties memProperties = null;

	/**
	 * 通过key获取配置值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String getProperty(String key) throws Exception {
		return getProperty(key, null);
	}
	
	public static String getProperty(String key, String defaultVl) throws Exception {
		if (null == memProperties) {
			logger.info("The memProperties is empty ,read properties from " + CONFIG_FILE);
			memProperties = loadPropertiesFromFile(null);
		}
		
		String value = memProperties.getProperty(key, defaultVl);
		if (null == value) {
			String info = "Cannot get valid value for the key:" + key + " from file " + CONFIG_FILE;
			throw new Exception(info);
		}  
		return value;
	}

	/**
	 * 读取配置文件:
	 * @param fileName:配置文件名称
	 * @return
	 */
	protected static Properties loadPropertiesFromFile(String fileName) throws Exception {
		if (fileName == null || fileName.isEmpty()) {
			fileName = CONFIG_FILE;
		}

		memProperties = new Properties();
		FileInputStream in = null;
		try {
			
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			
			logger.info("====0.classLoader====");
			InputStream inputStream = classLoader.getResourceAsStream(fileName);
			
			if (inputStream == null)
			{
				logger.info("====1.class====");
				inputStream = PropertiesUtil.class.getResourceAsStream(fileName);
			}
			if (inputStream == null)
			{
				logger.info("====2.getClassLoader====");
				inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
			}
			if (inputStream == null)
			{
				logger.info("====3.newFile====");
				
				String localPath = new PropertiesUtil().getClass().getClassLoader().getResource(".").getPath();
				int idx = localPath.indexOf(":") + 1;
				localPath = localPath.substring(idx);
				logger.info("loadPropertiesFromFile, the target file path : " + localPath);
				//2016-11-16日志输出: loadPropertiesFromFile, the target file path : /home/hadoop/xjftestDatamigration/
				String filePathName = localPath + fileName;
				inputStream = new FileInputStream(filePathName);
			}
			memProperties.load(inputStream);
		} catch (Exception ex) {
			logger.error("Error occured when reading the properties file：" + fileName, ex);
			throw ex;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ex) {
					//
				}
				in = null;
			}
		}
		return memProperties;
	}
}