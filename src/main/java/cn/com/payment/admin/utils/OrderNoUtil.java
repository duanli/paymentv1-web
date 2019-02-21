package cn.com.payment.admin.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class OrderNoUtil {

	public static String getOrderNo(String type) {
		String rand1 = RandomNumberGenerator.generateNumber(6);
		String rqUID = type + DateUtils.getNowDate("yyyyMMdd") + DateUtils.getNowDate("HHmmss") + rand1;
		return rqUID;

	}

	public static String getShareId() {
		String rand1 = RandomNumberGenerator.generateNumber(4);
		String rqUID = DateUtils.getNowDate("yyMMdd") + DateUtils.getNowDate("HHmmss") + rand1;
		return rqUID;

	}

	public static String toSignStr(Object obj, Class<?> clazz) {
		if (obj == null) {
			return "";
		}
		List<String> listStr = new ArrayList<String>();

		Field[] fields = clazz.getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
		try {
			for (Field f : fields) {
				f.setAccessible(true); // 设置些属性是可以访问的
				Object val = f.get(obj); // 得到此属性的值
				String name = f.getName(); // 得到此属性的名称
				if (!name.equals("sign") && CommonUtils.isNotEmpty(val)) {
					listStr.add(name + "=" + val);
				}
			}

		} catch (IllegalAccessException e) {
		}
		// 节点间以&符连接，形成最终待签名字符串
		Collections.sort(listStr);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < listStr.size(); i++) {
			String msg = listStr.get(i);
			if (i > 0) {
				sb.append("&");
			}
			sb.append(msg);
		}
		return sb.toString();
	}

	public static String toSignStrForMap(Map<String, String> map) {
		if (map == null) {
			return "";
		}
		List<String> listStr = new ArrayList<String>();

		for (String name : map.keySet()) {
			Object value = map.get(name);// 得到每个key多对用value的值
			if (!name.equals("sign") && CommonUtils.isNotEmpty(value)) {
				listStr.add(name + "=" + value);
			}
		}
		// 节点间以&符连接，形成最终待签名字符串
		Collections.sort(listStr);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < listStr.size(); i++) {
			String msg = listStr.get(i);
			if (i > 0) {
				sb.append("&");
			}
			sb.append(msg);
		}
		System.out.println("signString=" + sb.toString());
		return sb.toString();
	}

	// 生成带字符串的
	public static String getnonceStr(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String getSettleAccount(String memberId) {
		// md5
		String subStr = memberId.substring(memberId.length() - 11, memberId.length());
		// String md5Str = Md5.md5(Md5.md5(subStr));
		// String merchantId = subStr + md5Str.substring(0, 4);
		return "";

	}
}
