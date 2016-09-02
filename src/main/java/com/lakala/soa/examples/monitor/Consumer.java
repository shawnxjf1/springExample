package com.lakala.soa.examples.monitor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lakala.soa.examples.monitor.api.IDemoService;

/**
 * ClassName:Consumer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月31日 下午6:11:22 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class Consumer {
	public static void main(String []args) {
		String config = Consumer.class.getPackage().getName().replace('.', '/') + "/consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        
        IDemoService demoService = (IDemoService)context.getBean("demoService");
        String hello = demoService.sayHello("world"); 
        System.out.println( hello ); 
        
	}
}