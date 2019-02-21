package cn.com.payment.admin.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
	/**
	 * md5加密方法
	 * 
	 * @author: zhengsunlei Jul 30, 2010 4:38:28 PM
	 * @param plainText
	 *            加密字符串
	 * @return String 返回32位md5加密字符串(16位加密取substring(8,24)) 每位工程师都有保持代码优雅的义务 each
	 *         engineer has a duty to keep the code elegant
	 */
	public final static String md5(String plainText) {
		// 返回字符串
		String md5Str = null;
		try {
			// 操作字符串
			StringBuffer buf = new StringBuffer();
			/**
			 * MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。
			 * 信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
			 * 
			 * MessageDigest 对象开始被初始化。 该对象通过使用 update()方法处理数据。 任何时候都可以调用
			 * reset()方法重置摘要。 一旦所有需要更新的数据都已经被更新了，应该调用digest()方法之一完成哈希计算。
			 * 
			 * 对于给定数量的更新数据，digest 方法只能被调用一次。 在调用 digest 之后，MessageDigest
			 * 对象被重新设置成其初始状态。
			 */
			MessageDigest md = MessageDigest.getInstance("MD5");

			// 添加要进行计算摘要的信息,使用 plainText 的 byte 数组更新摘要。
			md.update(plainText.getBytes("UTF-8"));
			// 计算出摘要,完成哈希计算。
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i += 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				// 将整型 十进制 i 转换为16位，用十六进制参数表示的无符号整数值的字符串表示形式。
				buf.append(Integer.toHexString(i));
			}
			// 32位的加密
			md5Str = buf.toString().toUpperCase();
			// 16位的加密
			// md5Str = buf.toString().md5Strstring(8,24);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5Str;
	}
	
	public static String parseStrToMd5L32(String str) {
		String reStr = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = null;
			try {
				bytes = md5.digest(str.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			StringBuffer stringBuffer = new StringBuffer();
			for (byte b : bytes) {
				int bt = b & 0xff;
				if (bt < 16) {
					stringBuffer.append(0);
				}
				stringBuffer.append(Integer.toHexString(bt));
			}
			reStr = stringBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return reStr;
	}
	public static boolean checkMD5(String verifyString, String md5) {
		return md5.equals(md5(verifyString));
	}

	/**
	 * 微信sha1签名
	 * 
	 * @param str
	 * @return
	 */
	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));

			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
//		System.out.println(getSha1(
//				"jsapi_ticket=IpK_1T69hDhZkLQTlwsAX9TLqBBCS5eEzj-tKscauRFC_RbKqb3G_5A3iGMkypLVEpJ1dey699PdPtQn4Rxp7g&noncestr=7qmbwn868xmj9w0k&timestamp=1513931346&url=http://test.jike8.com.cn/mobile/product/detail?productId=2&currentOpenId=ob0tZwQghpEsh76UO5m1oGhprplI"));
	
		System.out.println(parseStrToMd5L32("Phone=18608009015&Phonepassword=123456&SysId=101&key=allinpaysc123"));
	}
}