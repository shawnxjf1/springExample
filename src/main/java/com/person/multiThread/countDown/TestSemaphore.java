package com.person.multiThread.countDown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 基本概念： Semaphore当前在多线程环境下被扩放使用，操作系统的信号量是个很重要的概念，在进程控制方面都有应用。Java 并发库
 * 的Semaphore 可以很轻松完成信号量控制，Semaphore可以控制某个资源可被同时访问的个数，通过 acquire()
 * 获取一个许可，如果没有就等待，而 release() 释放一个许可。 比如在Windows下可以设置共享文件的最大客户端访问个数。
 * 
 * @author shawn
 *
 */
public class TestSemaphore {


	public static void main(String[] args) {
		// 线程池
		ExecutorService exec = Executors.newCachedThreadPool();
		// 只能5个线程同时访问
		final Semaphore semp = new Semaphore(5);
		List<Runnable> runnableList = new ArrayList<Runnable>();
		// 模拟20个客户端访问
		for (int index = 0; index < 20; index++) {
			final int NO = index;
			Runnable run = new Runnable() {
				public void run() {
					try {
						long threadId = Thread.currentThread().getId();
						System.out.println("threadId=" + threadId + " begin acquire->semaphore availblePermits:" + semp.availablePermits());
						long beginTime =System.currentTimeMillis();
						// 获取许可
						semp.acquire();
						long endTime = System.currentTimeMillis();
						System.out.println("threadId=" + threadId + " acquire time =" + (endTime - beginTime));
						Thread.sleep((long) (5* 1000));
						// 访问完后，释放
						semp.release();
						System.out.println("threadId=" + threadId + " release-semaphore availblePermits:" + semp.availablePermits());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			runnableList.add(run);
		}
		for (int j=0;j< 20;j++)
		{
			exec.execute(runnableList.get(j));
		}
		// 退出线程池
		exec.shutdown();
		
		
		
//2016-11-27 从这里只能看到大体的趋势，比如 8,9, avaiblePermits  都是5，且8,9,10,11,12 acquire time=0 瞬间获取->因为5个数还够。
//		threadId=8 begin acquire->semaphore availblePermits:5
//				threadId=9 begin acquire->semaphore availblePermits:5
//				threadId=9 acquire time =0
//				threadId=8 acquire time =0
//				threadId=10 begin acquire->semaphore availblePermits:3
//				threadId=10 acquire time =0
//				threadId=11 begin acquire->semaphore availblePermits:3
//				threadId=11 acquire time =0
//				threadId=12 begin acquire->semaphore availblePermits:1
//				threadId=12 acquire time =0
//				threadId=13 begin acquire->semaphore availblePermits:0
//				threadId=14 begin acquire->semaphore availblePermits:0
//				threadId=15 begin acquire->semaphore availblePermits:0
//				threadId=16 begin acquire->semaphore availblePermits:0
//				threadId=17 begin acquire->semaphore availblePermits:0
//				threadId=18 begin acquire->semaphore availblePermits:0
//				threadId=19 begin acquire->semaphore availblePermits:0
//				threadId=20 begin acquire->semaphore availblePermits:0
//				threadId=21 begin acquire->semaphore availblePermits:0
//				threadId=22 begin acquire->semaphore availblePermits:0
//				threadId=23 begin acquire->semaphore availblePermits:0
//				threadId=24 begin acquire->semaphore availblePermits:0
//				threadId=25 begin acquire->semaphore availblePermits:0
//				threadId=26 begin acquire->semaphore availblePermits:0
//				threadId=27 begin acquire->semaphore availblePermits:0
//				threadId=8 release-semaphore availblePermits:2
//				threadId=11 release-semaphore availblePermits:4
//				threadId=12 release-semaphore availblePermits:5
//				threadId=13 acquire time =5003
//				threadId=10 release-semaphore availblePermits:3
//				threadId=15 acquire time =5002
//				threadId=9 release-semaphore availblePermits:2
//				threadId=17 acquire time =5002
//				threadId=16 acquire time =5002
//				threadId=14 acquire time =5003
//				threadId=13 release-semaphore availblePermits:2
//				threadId=17 release-semaphore availblePermits:3
//				threadId=16 release-semaphore availblePermits:4
//				threadId=18 acquire time =10004
//				threadId=15 release-semaphore availblePermits:2
//				threadId=19 acquire time =10004
//				threadId=14 release-semaphore availblePermits:5
//				threadId=21 acquire time =10003
//				threadId=22 acquire time =10003
//				threadId=20 acquire time =10004
//				threadId=19 release-semaphore availblePermits:3
//				threadId=20 release-semaphore availblePermits:5
//				threadId=23 acquire time =15007
//				threadId=24 acquire time =15007
//				threadId=22 release-semaphore availblePermits:5
//				threadId=21 release-semaphore availblePermits:3
//				threadId=18 release-semaphore availblePermits:3
//				threadId=27 acquire time =15007
//				threadId=26 acquire time =15007
//				threadId=25 acquire time =15007
//				threadId=27 release-semaphore availblePermits:3
//				threadId=26 release-semaphore availblePermits:5
//				threadId=25 release-semaphore availblePermits:5
//				threadId=24 release-semaphore availblePermits:3
//				threadId=23 release-semaphore availblePermits:3

	}
}
