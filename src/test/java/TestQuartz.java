import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })	
public class TestQuartz {
	
	/**
	 * src/test/resources和 src/main/resources都有 spring/applicationContext.xml<br>
	 * 这个测试用例先加载src/test/resources 下的 spring/applicationContext.xml<br>
	 */
	@Test
	public void test1()
	{
		try {
			Thread.sleep(50000);
			System.out.println("2016-12-26 end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/**
		 * 2016-12-26报错<br>
		 * Caused by: java.lang.IncompatibleClassChangeError: class org.springframework.scheduling.quartz.CronTriggerBean has interface org.quartz.CronTrigger as super class
		 */
	}

}
