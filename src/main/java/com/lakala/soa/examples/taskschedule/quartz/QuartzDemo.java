/**
 * Project Name:soa-test
 * File Name:SimpleDemo.java
 * Package Name:com.lakala.soa.examples.taskschedule.quartz
 * Date:2015年11月26日下午3:35:56
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.taskschedule.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

import com.lakala.soa.examples.taskschedule.CustomJob;

import static org.quartz.JobBuilder.newJob;  
import static org.quartz.TriggerBuilder.newTrigger;  
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * ClassName:SimpleDemo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年11月26日 下午3:35:56 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class QuartzDemo {

	public static void main(String[] args) throws Exception {
		
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

		Scheduler sched = schedFact.getScheduler();

		sched.start();

		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(CustomJob.class)
				.withIdentity("myJob", "group1")
				.build();

		// Trigger the job to run now, and then every 5 seconds
		Trigger trigger = newTrigger()
				.withIdentity("myTrigger", "group12")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(5)
						.repeatForever())
						.build();

		// Tell quartz to schedule the job using our trigger
		sched.scheduleJob(job, trigger);
	}
}
