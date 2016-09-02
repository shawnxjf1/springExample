/**
 * Project Name:soa-test
 * File Name:DemoServiceImpl.java
 * Package Name:com.lakala.soa.examples.eventnotify.impl
 * Date:2015年10月31日下午11:12:33
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.eventnotify.impl;

import com.lakala.soa.examples.eventnotify.api.IDemoService;

/**
 * ClassName:DemoServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class DemoServiceImpl implements IDemoService{

	public int getCalcResult(int id) {
		return 1/id;
	}

}
