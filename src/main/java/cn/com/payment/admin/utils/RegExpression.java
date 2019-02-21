package cn.com.payment.admin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpression {
	/**
	 * 正则表达式：检查银行卡号
	 */
	public static String REGEX_BANKCARDNUM= "^([1-9]{1})(\\d{14,18})$";
	/**
	 * 正则表达式：检查车牌号
	 */
	public static String REGEX_CARNUM = "^[\u4e00-\u9fa5|WJ]{1}[A-Z0-9]{6}$";
	/**
	 * 正则表达式：验证用户名
	 */
	public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

	/**
	 * 正则表达式：验证密码
	 */
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

	/**
	 * 正则表达式：验证手机号
	 */
	public static final String REGEX_MOBILE = "^((13[0-9])|(14[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$";

	/**
	 * 正则表达式：验证邮箱
	 */
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

	/**
	 * 正则表达式：验证汉字
	 */
	public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

	/**
	 * 正则表达式：验证身份证
	 */
	public static final String REGEX_ID_CARD = "^\\d{15}$|^\\d{17}[0-9Xx]$";

	/**
	 * 正则表达式：验证URL
	 */
	public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

	/**
	 * 正则表达式：验证IP地址
	 */
	public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
	/**
	 * 正则表达式：验证是否为金额数值
	 */
	public static final String REGEX_CASH_NUMBER = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$";

	// 通用方法调用 regExpress为表达式，str为被检查的字符串对象
	public static boolean checkCarNum(String regExpress, String str) {
		Pattern pattern = Pattern.compile(regExpress);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	// 检测手机号
	public static boolean isMobile(String mobile) {
		Pattern pattern = Pattern.compile(REGEX_MOBILE);
		Matcher matcher = pattern.matcher(mobile);
		return matcher.matches();
	}

	// 检测车牌号
	public static boolean isCarNum(String carNum) {
		Pattern pattern = Pattern.compile(REGEX_CARNUM);
		Matcher matcher = pattern.matcher(carNum);
		return matcher.matches();
	}

	// 检测身份证号
	public static boolean isIdCard(String idCard) {
		Pattern pattern = Pattern.compile(REGEX_ID_CARD);
		Matcher matcher = pattern.matcher(idCard);
		return matcher.matches();
	}

	public static boolean isCashNumber(String str) {
		Pattern pattern = Pattern.compile(REGEX_CASH_NUMBER); // 判断小数点后2位的数字的正则表达式
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	public static boolean isBankCardNo(String str) {
		Pattern pattern = Pattern.compile(REGEX_BANKCARDNUM); // 判断小数点后2位的数字的正则表达式
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(isCashNumber("1"));
	}
}
