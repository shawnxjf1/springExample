package com.person.multiThread;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestSynchronized {
	Logger log = Logger.getLogger(TestSynchronized.class);

	/**
	 * synchronized 不能作用到null对象上
	 */
	private void testSynchronizeNull() {
		Object o = null;

		synchronized (o) {
			log.info("synchronized null");
		}
	}

	@Test
	public void TestSynchronizedNull() {
		testSynchronizeNull();
	}

}
