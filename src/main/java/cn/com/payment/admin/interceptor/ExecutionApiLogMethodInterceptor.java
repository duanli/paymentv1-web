package cn.com.payment.admin.interceptor;

import java.lang.reflect.Method;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * <b>function:</b> Spring 接口调用拦截器，主要拦截com.xxx.*.sdk.client对外接口
 * @author hoojo
 * @createDate 2016-11-24 下午5:39:57
 * @file ExecutionApiLogMethodInterceptor.java
 * @package com.xxx.eduyun.sdk.framework
 * @project eduyun-sdk-service
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ExecutionApiLogMethodInterceptor implements MethodInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class.getName());
    private static final ObjectMapper mapper = new ObjectMapper();
    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        info("************************************【接口调用拦截开始】*************************************");
        String targetName = invocation.getThis().getClass().getSimpleName();
        Method method = invocation.getMethod();
        String methodName = method.getName();
        
        info("系统开始执行方法：{}.{}", targetName, methodName);
        
        info("【{}.{}】方法参数打印如下：", targetName, methodName);
        Object[] args = invocation.getArguments();
        
        //printArgs(args, method, invocation.getThis().getClass());
        printArgs(args, method);
        
        try {
            long timed = System.currentTimeMillis();
            
            Object result = invocation.proceed();

            info("【{}.{}】方法执行完成，耗时：【{}ms】", targetName, methodName, new Date().getTime() - timed);
            info("【{}.{}】方法执行返回结果：{}", targetName, methodName, result);
            
            info("【{}.{}】方法返回数据打印如下：", targetName, methodName);
            printResult(result);
            info("************************************【接口调用拦截结束*】************************************");
            
            return result;
        } catch (Throwable throwable) {
            error("外部接口调用方法【{}.{}】异常：", targetName, methodName, throwable);
            
            info("************************************【接口异常拦截结束】*************************************");
            throw throwable;
        }
    }
    
    private void printArgs(Object[] args, Method method) {
        try {
            
            String[] argNames = null;
            try {
                argNames = ParameterNameUtils.getMethodParamNames(method);
            } catch (Exception e) {
                error("获取参数名称异常：", e);
            }
            
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    String argName = "";
                    if (argNames != null && argNames.length >= i) {
                        argName = argNames[i];
                    }
                    
                    if (args[i] != null) {
                        String value = "";
                        try {
                            value = mapper.writeValueAsString(args[i]);
                        } catch (Exception e) {
                            error("转换参数 \"{}\" 发生异常：", argName, e);
                        }
                        info("【参数 \"{}\" 】：({})", argName, value);
                    } else {
                        info("参数 \"{}\"：NULL", argName);
                    }
                }
            }
        } catch (Exception e) {
            error("【接口调用拦截器】打印方法执行参数异常：", e);
        }
    }
    
    private void printResult(Object result) {
        if (result != null) {
            try {
                info("【返回数据】：({})", mapper.writeValueAsString(result));
            } catch (Exception e) {
                error("返回数据打印异常：", e);
            }
        } else {
            info("【返回数据】：NULL");
        }
    }
    
    protected final void error(String msg, Object... objects) {
    	logger.error(msg, objects);
    }

    protected final void info(String msg, Object... objects) {
    	logger.info(msg, objects);
    }
}