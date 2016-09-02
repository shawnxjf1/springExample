/**
 * Project Name:soa-test
 * File Name:CustomJob.java
 * Package Name:com.lakala.soa.examples.taskschedule.quartz
 * Date:2015年11月26日上午11:58:02
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.taskschedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * ClassName:CustomJob <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年11月26日 上午11:58:02 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class CustomJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
	
		String jobName = arg0.getJobDetail().getKey().getName();
		
		// 任务执行的时间  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒");  
        String jobRunTime = dateFormat.format(Calendar.getInstance().getTime());  
          
        // 输出任务执行情况  
        System.out.println("任务 : " + jobName + " 在  " +jobRunTime + " 执行了 ");  
        
//		System.err.println("Task start ... Do whatever you want : " + new Date());
	}

}
