package com.lakala.soa.examples.webservice;

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
	
	public static void main(String[] args) {
		
		String config = DemoConsumer.class.getPackage().getName().replace('.', '/') + "/webservice-demo-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        
        ConsumerBean consumerBean = (ConsumerBean) context.getBean("consumerBean");
        consumerBean.start();
	}

}