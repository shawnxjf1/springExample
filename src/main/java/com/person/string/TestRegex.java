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
}
