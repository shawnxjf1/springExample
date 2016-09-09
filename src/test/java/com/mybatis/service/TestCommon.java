package com.mybatis.service;

import java.util.Date;

import org.junit.Test;

import com.person.date.DateUtil;

public class TestCommon {

	@Test
	public void testDate() {
		Date date = DateUtil.convertStrToDate("2015-06-01 01:02:03", "yyyy-MM-dd HH:mm:ss");
		System.out.println("date1= " + date);// date1= Mon Jun 01 01:02:03 CST
												// 2015

	}

}
