package com.lakala.soa.examples.rest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * ClassName:DemoConsumer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月31日 下午6:11:22 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class DemoConsumer {
	static ClassPathXmlApplicationContext context = null;
	
	public static void main(String[] args) {
		
		String config = DemoConsumer.class.getPackage().getName().replace('.', '/') + "/rest-demo-consumer.xml";
		context= new ClassPathXmlApplicationContext(config);
        context.start();
        
        ConsumerBean consumerBean = (ConsumerBean) context.getBean("consumerBean");
        consumerBean.start();
	}

}