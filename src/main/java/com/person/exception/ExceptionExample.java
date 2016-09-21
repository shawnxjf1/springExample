package com.person.exception;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 异常的基本知识： 1).运行时异常 2).检查异常（编译时检查异常）
 * 
 * 1.异常不是用来控制程序流的
 * 
 * 2.异常要么处理要么接着抛
 * 
 * 3.Dao层一般设计为抛异常是为了让service把数据库异常转化成业务异常。
 * 
 * 4.在捕获和转化异常的地方打印日志(打印出唯一流水号 ——想知道引起异常时哪一笔流水，查日志好查。)，如果是原封不动的重新抛出
 * 
 * 5.batch里如果不希望由于一个异常就跳出循环，在循环里最好catch异常。
 * 
 * 6.如果异常需要返回到源端，比如返回到web 用户浏览器
 * 则需要把该异常一直往上抛然后根据特定的异常转化成特定的异常码（比如支付中银行卡不对等等），但是也必须打印日志。
 * 
 * 7.checked 异常特定的异常代表特定的含义。
 * 
 * 问题： 1.如何设计异常类
 * 
 * @author lakala-shawn
 *
 */
public class ExceptionExample {

	Logger log = Logger.getLogger(ExceptionExample.class);

	/**
	 * 
	 * 原封不动的重新抛异常。
	 * 
	 * 执行结果为： ERROR exception.ExceptionExample: / by zerodenominator=0,member=10
	 * 
	 * @param denominator
	 * @param member
	 * @return
	 */
	private int catchAndThrowOriginal(int denominator, int member) {

		try {
			return member / denominator;
		} catch (Exception e) {
			log.error(e.getMessage() + "denominator=" + denominator + ",member=" + member);
			throw e;
		}

		// 可以跟踪到 是哪个参数引起了异常
		// [17/09/16 04:51:10:010 CST] main ERROR exception.ExceptionExample: /
		// by zerodenominator=0,member=10
		// Exception in thread "main" java.lang.ArithmeticException: / by zero
		// at
		// com.person.exception.ExceptionExample.throwException0(ExceptionExample.java:31)
		// at
		// com.person.exception.ExceptionExample.throwException1(ExceptionExample.java:40)
		// at
		// com.person.exception.ExceptionExample.main(ExceptionExample.java:50)
	}

	/**
	 * 
	 * 没有捕获 也就没有机会把异常错误与订单流水 绑定起来。如果信息流的上下有相关参数的日志则可以使用该方法，否则是使用捕捉在抛出的方法
	 * 
	 * @param denominator
	 * @param member
	 * @return
	 */
	private int noCatchThrowDirectly(int denominator, int member) {

		return member / denominator;

		// 没有捕获 也就没有机会把异常错误与订单流水 绑定起来。
		// Exception in thread "main" java.lang.ArithmeticException: / by zero
		// at
		// com.person.exception.ExceptionExample.throwException(ExceptionExample.java:51)
		// at
		// com.person.exception.ExceptionExample.throwException1(ExceptionExample.java:57)
		// at
		// com.person.exception.ExceptionExample.main(ExceptionExample.java:67)
	}

	private void mockExceptionThrow() {
		for (int i = 5; i >= 0; i--) {
			// throwException0(i, 10);
			noCatchThrowDirectly(i, 10);
		}
	}

	@Test
	public void testThrowException() {
		mockExceptionThrow();
	}

	public static void main(String[] args) {
		new ExceptionExample().mockExceptionThrow();
	}

	// ---带完善，没有声明异常不能重新抛出去
	// private static Map<String, String>
	// getSearchKeyValMapByColonAndVerticalLine(String parseTypes) {
	//
	// Map<String, String> parseTypeMap = new HashMap<String, String>();
	// try {
	// String[] parseTypeArray = parseTypes.split(SEARCH_KEY_SEPARATOR);
	// if (null == parseTypeArray) {
	// return null;
	// }
	// for (String parseType : parseTypeArray) {
	// String[] typeKeyVal = parseType.split(KEY_VAL_SEPARATOR);
	// if (null == typeKeyVal || typeKeyVal.length != 2) {
	// // FIXME 这里是否需要 专门弄一个 DATA_PARSE_EXCEPTION 来提示 输入录入有误
	// log.error("parseTypes format error break for() loop,parseTypes=" +
	// parseTypes);
	// break;
	// }
	// parseTypeMap.put(typeKeyVal[0], typeKeyVal[1]);
	// }
	// } catch (Exception e) {
	// log.error("error occur when,parseTypes=" + parseTypes, e);
	// // throws e; 没有
	// }
	// return parseTypeMap;
	// }
	//
	// public static SearchRuleCache convertRuleToRuleCacheObj(SearchRule
	// ruleTmp) {
	// SearchRuleCache ruleCache = new SearchRuleCache();
	//
	// // 把SearchRule 基本属性(BaseSearchRule继承过来属性)复制到SearchRuleCache对象
	// try {
	// BeanUtils.copyProperties(ruleCache, ruleTmp);
	// } catch (IllegalAccessException e) {
	// e.printStackTrace();
	// log.error("copyProperties error,ruleTmp=" + ruleTmp);
	// } catch (InvocationTargetException e) {
	// e.printStackTrace();
	// log.error("copyProperties error,ruleTmp=" + ruleTmp);
	// }
	//
	// // 解析SearchRule中的每一个searchKey的规则
	// String keys = ruleTmp.getSearchKeys();
	// if (null == keys || keys.isEmpty()) {
	// // attention 直接让程序结束
	// throw new RuntimeException("keysis null or empty,searchRule" + ruleTmp);
	// }
	//
	// }

}
