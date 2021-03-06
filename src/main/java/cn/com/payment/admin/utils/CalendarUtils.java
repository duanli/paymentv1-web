package cn.com.payment.admin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CalendarUtils {

	public static int getDayofweek(String date) {
		Calendar cal = Calendar.getInstance();
		if (date.equals("")) {
			cal.setTime(new Date(System.currentTimeMillis()));
		} else {
			cal.setTime(new Date(DateUtils.parse(date, "yyyyMMdd").getTime()));
		}
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获取指定月天数
	 * 
	 * @param num
	 *            0=当前月 -1上月,1=下月，以此类推
	 * @return
	 */
	public static int getDayCountForMonth(int num) {
		Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
		aCalendar.add(Calendar.MONTH, num);
		int day = aCalendar.getActualMaximum(Calendar.DATE);
		return day;
	}
	
	/**
	 * 获取指定月天数
	 * 
	 * @param date yyyyMM
	 * @return
	 */
	public static int getDayCountForSpecfyMonth(String date) {
		Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
		int year = Integer.parseInt(date.substring(0, 4));
		String monthsString = date.substring(4, 6);
		int month;
		if ("0".equals(monthsString.substring(0, 1))) {
			month = Integer.parseInt(monthsString.substring(1, 2));
		} else {
			month = Integer.parseInt(monthsString.substring(0, 2));
		}
		aCalendar.set(year, month - 1, Calendar.DATE);
		int day = aCalendar.getActualMaximum(Calendar.DATE);
		return day;
	}

	// 获取当前月每天的日期
	public static List<String> getDayListOfMonthStrs() {
		List<String> list = new ArrayList<String>();
		Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
		int year = aCalendar.get(Calendar.YEAR);// 年份
		int month = aCalendar.get(Calendar.MONTH);// 月份
		int day = aCalendar.getActualMaximum(Calendar.DATE);
		for (int i = 1; i <= day; i++) {
			String aDate = String.valueOf(year) + "/" + month + String.format("%02d", i);
			list.add(aDate);
		}
		return list;
	}

	/**
	 * 获取当前时间
	 * 
	 * @param args
	 */
	public static String getNowTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
		String lastMonth = dft.format(cal.getTime());
		return lastMonth;
	}

	/**
	 * 判断当天是否为本月第一天
	 * 
	 * @return
	 */
	public static boolean isFirstDayOfMonth() {
		boolean flag = false;
		Calendar calendar = Calendar.getInstance();
		int today = calendar.get(Calendar.DAY_OF_MONTH);
		if (1 == today) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 获取当前月份最后一天
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getMaxMonthDate() {
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		// calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dft.format(calendar.getTime());
	}

	/**
	 * 
	 * 描述:获取下一个月的第一天.
	 * 
	 * @return
	 */
	public static String getPerFirstDayOfMonth() {
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return dft.format(calendar.getTime());
	}

	/**
	 * 
	 * 描述:获取上个月的最后一天.
	 * 
	 * @return
	 */
	public static String getLastMaxMonthDate() {
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dft.format(calendar.getTime());
	}

	/**
	 * 获取上一个月
	 * 
	 * @return
	 */
	public static String getLastMonth() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
		String lastMonth = dft.format(cal.getTime());
		return lastMonth;
	}

	/**
	 * 
	 * 描述:获取指定月.
	 * @param num
	 *            0=当前月 -1上月,1=下月，以此类推
	 * @return
	 */
	public static String getSpecifyMonth(int num) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, num);
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
		String nextMonth = dft.format(cal.getTime());
		return nextMonth;
	}

	// 是否是最后一天
	public static boolean isLastDayOfMonth() {
		boolean flag = false;
		if (getMaxMonthDate().equals(getNowTime())) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 获取任意时间的下一个月 描述:<描述函数实现的功能>.
	 * 
	 * @param repeatDate
	 * @return
	 */
	public static String getPreMonth(String repeatDate) {
		String lastMonth = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
		int year = Integer.parseInt(repeatDate.substring(0, 4));
		String monthsString = repeatDate.substring(4, 6);
		int month;
		if ("0".equals(monthsString.substring(0, 1))) {
			month = Integer.parseInt(monthsString.substring(1, 2));
		} else {
			month = Integer.parseInt(monthsString.substring(0, 2));
		}
		cal.set(year, month, Calendar.DATE);
		lastMonth = dft.format(cal.getTime());
		return lastMonth;
	}

	/**
	 * 获取任意时间的上一个月 描述:<描述函数实现的功能>.
	 * 
	 * @param repeatDate
	 * @return
	 */
	public static String getLastMonth(String repeatDate) {
		String lastMonth = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
		int year = Integer.parseInt(repeatDate.substring(0, 4));
		String monthsString = repeatDate.substring(4, 6);
		int month;
		if ("0".equals(monthsString.substring(0, 1))) {
			month = Integer.parseInt(monthsString.substring(1, 2));
		} else {
			month = Integer.parseInt(monthsString.substring(0, 2));
		}
		cal.set(year, month - 2, Calendar.DATE);
		lastMonth = dft.format(cal.getTime());
		return lastMonth;
	}

	/**
	 * 获取任意时间的月的最后一天 描述:<描述函数实现的功能>.
	 * 
	 * @param repeatDate
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String getMaxMonthDate(String repeatDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		try {
			if (null != repeatDate && !"null".equals(repeatDate)) {
				calendar.setTime(dft.parse(repeatDate));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dft.format(calendar.getTime());
	}

	/**
	 * 获取任意时间的月第一天 描述:<描述函数实现的功能>.
	 * 
	 * @param repeatDate
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String getMinMonthDate(String repeatDate) {
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		try {
			if (null != repeatDate && !"".equals(repeatDate)) {
				calendar.setTime(dft.parse(repeatDate));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return dft.format(calendar.getTime());
	}

	/**
	 * 不论是当前时间，还是历史时间 皆是时间点的前天 repeatDate 任意时间
	 */
	public static String getModify2DaysAgo(String repeatDate) {
		Calendar cal = Calendar.getInstance();
		String daysAgo = "";
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
		if (repeatDate == null || "".equals(repeatDate)) {
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 2);

		} else {
			int year = Integer.parseInt(repeatDate.substring(0, 4));
			String monthsString = repeatDate.substring(4, 6);
			int month;
			if ("0".equals(monthsString.substring(0, 1))) {
				month = Integer.parseInt(monthsString.substring(1, 2));
			} else {
				month = Integer.parseInt(monthsString.substring(0, 2));
			}
			String dateString = repeatDate.substring(6, 8);
			int date;
			if ("0".equals(dateString.subSequence(0, 1))) {
				date = Integer.parseInt(dateString.substring(1, 2));
			} else {
				date = Integer.parseInt(dateString.substring(0, 2));
			}
			cal.set(year, month - 1, date - 1);
			System.out.println(dft.format(cal.getTime()));
		}
		daysAgo = dft.format(cal.getTime());
		return daysAgo;
	}

	/**
	 * 不论是当前时间，还是历史时间 皆是时间点的T-N天 repeatDate 任意时间 param 数字 可以表示前几天
	 */
	public static String getModifyNumDaysAgo(String repeatDate, int param) {
		Calendar cal = Calendar.getInstance();
		String daysAgo = "";
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
		if (repeatDate == null || "".equals(repeatDate)) {
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - param);
		} else {
			int year = Integer.parseInt(repeatDate.substring(0, 4));
			String monthsString = repeatDate.substring(4, 6);
			int month;
			if ("0".equals(monthsString.substring(0, 1))) {
				month = Integer.parseInt(monthsString.substring(1, 2));
			} else {
				month = Integer.parseInt(monthsString.substring(0, 2));
			}
			String dateString = repeatDate.substring(6, 8);
			int date;
			if ("0".equals(dateString.subSequence(0, 1))) {
				date = Integer.parseInt(dateString.substring(1, 2));
			} else {
				date = Integer.parseInt(dateString.substring(0, 2));
			}
			cal.set(year, month - 1, date - param + 1);
			System.out.println(dft.format(cal.getTime()));
		}
		daysAgo = dft.format(cal.getTime());
		return daysAgo;
	}

	public static void main(String[] args) {
		System.out.println(getDayCountForSpecfyMonth("201801"));
		;
	}
}
