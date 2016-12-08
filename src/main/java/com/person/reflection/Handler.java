package com.person.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

	public Object targetObj;

	public Handler(Object targetObj) {
		this.targetObj = targetObj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("before the function \"" + method.getName() + "\"");
		Object ret = method.invoke(targetObj, args);
		System.out.println(ret);
		System.out.println("after the function \"" + method.getName() + "\"");
		return ret;
	}

}