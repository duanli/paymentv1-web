package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 代码生成器自动生成 Date:2015-6-10 16:35:00
 * 
 * @author rono
 */
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id; // 主键id
	private String userName; // 用户名
	private String pswd; // 用户密码
	private String salt; // 散列盐值
	private String name; // 姓名
	private String mateName; // 配偶姓名
	private Boolean gender; // 性别(0
	private String cellPhone; // 用户手机号
	private String photo; // 用户头像
	private String accNo; // 身份证号
	private String email; // 邮件
	private String qq; // QQ
	private Boolean state; // 状态：0/下线 1/在线 2/离开
	private String duty; // 职务
	private Boolean locked; // 是否锁定
	private Integer loginCount; // 登录次数
	private Date lastActivity; // 最近活动时间
	private String accounts; // 卖方详细信息
	private String remark; // 备注
	private Boolean isDel; // 显示标记(0
	private Date createDate; // 创建时间
	private Date updateDate; // 更新时间
	private String reserved1; // 保留字段1
	private String reserved2; // 保留字段2
	private Long merAgentId;
	private Long merId;
	private Long proAgentId;
	private List<Role> roles;

	public Admin() {
	}

	public Admin(String userName, Boolean isDel) {
		this.userName = userName;
		this.isDel = isDel;
	}

	public Long getMerAgentId() {
		return merAgentId;
	}

	public void setMerAgentId(Long merAgentId) {
		this.merAgentId = merAgentId;
	}

	public Long getMerId() {
		return merId;
	}

	public void setMerId(Long merId) {
		this.merId = merId;
	}

	public Long getProAgentId() {
		return proAgentId;
	}

	public void setProAgentId(Long proAgentId) {
		this.proAgentId = proAgentId;
	}

	/**
	 * 主键id
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 主键id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 用户名
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 用户密码
	 * 
	 * @return pswd
	 */
	public String getPswd() {
		return pswd;
	}

	/**
	 * 用户密码
	 * 
	 * @param pswd
	 */
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	/**
	 * 散列盐值
	 * 
	 * @return salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * 散列盐值
	 * 
	 * @param salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * 姓名
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 姓名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 配偶姓名
	 * 
	 * @return mateName
	 */
	public String getMateName() {
		return mateName;
	}

	/**
	 * 配偶姓名
	 * 
	 * @param mateName
	 */
	public void setMateName(String mateName) {
		this.mateName = mateName;
	}

	/**
	 * 性别(0
	 * 
	 * @return gender
	 */
	public Boolean getGender() {
		return gender;
	}

	/**
	 * 性别(0
	 * 
	 * @param gender
	 */
	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	/**
	 * 用户手机号
	 * 
	 * @return cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * 用户手机号
	 * 
	 * @param cellPhone
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * 用户头像
	 * 
	 * @return photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * 用户头像
	 * 
	 * @param photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * 身份证号
	 * 
	 * @return accNo
	 */
	public String getAccNo() {
		return accNo;
	}

	/**
	 * 身份证号
	 * 
	 * @param accNo
	 */
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	/**
	 * 邮件
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 邮件
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * QQ
	 * 
	 * @return qq
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * QQ
	 * 
	 * @param qq
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * 状态：0/下线 1/在线 2/离开
	 * 
	 * @return state
	 */
	public Boolean getState() {
		return state;
	}

	/**
	 * 状态：0/下线 1/在线 2/离开
	 * 
	 * @param state
	 */
	public void setState(Boolean state) {
		this.state = state;
	}

	/**
	 * 职务
	 * 
	 * @return duty
	 */
	public String getDuty() {
		return duty;
	}

	/**
	 * 职务
	 * 
	 * @param duty
	 */
	public void setDuty(String duty) {
		this.duty = duty;
	}

	/**
	 * 是否锁定
	 * 
	 * @return locked
	 */
	public Boolean getLocked() {
		return locked;
	}

	/**
	 * 是否锁定
	 * 
	 * @param locked
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	/**
	 * 登录次数
	 * 
	 * @return loginCount
	 */
	public Integer getLoginCount() {
		return loginCount;
	}

	/**
	 * 登录次数
	 * 
	 * @param loginCount
	 */
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	/**
	 * 最近活动时间
	 * 
	 * @return lastActivity
	 */
	public Date getLastActivity() {
		return lastActivity;
	}

	/**
	 * 最近活动时间
	 * 
	 * @param lastActivity
	 */
	public void setLastActivity(Date lastActivity) {
		this.lastActivity = lastActivity;
	}

	/**
	 * 卖方详细信息
	 * 
	 * @return accounts
	 */
	public String getAccounts() {
		return accounts;
	}

	/**
	 * 卖方详细信息
	 * 
	 * @param accounts
	 */
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	/**
	 * 备注
	 * 
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 显示标记(0
	 * 
	 * @return isDel
	 */
	public Boolean getIsDel() {
		return isDel;
	}

	/**
	 * 显示标记(0
	 * 
	 * @param isDel
	 */
	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	/**
	 * 创建时间
	 * 
	 * @return createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 创建时间
	 * 
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 更新时间
	 * 
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 更新时间
	 * 
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 保留字段1
	 * 
	 * @return reserved1
	 */
	public String getReserved1() {
		return reserved1;
	}

	/**
	 * 保留字段1
	 * 
	 * @param reserved1
	 */
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}

	/**
	 * 保留字段2
	 * 
	 * @return reserved2
	 */
	public String getReserved2() {
		return reserved2;
	}

	/**
	 * 保留字段2
	 * 
	 * @param reserved2
	 */
	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * 获得私盐
	 * 
	 * @return
	 */
	public String getNewSalt() {
		return userName + salt;
	}
}