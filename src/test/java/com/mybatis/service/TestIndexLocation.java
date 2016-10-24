package com.mybatis.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ContextConfiguration("classpath:/spring/applicationContext.xml")<br>
 * 注意这里重点要把main和test下applicationContext区分开来因为test和main的环境不一样。<br>
 * 案例:由于src/main/spring/applicationContext.xml有<soa>，使用此applicationContext.xml加载测试bean的话 @ContextConfiguration("classpath:/spring/applicationContext.xml")
 * //src/main下的context.xml 报如下错<br>
 * <code>java.lang.Exception: No tests found matching [{ExactMatcher:fDisplayName=testIndexNotEqu</code>
 * 解决办法：1.把spring-version：4.2.6改成了3.2.9<br>
 * 2.把test和main的applicationContext分开，src/test/applicationContext.xml里把<soa>标签去掉。<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/applicationContext.xml")
public class TestIndexLocation {

}
