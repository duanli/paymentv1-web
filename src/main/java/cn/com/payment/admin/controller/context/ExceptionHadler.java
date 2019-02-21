package cn.com.payment.admin.controller.context;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHadler implements HandlerExceptionResolver{
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView view=new ModelAndView();
		view.addObject("exception",ex);
		
		if(ex instanceof UnauthorizedException){
			view.setViewName("403");			
		}else if(ex instanceof IOException){
			view.setViewName("404");
		}
		return view;
	}
}