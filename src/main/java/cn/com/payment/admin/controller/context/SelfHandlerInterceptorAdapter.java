package cn.com.payment.admin.controller.context;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.com.payment.admin.utils.CommonUtils;

/**
 * 自定义过滤器
 * 2015-5-25
 * @author rono
 */
public class SelfHandlerInterceptorAdapter extends HandlerInterceptorAdapter{
	private static final Logger logger = LogManager.getLogger(SelfHandlerInterceptorAdapter.class.getName());
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("[系统]IP("+getIpAddr(request)+") 访问了系统地址:"+request.getRequestURL()+(CommonUtils.isEmpty(request.getQueryString())?"":"?"+request.getQueryString()));
		return super.preHandle(request, response, handler);
	}
	 
	public static String bytes2String(byte[] res,String charset) {
		String des = "";
		if (res != null) {
			des = (new String(res,Charset.forName(charset))).trim();
		}
		return des;
	}
	public static String getIpAddr(HttpServletRequest request) throws Exception {  
	    if (request == null) {  
	        return "";
	    }  
	    String ipString = request.getHeader("x-forwarded-for");  
	    if (CommonUtils.isEmpty(ipString) || "unknown".equalsIgnoreCase(ipString)) {  
	        ipString = request.getHeader("Proxy-Client-IP");  
	    }  
	    if (CommonUtils.isEmpty(ipString) || "unknown".equalsIgnoreCase(ipString)) {  
	        ipString = request.getHeader("WL-Proxy-Client-IP");  
	    }  
	    if (CommonUtils.isEmpty(ipString) || "unknown".equalsIgnoreCase(ipString)) {  
	        ipString = request.getRemoteAddr();  
	    }  
	  
	    // 多个路由时，取第一个非unknown的ip  
	    final String[] arr = ipString.split(",");  
	    for (final String str : arr) {  
	        if (!"unknown".equalsIgnoreCase(str)) {  
	            ipString = str;  
	            break;  
	        }  
	    }  
	    return ipString;  
	} 
}
