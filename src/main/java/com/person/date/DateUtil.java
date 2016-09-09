package com.person.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author lakala-shawn
 *
 */
public class DateUtil {

	private static final String YYYY_MM_DD = "yyyy-MM-dd";

	private final String DATE_FORMAT_YYYY_MM_HHMMSS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 默认的日期格式
	 */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static final String FMT_DATE_YYYY = "yyyy";

	public static final String FMT_DATE_YYYYMMDD = "yyyy-MM-dd";

	public static final String FMT_DATE_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

	public static final String FMT_DATE_HHMMSS = "HH:mm:ss";

	public static final String FMT_DATE_HHMM = "HH:mm";

	public static final String FMT_DATE_SPECIAL = "yyyyMMdd";

	public static final String FMT_DATE_MMDD = "MM-dd";

	public static final String FMT_DATE_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

	public static final String FMT_DATE_MMDD_HHMM = "MM-dd HH:mm";

	public static final String FMT_DATE_MMMDDD = "MM月dd日";

	public static final String FMT_DATE_YYYYMMDDHHMM_NEW = "yyyyMMddHHmm";

	public static final String FMT_DATE_YYYY年MM月DD日 = "yyyy年MM月dd日";

	public static final String FMT_DATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static final String FMT_DATE_YYYYMMDDHH = "yyyyMMddHH";

	private static final int[] TIME_FIELD_LEVELS = { Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY,
			Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND };

	private static Map<String, Integer> periodUnits;

	static {
		periodUnits = new HashMap<String, Integer>();
		periodUnits.put("D", new Integer(Calendar.DATE));
		periodUnits.put("M", new Integer(Calendar.MONTH));
		periodUnits.put("W", new Integer(Calendar.WEEK_OF_MONTH));
		periodUnits.put("Y", new Integer(Calendar.YEAR));
		periodUnits.put("h", new Integer(Calendar.HOUR_OF_DAY));
		periodUnits.put("m", new Integer(Calendar.MINUTE));
		periodUnits.put("s", new Integer(Calendar.SECOND));
	}

	/**
	 * 对齐日期对象到指定精度
	 * 
	 * @param date
	 *            日期对象
	 * @param field
	 *            要对齐的时间域，参考Calendar中field的定义
	 * @return 对齐后的日期
	 */
	public static Date roundDate(Date date, int field) {
		if (date == null) {
			return date;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		roundDate(cal, field);

		return cal.getTime();
	}

	public static void roundDate(Calendar cal, int field) {
		boolean clearFlag = false;
		for (int i = 0; i < TIME_FIELD_LEVELS.length; i++) {
			if (clearFlag) {
				cal.set(TIME_FIELD_LEVELS[i], cal.getMinimum(TIME_FIELD_LEVELS[i]));
			} else if (TIME_FIELD_LEVELS[i] == field) {
				clearFlag = true;
			}
		}
	}

	/**
	 * 调整日期对象
	 * 
	 * @param date
	 *            日期对象
	 * @param field
	 *            时间域，参考Calendar中field的定义
	 * @param amount
	 *            调整数量
	 * @return 调整后的日期对象
	 */
	public static Date rollDate(Date date, int field, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(field, amount);
		return cal.getTime();
	}

	/**
	 * 获得日期对象的时间域值
	 * 
	 * @param field
	 *            时间域，参考Calendar中field的定义
	 * @return 对应时间域的值
	 */
	public static int getDateField(Date date, int field) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(field);
	}

