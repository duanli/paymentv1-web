package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ProviderAccount
 *
 * Date:2019-3-2 15:09:00
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
	 * 产品ID
	 */
	private Long productId;
	/**
	 * 账户名称
	 */
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
	 * 每日限额
	 */
	private Long totleAmtLimit;
	/**
	 * 单笔最低额度
	 */
	private Long minAmt;
	/**
	 * 单笔最高额度
	 */
	private Long maxAmt;
	/**
	 * 有效起始时间
	 */
	private Date beginTime;
	/**
	 * 有效截止时间
	 */
	private Date endTime;
	/**
	 * 限流状态0-停用；1-启用
	 */
	private String restrictState;
	/**
	 * 权重
	 */
	private Integer percentage;
	/**
	 * 基准费率(单位:万分之)
	 */
	private Integer feeRate;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 是否删除
	 */
	private String isDel;

	private String productName;

	public ProviderAccount() {
	}

	public ProviderAccount(Long providerAccId, Long productId, String accName, String providerMchNo,
			String providerMchKey, String providerAPPId, String providerRSAKey, String state, Long totleAmtLimit,
			Long minAmt, Long maxAmt, Date beginTime, Date endTime, String restrictState, Integer percentage,
			Integer feeRate, Date createTime, Date updateTime, String isDel) {
		this.providerAccId = providerAccId;
		this.productId = productId;
		this.accName = accName;
		this.providerMchNo = providerMchNo;
		this.providerMchKey = providerMchKey;
		this.providerAPPId = providerAPPId;
		this.providerRSAKey = providerRSAKey;
		this.state = state;
		this.totleAmtLimit = totleAmtLimit;
		this.minAmt = minAmt;
		this.maxAmt = maxAmt;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.restrictState = restrictState;
		this.percentage = percentage;
		this.feeRate = feeRate;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isDel = isDel;
	}

	private ProviderAccount(ProviderAccountBuilder builder) {
		this.providerAccId = builder.providerAccId;
		this.productId = builder.productId;
		this.accName = builder.accName;
		this.providerMchNo = builder.providerMchNo;
		this.providerMchKey = builder.providerMchKey;
		this.providerAPPId = builder.providerAPPId;
		this.providerRSAKey = builder.providerRSAKey;
		this.state = builder.state;
		this.totleAmtLimit = builder.totleAmtLimit;
		this.minAmt = builder.minAmt;
		this.maxAmt = builder.maxAmt;
		this.beginTime = builder.beginTime;
		this.endTime = builder.endTime;
		this.restrictState = builder.restrictState;
		this.percentage = builder.percentage;
		this.feeRate = builder.feeRate;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
		this.isDel = builder.isDel;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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
	 * 产品ID
	 * 
	 * @return productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * 产品ID
	 * 
	 * @param productId
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * 账户名称
	 * 
	 * @return accName
	 */
	public String getAccName() {
		return accName;
	}

	/**
	 * 账户名称
	 * 
	 * @param accName
	 */
	public void setAccName(String accName) {
		this.accName = accName;
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
	 * 每日限额
	 * 
	 * @return totleAmtLimit
	 */
	public Long getTotleAmtLimit() {
		return totleAmtLimit;
	}

	/**
	 * 每日限额
	 * 
	 * @param totleAmtLimit
	 */
	public void setTotleAmtLimit(Long totleAmtLimit) {
		this.totleAmtLimit = totleAmtLimit;
	}

	/**
	 * 单笔最低额度
	 * 
	 * @return minAmt
	 */
	public Long getMinAmt() {
		return minAmt;
	}

	/**
	 * 单笔最低额度
	 * 
	 * @param minAmt
	 */
	public void setMinAmt(Long minAmt) {
		this.minAmt = minAmt;
	}

	/**
	 * 单笔最高额度
	 * 
	 * @return maxAmt
	 */
	public Long getMaxAmt() {
		return maxAmt;
	}

	/**
	 * 单笔最高额度
	 * 
	 * @param maxAmt
	 */
	public void setMaxAmt(Long maxAmt) {
		this.maxAmt = maxAmt;
	}

	/**
	 * 有效起始时间
	 * 
	 * @return beginTime
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * 有效起始时间
	 * 
	 * @param beginTime
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * 有效截止时间
	 * 
	 * @return endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 有效截止时间
	 * 
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 限流状态0-停用；1-启用
	 * 
	 * @return restrictState
	 */
	public String getRestrictState() {
		return restrictState;
	}

	/**
	 * 限流状态0-停用；1-启用
	 * 
	 * @param restrictState
	 */
	public void setRestrictState(String restrictState) {
		this.restrictState = restrictState;
	}

	/**
	 * 权重
	 * 
	 * @return percentage
	 */
	public Integer getPercentage() {
		return percentage;
	}

	/**
	 * 权重
	 * 
	 * @param percentage
	 */
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	/**
	 * 基准费率(单位:万分之)
	 * 
	 * @return feeRate
	 */
	public Integer getFeeRate() {
		return feeRate;
	}

	/**
	 * 基准费率(单位:万分之)
	 * 
	 * @param feeRate
	 */
	public void setFeeRate(Integer feeRate) {
		this.feeRate = feeRate;
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

	public static class ProviderAccountBuilder {
		private Long providerAccId; // 支付账户主键
		private Long productId; // 产品ID
		private String accName; // 账户名称
		private String providerMchNo; // 服务商账户号
		private String providerMchKey; // 服务商账户密钥
		private String providerAPPId; // 服务商应用ID
		private String providerRSAKey; // 服务商公钥
		private String state; // 状态0-未启用;1-启用2-暂停
		private Long totleAmtLimit; // 每日限额
		private Long minAmt; // 单笔最低额度
		private Long maxAmt; // 单笔最高额度
		private Date beginTime; // 有效起始时间
		private Date endTime; // 有效截止时间
		private String restrictState; // 限流状态0-停用；1-启用
		private Integer percentage; // 权重
		private Integer feeRate; // 基准费率(单位:万分之)
		private Date createTime; // 创建时间
		private Date updateTime; // 更新时间
		private String isDel; // 是否删除

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
		 * 产品ID
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addProductId(Long productId) {
			this.productId = productId;
			return this;
		}

		/**
		 * 账户名称
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addAccName(String accName) {
			this.accName = accName;
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
		 * 每日限额
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addTotleAmtLimit(Long totleAmtLimit) {
			this.totleAmtLimit = totleAmtLimit;
			return this;
		}

		/**
		 * 单笔最低额度
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addMinAmt(Long minAmt) {
			this.minAmt = minAmt;
			return this;
		}

		/**
		 * 单笔最高额度
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addMaxAmt(Long maxAmt) {
			this.maxAmt = maxAmt;
			return this;
		}

		/**
		 * 有效起始时间
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addBeginTime(Date beginTime) {
			this.beginTime = beginTime;
			return this;
		}

		/**
		 * 有效截止时间
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addEndTime(Date endTime) {
			this.endTime = endTime;
			return this;
		}

		/**
		 * 限流状态0-停用；1-启用
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addRestrictState(String restrictState) {
			this.restrictState = restrictState;
			return this;
		}

		/**
		 * 权重
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addPercentage(Integer percentage) {
			this.percentage = percentage;
			return this;
		}

		/**
		 * 基准费率(单位:万分之)
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addFeeRate(Integer feeRate) {
			this.feeRate = feeRate;
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
		 * 是否删除
		 * 
		 * @return ProviderAccountBuilder
		 */
		public ProviderAccountBuilder addIsDel(String isDel) {
			this.isDel = isDel;
			return this;
		}

		public ProviderAccount build() {
			return new ProviderAccount(this);
		}
	}
}