package cn.com.payment.admin.model;

import java.io.Serializable;



/**
 * 代码生成器自动生成 Date:2015-6-10 16:35:00
 * 
 * @author rono
 */
public class AdminRole implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long adminId; // 管理员ID
	private Long roleId; // 角色ID
	
	public AdminRole() {
	}

	public AdminRole(Long adminId, Long roleId) {
		this.adminId = adminId;
		this.roleId = roleId;
	}

	/**
	 * 管理员ID
	 * 
	 * @return adminId
	 */
	public Long getAdminId() {
		return adminId;
	}

	/**
	 * 管理员ID
	 * 
	 * @param adminId
	 */
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	/**
	 * 角色ID
	 * 
	 * @return roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 角色ID
	 * 
	 * @param roleId
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}