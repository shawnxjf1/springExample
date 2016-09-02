/**
 * Project Name:soa-test
 * File Name:SimpleTriggerDemo.java
 * Package Name:com.lakala.soa.examples.taskschedule.quartz
 * Date:2015年11月26日下午4:10:08
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.taskschedule.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.lakala.soa.examples.taskschedule.CustomJob;
	
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


//	    文件加载位置
//	              默认：优先顺序 Classpath:quartz.properties --> org/quartz/quartz.properties (quartz lib)
//	    改变默认：设置一个系统属性"org.quartz.properties"指向对应的properties文件
//	              程序中显示指定
//	            在StdSchedulerFactory.getScheduler()之前使用StdSchedulerFactory.initialize(xx)
	
		// Create the properties to configure the factory  
        Properties props = new Properties(); 
        // required to supply threadpool class and num of threads
        props.put(StdSchedulerFactory.PROP_THREAD_POOL_CLASS,"org.quartz.simpl.SimpleThreadPool");  
        props.put("org.quartz.threadPool.threadCount", "10");   
        schedFact.initialize(props);  
        
		Scheduler sched = schedFact.getScheduler();

		sched.start();

		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(CustomJob.class)
				.withIdentity("myJob", "group1")
				.build();

		Trigger trigger;
		
		// define exact start time
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date startTime = df.parse("2015/11/30 16:00:00");
		
		//	指定时间开始触发，不重复：
		trigger = (SimpleTrigger) newTrigger() 
				.withIdentity("trigger1", "group1")
				.startAt(startTime)                        // some Date 
				.forJob("myJob", "group1")                 // identify job with name, group strings
				.build();
		
		
		//	指定时间触发，每隔10秒执行一次，重复10次：
		/*trigger = newTrigger()
		        .withIdentity("trigger1", "group1")
		        .startAt(startTime)  // if a start time is not given (if this line were omitted), "now" is implied
		        .withSchedule(simpleSchedule()
		            .withIntervalInSeconds(10)
		            .withMisfireHandlingInstructionFireNow()  //misfire
		            .withRepeatCount(10)) // note that 10 repeats will give a total of 11 firings
		        .forJob("myJob", "group1") // identify job with handle to its JobDetail itself                   
		        .build();*/
		
		//	1分钟以后开始触发，仅执行一次：
		/*trigger = (SimpleTrigger) newTrigger() 
		        .withIdentity("trigger1", "group1")
		        .startAt(DateBuilder.futureDate(5, IntervalUnit.MINUTE)) // use DateBuilder to create a date in the future
		        .forJob("myJob", "group1") // identify job with its JobKey
		        .build();*/
		
		// 立即触发，每个5分钟执行一次，直到22:00：
		/*SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date endTime = df2.parse("2015/11/26 16:45:01");
		
		trigger = newTrigger()
		        .withIdentity("trigger1", "group1")
		        .withSchedule(simpleSchedule()
		            .withIntervalInMinutes(5)
		            .repeatForever())
		        .endAt(endTime)
		        .build();*/
		
		//  在下一小时整点触发，每个2小时执行一次，一直重复：
		/*trigger = newTrigger()
		        .withIdentity("trigger1") 
		        .startAt(DateBuilder.evenHourDate(null)) // get the next even-hour (minutes and seconds zero ("00:00"))
		        .withSchedule(simpleSchedule()
		            .withIntervalInHours(2)
		            .repeatForever())
		        // note that in this example, 'forJob(..)' is not called which is valid 
		        // if the trigger is passed to the scheduler along with the job  
		        .build();*/
		
		
		

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
