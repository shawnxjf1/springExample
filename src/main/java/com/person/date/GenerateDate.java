package com.person.date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Test;

public class GenerateDate
{
    static final String FORMAT_12 = "yyyyMMddhhmmss";
	
	static final String FORMAT_24 = "yyyyMMddHHmmss";
	/**
	 * 
	 * 生成2015-01-01 到 2016-01-01 一年之间 所有月份的开始时间和结束时间<br>
	 * 比如一月份(20160101000000和20160101235959)<br>
	 * 初始化数据<br>
	 */
	@Test
	public  void geneDateWithJodTime()
	{
		DateTime beginTime = new DateTime("2015-01-01");
		DateTime endTime = new DateTime("2016-01-01");
		
		int dayCount = Days.daysBetween(beginTime, endTime).getDays();
		System.out.println(dayCount + "days between(" + beginTime + " and " + endTime + ")");
		//DateTime dt = new DateTime("");
		DateTime monthBegin = beginTime;
		DateTime monthEnd = monthBegin.dayOfMonth().withMaximumValue();

		while(monthBegin.isBefore(endTime))
		{
			//每个月份+1
			monthBegin = monthBegin.plusMonths(1);
			monthEnd = monthBegin.dayOfMonth().withMaximumValue();
			monthBegin = monthBegin.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0);
			monthEnd = monthEnd.withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59);
			
			System.out.println("monthBegin==>"  + monthBegin.toString(FORMAT_12));
			System.out.println("monthEnd==>"  + monthEnd.toString(FORMAT_12));
			/****************************************************/
			System.out.println("monthBegin==>"  + monthBegin.toString(FORMAT_24));
			System.out.println("monthEnd==>"  + monthEnd.toString(FORMAT_24));
            //  monthBegin==>20160101120000
            //  monthEnd==>20160131115959
            //	monthBegin==>20160101000000
            //	monthEnd==>20160131235959
		}
	}
}
