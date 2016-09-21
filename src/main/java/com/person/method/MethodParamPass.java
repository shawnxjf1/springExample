package com.person.method;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class MethodParamPass {

	static Logger log = Logger.getLogger(MethodParamPass.class);

	/**
	 * 该函数测试如果在函数体内 new obj(),则这个obj的变化在外层显示不出来。 原理：java函数传递的是引用，在函数内部新new
	 * Obj()原有的引用地址丢失了。
	 * 
	 * @param map1
	 */
	private static void paramNotPassWhenNewObjParm(Map<String, String> map1) {
		if (null == map1) {
			map1 = new HashMap<String, String>();
			map1.put("map", "map-test-1");
		} else {
			map1.put("map", "map-test-2");
		}
		log.info("map1=" + map1);
	}

	public static void main(String[] args) {
		Map<String, String> map2 = null;
		paramNotPassWhenNewObjParm(map2);
		log.info("map2=" + map2);

		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		Map<String, String> map3 = new HashMap<String, String>();
		paramNotPassWhenNewObjParm(map3);
		log.info("map3=" + map3);

		// main INFO service.TestCommon: map1={map=map-test-1}
		// main INFO service.TestCommon: map2=null
		// main INFO service.TestCommon: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		// main INFO service.TestCommon: map1={map=map-test-2}
		// main INFO service.TestCommon: map3={map=map-test-2}
	}

}
