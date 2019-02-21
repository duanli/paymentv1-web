package cn.com.payment.admin.config;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;;

/**
 * Created by jiaobuchong on 12/23/15.
 */
@Aspect // 定义一个切面
@Configuration
public class LogRecordAspect {
	private static final Logger logger = LoggerFactory.getLogger(LogRecordAspect.class);

	// 定义切点Pointcut
	@Pointcut("execution(* cn.allinpay.share.controller.*Controller.*(..))")
	public void excudeService() {
	}

	@Around("excudeService()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		Gson gson = new Gson();
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod(); // 获取被拦截的方法
		String methodName = method.getName(); // 获取被拦截的方法名
		Set<Object> allParams = new LinkedHashSet<>(); // 保存所有请求参数，用于输出到日志中
		Object result = null;
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			if (arg instanceof Map<?, ?>) {
				// 提取方法中的MAP参数，用于记录进日志中
				@SuppressWarnings("unchecked")
				Map<String, Object> map = (Map<String, Object>) arg;
				allParams.add(map);
				logger.info("\nAPP请求参数-↓-↓-↓-↓-↓-↓-↓-↓-↓-↓-\n{}", gson.toJson(arg));
			} else if (arg instanceof HttpServletRequest) {
				HttpServletRequest request = (HttpServletRequest) arg;
				// 获取query string 或 posted form data参数
				Map<String, String[]> paramMap = request.getParameterMap();
				if (paramMap != null && paramMap.size() > 0) {
					allParams.add(paramMap);
				}
			} else if (arg instanceof HttpServletResponse) {

			} else {
				if (methodName.contains("get") || methodName.contains("create") || methodName.contains("update")
						|| methodName.contains("delete"))
					logger.info("\nAPP请求参数-↓-↓-↓-↓-↓-↓-↓-↓-↓-↓-\n{}", gson.toJson(arg));
			}
		}
		// result的值就是被拦截方法的返回值
		result = pjp.proceed();
		if (methodName.contains("get") || methodName.contains("create") || methodName.contains("update")
				|| methodName.contains("delete"))
			// logger.info("\nAPP返回参数-↓-↓-↓-↓-↓-↓-↓-↓-↓-↓-\n{} ",
			// JsonUtils.to(result));
			logger.info("\nAPP返回参数-↓-↓-↓-↓-↓-↓-↓-↓-↓-↓-\n{} ",result);
		return result;
	}

	/***
	 * 获取 request 中 json 字符串的内容
	 * 
	 * @param request
	 * @return : <code>byte[]</code>
	 * @throws IOException
	 */
	public static String getRequestJsonString(HttpServletRequest request) throws IOException {
		String submitMehtod = request.getMethod();
		// GET
		if (submitMehtod.equals("GET")) {
			return new String(request.getQueryString().getBytes("iso-8859-1"), "utf-8").replaceAll("%22", "\"");
			// POST
		} else {
			return getRequestPostStr(request);
		}
	}

	/**
	 * 描述:获取 post 请求的 byte[] 数组
	 * 
	 * <pre>
	 * 举例：
	 * </pre>
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
		int contentLength = request.getContentLength();
		if (contentLength < 0) {
			return null;
		}
		byte buffer[] = new byte[contentLength];
		for (int i = 0; i < contentLength;) {

			int readlen = request.getInputStream().read(buffer, i, contentLength - i);
			if (readlen == -1) {
				break;
			}
			i += readlen;
		}
		return buffer;
	}

	/**
	 * 描述:获取 post 请求内容
	 * 
	 * <pre>
	 * 举例：
	 * </pre>
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static String getRequestPostStr(HttpServletRequest request) throws IOException {
		byte buffer[] = getRequestPostBytes(request);
		String charEncoding = request.getCharacterEncoding();
		if (charEncoding == null) {
			charEncoding = "UTF-8";
		}
		return new String(buffer, charEncoding);
	}

}