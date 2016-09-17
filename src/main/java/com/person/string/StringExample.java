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

}
