package cn.com.payment.admin.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * 用以获得真实ip(如果存在代理可能会获取不真实的ip地址)
 * 
 * @author email 1034847021@qq.com
 */
public class GetRealIp {
	public static String getIpAddr(HttpServletRequest request) {
		if (null == request) {
		return "";
		}
		String ip = request.getHeader("x-forwarded-for");
		if(ip != null) {
//			String[] ips = ip.split(",");
			ip = ip.split(",")[0];
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getRemoteAddr();
		}
		return ip == null ? "" : ip;
		}

	public static String getIpAddress() throws SocketException, UnknownHostException {
		Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		while (allNetInterfaces.hasMoreElements()) {
			NetworkInterface netInterface = allNetInterfaces.nextElement();
			System.out.println(netInterface.getName());
			Enumeration<InetAddress> addresses = netInterface	.getInetAddresses();
			while (addresses.hasMoreElements()) {
				ip = addresses.nextElement();
				if (ip != null && ip instanceof Inet4Address) {
					System.out.println("本机的IP = " + ip.getHostAddress());
					//return ip.getHostAddress();
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws SocketException, UnknownHostException {
		getIpAddress();
	}
}
