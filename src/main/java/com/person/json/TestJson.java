package com.person.json;

import org.junit.Test;

public class TestJson {
	
   @Test
   public void testJsonAnnotation() {
		
		JsonUtil jUtil = new JsonUtil();
		jUtil.setName("xujianfneg");
		jUtil.setValue("hahaha");
		
		System.out.println("===" + jUtil.toJson(jUtil));
		//2016-11-10 19:32:32 输出结果:==={"name":"xujianfneg"}  value 没有标记 jsonProperty 所以value不输出
	}

}
