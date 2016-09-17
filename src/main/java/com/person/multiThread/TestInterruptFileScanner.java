package com.person.multiThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

/**
 * 参考：http://www.infoq.com/cn/articles/java-interrupt-mechanism
 * 1.中断的原理：当线程t1想中断线程t2，只需要在线程t1中将线程t2对象的中断标识置为true，然后线程2可以选择在合适的时候处理该中断请求，甚至可以不理会该请求，就像这个线程没有被中断一样。Java中断机制是一种协作机制，也就是说通过中断并不能直接终止另一个线程，而需要被中断的线程自己处理中断。这好比是家里的父母叮嘱在外的子女要注意身体，但子女是否注意身体，怎么注意身体则完全取决于自己。
 * 1.已有类库中的中断：类库中的有些类的方法也可能会调用中断，如FutureTask中的cancel方法，如果传入的参数为true，它将会在正在运行异步任务的线程上调用interrupt方法，如果正在执行的异步任务中的代码没有对中断做出响应，那么cancel方法中的参数将不会起到什么效果；又如ThreadPoolExecutor中的shutdownNow方法会遍历线程池中的工作线程并调用线程的interrupt方法来中断线程，所以如果工作线程中正在执行的任务没有对中断做出响应，任务将一直执行直到正常结束。
 * 2.终端的处理：处理时机决定着程序的效率与中断响应的灵敏性。频繁的检查中断状态可能会使程序执行效率下降，相反，检查的较少可能使中断请求得不到及时响应。如果发出中断请求之后，被中断的线程继续执行一段时间不会给系统带来灾难，那么就可以将中断处理放到方便检查中断，同时又能从一定程度上保证响应灵敏度的地方。当程序的性能指标比较关键时，可能需要建立一个测试模型来分析最佳的中断检测点，以平衡性能和响应灵敏性。
 * 
 * 
 * @author lakala-shawn
 *
 */
public class TestInterruptFileScanner {

	private static Logger log = Logger.getLogger(TestInterruptFileScanner.class);

	/*
	 * java.lang.Thread类中关于中断的方法：
	 * 
	 * public static boolean interrupted
	 * 
	 * 测试当前线程是否已经中断。线程的中断状态 由该方法<b>清除</b>。换句话说，如果连续两次调用该方法，则第二次调用将返回
	 * false（在第一次调用已清除了其中断状态之后，且第二次调用检验完中断状态前，当前线程再次中断的情况除外）。
	 * 
	 * public boolean isInterrupted()
	 * 
	 * 测试线程是否已经中断。线程的中断状态不受该方法的影响。
	 * 
	 * public void interrupt()
	 * 
	 * 中断线程。
	 */

	/**
	 * 扫描文件
	 * 
	 * @param f
	 * @throws InterruptedException
	 */
	private static void listFile(File f) throws InterruptedException {
		if (f == null) {
			throw new IllegalArgumentException();
		}
		// 如果是文件就不检测中断(对每个文件都检测中断会降低性能)
		if (f.isFile()) {
			System.out.println(f);// 打印出文件路劲
			return;
		}
		File[] allFiles = f.listFiles();
		// Thread.interrupted() 测试线程是否被中断，并且重置中断状态
		// Tests if some Thread has been interrupted. The interrupted state * is
		// reset
		if (Thread.interrupted()) {
			throw new InterruptedException("文件扫描任务被中断");
		}

		if (null == allFiles) {
			log.info("allFile is null");
			return;
		}
		for (File file : allFiles) {
			// 递归检测文件
			// 还可以将中断检测放到这里
			listFile(file);
		}
	}

	public static String readFromConsole() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static void main(String[] args) throws Exception {
		final Thread fileIteratorThread = new Thread("fileListThread") {
			@Override
			public void run() {
				try {
					listFile(new File("c:\\"));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		new Thread("interrupteManagerThread") {
			@Override
			public void run() {
				while (true) {
					if ("quit".equalsIgnoreCase(readFromConsole())) {
						if (fileIteratorThread.isAlive()) {

							fileIteratorThread.interrupt();
							return;
						}
					} else {
						System.out.println("输入quit退出文件扫描");
					}
				}
			}
		}.start();
		fileIteratorThread.start();
	}
}
