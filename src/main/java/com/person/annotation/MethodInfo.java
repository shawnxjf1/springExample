package com.person.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 疑问：
 * 
 * 1.具体实现要看业务代码的，注解只是个标记，要看某个具体的类通过反射读到这个Produces注解后是做什么事情。
 * 
 * 2.
 * 
 * @author lakala-shawn
 *
 */
@Documented
@Target(ElementType.METHOD) // Target(){ElementType[]
							// value();}而elementType是一个枚举类型
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MethodInfo {
	// 注意在注解中 author() date()都是带有()的。
	String author() default "xujianfeng";

	String date();

	int revision() default 1;

	String comments();

}
