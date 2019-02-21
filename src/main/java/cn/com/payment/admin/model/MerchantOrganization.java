package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * MerchantOrganization
 *
 * Date:2019-1-30 14:14:58
 * 
 * @author dl
 */
public class MerchantOrganization implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long orgId;
	/**
	 * 机构编号
	 */
	private String orgNo;
	/**
	 * 机构名称
	 */
	private String orgName;
	/**
	 * 机构描述
	 */
	private String orgDesc;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 联系人
	 */
	private String contacts;
	/**
	 * 联系人电话
	 */
	private String contactsCell;
	/**
	 * 机构APPID
	 */
	private String orgAPPId;
	/**
	 * 机构KEY
	 */
	private String orgKey;
	/**
	 * 机构公钥
	 */
	private String rsaKey;
	/**
	 * 状态 0-停用 1-启用 2-暂停
	 */
	private String state;
	/**
	 * 是否删除
	 */
	private String isDel;

	public MerchantOrganization() {
	}

	public MerchantOrganization(Long orgId, String orgNo, String orgName, String orgDesc, Date createTime,
			Date updateTime, String email, String contacts, String contactsCell, String orgAPPId, String orgKey,
			String rsaKey, String state, String isDel) {
		this.orgId = orgId;
		this.orgNo = orgNo;
		this.orgName = orgName;
		this.orgDesc = orgDesc;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.email = email;
		this.contacts = contacts;
		this.contactsCell = contactsCell;
		this.orgAPPId = orgAPPId;
		this.orgKey = orgKey;
		this.rsaKey = rsaKey;
		this.state = state;
		this.isDel = isDel;
	}

	private MerchantOrganization(MerchantOrganizationBuilder builder) {
		this.orgId = builder.orgId;
		this.orgNo = builder.orgNo;
		this.orgName = builder.orgName;
		this.orgDesc = builder.orgDesc;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
		this.email = builder.email;
		this.contacts = builder.contacts;
		this.contactsCell = builder.contactsCell;
		this.orgAPPId = builder.orgAPPId;
		this.orgKey = builder.orgKey;
		this.rsaKey = builder.rsaKey;
		this.state = builder.state;
		this.isDel = builder.isDel;
	}

	/**
	 * 主键ID
	 * 
	 * @return orgId
	 */
	public Long getOrgId() {
		return orgId;
	}

	/**
	 * 主键ID
	 * 
	 * @param orgId
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	/**
	 * 机构编号
	 * 
	 * @return orgNo
	 */
	public String getOrgNo() {
		return orgNo;
	}

	/**
	 * 机构编号
	 * 
	 * @param orgNo
	 */
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	/**
	 * 机构名称
	 * 
	 * @return orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * 机构名称
	 * 
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * 机构描述
	 * 
	 * @return orgDesc
	 */
	public String getOrgDesc() {
		return orgDesc;
	}

	/**
	 * 机构描述
	 * 
	 * @param orgDesc
	 */
	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
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
	 * 修改时间
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 修改时间
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 邮箱
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 邮箱
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 联系人
	 * 
	 * @return contacts
	 */
	public String getContacts() {
		return contacts;
	}

	/**
	 * 联系人
	 * 
	 * @param contacts
	 */
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	/**
	 * 联系人电话
	 * 
	 * @return contactsCell
	 */
	public String getContactsCell() {
		return contactsCell;
	}

	/**
	 * 联系人电话
	 * 
	 * @param contactsCell
	 */
	public void setContactsCell(String contactsCell) {
		this.contactsCell = contactsCell;
	}

	/**
	 * 机构APPID
	 * 
	 * @return orgAPPId
	 */
	public String getOrgAPPId() {
		return orgAPPId;
	}

	/**
	 * 机构APPID
	 * 
	 * @param orgAPPId
	 */
	public void setOrgAPPId(String orgAPPId) {
		this.orgAPPId = orgAPPId;
	}

	/**
	 * 机构KEY
	 * 
	 * @return orgKey
	 */
	public String getOrgKey() {
		return orgKey;
	}

	/**
	 * 机构KEY
	 * 
	 * @param orgKey
	 */
	public void setOrgKey(String orgKey) {
		this.orgKey = orgKey;
	}

	/**
	 * 机构公钥
	 * 
	 * @return rsaKey
	 */
	public String getRsaKey() {
		return rsaKey;
	}

	/**
	 * 机构公钥
	 * 
	 * @param rsaKey
	 */
	public void setRsaKey(String rsaKey) {
		this.rsaKey = rsaKey;
	}

	/**
	 * 状态 0-停用 1-启用 2-暂停
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 状态 0-停用 1-启用 2-暂停
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 是否删除
	 * 
	 * @return isDel
	 */
	public String getIsDel() {
		return isDel;
	}

	/**
	 * 是否删除
	 * 
	 * @param isDel
	 */
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public static class MerchantOrganizationBuilder {
		private Long orgId; // 主键ID
		private String orgNo; // 机构编号
		private String orgName; // 机构名称
		private String orgDesc; // 机构描述
		private Date createTime; // 创建时间
		private Date updateTime; // 修改时间
		private String email; // 邮箱
		private String contacts; // 联系人
		private String contactsCell; // 联系人电话
		private String orgAPPId; // 机构APPID
		private String orgKey; // 机构KEY
		private String rsaKey; // 机构公钥
		private String state; // 状态 0-停用 1-启用 2-暂停
		private String isDel; // 是否删除

		/**
		 * 主键ID
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addOrgId(Long orgId) {
			this.orgId = orgId;
			return this;
		}

		/**
		 * 机构编号
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addOrgNo(String orgNo) {
			this.orgNo = orgNo;
			return this;
		}

		/**
		 * 机构名称
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addOrgName(String orgName) {
			this.orgName = orgName;
			return this;
		}

		/**
		 * 机构描述
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addOrgDesc(String orgDesc) {
			this.orgDesc = orgDesc;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 修改时间
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		/**
		 * 邮箱
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addEmail(String email) {
			this.email = email;
			return this;
		}

		/**
		 * 联系人
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addContacts(String contacts) {
			this.contacts = contacts;
			return this;
		}

		/**
		 * 联系人电话
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addContactsCell(String contactsCell) {
			this.contactsCell = contactsCell;
			return this;
		}

		/**
		 * 机构APPID
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addOrgAPPId(String orgAPPId) {
			this.orgAPPId = orgAPPId;
			return this;
		}

		/**
		 * 机构KEY
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addOrgKey(String orgKey) {
			this.orgKey = orgKey;
			return this;
		}

		/**
		 * 机构公钥
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addRsaKey(String rsaKey) {
			this.rsaKey = rsaKey;
			return this;
		}

		/**
		 * 状态 0-停用 1-启用 2-暂停
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 是否删除
		 * 
		 * @return MerchantOrganizationBuilder
		 */
		public MerchantOrganizationBuilder addIsDel(String isDel) {
			this.isDel = isDel;
			return this;
		}

		public MerchantOrganization build() {
			return new MerchantOrganization(this);
		}
	}
}