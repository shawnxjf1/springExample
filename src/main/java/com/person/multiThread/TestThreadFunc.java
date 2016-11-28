package com.person.multiThread;

import org.junit.Test;

public class TestThreadFunc {
	
	@Test
	public void testWithNoJoin()
	{
		System.out.println("begin create thread.");
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t1 executing...");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t2 executing...");
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t3 executing...");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		System.out.println("end thread start...");
		/**
		 * 2016年11月26日 运行结果：<br>
		 * begin create thread.
 t1 executing...
 t2 executing...
end thread start...
 t3 executing...
		 */
	}
	
	@Test
	public void testWithJoin()
	{
		System.out.println("begin create thread.");
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t1 executing...");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t2 executing...");
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t3 executing...");
			}
		});
		t1.start();
		t2.start();
		t3.start();
		
		try {
			//Waits for this thread to die.
			t2.join();
			t3.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end thread start...");
	}
	
	/**
	 * 2016年11月26日 执行结果：
	 * begin create thread.
 t1 executing...
 t2 executing...
 t3 executing...
end thread start...<br>
    注意不管join 的调用顺序如何，最终结果都是按照start顺序执行的

	 */


}
