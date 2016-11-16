package com.person.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

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

	}
	
}
