package com.person.exception;

import java.util.List;
import java.util.Map;

/**
 * 1.总体来说exception是全局的而return只是解决了当前函数返回的问题是一个局部解决方法（只解决了信息的一段），有异常和错误这样的信息最终
 * 需要用户去处理。<br>
 * 
 * @author lakala-shawn
 *
 */
public class ExceptionInIndexSearch {

	/**
	 * 1.attention: 抛出异常比 return好，return只能返回当前函数，上层调用函数还是需要处理。<br>
	 * 2.excepiton可以用来结束程序，比如人为元数据配置有问题直接可以停掉程序，这里抛出异常比较合适。<br>
	 * 3.对于需要停掉程序的异常或者把整条信息结束(比如下单信息流直接报错到user不用继续往下走)的异常不要捕捉。
	 * 
	 * @param sysName
	 * @param containerMap
	 */
	private void loadIndexFieldKeyRules(String sysName, Map<String, List<String>> containerMap) {
		List<String> f1FieldRuleList = containerMap.get("f1");
		if (null == f1FieldRuleList || f1FieldRuleList.size() <= 0) {
			// attention: 抛出异常比 return好，return只能返回当前函数，上层调用函数还是需要处理。
			throw new RuntimeException("Exception: loadIndexFieldKeyRules[" + sysName + "] return null or empty !");
		}
	}

}
