/**
 * Project Name:soa-test
 * File Name:TimerDemo.java
 * Package Name:com.lakala.soa.examples.taskschedule
 * Date:2015年11月26日上午9:43:36
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
 */

package com.lakala.soa.examples.taskschedule.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.lakala.soa.examples.taskschedule.CustomTimerTask;

/**
 * ClassName:TimerDemo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月26日 上午9:43:36 <br/>
 * 
 * @author tent
 * @version
 * @since JDK 1.7
 * @see
 */
public class TimerDemo {

	// when there is so many Timer, some Timer will be delay, cause Timer was be put in TimerThread(TaskQueue) object
	
	public static void main(String[] args) throws Exception {
		
		// 1.schedule(TimerTask task, long delay)
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {

				CustomTimerTask.start();
			}
		}, 2000);
		
		// 2.schedule(TimerTask task, long delay, long period)
		/*new Timer().schedule(new TimerTask() {

			@Override
			public void run() {

				CustomTimerTask.start();
			}
		},1000, 2000);*/

		// 3.schedule(TimerTask task, Date time)
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = df.parse("2015/11/03 16:19:40");
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				CustomTimerTask.start();
			}
		}, date);*/
		
		// 4.schedule(TimerTask task, Date firstTime, long period)
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = df.parse("2015/11/26 12:00:00");
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				CustomTimerTask.start();
			}
		}, date, 16 * 60 * 60 * 1000);*/
		
		// --------------------------print current time------------------------------------------------
		while (true) {
			
			Date now = new Date();
			String currentTime = " "  + now.getHours() + now.getMinutes() + now.getSeconds();
			System.out.println(currentTime);
			Thread.currentThread().sleep(1000);
		}
		
	}
}
