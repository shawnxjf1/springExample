package com.lakala.soa.examples.async;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.lakala.soa.examples.async.api.AsyncService;

/**
 * AsyncConsumer
 * 
 * @author michael.yc
 */
public class AsyncConsumer {
	public static void main(String[] args) throws Exception {
        String config = AsyncConsumer.class.getPackage().getName().replace('.', '/') + "/async-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        
        final AsyncService asyncService = (AsyncService)context.getBean("asyncService");
     
        System.out.println(asyncService.sayAsyncHello("yc"));
        
        //从RpcContext中获取存在的最新的future对象
        //fooService.findFoo(fooId); // 此调用会立即返回null
       // Future<Foo> fooFuture = RpcContext.getContext().getFuture(); // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future。
        
      //  barService.findBar(barId); // 此调用会立即返回null
       // Future<Bar> barFuture = RpcContext.getContext().getFuture(); // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future。
         
        // 此时findFoo和findBar的请求同时在执行，客户端不需要启动多线程来支持并行，而是借助NIO的非阻塞完成。
         
     //   Foo foo = fooFuture.get(); // 如果foo已返回，直接拿到返回值，否则线程wait住，等待foo返回后，线程会被notify唤醒。
      //  Bar bar = barFuture.get(); // 同理等待bar返回。
        
        // 异步执行对象通过接口传到RpcContext中，返回future对象
        Future<String> f = RpcContext.getContext().asyncCall(new Callable<String>() {
            public String call() throws Exception {
                return asyncService.sayAsyncHello("async call request");
            }
        });
        System.out.println("async call ret :" + f.get());
        
        //不需要得到返回值
        RpcContext.getContext().asyncCall(new Runnable() {
            public void run() {
             //   System.out.println(asyncService.sayAsyncHello("oneway call request1"));
                asyncService.sayAsyncHello("oneway call request2");
            }
        });
        
        System.in.read();
    }

}
