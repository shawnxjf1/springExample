package com.spring;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 渠道文件处理触发
 * 
 * @author chen_cong
 * @version 1.0
 * @since 29 Apr 2015
 */
@Service("quarterExampleTrigger")
public class QuarterExampleTrigger {

	private static Logger logger = Logger.getLogger(QuarterExampleTrigger.class);

	/**
	 * 定时交易入口
	 * 
	 * @throws Exception
	 */
	public void execute() throws Exception {
		System.out.println("spring quartz executing....");
	}
}
