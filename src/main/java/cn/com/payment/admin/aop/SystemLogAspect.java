package cn.com.payment.admin.aop;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import cn.com.payment.admin.annotation.SystemControllerLog;
import cn.com.payment.admin.annotation.SystemServiceLog;
import cn.com.payment.admin.model.Admin;
import cn.com.payment.admin.model.Log;
import cn.com.payment.admin.service.LogService;

/**
 * 系统日志切面类
 * 
 * @author lin.r.x
 *
 */
@Aspect
@Component
public class SystemLogAspect {
	private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

	private static final ThreadLocal<Date> beginTimeThreadLocal = new NamedThreadLocal<Date>("ThreadLocal beginTime");
	private static final ThreadLocal<Log> logThreadLocal = new NamedThreadLocal<Log>("ThreadLocal log");

	private static final ThreadLocal<Admin> currentUser = new NamedThreadLocal<>("ThreadLocal user");

	@Autowired(required = false)
	private HttpServletRequest request;

	// @Autowired
	// private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Autowired
	private LogService logService;

	/**
	 * Controller层切点 注解拦截
	 */
	@Pointcut("@annotation(cn.com.payment.admin.annotation.SystemControllerLog)")
	public void dbControllerAspect() {

	}

	/**
	 * Controller层切点 注解拦截
	 */
	@Pointcut("execution(* cn.com.payment.admin.controller..*.*Controller.*(..))")
	public void logFileControllerAspect() {

	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作的开始时间
	 * 
	 * @param joinPoint
	 *            切点
	 * @throws InterruptedException
	 */
	@Before("dbControllerAspect()")
	public void doDbBefore(JoinPoint joinPoint) throws InterruptedException {
		Date beginTime = new Date();
		beginTimeThreadLocal.set(beginTime);// 线程绑定变量（该数据只有当前请求的线程可见）
	}

	/**
	 * 后置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint
	 *            切点
	 */
	@After("dbControllerAspect()")
	public void doDbAfter(JoinPoint joinPoint) {
		String type = getControllerMethodType(joinPoint);// 日志类型(0-只记录日志文件;1-只记录数据库;2-记录文件以及数据库)
		// 判断
		if ("0".equals(type)) {// 0-只记录日志文件
			outLogFile(joinPoint);
		} else if ("1".equals(type)) {// 1-只记录数据库
			outLogDataBase(joinPoint);
		} else if ("2".equals(type)) {// 2-记录文件以及数据库
			outLogFile(joinPoint);
			outLogDataBase(joinPoint);
		} else {// 不处理
			logger.error("日志注解参数=type 配置不正确,请添加注解时候务必加上正确参数");
		}
		// Object object = ((Object) joinPoint).proceed();
	}

	/**
	 * 异常通知 记录操作报错日志
	 * 
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "dbControllerAspect()", throwing = "e")
	public void doDbAfterThrowing(JoinPoint joinPoint, Throwable e) {
		Log log = logThreadLocal.get();
		log.setType("error");
		log.setException(e.toString());
		logService.updateLog(log);
		// new UpdateLogThread(log, logService).start();
	}

	/**
	 * 输出文件日志
	 * 
	 * @param joinPoint切点
	 * @return discription
	 */
	public void outLogFile(JoinPoint joinPoint) {
		StringBuilder sb = new StringBuilder(1000);
		sb.append("-----------------------开始计时:")
				.append(new SimpleDateFormat("hh:mm:ss.SSS").format(new Date().getTime()))
				.append("-------------------------------------\n");

		sb.append("RemoteAddr: ").append(request.getRemoteAddr()).append("\n");
		sb.append("UserAgent: ").append(request.getHeader("user-agent")).append("\n");
		sb.append("Controller: ").append(joinPoint.getTarget().getClass().getName()).append("\n");
		sb.append("Method    : ").append(joinPoint.getSignature().getName()).append("\n");
		sb.append("URI       : ").append(request.getRequestURI()).append("\n");
		sb.append("请求Params    : ").append(getParamString(request.getParameterMap())).append("\n");
		//返回参数打印
//		Object[] arguments = joinPoint.getArgs();
//		Gson gson = new Gson();
//	    String params = gson.toJson(arguments[0]);
//		sb.append("返回Params    : ").append(params).append("\n");
		logger.info(sb.toString());
	}

	/**
	 * 写数据库日志
	 * 
	 * @param joinPoint切点
	 * @return discription
	 */
	public void outLogDataBase(JoinPoint joinPoint) {
		// 读取session中的用户
		HttpSession session = request.getSession();
		Admin user = (Admin) session.getAttribute("user");
		if (user != null) {
			Log log = new Log();
			log.setTitle(getControllerMethodDescription(joinPoint));
			log.setType("info");
			log.setRemoteAddr(request.getRemoteAddr());// 请求的IP
			log.setRequestUri(request.getRequestURI()); // 请求的Uri
			log.setMethod(request.getMethod());// 请求的方法类型(post/get)
			log.setUserAgent(request.getHeader("user-agent"));
			log.setMapToParams(request.getParameterMap());
			log.setUserId(user.getId());
			Date operateDate = beginTimeThreadLocal.get();
			log.setStartDate(operateDate);
			log.setTimeout(String.valueOf(System.currentTimeMillis() - beginTimeThreadLocal.get().getTime()));

			// 1.直接执行保存操作
			// this.logService.createSystemLog(log);

			// 2.优化:异步保存日志
			// new SaveLogThread(log, logService).start();

			// 3.再优化:通过线程池来执行日志保存
			// threadPoolTaskExecutor.execute(new SaveLogThread(log,
			// logService));
			// 4.再优化:通过异步线程池来执行service日志保存
			logService.createLog(log);
			logThreadLocal.set(log);
		}
	}

	/**
	 * 获取注解中对方法的描述信息 用于service层注解
	 * 
	 * @param joinPoint切点
	 * @return discription
	 */
	public static String getServiceMthodDescription2(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SystemServiceLog serviceLog = method.getAnnotation(SystemServiceLog.class);
		String discription = serviceLog.description();
		return discription;
	}

	/**
	 * 获取注解对象 用于Controller层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return SystemControllerLog
	 */
	public static SystemControllerLog getSystemControllerLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SystemControllerLog systemControllerLog = method.getAnnotation(SystemControllerLog.class);
		return systemControllerLog;
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return discription
	 */
	public static String getControllerMethodDescription(JoinPoint joinPoint) {
		return getSystemControllerLog(joinPoint).description();
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return type
	 */
	public static String getControllerMethodType(JoinPoint joinPoint) {
		return getSystemControllerLog(joinPoint).type();
	}

	private String getParamString(Map<String, String[]> map) {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, String[]> e : map.entrySet()) {
			sb.append(e.getKey()).append("=");
			String[] value = e.getValue();
			if (value != null && value.length == 1) {
				sb.append(value[0]).append("\t");
			} else {
				sb.append(Arrays.toString(value)).append("\t");
			}
		}
		return sb.toString();
	}
	/**
	 * 保存日志线程
	 */
	// private static class SaveLogThread implements Runnable {
	// private Log log;
	// private LogService logService;
	//
	// public SaveLogThread(Log log, LogService logService) {
	// this.log = log;
	// this.logService = logService;
	// }
	//
	// @Override
	// public void run() {
	// logService.create(log);
	// }
	// }

	/**
	 * 日志更新线程
	 */
	// private static class UpdateLogThread extends Thread {
	// private Log log;
	// private LogService logService;
	//
	// public UpdateLogThread(Log log, LogService logService) {
	// super(UpdateLogThread.class.getSimpleName());
	// this.log = log;
	// this.logService = logService;
	// }
	//
	// @Override
	// public void run() {
	// this.logService.update(log);
	// }
	// }
}