	/**
	 * 获得修改时间域值后的日期对象
	 * 
	 * @param date
	 *            日期对象
	 * @param field
	 *            时间域，参考Calendar中field的定义
	 * @param value
	 *            时间域的值
	 * @return 修改后的日期对象
	 */
	public static Date setDateField(Date date, int field, int value) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.set(field, value);
		return cal.getTime();
	}

	/**
	 * 根据给定参数打造时间对象, 毫秒数为零.
	 * 
	 * @param year
	 *            年. 例 2009
	 * @param month
	 *            月. 从1开始, 例 1
	 * @param date
	 *            日. 从1开始, 例 10
	 * @return 日期对象. 如果参数错误, 则返回null, 例 year=0; month=2, date=30
	 */
	public static Date getDate(int year, int month, int date) {
		return getDate(year, month, date, 0, 0, 0);
	}

	/**
	 * 根据给定参数打造时间对象, 毫秒数为零.
	 * 
	 * @param year
	 *            年. 例 2009
	 * @param month
	 *            月. 从1开始, 例 1
	 * @param date
	 *            日. 从1开始, 例 10
	 * @param hourOfDay
	 *            小时. 24小时制, 从0开始, 例 23
	 * @param minute
	 *            分. 从0开始, 例 59
	 * @param second
	 *            秒. 从0开始, 例 59
	 * @return 日期对象. 如果参数错误, 则返回null, 例 year=0; month=2, date=30
	 */
	public static Date getDate(int year, int month, int date, int hourOfDay, int minute, int second) {
		try {
			Calendar c = Calendar.getInstance();
			c.setLenient(false);
			c.set(year, month - 1, date, hourOfDay, minute, second);
			c.clear(Calendar.MILLISECOND);

			return c.getTime();
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 获取java.util.Date副本
	 * 
	 * @param date
	 *            日期对象
	 * @return 日期对象
	 */
	public static Date cloneDate(Date date) {
		return (date != null ? new Date(date.getTime()) : null);
	}

	/**
	 * 获取java.sql.Date副本
	 * 
	 * @param date
	 *            日期对象
	 * @return 日期对象
	 */
	public static java.sql.Date getSQLDate(Date date) {
		return (date != null ? new java.sql.Date(date.getTime()) : null);
	}

	/**
	 * 按自定义日期格式格式化日期
	 * 
	 * @param target
	 * @param format
	 * @return 格式化后的日期字符串，如果传入的日期对象为NULL，返回空字符串
	 */
	public static String formatDate(Date target, String format) {
		if (target == null) {
			return "";
		}
		return new SimpleDateFormat(format).format(target);
	}

	public static String formatTimestamp(Timestamp time, String format) {
		if (time == null) {
			return "";
		}
		return new SimpleDateFormat(format).format(time);
	}

	/**
	 * 按默认日期格式 格式化日期
	 * 
	 * @param target
	 * @return 格式化后的日期字符串，如果传入的日期对象为NULL，返回空字符串
	 */
	public static String formatDate(Date target) {
		return formatDate(target, DEFAULT_DATE_FORMAT);
	}

	/**
	 * 将字符串格式化为日期对象
	 * 
	 * @param date
	 * @param format
	 * @return 如果date为空或格式不标准，返回NULL，否则返回对应的日期对象
	 */
	public static Date formatToDate(String date, String format) {
		try {
			if (null == date || "".equals(date)) {
				return null;
			}

			SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
			return new Date(sorceFmt.parse(date).getTime());
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 将字符串格式化为日期对象
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Timestamp formatToTimestamp(String dateStr, String format) {
		try {
			SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
			return new Timestamp(sorceFmt.parse(dateStr).getTime()); // 一天的时间24*3600*1000
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 得到当前时间的TimeStamp格式
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static Date getIntervalDate(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);

		return calendar.getTime();
	}

	public static Date getIntervalHour(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);

		return calendar.getTime();
	}

	public static Date getIntervalMinute(Date date, int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);

		return calendar.getTime();
	}

	public static Date getIntervalSeconds(Date date, int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, seconds);
		return calendar.getTime();
	}

	public static Timestamp getDaysIntervalTimestamp(Date date, int days) {
		return new Timestamp(getIntervalDate(date, days).getTime());
	}

	public static Timestamp getSecondsIntervalTimestamp(Date date, int seconds) {
		return new Timestamp(getIntervalSeconds(date, seconds).getTime());
	}

	/**
	 * 方法用途:将时间按照指定的小时增加或者减少 <br>
	 * 实现步骤: <br>
	 * 
	 * @param date
	 * @param hours
	 * @return
	 */
	public static Timestamp getHoursIntervalTimestamp(Timestamp date, int hours) {
		return new Timestamp(getIntervalHour(date, hours).getTime());
	}

	/**
	 * 方法用途:将时间按照指定的秒增加或者减少 <br>
	 * 实现步骤: <br>
	 * 
	 * @param date
	 * @param seconds
	 * @return
	 */
	public static Timestamp getSecondsIntervalTimestamp(Timestamp date, int seconds) {
		return new Timestamp(getIntervalSeconds(date, seconds).getTime());
	}

	/**
	 * 判断传入日期是否是今天
	 */
	public static boolean isToday(Date date) {
		return isSameDay(date, new Date());
	}

	/**
	 * 判断传入日期是否是本月
	 */
	public static boolean isThisMonth(Timestamp date) {
		Calendar source = Calendar.getInstance();
		source.setTimeInMillis(date.getTime());
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(getCurrentTimestamp().getTime());
		return isSameMonth(source, today);
	}

	public static boolean isSameMonth(Date source, Date target) {
		Calendar sourceCal = Calendar.getInstance();
		sourceCal.setTime(source);
		Calendar targetCal = Calendar.getInstance();
		targetCal.setTime(target);
		return isSameMonth(sourceCal, targetCal);
	}

	public static boolean isSameMonth(Calendar source, Calendar target) {
		if (source == null || target == null) {
			return false;
		}
		SimpleDateFormat sorceFmt = new SimpleDateFormat("yyyy-MM");
		String sourceDate = sorceFmt.format(source.getTime());
		String targetDate = sorceFmt.format(target.getTime());
		if ((null != sourceDate && !"".equals(sourceDate)) && sourceDate.equals(targetDate)) {
			return true;
		}
		return false;
	}

	public static Date getDateBeforeMonth(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -month); // month月前
		Date dayBeforeHalfYear = new Date(calendar.getTimeInMillis());
		return dayBeforeHalfYear;
	}

	/**
	 * 得到当天开始的Timestamp
	 * 
	 * @return
	 */
	public static Timestamp getBeginOfToday() {
		return getBeginOfThisDay(new Date());
	}

	/**
	 * 得到当天结束的Timestamp
	 * 
	 * @return
	 */
	public static Timestamp getEndOfToday() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat form = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		String dateStr = form.format(cal.getTime()) + " 23:59:59";
		Date date = null;
		try {
			form = new SimpleDateFormat(FMT_DATE_YYYYMMDD_HHMMSS);
			date = form.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
		return new Timestamp(date.getTime());
	}

	public static Timestamp getBeginOfThisDay(Date time) {
		SimpleDateFormat form = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		String dateStr = form.format(time);
		Date date = null;
		try {
			date = form.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
		return new Timestamp(date.getTime());
	}

	public static Timestamp getBeginOfTheMonth(Timestamp timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		cal.set(Calendar.DATE, 1);
		String dateStr = form.format(cal.getTime()) + " 00:00:00";
		Date date = null;
		try {
			date = form.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
		return new Timestamp(date.getTime());
	}

	public static Timestamp getBeginOfThisMonth() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		cal.set(Calendar.DATE, 1);
		String dateStr = form.format(cal.getTime()) + " 00:00:00";
		Date date = null;
		try {
			date = form.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
		return new Timestamp(date.getTime());

	}

	public static Timestamp getTimestampAfter(Date from, int days) {
		return getDaysIntervalTimestamp(from, days);
	}

	/**
	 * 时间加n秒,n可为负数
	 * 
	 * @return
	 */
	public static Timestamp getTimestampAfterSeconds(Date from, int seconds) {
		return getSecondsIntervalTimestamp(from, seconds);
	}

	/**
	 * 时间加n个月,n可为负数
	 * 
	 * @return
	 */
	public static Timestamp getTimestampAfterMonth(Date from, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(from);
		calendar.add(Calendar.MONTH, months);
		return new Timestamp(calendar.getTime().getTime());
	}

	public static long formatAndGetTimeLongValue(Date time, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date formatTime = null;
		try {
			formatTime = sdf.parse(sdf.format(time.getTime()));
		} catch (ParseException e) {
			formatTime = new Date();
		}
		return formatTime.getTime() / 1000;
	}

	public static boolean checkTimeRange(Timestamp source, Timestamp target, int range, int unit) {
		Calendar sourceCal = Calendar.getInstance();
		sourceCal.setTime(source);
		Calendar targetCal = Calendar.getInstance();
		targetCal.setTime(target);
		return checkTimeRange(sourceCal, targetCal, range, unit);
	}

	/**
	 * 判断时间是否在区间范围内,比如source和target是否间隔为1小时内
	 * 
	 * @param source
	 *            基点时间
	 * @param target
	 *            目标时间
	 * @param range
	 *            区间范围
	 * @param Unit
	 *            时间单位，使用Calendar的单位
	 * @return true 在时间范围内，false不在
	 */
	public static boolean checkTimeRange(Calendar source, Calendar target, int range, int Unit) {
		if (source == null || target == null || range == 0) {
			return false;
		}
		if (source.before(target)) {
			source.add(Unit, range);
			if (source.compareTo(target) >= 0) {
				return true;
			}
		} else {
			source.add(Unit, range * -1);
			if (source.compareTo(target) <= 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断传入的两个日期是否是同年同月同日
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean isSameDay(Date source, Date target) {
		if (source == null || target == null) {
			return false;
		}
		SimpleDateFormat sorceFmt = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		String sourceDate = sorceFmt.format(source);
		String targetDate = sorceFmt.format(target);
		if ((null != sourceDate && !"".equals(sourceDate)) && sourceDate.equals(targetDate)) {
			return true;
		}
		return false;
	}

	/**
	 * 检验日期字符串是否为期望的格式
	 * 
	 * @param dateStr
	 * @param dateFormat
	 * @return
	 */
	public static boolean checkDateFormat(String dateStr, String dateFormat) {
		if (dateStr == null || dateStr.equals("")) {
			return false;
		}

		try {
			new SimpleDateFormat(dateFormat).parse(dateStr);
		} catch (ParseException e) {

			return false;
		}

		return true;
	}

	/**
	 * 根据距当前时间的分钟数获得timestamp
	 * 
	 * @long minute 当前时间之后的分钟数
	 * @return Timestamp
	 */
	public static Timestamp getTimestampByDiffMinute(long minute) {
		Calendar cal = Calendar.getInstance();
		long time = cal.getTimeInMillis() + minute * 60 * 1000;
		return new Timestamp(time);
	}

	/**
	 * 根据距当前时间的分钟数获得timestamp
	 * 
	 * @long minute 当前时间之后的秒数
	 * @return Timestamp
	 */
	public static Timestamp getTimestampByDiffSeconds(long seconds) {
		Calendar cal = Calendar.getInstance();
		long time = cal.getTimeInMillis() + seconds * 1000;
		return new Timestamp(time);
	}

	/**
	 * 
	 * @param date2Get
	 *            将日期按照指定的天数增加或者减少，并转换为需要的日期格式
	 * @param format
	 *            需要转换为的格式
	 * @param days
	 *            时间间隔
	 * @return date2Get 成功：转换后的日期，失败：can't format your input
	 */
	public static String getIntervalDate(Date date2Get, String format, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date2Get);
		c.add(Calendar.DAY_OF_YEAR, days); // 增加天数(如果days为负数,则为减少天数)
		String dateToGet = new SimpleDateFormat(format).format(c.getTime());
		return dateToGet;
	}

	/**
	 * 计算两个Date之间的间隔天数
	 * 
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return 间隔天数
	 */
	public static int calIntervalDays(Date start, Date end) {
		if (null == start || null == end) {
			return Integer.MIN_VALUE;
		}
		long interval = (end.getTime() - start.getTime()) % (24 * 60 * 60 * 1000);
		long result = (end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000);
		return interval == 0 ? (int) result : (int) result + 1;
	}

	/**
	 * 方法用途: 计算两个Timestamp之间的间隔分钟数<br>
	 * 实现步骤: <br>
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int calIntervalMins(Timestamp start, Timestamp end) {
		if (start == null || end == null) {
			return Integer.MIN_VALUE;
		}
		long interval = (end.getTime() - start.getTime()) % (60 * 1000);
		long result = (end.getTime() - start.getTime()) / (60 * 1000);
		return interval == 0 ? (int) result : (int) result + 1;
	}

	/**
	 * 计算Date增加day后的天数
	 * 
	 * @param start
	 *            开始时间
	 * @param day
	 *            增加的天数
	 * @return 处理后的时间
	 */
	public static Date calAddDays(Date start, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

	/**
	 * 生成跟起始时间相关的标记
	 * 
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return 标记
	 */
	public static String generateDateTag(Date start, Date end) {
		StringBuffer sb = new StringBuffer();
		sb.append(formatDate(start, FMT_DATE_SPECIAL)).append("_").append(formatDate(end, FMT_DATE_SPECIAL));
		return sb.toString();
	}

	/**
	 * 
	 * 方法用途: 传入时间秒,转换成天小时分<br>
	 * 实现步骤: <br>
	 * 
	 * @param seconds
	 * @return 秒转小时分
	 */
	public static String changeSecondsToStr(int seconds) {
		int mi = 60;
		int hh = mi * 60;
		int dd = hh * 24;

		long day = seconds / dd;
		if (day > 0) {
			return day + "天";
		}
		long hour = seconds / hh;
		if (hour > 0) {
			return hour + "小时";
		}
		long minute = seconds / mi;
		if (minute > 0) {
			return minute + "分钟";
		}
		if (seconds > 0) {
			return seconds + "秒";
		}
		return "";
	}

	/**
	 * 得到给定日志结束的Date
	 * 
	 * @return
	 */
	public static Date getEndOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	public void dateCalculate() {
		/************************** 分钟想加 **********************************/
		/**
		 * 当前时间
		 */
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		// 获取到几分钟之前的数据
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -5);

		/**
		 * 五分钟之前
		 */
		Timestamp fiveMinutesAgo = new Timestamp(calendar.getTime().getTime());
		/********************
		 * 以上 测试通过
		 ***************************/
	}

	/**
	 * 
	 * @param dateStr
	 * @param dateFormatParam
	 * @return
	 */
	// 测试结果如下：澄清点 date是带 时分秒如下：01:02:03
	// Date date = DateUtil.strToDate("2015-06-01 01:02:03", "yyyy-MM-dd
	// HH:mm:ss");
	// System.out.println("date1= " + date);// date1= Mon Jun 01 01:02:03 CST
	// 2015
	public static Date convertStrToDate(String dateStr, String dateFormatParam) {
		try {
			String dateStrFormat = null;
			if (null != dateFormatParam) {
				dateStrFormat = dateFormatParam;
			} else {
				dateStrFormat = YYYY_MM_DD;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(dateStrFormat);
			Date date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
