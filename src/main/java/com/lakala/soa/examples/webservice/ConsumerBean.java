/**
 * Project Name:soa-test
 * File Name:ConsumerBean.java
 * Package Name:com.lakala.soa.examples.rest
 * Date:2015年10月31日下午6:11:22
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.webservice;

import com.lakala.soa.examples.webservice.api.WebService;

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
	
	private WebService webService;
	
	public void setWebService(WebService webService) {
		this.webService = webService;
	}

	public void start(){
		
		String str = webService.printWord("soa consumer refer a webService");
		System.out.println(str);
	}
}
