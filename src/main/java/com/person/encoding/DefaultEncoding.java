package com.person.encoding;

import java.nio.charset.Charset;

import org.apache.log4j.Logger;

public class DefaultEncoding {
	static Logger logger = Logger.getLogger(DefaultEncoding.class);

	public static void main(String[] args) {

		// 方法一：中文操作系统中打印GBK
		logger.info("fiel.encoding=" + System.getProperty("file.encoding"));

		// 方法二：中文操作系统中打印GBK
		logger.info("Charset.defaultCharset()=" + Charset.defaultCharset());
	}

}
