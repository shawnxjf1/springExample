package com.person.string;

import org.junit.Test;

public class StringExample {

	@Test
	public void testSplit() {
		// 注意由于 | 为正则表达式 特殊字符 所以需要转义
		// & : 不需要转义（测试过）
		String[] strArrays = "TXNTIM:1".split("\\|");
		System.out.println(strArrays.toString());
	}

	/**
	 * subString()中无需考虑正则
	 */
	@Test
	public void testSubStr() {
		String a = "[abc]"; // subString 这里[] 在正则中的特殊字符不考虑
		System.out.println(a.substring(1, a.length() - 1)); // 输出结果为abc
		// extends
		// to the character
		// at
		// index endIndex - 1.

		// Returns a string that is a substring of this string. The substring
		// begins at the specified beginIndex and extends to the character at
		// index endIndex - 1.
		// Thus the length of the substring is endIndex-beginIndex.
	}

	/**
	 * Concatenates the specified string to the end of this string.
	 * <p>
	 * If the length of the argument string is {@code 0}, then this
	 * {@code String} object is returned. Otherwise, a {@code String} object is
	 * returned that represents a character sequence that is the concatenation
	 * of the character sequence represented by this {@code String} object and
	 * the character sequence represented by the argument string.
	 * <p>
	 * Examples: <blockquote>
	 * 
	 * <pre>
	 * "cares".concat("s") returns "caress"
	 * "to".concat("get").concat("her") returns "together"
	 * </pre>
	 * 
	 * </blockquote>
	 *
	 * @param str
	 *            the {@code String} that is concatenated to the end of this
	 *            {@code String}.
	 * @return a string that represents the concatenation of this object's
	 *         characters followed by the string argument's characters.
	 */

	/**
	 * public String concat(String str) { }
	 */

	@Test
	public void testStr() {
		String name = "a.b.c";
		String path = name.replace('.', '/').concat("/");
		System.out.println("path=" + path);
	}

}
