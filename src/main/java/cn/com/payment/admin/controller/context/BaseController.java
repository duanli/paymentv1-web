package cn.com.payment.admin.controller.context;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.com.payment.admin.model.Admin;
import cn.com.payment.admin.model.Role;
import cn.com.payment.admin.service.AdminRoleService;
import cn.com.payment.admin.utils.CommonUtils;

@Controller
public abstract class BaseController {
	@Autowired
	private AdminRoleService adminRoleService;
	
	public String getLoginUserName(){
		String str = (String)SecurityUtils.getSubject().getPrincipal();
		System.out.println(str);
		return null;
	}
	/**
	 * 获取当前用户的所有角色
	 * @return
	 * @throws Exception 
	 */
	public List<Role> getLoginUserRoles() throws Exception{
		String userName = (String)SecurityUtils.getSubject().getPrincipal();
		if(CommonUtils.isNotEmpty(userName)){
			List<Admin> list = adminRoleService.searchAdminAndRole(new Admin(userName,false));
			if(null!=list && list.size()>0){
				List<Role> roles = list.get(0).getRoles();
				if(null!=roles && roles.size()>0)
					return roles;
			}
		}
		return new ArrayList<Role>();
	}
	/**
	 * 获取当前登录用户的所以角色id
	 * @return
	 * @throws Exception 
	 */
	public Long[] getLoginUserRoleIds() throws Exception{
		List<Role> roles = getLoginUserRoles();
		if(null!=roles && roles.size()>0){
			Long[] ids =  new Long[roles.size()];
			for(int i=0,len=roles.size();i<len;i++){
				ids[i] = roles.get(i).getId();
			}
			return ids;
		}
		return null;
	}
}
