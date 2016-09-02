package com.lakala.soa.examples.monitor;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * ClassName:Provider <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月31日 下午6:11:22 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class Provider {
	public static void main(String []args) throws IOException {
		String config = Provider.class.getPackage().getName().replace('.', '/') + "/provider.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
	}
}