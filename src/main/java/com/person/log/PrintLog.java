package com.person.log;

import org.apache.log4j.Logger;

/**
 * 每次写代码都需要 岔开思路去考虑怎么打印日志， 所以这里写下来（形成template）。
 * 
 * 1.所有的日志都应该符合信息流逻辑，即error日志打印的是 信息流链上出了问题，如果执行结果有问题首先可以去看有没有error日志(信息流有没有偏差)。
 * 
 * 2.异步定时调度要写上该次更新的时间，比如searchRule系统里每5分钟更新缓存（记录更新时间最好）。
 * 
 * @author lakala-shawn
 *
 */
public class PrintLog {
	Logger logger = Logger.getLogger(PrintLog.class);

	// TODO 完善下日志代码

	/**
	 * 人为输入错误
	 * 
	 * 
	 * @param retrivCond
	 * @return
	 */
	private void printPersonConstaintErrorLog() {

		// 如下代码注释，因为从工程中考出来的
		/*
		 * String matchedMapKey = assembleRuleKey(retrivCond.getSysName(),
		 * retrivCond.getBizType(), retrivCond.getSearchField());
		 */
		/**
		 * 4种区间判断
		 *//*
			 * Date matchBeginCond = converToDate(retrivCond.getMatchBegin());
			 * Date matchEndCond = converToDate(retrivCond.getMatchEnd());
			 * 
			 * List<SearchRule> searchRuleFromMap =
			 * bizSearchRulesMap.get(matchedMapKey); if (null ==
			 * searchRuleFromMap) {
			 * logger.error("no key in map,for matchedMapKey=" + matchedMapKey);
			 * return null; }
			 */

		/*
		 * List<SearchRule> matchedRules = new ArrayList<SearchRule>(); for
		 * (SearchRule searchRule : searchRuleFromMap) { if
		 * (!SearchTypeEnum.DATE.getValue().equals(searchRule.getParseType())) {
		 * 
		 * * 注释掉代码只是为了演示怎么写注释 // 对于一个业务类型
		 * 只有只有一种parseType，所以这里一条数据里parseType不是Date类型的话直接跳出。 logger.error(
		 * "constraint: only one parse type for each bizType,so if not accordance exit this method. "
		 * ); return null; } Date matchBeginInCache =
		 * converToDate(searchRule.getMatchBegin()); Date matchEndInCache =
		 * converToDate(searchRule.getMatchEnd()); // FIXME == 另外判断 // 查询区间
		 * 和被匹配区间 if (matchBeginCond.compareTo(matchEndInCache) == 1 ||
		 * matchBeginCond.compareTo(matchEndInCache) == 0 ||
		 * matchEndCond.compareTo(matchBeginInCache) == -1 ||
		 * matchEndCond.compareTo(matchBeginInCache) == 0) { // 查询区间在被匹配区间两头
		 * 说明该searchRule对应的index不是目标index 直接跳过 continue; }
		 * matchedRules.add(searchRule);// 返回给客户端直接通过 }
		 */
	}

}
