package cn.com.payment.admin.model;

import java.io.Serializable;



/**
 * 代码生成器自动生成 Date:2015-6-10 16:35:00
 * 
 * @author rono
 */
public class RoleAuth implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long roleId; // 角色id
	private Long menuId; // 资源id

	public RoleAuth() {
	}

	public RoleAuth(Long roleId, Long menuId) {
		this.roleId = roleId;
		this.menuId = menuId;
	}
	/**
	 * 角色id
	 * 
	 * @return roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 角色id
	 * 
	 * @param roleId
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 资源id
	 * 
	 * @return menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * 资源id
	 * 
	 * @param menuId
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}