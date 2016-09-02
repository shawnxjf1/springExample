/**
 * Project Name:soa-test
 * File Name:DemoServiceImpl.java
 * Package Name:com.lakala.soa.examples.localinvoke.impl
 * Date:2015年11月1日上午3:26:29
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.remote.impl;

import com.lakala.soa.examples.remote.api.IDemoService;
/**
 * ClassName:DemoServiceImpl <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class DemoServiceImpl implements IDemoService{

	public String sayHello(String name) {
        return "Provider say: Hello " + name;
    }
}
