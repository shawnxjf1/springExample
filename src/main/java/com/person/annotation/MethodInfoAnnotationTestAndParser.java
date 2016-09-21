package com.person.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.Test;

public class MethodInfoAnnotationTestAndParser {

	/**
	 * 测试注解
	 */
	@MethodInfo(author = "xjf", revision = 2, date = "2016-9-1", comments = "xujianfeng create in 2016-09-01")
	public void printAnnotatin() {
		System.out.println("printAnnotatin");
	}

	/**
	 * 解析注解
	 */
	public void parseMethodInfoAnnotation() {
		try {
			for (Method method : MethodInfoAnnotationTestAndParser.class.getClassLoader()
					.loadClass("com.person.annotation.MethodInfoAnnotationTestAndParser").getMethods()) {
				// checks if MethodInfo annotation is present for the method
				if (method.isAnnotationPresent(com.person.annotation.MethodInfo.class)) {
					try {
						// iterates all the annotations available in the method
						for (Annotation anno : method.getDeclaredAnnotations()) {
							System.out.println("Annotation in Method " + method + ": " + anno);
							// 输出结果为：
							// Annotation in Method public void
							// com.person.annotation.MethodInfoAnnotationTestAndParser.printAnnotatin():
							// @com.person.annotation.MethodInfo(author=xjf,
							// revision=2, date=2016-9-1, comments=xujianfeng
							// create in 2016-09-01)
						}
						MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
						if (methodAnno.revision() == 1) {
							System.out.println("Method with revision no 1 = " + method);
						}

					} catch (Throwable ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPrintAnnotation() {
		printAnnotatin();
	}

	// 当我们想读取某个注释信息时，我们是在运行时通过反射来实现的，如果你对元注释还有点印象，那你应该记得我们需要将保持性策略设置为RUNTIME，也就是说只有注释标记了@Retention(RetentionPolicy.RUNTIME)的，我们才能通过反射来获得相关信息
	/**
	 * policy改成source 输出是 "",必须是runtime才能获取反射信息。
	 */
	@Test
	public void testAnnotationParser() {
		parseMethodInfoAnnotation();
	}

}
