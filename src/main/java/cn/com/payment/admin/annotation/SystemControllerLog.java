package cn.com.payment.admin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 拦截Controller
 * 
 * @author lin.r.x
 *
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemControllerLog {
	/**
	 * 描述业务操作 例:Xxx管理-执行Xxx操作
	 * 
	 * @return
	 */
	String description() default "";
	
	/**
	* 操作表类型 0-只记录日志文件;1-只记录数据库;2-记录文件以及数据库
	*/
	String type() default "0";
}