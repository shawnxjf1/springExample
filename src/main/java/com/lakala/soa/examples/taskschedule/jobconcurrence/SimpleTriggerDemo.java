/**
 * Project Name:soa-test
 * File Name:SimpleTriggerDemo.java
 * Package Name:com.lakala.soa.examples.taskschedule.quartz
 * Date:2015年11月26日下午4:10:08
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.taskschedule.jobconcurrence;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * ClassName:SimpleTriggerDemo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年11月26日 下午4:10:08 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class SimpleTriggerDemo {

public static void main(String[] args) throws Exception {
		
		StdSchedulerFactory schedFact = new StdSchedulerFactory();

		Scheduler sched = schedFact.getScheduler();

		sched.start();

		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(SerialJobUseImpStatefulJob.class)
				.withIdentity("myJob", "group1")
				.build();

		Trigger trigger;
		
		//	指定时间触发，每隔2秒执行一次，重复10次：
		trigger = newTrigger()
		        .withIdentity("trigger1", "group1")
		        .startNow()
		        .withSchedule(simpleSchedule()
		            .withIntervalInSeconds(2)
		            .withRepeatCount(10)) // note that 10 repeats will give a total of 11 firings
		        .forJob("myJob", "group1") // identify job with handle to its JobDetail itself                   
		        .build();
		

		// Tell quartz to schedule the job using our trigger
		sched.scheduleJob(job, trigger);
		
		// --------------------------print current time------------------------------------------------
		while (true) {
			Date now = new Date();
			String currentTime = " "  + now.getHours() + now.getMinutes() + now.getSeconds();
			System.out.println(currentTime);
			Thread.currentThread().sleep(1000);
		}
	}
}
