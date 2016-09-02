package com.lakala.soa.examples.eventnotify;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lakala.soa.examples.eventnotify.api.IDemoService;

/**
 * Consumer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class Consumer {
	public static void main(String []args) {
		String config = Consumer.class.getPackage().getName().replace('.', '/') + "/eventnotify-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        
        IDemoService demoService = (IDemoService)context.getBean("s");
        demoService.getCalcResult(1);
        demoService.getCalcResult(0);
	}
}