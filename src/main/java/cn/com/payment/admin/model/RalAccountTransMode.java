package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * RalAccountTransMode
 *
 * Date:2019-2-14 22:10:01
 * 
 * @author dl
 */
public class RalAccountTransMode implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 商户交易方式Id
	 */
	private Long ralAccProductId;
	/**
	 * 商户主键ID
	 */
	private Long mchId;
	/**
	 * 支付账户主键
	 */
	private Long providerAccId;
	/**
	 * 交易产品ID
	 */
	private Long productId;
	/**
	 * 基准费率(单位:万分之)
	 */
	private Integer feeRate;
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
	 * 流量占比
	 */
	private Integer percentage;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 状态 0-停用 1-启用 2-暂停
	 */
	private String state;
	/**
	 * 是否删除
	 */
	private String isDel;
	/**
	 * IP白名单
	 */
	private String validIP;
	/**
	 * 限流状态0-停用；1-启用
	 */
	private String restrictState;
	/**
	 * 结算方式0-D0;1-D1;2-T0;3-T1
	 */
	private String settleType;
	/**
	 * 账户余额每个通道产品余额
	 */
	private Long balance;
	/**
	 * 未入账余额
	 */
	private Long balanceUnaccounted;
	/**
	 * 冻结余额
	 */
	private Long balanceFreeze;
	/**
	 * 可用余额
	 */
	private Long balanceValid;

	private MerchantInfo merchantInfo;

	private RalProviderTransMode ralProviderTransMode;

	private ProviderAccount providerAccount;

	private Long transModeId;

	public RalAccountTransMode() {
	}

	public RalAccountTransMode(Long ralAccProductId, Long mchId, Long providerAccId, Long productId, Integer feeRate,
			Long totleAmtLimit, Long minAmt, Long maxAmt, Integer percentage, Date createTime, Date updateTime,
			String state, String isDel, String validIP, String restrictState, String settleType, Long balance,
			Long balanceUnaccounted, Long balanceFreeze, Long balanceValid) {
		this.ralAccProductId = ralAccProductId;
		this.mchId = mchId;
		this.providerAccId = providerAccId;
		this.productId = productId;
		this.feeRate = feeRate;
		this.totleAmtLimit = totleAmtLimit;
		this.minAmt = minAmt;
		this.maxAmt = maxAmt;
		this.percentage = percentage;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.state = state;
		this.isDel = isDel;
		this.validIP = validIP;
		this.restrictState = restrictState;
		this.settleType = settleType;
		this.balance = balance;
		this.balanceUnaccounted = balanceUnaccounted;
		this.balanceFreeze = balanceFreeze;
		this.balanceValid = balanceValid;
	}

	private RalAccountTransMode(RalAccountTransModeBuilder builder) {
		this.ralAccProductId = builder.ralAccProductId;
		this.mchId = builder.mchId;
		this.providerAccId = builder.providerAccId;
		this.productId = builder.productId;
		this.feeRate = builder.feeRate;
		this.totleAmtLimit = builder.totleAmtLimit;
		this.minAmt = builder.minAmt;
		this.maxAmt = builder.maxAmt;
		this.percentage = builder.percentage;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
		this.state = builder.state;
		this.isDel = builder.isDel;
		this.validIP = builder.validIP;
		this.restrictState = builder.restrictState;
		this.settleType = builder.settleType;
		this.balance = builder.balance;
		this.balanceUnaccounted = builder.balanceUnaccounted;
		this.balanceFreeze = builder.balanceFreeze;
		this.balanceValid = builder.balanceValid;
	}

	public Long getTransModeId() {
		return transModeId;
	}

	public void setTransModeId(Long transModeId) {
		this.transModeId = transModeId;
	}

	public MerchantInfo getMerchantInfo() {
		return merchantInfo;
	}

	public void setMerchantInfo(MerchantInfo merchantInfo) {
		this.merchantInfo = merchantInfo;
	}

	public RalProviderTransMode getRalProviderTransMode() {
		return ralProviderTransMode;
	}

	public void setRalProviderTransMode(RalProviderTransMode ralProviderTransMode) {
		this.ralProviderTransMode = ralProviderTransMode;
	}

	public ProviderAccount getProviderAccount() {
		return providerAccount;
	}

	public void setProviderAccount(ProviderAccount providerAccount) {
		this.providerAccount = providerAccount;
	}

	/**
	 * 商户交易方式Id
	 * 
	 * @return ralAccProductId
	 */
	public Long getRalAccProductId() {
		return ralAccProductId;
	}

	/**
	 * 商户交易方式Id
	 * 
	 * @param ralAccProductId
	 */
	public void setRalAccProductId(Long ralAccProductId) {
		this.ralAccProductId = ralAccProductId;
	}

	/**
	 * 商户主键ID
	 * 
	 * @return mchId
	 */
	public Long getMchId() {
		return mchId;
	}

	/**
	 * 商户主键ID
	 * 
	 * @param mchId
	 */
	public void setMchId(Long mchId) {
		this.mchId = mchId;
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
	 * 交易产品ID
	 * 
	 * @return productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * 交易产品ID
	 * 
	 * @param productId
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
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
	 * 流量占比
	 * 
	 * @return percentage
	 */
	public Integer getPercentage() {
		return percentage;
	}

	/**
	 * 流量占比
	 * 
	 * @param percentage
	 */
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
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

	/**
	 * IP白名单
	 * 
	 * @return validIP
	 */
	public String getValidIP() {
		return validIP;
	}

	/**
	 * IP白名单
	 * 
	 * @param validIP
	 */
	public void setValidIP(String validIP) {
		this.validIP = validIP;
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
	 * 结算方式0-D0;1-D1;2-T0;3-T1
	 * 
	 * @return settleType
	 */
	public String getSettleType() {
		return settleType;
	}

	/**
	 * 结算方式0-D0;1-D1;2-T0;3-T1
	 * 
	 * @param settleType
	 */
	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	/**
	 * 账户余额每个通道产品余额
	 * 
	 * @return balance
	 */
	public Long getBalance() {
		return balance;
	}

	/**
	 * 账户余额每个通道产品余额
	 * 
	 * @param balance
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}

	/**
	 * 未入账余额
	 * 
	 * @return balanceUnaccounted
	 */
	public Long getBalanceUnaccounted() {
		return balanceUnaccounted;
	}

	/**
	 * 未入账余额
	 * 
	 * @param balanceUnaccounted
	 */
	public void setBalanceUnaccounted(Long balanceUnaccounted) {
		this.balanceUnaccounted = balanceUnaccounted;
	}

	/**
	 * 冻结余额
	 * 
	 * @return balanceFreeze
	 */
	public Long getBalanceFreeze() {
		return balanceFreeze;
	}

	/**
	 * 冻结余额
	 * 
	 * @param balanceFreeze
	 */
	public void setBalanceFreeze(Long balanceFreeze) {
		this.balanceFreeze = balanceFreeze;
	}

	/**
	 * 可用余额
	 * 
	 * @return balanceValid
	 */
	public Long getBalanceValid() {
		return balanceValid;
	}

	/**
	 * 可用余额
	 * 
	 * @param balanceValid
	 */
	public void setBalanceValid(Long balanceValid) {
		this.balanceValid = balanceValid;
	}

	public static class RalAccountTransModeBuilder {
		private Long ralAccProductId; // 商户交易方式Id
		private Long mchId; // 商户主键ID
		private Long providerAccId; // 支付账户主键
		private Long productId; // 交易产品ID
		private Integer feeRate; // 基准费率(单位:万分之)
		private Long totleAmtLimit; // 每日限额
		private Long minAmt; // 单笔最低额度
		private Long maxAmt; // 单笔最高额度
		private Integer percentage; // 流量占比
		private Date createTime; // 创建时间
		private Date updateTime; // 修改时间
		private String state; // 状态 0-停用 1-启用 2-暂停
		private String isDel; // 是否删除
		private String validIP; // IP白名单
		private String restrictState; // 限流状态0-停用；1-启用
		private String settleType; // 结算方式0-D0;1-D1;2-T0;3-T1
		private Long balance; // 账户余额每个通道产品余额
		private Long balanceUnaccounted; // 未入账余额
		private Long balanceFreeze; // 冻结余额
		private Long balanceValid; // 可用余额

		/**
		 * 商户交易方式Id
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addRalAccProductId(Long ralAccProductId) {
			this.ralAccProductId = ralAccProductId;
			return this;
		}

		/**
		 * 商户主键ID
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addMchId(Long mchId) {
			this.mchId = mchId;
			return this;
		}

		/**
		 * 支付账户主键
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addProviderAccId(Long providerAccId) {
			this.providerAccId = providerAccId;
			return this;
		}

		/**
		 * 交易产品ID
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addProductId(Long productId) {
			this.productId = productId;
			return this;
		}

		/**
		 * 基准费率(单位:万分之)
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addFeeRate(Integer feeRate) {
			this.feeRate = feeRate;
			return this;
		}

		/**
		 * 每日限额
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addTotleAmtLimit(Long totleAmtLimit) {
			this.totleAmtLimit = totleAmtLimit;
			return this;
		}

		/**
		 * 单笔最低额度
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addMinAmt(Long minAmt) {
			this.minAmt = minAmt;
			return this;
		}

		/**
		 * 单笔最高额度
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addMaxAmt(Long maxAmt) {
			this.maxAmt = maxAmt;
			return this;
		}

		/**
		 * 流量占比
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addPercentage(Integer percentage) {
			this.percentage = percentage;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 修改时间
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		/**
		 * 状态 0-停用 1-启用 2-暂停
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 是否删除
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addIsDel(String isDel) {
			this.isDel = isDel;
			return this;
		}

		/**
		 * IP白名单
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addValidIP(String validIP) {
			this.validIP = validIP;
			return this;
		}

		/**
		 * 限流状态0-停用；1-启用
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addRestrictState(String restrictState) {
			this.restrictState = restrictState;
			return this;
		}

		/**
		 * 结算方式0-D0;1-D1;2-T0;3-T1
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addSettleType(String settleType) {
			this.settleType = settleType;
			return this;
		}

		/**
		 * 账户余额每个通道产品余额
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addBalance(Long balance) {
			this.balance = balance;
			return this;
		}

		/**
		 * 未入账余额
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addBalanceUnaccounted(Long balanceUnaccounted) {
			this.balanceUnaccounted = balanceUnaccounted;
			return this;
		}

		/**
		 * 冻结余额
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addBalanceFreeze(Long balanceFreeze) {
			this.balanceFreeze = balanceFreeze;
			return this;
		}

		/**
		 * 可用余额
		 * 
		 * @return RalAccountTransModeBuilder
		 */
		public RalAccountTransModeBuilder addBalanceValid(Long balanceValid) {
			this.balanceValid = balanceValid;
			return this;
		}

		public RalAccountTransMode build() {
			return new RalAccountTransMode(this);
		}
	}
}