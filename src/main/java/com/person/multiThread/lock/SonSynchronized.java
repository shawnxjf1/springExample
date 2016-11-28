package com.person.multiThread.lock;

/**
 * 这段代码说明一个问题 synchronized 是可重入的<br>
 * @author shawn
 *
 */
public class SonSynchronized extends FatherSynchronized{
	
	public synchronized void doSomething()
	{
		super.doSomething();
		System.out.println("son do something");
	}
	
	public static void main(String[] args) {
		SonSynchronized son = new SonSynchronized();
		son.doSomething();
		/**
		 * 2016年11月27日 执行结果:说明获取锁的粒度是线程而不是调用<br>
		 * father do something
		 * son do something
		 */
	}

}
