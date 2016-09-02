/**
 * Project Name:soa-test
 * File Name:ConsumerBean.java
 * Package Name:com.lakala.soa.examples.rest
 * Date:2015年10月31日下午6:11:22
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.rest;

import com.alibaba.dubbo.rpc.RpcContext;
import com.lakala.soa.examples.rest.api.AnotherUserRestService;
import com.lakala.soa.examples.rest.vo.User;

/**
 * ClassName:ConsumerBean <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年10月31日 下午6:11:22 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class ConsumerBean {
	
	private AnotherUserRestService anotherUserRestService;

	public void setAnotherUserRestService(
			AnotherUserRestService anotherUserRestService) {
		this.anotherUserRestService = anotherUserRestService;
	}
	
	public void start(){
		
		User user = new User(1L, "larrypage");
        System.out.println("SUCCESS: registered user with id " + anotherUserRestService.registerUser(user).getId());

        RpcContext.getContext().setAttachment("clientName", "demo");
        RpcContext.getContext().setAttachment("clientImpl", "soa");
        System.out.println("SUCCESS: got user " + anotherUserRestService.getUser(1L));
	}
}
