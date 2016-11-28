package com.person.multiThread.countDown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
   private static final int PlayerRunner_AMOUNT = 5;
   public CountDownLatchDemo() {
       // TODO Auto-generated constructor stub    
    }
   /**
    * @param args
    */
   public static void main(String[] args) {
       //对于每位运动员，CountDownLatch减1后即结束比赛
       CountDownLatch begin = new CountDownLatch(1);
       //对于整个比赛，所有运动员结束后才算结束
       CountDownLatch end = new CountDownLatch(PlayerRunner_AMOUNT);
       PlayerRunner[] plays = new PlayerRunner[PlayerRunner_AMOUNT];
       
       for(int i=0;i<PlayerRunner_AMOUNT;i++)
           plays[i] = new PlayerRunner(i+1,begin,end);
       
       //设置特定的线程池，大小为5
       ExecutorService exe = Executors.newFixedThreadPool(PlayerRunner_AMOUNT);
       for(PlayerRunner p:plays)
           exe.execute(p);            //分配线程
       System.out.println("Race begins!");
       begin.countDown();
       try{
           end.wait();            //等待end状态变为0,countDown 技术为0，即为比赛结束
       }catch (InterruptedException e) {
           e.printStackTrace();
       }finally{
           System.out.println("Race ends!");
       }
       exe.shutdown();
       /**
        * 2016年11月26日 执行结果为：<br>
        * Race begins!
Race ends!
Exception in thread "main" java.lang.IllegalMonitorStateException
	at java.lang.Object.wait(Native Method)
	at java.lang.Object.wait(Object.java:503)
	at com.person.multiThread.countDown.CountDownLatchDemo.main(CountDownLatchDemo.java:33)
Play5 arrived.
Play2 arrived.
Play3 arrived.
Play4 arrived.
Play1 arrived.
FIXME 在多线程并发编程实战里好像是有一个关口， IllegalMonitorStateException.
        */
   }
}