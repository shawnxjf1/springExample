package com.person.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 注意该类的测试用例 index元数据来源于：testInitData()里<br>
 * city的元数据说明：shanghai 1  4  7  | shenzhen2 5 8  | beijng3 6 9
 * 
 * 要测试的例子描述：<br>
 * 1.复杂表达式测试 + 里面带有定位索引字段且可以定位索引字段位于2层以下的例子。<br>
 * 2.复杂表达式的场景有>,>=,<=,[],!=都有<br>
 */
/**
 * 1. data prepare : add to database
 * 2. write expression
 * 3. parse expression
 * 4. output indices 
 * 		context.getTargetIndices();
 * 		context.getTargetIndexType();
 * 
 * no need to submit search to ES 
 * 
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/test/applicationContext.xml")
public class TestIndexLocation {
	
	
	
	/**
	 * 2016-10-21 测试通过<br>
	 * @throws Exception 
	 */
	@Test
	public void testIndexLocate() throws Exception
	{
		
	}
}
