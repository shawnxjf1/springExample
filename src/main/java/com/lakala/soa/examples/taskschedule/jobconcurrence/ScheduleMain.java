package com.lakala.soa.examples.taskschedule.jobconcurrence;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * ClassName:ScheduleMain <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class ScheduleMain {
	public static void main(String []args) {
		
		String config = ScheduleMain.class.getPackage().getName().replace('.', '/') + "/quartz.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
	}
}