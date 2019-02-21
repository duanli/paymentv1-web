package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * User
 *
 * Date:2017-12-10 16:59:10
 * 
 * @author dl
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 机构ID
	 */
	private Long orgId;
	/**
	 * 推荐部门ID
	 */
	private Long parentDepId;
	/**
	 * 推荐人ID
	 */
	private Long parentUserId;
	/**
	 * 部门ID
	 */
	private Long departmentId;
	/**
	 * 名称
	 */
	private String userName;
	/**
	 * 手机号
	 */
	private String userCell;
	/**
	 * 身份证号
	 */
	private String idNo;
	/**
	 * 微信ID
	 */
	private String openId;

	/**
	 * 微信开放平台ID
	 */
	private String unionId;
	/**
	 * 支付宝ID
	 */
	private String aliId;

	private String acountId;
	/**
	 * 职务
	 */
	private String duties;
	/**
	 * 头像
	 */
	private String headerUrl;
	/**
	 * 昵称
	 */
	private String nick;
	/**
	 * 用户类型 0-代理人,1-粉丝
	 */
	private String userType;
	/**
	 * 状态 0-停用,1-启用
	 */
	private String state;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;


	public User() {
	}

	public User(Long userId, Long orgId, Long parentDepId, Long parentUserId, Long departmentId, String userName,
			String userCell, String idNo, String openId, String aliId, String duties, String headerUrl, String nick,
			String userType, String state, Date createTime, Date updateTime) {
		this.userId = userId;
		this.orgId = orgId;
		this.parentDepId = parentDepId;
		this.parentUserId = parentUserId;
		this.departmentId = departmentId;
		this.userName = userName;
		this.userCell = userCell;
		this.idNo = idNo;
		this.openId = openId;
		this.aliId = aliId;
		this.duties = duties;
		this.headerUrl = headerUrl;
		this.nick = nick;
		this.userType = userType;
		this.state = state;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	private User(UserBuilder builder) {
		this.userId = builder.userId;
		this.orgId = builder.orgId;
		this.parentDepId = builder.parentDepId;
		this.parentUserId = builder.parentUserId;
		this.departmentId = builder.departmentId;
		this.userName = builder.userName;
		this.userCell = builder.userCell;
		this.idNo = builder.idNo;
		this.openId = builder.openId;
		this.aliId = builder.aliId;
		this.duties = builder.duties;
		this.headerUrl = builder.headerUrl;
		this.nick = builder.nick;
		this.userType = builder.userType;
		this.state = builder.state;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getAcountId() {
		return acountId;
	}

	public void setAcountId(String acountId) {
		this.acountId = acountId;
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
	 * 推荐部门ID
	 * 
	 * @return parentDepId
	 */
	public Long getParentDepId() {
		return parentDepId;
	}

	/**
	 * 推荐部门ID
	 * 
	 * @param parentDepId
	 */
	public void setParentDepId(Long parentDepId) {
		this.parentDepId = parentDepId;
	}

	/**
	 * 推荐人ID
	 * 
	 * @return parentUserId
	 */
	public Long getParentUserId() {
		return parentUserId;
	}

	/**
	 * 推荐人ID
	 * 
	 * @param parentUserId
	 */
	public void setParentUserId(Long parentUserId) {
		this.parentUserId = parentUserId;
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
	 * 名称
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 名称
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 手机号
	 * 
	 * @return userCell
	 */
	public String getUserCell() {
		return userCell;
	}

	/**
	 * 手机号
	 * 
	 * @param userCell
	 */
	public void setUserCell(String userCell) {
		this.userCell = userCell;
	}

	/**
	 * 身份证号
	 * 
	 * @return idNo
	 */
	public String getIdNo() {
		return idNo;
	}

	/**
	 * 身份证号
	 * 
	 * @param idNo
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
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
	 * 职务
	 * 
	 * @return duties
	 */
	public String getDuties() {
		return duties;
	}

	/**
	 * 职务
	 * 
	 * @param duties
	 */
	public void setDuties(String duties) {
		this.duties = duties;
	}

	/**
	 * 头像
	 * 
	 * @return headerUrl
	 */
	public String getHeaderUrl() {
		return headerUrl;
	}

	/**
	 * 头像
	 * 
	 * @param headerUrl
	 */
	public void setHeaderUrl(String headerUrl) {
		this.headerUrl = headerUrl;
	}

	/**
	 * 昵称
	 * 
	 * @return nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * 昵称
	 * 
	 * @param nick
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * 用户类型 0-代理人,1-粉丝
	 * 
	 * @return userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * 用户类型 0-代理人,1-粉丝
	 * 
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * 状态 0-停用,1-启用
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 状态 0-停用,1-启用
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
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

	public static class UserBuilder {
		private Long userId; // 用户ID
		private Long orgId; // 机构ID
		private Long parentDepId; // 推荐部门ID
		private Long parentUserId; // 推荐人ID
		private Long departmentId; // 部门ID
		private String userName; // 名称
		private String userCell; // 手机号
		private String idNo; // 身份证号
		private String openId; // 微信ID
		private String aliId; // 支付宝ID
		private String duties; // 职务
		private String headerUrl; // 头像
		private String nick; // 昵称
		private String userType; // 用户类型 0-代理人,1-粉丝
		private String state; // 状态 0-停用,1-启用
		private Date createTime; // 创建时间
		private Date updateTime; // 更新时间

		/**
		 * 用户ID
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addUserId(Long userId) {
			this.userId = userId;
			return this;
		}

		/**
		 * 机构ID
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addOrgId(Long orgId) {
			this.orgId = orgId;
			return this;
		}

		/**
		 * 推荐部门ID
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addParentDepId(Long parentDepId) {
			this.parentDepId = parentDepId;
			return this;
		}

		/**
		 * 推荐人ID
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addParentUserId(Long parentUserId) {
			this.parentUserId = parentUserId;
			return this;
		}

		/**
		 * 部门ID
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
			return this;
		}

		/**
		 * 名称
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addUserName(String userName) {
			this.userName = userName;
			return this;
		}

		/**
		 * 手机号
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addUserCell(String userCell) {
			this.userCell = userCell;
			return this;
		}

		/**
		 * 身份证号
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addIdNo(String idNo) {
			this.idNo = idNo;
			return this;
		}

		/**
		 * 微信ID
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addOpenId(String openId) {
			this.openId = openId;
			return this;
		}

		/**
		 * 支付宝ID
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addAliId(String aliId) {
			this.aliId = aliId;
			return this;
		}

		/**
		 * 职务
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addDuties(String duties) {
			this.duties = duties;
			return this;
		}

		/**
		 * 头像
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addHeaderUrl(String headerUrl) {
			this.headerUrl = headerUrl;
			return this;
		}

		/**
		 * 昵称
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addNick(String nick) {
			this.nick = nick;
			return this;
		}

		/**
		 * 用户类型 0-代理人,1-粉丝
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addUserType(String userType) {
			this.userType = userType;
			return this;
		}

		/**
		 * 状态 0-停用,1-启用
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 更新时间
		 * 
		 * @return UserBuilder
		 */
		public UserBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}