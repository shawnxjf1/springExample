/**
 * Project Name:soa-test
 * File Name:NofifyImpl.java
 * Package Name:com.lakala.soa.examples.eventnotify.impl
 * Date:2015年10月31日下午11:19:58
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.eventnotify.impl;

import com.lakala.soa.examples.eventnotify.api.INotify;

/**
 * ClassName:NofifyImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class NofifyImpl implements INotify{

	public void onInvoke(Integer id) {
		
		System.err.println("NofifyImpl class method onInvoke() is working---");
	}

	public void onReturn(Integer msg, Integer id) {
		
		System.err.println("NofifyImpl class method onReturn() is working---");
	}

	public void onThrow(Throwable ex, Integer id) {
		
		ex.printStackTrace();
		System.err.println("NofifyImpl class method onThrow() is working---");
	}

}
