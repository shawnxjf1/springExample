package com.lakala.soa.examples.async.impl;

import com.lakala.soa.examples.async.api.AsyncService;

/**
 * AsyncServiceImpl
 * 
 * @author michael.yc
 */
public class AsyncServiceImpl implements AsyncService {

	public String sayAsyncHello(String value) {
		System.out.println("server side" + value);
		return "reference side:" + value;
	}

}
