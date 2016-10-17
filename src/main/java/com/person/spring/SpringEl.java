package com.person.spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * SpEL提供简单的接口从而简化用户使用，在介绍原理前让我们学习下几个概念：
 * 一、表达式：表达式是表达式语言的核心，所以表达式语言都是围绕表达式进行的，从我们角度来看是“干什么”；
 * 二、解析器：用于将字符串表达式解析为表达式对象，从我们角度来看是“谁来干”；
 * 三、上下文：表达式对象执行的环境，该环境可能定义变量、定义自定义函数、提供类型转换等等，从我们角度看是“在哪干”；
 * 四、根对象及活动上下文对象：根对象是默认的活动上下文对象，活动上下文对象表示了当前表达式操作的对象，从我们角度看是“对谁干”。
 */
public class SpringEl {

	/**
	 * 问题：Expression 有3个实现类：LiteralExpression CompositeStringExpression
	 * SpelExpression，默认的为SpelExpression(默认体现在哪里代码反射处理在哪里)
	 */
	@Test
	public void testParserContext() {
		ExpressionParser parser = new SpelExpressionParser();
		ParserContext parserContext = new ParserContext() {
			@Override
			public boolean isTemplate() {
				return true;
			}

			@Override
			public String getExpressionPrefix() {
				return "#{";
			}

			@Override
			public String getExpressionSuffix() {
				return "}";
			}
		};
		String template = "#{'Hello '}#{'World!'}";
		Expression expression = parser.parseExpression(template, parserContext);
		Assert.assertEquals("Hello World!", expression.getValue());
	}

	@Test
	public void testExecutePaser() {
		ExpressionParser parser = new SpelExpressionParser();

		// literal expressions
		Expression exp = parser.parseExpression("'Hello World'");
		String msg1 = exp.getValue(String.class);
		System.out.println(msg1);

		// method invocation
		Expression exp2 = parser.parseExpression("'Hello World'.length()");
		int msg2 = (Integer) exp2.getValue();
		System.out.println(msg2);

		// Mathematical operators
		Expression exp3 = parser.parseExpression("100 * 2");
		int msg3 = (Integer) exp3.getValue();
		System.out.println(msg3);

		// create an item object
		Item item = new Item("yiibai", 100);
		// test EL with item object
		StandardEvaluationContext itemContext = new StandardEvaluationContext(item);

		// display the value of item.name property
		Expression exp4 = parser.parseExpression("name"); // 输出:
		// attention yiibai，在一个context下去name的值
		String msg4 = exp4.getValue(itemContext, String.class);
		System.out.println(msg4);

		// test if item.name == 'yiibai'
		Expression exp5 = parser.parseExpression("name == 'yiibai'");
		// 执行表达式，name= 'yiibai'
		boolean msg5 = exp5.getValue(itemContext, Boolean.class);
		System.out.println(msg5);

	}

	class Item {

		private String name;

		private int qty;

		public Item(String name, int qty) {
			super();
			this.name = name;
			this.qty = qty;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		// ...
	}

}
