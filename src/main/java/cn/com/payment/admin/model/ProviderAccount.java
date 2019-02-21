package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ProviderAccount
 *
 * Date:2019-1-30 14:14:58
 * 
 * @author dl
 */
public class ProviderAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 支付账户主键
	 */
	private Long providerAccId;
	/**
	 * 服务商主键ID
	 */
	private Long providerId;

	private String accName;
	/**
	 * 服务商账户号
	 */
	private String providerMchNo;
	/**
	 * 服务商账户密钥
	 */
	private String providerMchKey;
	/**
	 * 服务商应用ID
	 */
	private String providerAPPId;
	/**
	 * 服务商公钥
	 */
	private String providerRSAKey;
	/**
	 * 状态0-未启用;1-启用2-暂停
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
	/**
	 * 手续费费率万分之
	 */
	private Integer feeRate;
	/**
	 * 账户总余额
	 */
	private Long balance;

	private Provider provider;

	public ProviderAccount() {
	}

	public ProviderAccount(Long providerAccId, Long providerId, String providerMchNo, String providerMchKey,
			String providerAPPId, String providerRSAKey, String state, Date createTime, Date updateTime,
			Integer feeRate, Long balance) {
		this.providerAccId = providerAccId;
		this.providerId = providerId;
		this.providerMchNo = providerMchNo;
		this.providerMchKey = providerMchKey;
		this.providerAPPId = providerAPPId;
		this.providerRSAKey = providerRSAKey;
		this.state = state;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.feeRate = feeRate;
		this.balance = balance;
	}

	private ProviderAccount(ProviderAccountBuilder builder) {
		this.providerAccId = builder.providerAccId;
		this.providerId = builder.providerId;
		this.providerMchNo = builder.providerMchNo;
		this.providerMchKey = builder.providerMchKey;
		this.providerAPPId = builder.providerAPPId;
		this.providerRSAKey = builder.providerRSAKey;
		this.state = builder.state;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
		this.feeRate = builder.feeRate;
		this.balance = builder.balance;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	/**
	 * 支付账户主键
	 * 
	 * @return providerAccId
	 */
	public Long getProviderAccId() {
		return providerAccId;
	}

	/**
	 * 支付账户主键
	 * 
	 * @param providerAccId
	 */
	public void setProviderAccId(Long providerAccId) {
		this.providerAccId = providerAccId;
	}

	/**
	 * 服务商主键ID
	 * 
	 * @return providerId
	 */
	public Long getProviderId() {
		return providerId;
	}

	/**
	 * 服务商主键ID
	 * 
	 * @param providerId
	 */
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	/**
	 * 服务商账户号
	 * 
	 * @return providerMchNo
	 */
	public String getProviderMchNo() {
		return providerMchNo;
	}

	/**
	 * 服务商账户号
	 * 
	 * @param providerMchNo
	 */
	public void setProviderMchNo(String providerMchNo) {
		this.providerMchNo = providerMchNo;
	}

	/**
	 * 服务商账户密钥
	 * 
	 * @return providerMchKey
	 */
	public String getProviderMchKey() {
		return providerMchKey;
	}

	/**
	 * 服务商账户密钥
	 * 
	 * @param providerMchKey
	 */
	public void setProviderMchKey(String providerMchKey) {
		this.providerMchKey = providerMchKey;
	}

	/**
	 * 服务商应用ID
	 * 
	 * @return providerAPPId
	 */
	public String getProviderAPPId() {
		return providerAPPId;
	}

	/**
	 * 服务商应用ID
	 * 
	 * @param providerAPPId
	 */
	public void setProviderAPPId(String providerAPPId) {
		this.providerAPPId = providerAPPId;
	}

	/**
	 * 服务商公钥
	 * 
	 * @return providerRSAKey
	 */
	public String getProviderRSAKey() {
		return providerRSAKey;
	}

	/**
	 * 服务商公钥
	 * 
	 * @param providerRSAKey
	 */
	public void setProviderRSAKey(String providerRSAKey) {
		this.providerRSAKey = providerRSAKey;
	}

	/**
	 * 状态0-未启用;1-启用2-暂停
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 状态0-未启用;1-启用2-暂停
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

	/**
	 * 手续费费率万分之
	 * 
	 * @return feeRate
	 */
	public Integer getFeeRate() {
		return feeRate;
	}

	/**
	 * 手续费费率万分之
	 * 
	 * @param feeRate
	 */
	public void setFeeRate(Integer feeRate) {
		this.feeRate = feeRate;
	}

	/**
	 * 账户总余额
	 * 
	 * @return balance
	 */
	public Long getBalance() {
		return balance;
	}

	/**
	 * 账户总余额
	 * 
	 * @param balance
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public static class ProviderAccountBuilder {
		private Long providerAccId; // 支付账户主键
		private Long providerId; // 服务商主键ID
		private String providerMchNo; // 服务商账户号
		private String providerMchKey; // 服务商账户密钥
		private String providerAPPId; // 服务商应用ID
		private String providerRSAKey; // 服务商公钥
		private String state; // 状态0-未启用;1-启用2-暂停
		private Date createTime; // 创建时间
		private Date updateTime; // 更新时间
		private Integer feeRate; // 手续费费率万分之
		private Long balance; // 账户总余额

		/**
		 * 支付账户主键
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addProviderAccId(Long providerAccId) {
			this.providerAccId = providerAccId;
			return this;
		}

		/**
		 * 服务商主键ID
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addProviderId(Long providerId) {
			this.providerId = providerId;
			return this;
		}

		/**
		 * 服务商账户号
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addProviderMchNo(String providerMchNo) {
			this.providerMchNo = providerMchNo;
			return this;
		}

		/**
		 * 服务商账户密钥
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addProviderMchKey(String providerMchKey) {
			this.providerMchKey = providerMchKey;
			return this;
		}

		/**
		 * 服务商应用ID
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addProviderAPPId(String providerAPPId) {
			this.providerAPPId = providerAPPId;
			return this;
		}

		/**
		 * 服务商公钥
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addProviderRSAKey(String providerRSAKey) {
			this.providerRSAKey = providerRSAKey;
			return this;
		}

		/**
		 * 状态0-未启用;1-启用2-暂停
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 更新时间
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		/**
		 * 手续费费率万分之
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addFeeRate(Integer feeRate) {
			this.feeRate = feeRate;
			return this;
		}

		/**
		 * 账户总余额
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addBalance(Long balance) {
			this.balance = balance;
			return this;
		}

		public ProviderAccount build() {
			return new ProviderAccount(this);
		}
	}
}