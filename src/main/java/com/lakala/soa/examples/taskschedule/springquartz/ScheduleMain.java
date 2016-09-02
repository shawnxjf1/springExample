package com.lakala.soa.examples.taskschedule.springquartz;

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
		
		String jobType = "/quartz2.xml";
		if (!(null == args[0]) && ! "".equals(args[0]) ) {
			jobType = args[0];
			System.out.println(args[0]);
		}
		
		String config = ScheduleMain.class.getPackage().getName().replace('.', '/') + jobType;
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
	}
}