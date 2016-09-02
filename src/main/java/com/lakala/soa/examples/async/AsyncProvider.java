package com.lakala.soa.examples.async;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AsyncProvider
 * 
 * @author michael.yc
 */
public class AsyncProvider {
	public static void main(String []args) throws IOException {
		String config = AsyncProvider.class.getPackage().getName().replace('.', '/') + "/async-provider.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
		context.start();
		System.in.read();
	}
}
