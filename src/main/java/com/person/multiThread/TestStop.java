package com.person.multiThread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TestStop {
	/**
	 * 数组设置大一些，这样调用t.stop()的时刻 thread t 还在执行
	 */
	private static final int[] array = new int[80000];
	private static final Thread t = new Thread("stop_test_thread") {
		@Override
		public void run() {
			try {
				System.out.println(sort(array));
			} catch (Error err) {
				err.printStackTrace();
			}
			System.out.println("in thread stop_test_thread run()method.");
		}
	};

	static {
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(i + 1);
		}
	}

	private static int sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println("do sort in thead,threadname= " + Thread.currentThread().getName());
		return array[0];
	}

	public static void stopMock() throws Exception {

		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("go to stop thread t");
		t.stop();
		System.out.println("finish stopMock().");
	}

	@Test
	public void testStop() {
		try {
			stopMock();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// go to stop thread t
		// finish stopMock().
		// java.lang.ThreadDeath
		// at java.lang.Thread.stop(Thread.java:850)
		// at com.person.multiThread.TestStop.stopMock(TestStop.java:51)
		// at com.person.multiThread.TestStop.testStop(TestStop.java:58)
		// ...
		// in thread stop_test_thread run()method.

	}
}