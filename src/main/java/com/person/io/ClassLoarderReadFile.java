package com.person.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 
 * @author lakala-shawn
 *
 */
public class ClassLoarderReadFile {

	private static final String log4jProperties = "log4j.properties";

	/**
	 * 测试OK
	 */
	public void readFileInClasspathDirectory() {
		try {

			ClassLoader classLoader = getClass().getClassLoader();
			/**
			 * getResource()方法会去classpath下找这个文件，获取到url resource,
			 * 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
			 */
			URL url = classLoader.getResource(log4jProperties);

			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(url.getFile());

			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			// 从这里inputStream 转换成readder
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				System.out.println(strLine);
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		new ClassLoarderReadFile().readFileInClasspathDirectory();
	}

}
