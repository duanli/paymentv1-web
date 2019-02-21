package cn.com.payment.admin.service;

import java.util.List;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.Menu;

public interface RoleAuthService extends BaseService<Menu, Long> {
	List<Menu> searchTreeMenu(Menu menu) throws Exception;

	/**
	 * 创建角色权限
	 * 
	 * @param roleId
	 * @param roles
	 * @throws BizException
	 */
	void createRoleAuth(Long roleId, Long[] roles) throws BaseException, Exception;

	/**
	 * 获取角色相关的菜单信息
	 * 
	 * @param menu
	 * @return
	 */
	List<Menu> searchRoleMenu(Menu menu) throws Exception;

	/**
	 * 获取属性菜单
	 * 
	 * @param menu
	 * @return
	 * @throws Exception
	 */
	List<Menu> searchRoleMenuTree(Menu menu) throws Exception;
}
