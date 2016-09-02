/**
 * Project Name:soa-test
 * File Name:Job1.java
 * Package Name:com.lakala.soa.examples.taskschedule.springquartz
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.taskschedule.springquartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean; 

/**
 * ClassName:Job1 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */

//QuartzJobBean 方式  得用  Quartz 1.8.x 以下版本
public class Job1 extends QuartzJobBean{

	private int timeout;  
	private static int i = 0;  
	  
	//调度工厂实例化后，经过timeout时间开始执行调度  
	public void setTimeout(int timeout) {  
	    this.timeout = timeout;  
	}  
	  
	/** 
	* 要调度的具体任务 
	*/  
	@Override  
	protected void executeInternal(JobExecutionContext context)  
	throws JobExecutionException {  
	  
	    System.out.println("继承QuartzJobBean的方式-调度" + ++i + "进行中...");  
	}  
}
