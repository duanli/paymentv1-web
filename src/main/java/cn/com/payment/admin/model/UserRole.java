package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * UserRole
 *
 * Date:2018-2-24 14:52:01
 * 
 * @author dl
 */
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
	private Long roleId;
	/**
	 * 用户ID
	 */
	private Long userId;

	private Long parentRoleId;
	/**
	 * 机构ID
	 */
	private Long orgId;
	/**
	 * 部门ID
	 */
	private Long departmentId;
	/**
	 * 微信开放平台ID
	 */
	private String unionId;
	/**
	 * 微信ID
	 */
	private String openId;
	/**
	 * 支付宝ID
	 */
	private String aliId;
	/**
	 * 状态[0-停用,1-启用]
	 */
	private String state;
	/**
	 * 角色类型[1-代理人,2-自由人,3-粉丝]
	 */
	private String roleType;
	/**
	 * 推荐标示[0-不可推荐,1-可以推荐]
	 */
	private String recoFlag;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	private User user;
	private UserRole puserRole;

	private String remark;

	public UserRole() {
	}

	public UserRole(Long roleId, Long userId, Long orgId, Long departmentId, String unionId, String openId,
			String aliId, String state, String roleType, String recoFlag, Date createTime, Date updateTime) {
		this.roleId = roleId;
		this.userId = userId;
		this.orgId = orgId;
		this.departmentId = departmentId;
		this.unionId = unionId;
		this.openId = openId;
		this.aliId = aliId;
		this.state = state;
		this.roleType = roleType;
		this.recoFlag = recoFlag;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	private UserRole(UserRoleBuilder builder) {
		this.roleId = builder.roleId;
		this.userId = builder.userId;
		this.orgId = builder.orgId;
		this.departmentId = builder.departmentId;
		this.unionId = builder.unionId;
		this.openId = builder.openId;
		this.aliId = builder.aliId;
		this.state = builder.state;
		this.roleType = builder.roleType;
		this.recoFlag = builder.recoFlag;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getParentRoleId() {
		return parentRoleId;
	}

	public void setParentRoleId(Long parentRoleId) {
		this.parentRoleId = parentRoleId;
	}

	public UserRole getPuserRole() {
		return puserRole;
	}

	public void setPuserRole(UserRole puserRole) {
		this.puserRole = puserRole;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	/**
	 * 用户ID
	 * 
	 * @return userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 用户ID
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 机构ID
	 * 
	 * @return orgId
	 */
	public Long getOrgId() {
		return orgId;
	}

	/**
	 * 机构ID
	 * 
	 * @param orgId
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	/**
	 * 部门ID
	 * 
	 * @return departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * 部门ID
	 * 
	 * @param departmentId
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * 微信开放平台ID
	 * 
	 * @return unionId
	 */
	public String getUnionId() {
		return unionId;
	}

	/**
	 * 微信开放平台ID
	 * 
	 * @param unionId
	 */
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	/**
	 * 微信ID
	 * 
	 * @return openId
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * 微信ID
	 * 
	 * @param openId
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * 支付宝ID
	 * 
	 * @return aliId
	 */
	public String getAliId() {
		return aliId;
	}

	/**
	 * 支付宝ID
	 * 
	 * @param aliId
	 */
	public void setAliId(String aliId) {
		this.aliId = aliId;
	}

	/**
	 * 状态[0-停用,1-启用]
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 状态[0-停用,1-启用]
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 角色类型[0-代理人,1-自由人,2-粉丝]
	 * 
	 * @return roleType
	 */
	public String getRoleType() {
		return roleType;
	}

	/**
	 * 角色类型[0-代理人,1-自由人,2-粉丝]
	 * 
	 * @param roleType
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	/**
	 * 推荐标示[0-不可推荐,1-可以推荐]
	 * 
	 * @return recoFlag
	 */
	public String getRecoFlag() {
		return recoFlag;
	}

	/**
	 * 推荐标示[0-不可推荐,1-可以推荐]
	 * 
	 * @param recoFlag
	 */
	public void setRecoFlag(String recoFlag) {
		this.recoFlag = recoFlag;
	}

	/**
	 * 创建时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 更新时间
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 更新时间
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static class UserRoleBuilder {
		private Long roleId; // 角色ID
		private Long userId; // 用户ID
		private Long orgId; // 机构ID
		private Long departmentId; // 部门ID
		private String unionId; // 微信开放平台ID
		private String openId; // 微信ID
		private String aliId; // 支付宝ID
		private String state; // 状态[0-停用,1-启用]
		private String roleType; // 角色类型[0-代理人,1-自由人,2-粉丝]
		private String recoFlag; // 推荐标示[0-不可推荐,1-可以推荐]
		private Date createTime; // 创建时间
		private Date updateTime; // 更新时间

		/**
		 * 角色ID
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addRoleId(Long roleId) {
			this.roleId = roleId;
			return this;
		}

		/**
		 * 用户ID
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addUserId(Long userId) {
			this.userId = userId;
			return this;
		}

		/**
		 * 机构ID
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addOrgId(Long orgId) {
			this.orgId = orgId;
			return this;
		}

		/**
		 * 部门ID
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
			return this;
		}

		/**
		 * 微信开放平台ID
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addUnionId(String unionId) {
			this.unionId = unionId;
			return this;
		}

		/**
		 * 微信ID
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addOpenId(String openId) {
			this.openId = openId;
			return this;
		}

		/**
		 * 支付宝ID
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addAliId(String aliId) {
			this.aliId = aliId;
			return this;
		}

		/**
		 * 状态[0-停用,1-启用]
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 角色类型[0-代理人,1-自由人,2-粉丝]
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addRoleType(String roleType) {
			this.roleType = roleType;
			return this;
		}

		/**
		 * 推荐标示[0-不可推荐,1-可以推荐]
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addRecoFlag(String recoFlag) {
			this.recoFlag = recoFlag;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 更新时间
		 * 
		 * @return UserRoleBuilder
		 */
		public UserRoleBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		public UserRole build() {
			return new UserRole(this);
		}
	}
}