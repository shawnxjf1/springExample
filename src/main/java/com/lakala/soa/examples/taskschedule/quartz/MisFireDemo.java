/**
 * Project Name:soa-test
 * File Name:MissFireDemo.java
 * Package Name:com.lakala.soa.examples.taskschedule.quartz
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.taskschedule.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.File;
import java.io.FileFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;

import com.lakala.soa.examples.taskschedule.CustomJob;

/**
 * ClassName:MissFireDemo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class MisFireDemo {

//	 在 Quartz 应用中，misfired job 是经常遇到的情况。一般来说，下面这些原因可能造成 misfired job：
//
//	 1）系统因为某些原因被重启。在系统关闭到重新启动之间的一段时间里，可能有些任务会被 misfire；
//
//	 2）Trigger 被暂停（suspend）的一段时间里，有些任务可能会被 misfire；
//
//	 3）线程池中所有线程都被占用，导致任务无法被触发执行，造成 misfire；
//
//	 4）有状态任务在下次触发时间到达时，上次执行还没有结束；
//
//	 为了处理 misfired job，Quartz 中为 trigger 定义了处理策略，主要有下面两种：
//
//	 MISFIRE_INSTRUCTION_FIRE_ONCE_NOW：针对 misfired job 马上执行一次；
//
//	 MISFIRE_INSTRUCTION_DO_NOTHING：忽略 misfired job，等待下次触发； 
	 
	public static void main(String[] args) throws SchedulerException, InterruptedException, ParseException {

		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

		Scheduler sched = schedFact.getScheduler();

		sched.start();

		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(CustomJob.class)
				.withIdentity("myJob", "group1")
				.build();

		Trigger trigger;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date startTime = df.parse("2015/11/30 19:45:00");
		
		trigger = (SimpleTrigger) newTrigger() 
		        .withIdentity("trigger1", "group1")
		        .startAt(startTime)                        // some Date 
		        .withSchedule(simpleSchedule()
			            .withIntervalInSeconds(30)
			            .withRepeatCount(5)
			            .withMisfireHandlingInstructionNextWithExistingCount())
		        .forJob("myJob", "group1")                 // identify job with name, group strings
		        .build();
		
		// Tell quartz to schedule the job using our trigger
		sched.scheduleJob(job, trigger);
		
	}

//	CronTrigger
//	default: withMisfireHandlingInstructionFireAndProceed
//
//	withMisfireHandlingInstructionFireAndProceed
//	——以当前时间为触发频率立刻触发一次执行
//	——然后按照Cron频率依次执行
//
//	withMisfireHandlingInstructionDoNothing
//	——不触发立即执行
//	——等待下次Cron触发频率到达时刻开始按照Cron频率依次执行
//
//	withMisfireHandlingInstructionIgnoreMisfires
//	——以错过的第一个频率时间立刻开始执行
//	——重做错过的所有频率周期后
//	——当下一次触发频率发生时间大于当前时间后，再按照正常的Cron频率依次执行
//
//
//
//
//	SimpleTrigger
//	default: withMisfireHandlingInstructionNowWithExistingCount
//
//	withMisfireHandlingInstructionFireNow
//	——以当前时间为触发频率立即触发执行
//	——执行至FinalTIme的剩余周期次数
//	——以调度或恢复调度的时刻为基准的周期频率，FinalTime根据剩余次数和当前时间计算得到
//	——调整后的FinalTime会略大于根据starttime计算的到的FinalTime值
//
//	withMisfireHandlingInstructionIgnoreMisfires
//	——以错过的第一个频率时间立刻开始执行
//	——重做错过的所有频率周期
//	——当下一次触发频率发生时间大于当前时间以后，按照Interval的依次执行剩下的频率
//	——共执行RepeatCount+1次
//
//	withMisfireHandlingInstructionNextWithExistingCount
//	——不触发立即执行
//	——等待下次触发频率周期时刻，执行至FinalTime的剩余周期次数
//	——以startTime为基准计算周期频率，并得到FinalTime
//	——即使中间出现pause，resume以后保持FinalTime时间不变
//
//	withMisfireHandlingInstructionNextWithRemainingCount
//	——不触发立即执行
//	——等待下次触发频率周期时刻，执行至FinalTime的剩余周期次数
//	——以startTime为基准计算周期频率，并得到FinalTime
//	——即使中间出现pause，resume以后保持FinalTime时间不变
//
//	----------------
//
//	withMisfireHandlingInstructionNowWithExistingCount
//	——以当前时间为触发频率立即触发执行
//	——执行至FinalTIme的剩余周期次数
//	——以调度或恢复调度的时刻为基准的周期频率，FinalTime根据剩余次数和当前时间计算得到
//	——调整后的FinalTime会略大于根据starttime计算的到的FinalTime值
//
//	withMisfireHandlingInstructionNowWithRemainingCount
//	——以当前时间为触发频率立即触发执行
//	——执行至FinalTIme的剩余周期次数
//	——以调度或恢复调度的时刻为基准的周期频率，FinalTime根据剩余次数和当前时间计算得到
//
//	——调整后的FinalTime会略大于根据starttime计算的到的FinalTime值
//
//	MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_REMAINING_REPEAT_COUNT
//	——此指令导致trigger忘记原始设置的starttime和repeat-count
//	——触发器的repeat-count将被设置为剩余的次数
//	——这样会导致后面无法获得原始设定的starttime和repeat-count值 
//
//	总结：
//	RemainingCount
//	withMisfireHandlingInstructionNowWithRemainingCount	now 	当前会执行一次
//	withMisfireHandlingInstructionNextWithRemainingCount	next	当前不会执行
//	执行次数：{总共次数 withRepeatCount() + 1（本身1次）} 减去 {miss 掉的 次数} 再加上 {now/next 的次数}
//
//	ExistingCount
//	withMisfireHandlingInstructionNowWithExistingCount	now 	当前会执行一次
//	执行次数：{总共次数 withRepeatCount() } 再加上 {now/next 的次数}
//	withMisfireHandlingInstructionNextWithExistingCount	next	当前不会执行
//	执行次数：{总共次数 withRepeatCount() + 1（本身1次）} 减去 {miss 掉的 次数}
}
