package com.person.json;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	@JsonProperty
	private String name;
	
	private String value;
	
	Logger logger = Logger.getLogger(JsonUtil.class);
	
	/**
	 * FIXME 对于null 的属性 怎么不让它输出<br>
	 * 2016-11-04 测试结果是，如果this 的属性有null的同样输出了
	 * @return
	 */
	public String  toJson(Object o)
	{
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(o);
		} catch (JsonProcessingException ex) {
			logger.error("Response.toJson exception", ex);
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		JsonUtil jUtil = new JsonUtil();
		jUtil.name = "xujianfneg";
		jUtil.value = "hahaha";
		
		System.out.println("===" + jUtil.toJson(jUtil));
		//2016-11-10 19:32:32 输出结果:==={"name":"xujianfneg"}  value 没有标记 jsonProperty 所以value不输出
		
	}

}
