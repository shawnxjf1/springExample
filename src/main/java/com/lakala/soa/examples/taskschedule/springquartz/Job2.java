/**
 * Project Name:soa-test
 * File Name:Job2.java
 * Package Name:com.lakala.soa.examples.taskschedule.springquartz
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.taskschedule.springquartz;

import java.util.Date;

/**
 * ClassName:Job2 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class Job2 {

	private static int i = 0;  
	  
	public void doJob2() throws InterruptedException {  
		
//		Thread.sleep(5000);
		
	    System.out.println("不继承QuartzJobBean方式-调度" + ++i + "进行中...");  
	    System.err.println(Thread.currentThread().getName() + " >>> " + System.currentTimeMillis());
	    
	} 
}
