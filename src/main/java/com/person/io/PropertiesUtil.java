package com.person.io;

import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 属性 工具操作类
 * 
 * 2016-09-01
 * 
 * @author lakala-shawn
 */
public class PropertiesUtil {
	static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

	static final String CONFIG_FILE = "datamigration.properties";

	static Properties memProperties = null;

	/**
	 * 通过key获取配置值
	 * 
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
	 * 读取配置文件
	 * 
	 * @param fileName:配置文件名称
	 * @return
	 */
	protected static Properties loadPropertiesFromFile(String fileName) throws Exception {
		if (fileName == null || fileName.isEmpty()) {
			fileName = CONFIG_FILE;
		}
		String localPath = ClassLoader.getSystemResource(CONFIG_FILE).toString();
		int fileKeyWordIndex = localPath.indexOf(":") + 1;
		localPath = localPath.substring(fileKeyWordIndex);
		logger.info("loadPropertiesFromFile, the target file path : " + localPath);

		memProperties = new Properties();
		FileInputStream in = null;
		try {
			in = new FileInputStream(localPath);
			memProperties.load(in);
		} catch (Exception ex) {
			logger.error("Error occured when reading the properties file：" + localPath, ex);
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

	public static void main(String[] args) throws Exception {
		loadPropertiesFromFile(null);
	}

}
