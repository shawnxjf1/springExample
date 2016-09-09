package com.person.multiThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * 该代码展示如何杀掉一个线程
 * 
 * @author lakala-shawn
 *
 */
@Service
public class ThreadKillService implements InitializingBean, DisposableBean {

	Logger logger = LoggerFactory.getLogger(ThreadKillService.class);

	/**
	 * 单位为分钟
	 */
	final int RULE_UPDATE_INTERVAL = 5;

	private Thread t = null;

	boolean threadRuningFlag = true;

	@Override
	public void afterPropertiesSet() throws Exception {

		t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					long curThreadId = Thread.currentThread().getId();
					logger.info("enter the sync Cache thread,for the threadId=" + curThreadId);
					while (threadRuningFlag) {
						// Do something
						logger.info(">>>>>>>>>>do something in while()>>>>>>>>>>>>>>>" + curThreadId);

						Thread.sleep(RULE_UPDATE_INTERVAL * 60 * 1000);
					}
					logger.info("exit the sync Cache thread,threadId=" + curThreadId);

				} catch (InterruptedException e) {
					logger.error("exception occur when afterPropertiesSet.run()", e);
				}
			}
		});
		t.start();
		// TODO
		// 启动另一个线程定时更新缓存
	}

	@Override
	public void destroy() throws Exception {

		// 销毁线程
		if (t != null) {
			/**
			 * [06/09/16 06:02:35:035 CST] Thread-0 INFO
			 * service.SearchRuleService: enter the sync Cache thread,for the
			 * threadId=12 [06/09/16 06:02:35:035 CST] Thread-0 INFO
			 * service.SearchRuleService: >>>>>>>>>>>>>>>>>>>>>>>>>12 [06/09/16
			 * 06:05:35:035 CST] main INFO service.SearchRuleService: setting
			 * threadRuningFlag = false
			 */
			/**
			 * 注释threadRuningFlag = false;，直接把t=null 通过垃圾回收直接回收也OK-测试通过
			 */
			threadRuningFlag = false;
			logger.info("setting  threadRuningFlag = false");
			t = null;
		}

	}

}
