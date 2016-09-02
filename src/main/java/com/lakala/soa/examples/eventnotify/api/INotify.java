/**
 * Project Name:soa-test
 * File Name:INofify.java
 * Package Name:com.lakala.soa.examples.eventnotify.api
 * Date:2015年10月31日下午11:18:15
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.eventnotify.api;
/**
 * ClassName:INofify <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface INotify {
	
	//在定义回调处理方法时，需要按照以下规则匹配原service方法
	
	//调用之前
	public void onInvoke(Integer id);
	
	//调用之后
	//onreturn(service返回值，service原参数1,service原参数2...)
	public void onReturn(Integer msg, Integer id);
	
	//出现异常
	//onthrow(Throwable ex，service原参数1,service原参数2...)
    public void onThrow(Throwable ex, Integer id);
}
