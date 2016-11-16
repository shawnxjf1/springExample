package com.person.string;

import org.junit.Test;

/**
 * 正则匹配中涉及到3个类：pattern,matcher<br>
 * 1.Pattern.java : A compiled representation of a regular expression.<br>
 * 2.matcher.jva:engine, Matcher
 * 
 * An engine that performs match operations on a
 * {@linkplain java.lang.CharSequence character sequence} by interpreting a
 * {@link Pattern}.
 *
 * <p>
 * A matcher is created from a pattern by invoking the pattern's
 * {@link Pattern#matcher matcher} method. Once created, a matcher can be used
 * to perform three different kinds of match operations:
 *
 * <ul>
 *
 * <li>
 * <p>
 * The {@link #matches matches} method attempts to match the entire input
 * sequence against the pattern.
 * </p>
 * </li>
 *
 * <li>
 * <p>
 * The {@link #lookingAt lookingAt} method attempts to match the input sequence,
 * starting at the beginning, against the pattern.
 * </p>
 * </li>
 *
 * <li>
 * <p>
 * The {@link #find find} method scans the input sequence looking for the next
 * subsequence that matches the pattern.
 * </p>
 * </li>
 * 
 * @author lakala-shawn
 *
 */
public class RegexBasicConcept {

	/**
	 * 
	 * 正则表达式的() [] {}有不同的意思。 <br>
	 * () 是为了提取匹配的字符串。表达式中有几个()就有几个相应的匹配字符串。 <br>
	 * (\s*)表示连续空格的字符串。 []是定义匹配的字符范围。比如 [a-zA-Z0-9]
	 * 表示相应位置的字符要匹配英文字符和数字。[\s*]表示空格或者*号。<br>
	 * {}一般用来表示匹配的长度，比如 \s{3} 表示匹配三个空格，\s[1,3]表示匹配一到三个空格。<br>
	 * (0-9) 匹配 '0-9′ 本身。 [0-9]* 匹配数字（注意后面有 *，可以为空）[0-9]+ 匹配数字（注意后面有
	 * +，不可以为空）{1-9} 写法错误。 <br>
	 * [0-9]{0,9} 表示长度为 0 到 9 的数字字符串。
	 */

	/**
	 * 带确认
	 */
	@Test
	public void testBracket() {
		// TODO 测试() group的概念，可以了解java怎么设计这几个类，怎么考虑正则匹配的事情的。
	}

	@Test
	public void testRemoveWhiteSpace() {
		String expression = "+ A   or Blank In Middle +";
		expression = expression.replaceAll("[+]", "--");
		System.out.println("expression=" + expression);
		// expression=--- A or Blank In Middle ---
		/**
		 * 说明了默认为贪婪匹配
		 */
		expression = expression.replaceAll("(\\s+)", "空");//\s为空格，注意多个空格也只替换一个
		System.out.println("expression=" + expression);
		// expression=--空A空or空Blank空In空Middle空--

		// 想整个替换是不可能的：
		// 如下不起作用
		// expression = expression.replaceAll("[+](\\s*)[O|o][R|r](\\s*)[+]", "
		// OR ");
	}
	
	/**
	 * 1.贪婪模式在整个表达式匹配成功的前提下，尽可能多的匹配，而非贪婪模式在整个表达式匹配成功的前提下，尽可能少的匹配。<br>
	 * 2.属于贪婪模式的量词，也叫做匹配优先量词，包括：
     * “{m,n}”、“{m,}”、“?”、“*”和“+”。
     * 在一些使用NFA引擎的语言中，在匹配优先量词后加上“?”，即变成属于非贪婪模式的量词，也叫做忽略优先量词，包括：
     * “{m,n}?”、“{m,}?”、“??”、“*?”和“+?”。
	 */
	
}
