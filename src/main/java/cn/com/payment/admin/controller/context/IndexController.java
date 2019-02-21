package cn.com.payment.admin.controller.context;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.payment.admin.model.Admin;
import cn.com.payment.admin.service.AdminRoleService;
import cn.com.payment.admin.utils.CommonUtils;

@Controller
public class IndexController {

	@Autowired
	private AdminRoleService adminRoleService;

	/**
	 * shiro 拦截器（authc）会对提交的认证信息进行拦截，首先进入自定义的Realm方法，验证完成才进行下面的方法(前置拦截器)
	 * 
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	public String login(HttpServletRequest req, Model model) {
		// 解决用户退出后，session未清空，按钮不显示的问题
		/*
		 * if (SecurityUtils.getSubject().getSession() != null) {
		 * SecurityUtils.getSubject().logout(); }
		 */
		// && SecurityUtils.getSubject().isPermitted("menu:view")
		if (SecurityUtils.getSubject().isAuthenticated()) {
			String userName = (String) SecurityUtils.getSubject()
					.getPrincipal();
			List<Admin> list = null;
			try {
				list = adminRoleService.searchByProperty(new Admin(userName,
						false));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (CommonUtils.isNotEmpty(list)) {
				Session session = SecurityUtils.getSubject().getSession();
//				session.setAttribute("merAgentId", list.get(0).getMerAgentId());
				session.setAttribute("merId", list.get(0).getMerId());
				session.setAttribute("adminId", list.get(0).getId());
				session.setAttribute("roleId", list.get(0).getRoles().get(0).getId());
			}
			return "redirect:/console/main.jsp";
		}
		final String exception = (String) req.getAttribute("shiroLoginFailure");
		String errorMsg = "";
		final String userName = req.getParameter("username");
		if (CommonUtils.isNotEmpty(exception)) {
			if (UnknownAccountException.class.getName().equals(exception)
					|| IncorrectCredentialsException.class.getName().equals(
							exception)) {
				errorMsg = "用户名或者密码错误，请重新输入！";
			} else if (LockedAccountException.class.getName().equals(exception)) {
				errorMsg = "用户已被锁定";
			} else {
				errorMsg = "账户异常，请联系管理员！";
			}
		}
		model.addAttribute("error", errorMsg);
		model.addAttribute("userName", userName);
		return "login";
	}
}