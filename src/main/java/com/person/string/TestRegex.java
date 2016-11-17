package com.person.string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.support.PrintUtil;

public class TestRegex {
	static Pattern ptBetween = Pattern.compile("(\\s*)[+|\\s+](\\s*)[T|t][O|o](\\s*)[\\s+|+](\\s*)"); // [+|\\s*]
	static Pattern ptComm = Pattern.compile("(\\s*)[*](\\s*)");

	@Test
	public void test() {
		String expression = "[20150902000000 TO 20150929000000]";
		Matcher mt = ptBetween.matcher(expression);
		// mt.matches() 匹配 ; find 正则串
		// min node : matcher.group() ; matcher.start() ; matcher.end()
		String minVl = expression.substring(1, mt.start()); // [|{
		String maxV1 = expression.substring(mt.end());
		System.out.println(String.format("minV1=%s and maxV1= %s", minVl, maxV1));
	}

	@Test
	public void test1() {
		String expression = " * ";
		Matcher mt = ptBetween.matcher(expression);
	}
	
	/**
	 * Capturing groups are a way to treat multiple characters as a single unit. They are created by placing the characters to be grouped inside a set of parentheses. For example, the regular expression (dog) creates a single group containing the letters "d", "o", and "g".
	 */
	@Test
	public void testCaptureGroup()
	{
		// String to be scanned to find the pattern.
	      String line = "This order was placed for QT3000! OK?";
	      String pattern = "(.*)(\\d+)(.*)";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(line);
	      if (m.find( )) {
	    	 System.out.println("group() Found value: " + m.group() );
	         System.out.println("group(0) Found value: " + m.group(0) );
	         System.out.println("group(1)Found value: " + m.group(1) );
	         System.out.println("group(2) Found value: " + m.group(2) );
	      }else {
	         System.out.println("NO MATCH");
	      }
	   }
	
	/**
	 * 测试贪婪匹配<br>
	 * 参考:http://blog.csdn.net/lxcnn/article/details/4756030 <br>
	 * 2016-11-17：注意必须要调用g.find(),不然g.group()不会输出<br>
	 */
	@Test
	public void testGreedMatch() {
		String sourceStr = "aa<div>test1</div>bb<div>test2</div>cc";
		String greedPattern = "<div>.*</div>";
		String noGreedPattern = "<div>.*?</div>";// 匹配优先量词后加上“?”，即变成属于非贪婪模式的量词，也叫做忽略优先量词
		Pattern greedR = Pattern.compile(greedPattern);
		//greedR.pattern() 为 <div>.*</div>
		Pattern noGreedR = Pattern.compile(noGreedPattern);

		Matcher g = greedR.matcher(sourceStr);
		if (g.find()) {
			System.out.println(g.group());
		}
		/**
		 * 2016-11-16： notepad++ 里测过，返回结果为：<div>test1</div>bb<div>test2</div>
		 */

		Matcher ng = noGreedR.matcher(sourceStr);
		System.out.println("groupCount="+ng.groupCount());
		if (ng.find()) {
			System.out.println("group =" + ng.group());
			for (int i = 0; i < ng.groupCount(); i++) {
				System.out.println("group" + i + "=" + ng.group(i));
			}
		}
		/**
		 * 2016-11-16: notepad++里测过，返回两个：<div>test1</div> , <div>test2</div>
		 */
		
		/**
		 * 2016-11-17输出： 
		 * 1.FIXME groupCount=0 为什么还有输出呢？ 
		 * 2.<div>test1</div>bb
		 * <div>test2</div> groupCount=0 group =<div>test1</div>
		 */
		
		/**
		 * 调试find() find为调用一次往前查找一次：
		 * 1).第一次调用ng.find()之前first=0，to=30调用完ng.find()之后first=2,last=18<br>
		 * 注意：a.sourceStr = "aa<div>test1</div>bb<div>test2</div>cc"; 的aa<div的<索引为2<br>
		 * b.len("aa<div>test1</div>") = 18，ng.find()匹配了第一个.
		 * 
		 * 2).第二次调用first=20,last =36 。
		 */

	}
	
	/**
	 * String.split()调用的就是该方法<br>
	 */
	@Test
	public void testPattern()
	{
		Pattern p = Pattern.compile("\\d+");
		String [] strs= p.split("123abc456def");
		System.out.println(Arrays.asList(strs));
		/**
		 * 2016-11-17 输出结果：[, abc, def]<br>
		 */
		
		System.out.println(Pattern.matches("\\d+","2223"));//返回true 
		System.out.println(Pattern.matches("\\d+","2223aa"));//返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到 
		System.out.println(Pattern.matches("\\d+","22bb23"));//返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到
		/**
		 * true
         * false
         * false
		 */
	}
	
	/**
	 * REVIEW  
	 * 匹配操作：
	 * Matcher类提供三个匹配操作方法,三个方法均返回boolean类型,当匹配到时返回true,没匹配到则返回false 
     * matches()对整个字符串进行匹配,只有整个字符串都匹配了才返回true ，
     * lookAt只能从前面开始查找，
     * find()可以从任意位置查找
	 */
	
	/**
	 * lookAt 必须从开始位置查找
	 */
	@Test
	public void testLookAt()
	{
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher("aa123");
		PrintUtil.SysOut("lookingAt=", m.lookingAt());
		/**
		 * 2016-11-17：lookingAt=false
		 */
	}
	
	@Test
	public void testMatches()
	{
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher("aa123");
		PrintUtil.SysOut("matches=", m.matches());
		/**
		 * 2016-11-17：matches=false<br>
		 */
	}
	
	/**
	 * Mathcer.start()/ Matcher.end()/ Matcher.group()
                 当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用以上三个方法得到更详细的信息. 
       start()返回匹配到的子字符串在字符串中的索引位置. 
       end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置. 
       group()返回匹配到的子字符串 
	 */
	@Test
	public void testStartEndGroup()
	{
		Pattern p=Pattern.compile("\\d+"); 
		Matcher m=p.matcher("aaa2223bb"); 
		boolean findFlag= m.find();//匹配2223 
		m.start();//返回3 
		m.end();//返回7,返回的是2223后的索引号 
		m.group();//返回2223  -> 返回本次查找所匹配到的
		PrintUtil.SysOutArr("find,start,end,group=",findFlag,m.start(),m.end(),m.group());
		
		Matcher m2=p.matcher("2223bb"); 
		boolean lookingAtFlag = m.lookingAt();   //匹配2223 
		m2.start();   //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0 
		m2.end();   //返回4 
		m2.group();   //返回2223 
		PrintUtil.SysOutArr("lookingAt,start,end,group=",lookingAtFlag,m2.start(),m2.end(),m2.group());

		Matcher m3=p.matcher("2223bb"); 
		boolean matchesFlag = m.matches();
		m3.start();   //返回0,原因相信大家也清楚了 
		m3.end();   //返回6,原因相信大家也清楚了,因为matches()需要匹配所有字符串 
		m3.group();   //返回2223bb 
		PrintUtil.SysOutArr("matches,start,end,group=",matchesFlag,m3.start(),m3.end(),m3.group());
	}
	
	
}
