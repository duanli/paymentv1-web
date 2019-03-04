package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * RalProductMerchant
 *
 * Date:2019-3-2 15:09:00
 * 
 * @author dl
 */
public class RalProductMerchant implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 商户交易方式Id
	 */
	private Long ralMerProductId;
	/**
	 * 商户主键ID
	 */
	private Long mchId;
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
	 * 有效起始时间
	 */
	private Date beginTime;
	/**
	 * 有效截止时间
	 */
	private Date endTime;
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

	private MerchantInfo merchantInfo;

	private RalProviderTransMode ralProviderTransMode;

	private Long transModeId;

	public RalProductMerchant() {
	}

	public RalProductMerchant(Long ralMerProductId, Long mchId, Long productId, Integer feeRate, Long totleAmtLimit,
			Long minAmt, Long maxAmt, Date beginTime, Date endTime, Integer percentage, Date createTime,
			Date updateTime, String state, String isDel, String validIP, String restrictState, String settleType) {
		this.ralMerProductId = ralMerProductId;
		this.mchId = mchId;
		this.productId = productId;
		this.feeRate = feeRate;
		this.totleAmtLimit = totleAmtLimit;
		this.minAmt = minAmt;
		this.maxAmt = maxAmt;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.percentage = percentage;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.state = state;
		this.isDel = isDel;
		this.validIP = validIP;
		this.restrictState = restrictState;
		this.settleType = settleType;
	}

	private RalProductMerchant(RalProductMerchantBuilder builder) {
		this.ralMerProductId = builder.ralMerProductId;
		this.mchId = builder.mchId;
		this.productId = builder.productId;
		this.feeRate = builder.feeRate;
		this.totleAmtLimit = builder.totleAmtLimit;
		this.minAmt = builder.minAmt;
		this.maxAmt = builder.maxAmt;
		this.beginTime = builder.beginTime;
		this.endTime = builder.endTime;
		this.percentage = builder.percentage;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
		this.state = builder.state;
		this.isDel = builder.isDel;
		this.validIP = builder.validIP;
		this.restrictState = builder.restrictState;
		this.settleType = builder.settleType;
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

	/**
	 * 商户交易方式Id
	 * 
	 * @return ralMerProductId
	 */
	public Long getRalMerProductId() {
		return ralMerProductId;
	}

	/**
	 * 商户交易方式Id
	 * 
	 * @param ralMerProductId
	 */
	public void setRalMerProductId(Long ralMerProductId) {
		this.ralMerProductId = ralMerProductId;
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

	public static class RalProductMerchantBuilder {
		private Long ralMerProductId; // 商户交易方式Id
		private Long mchId; // 商户主键ID
		private Long productId; // 交易产品ID
		private Integer feeRate; // 基准费率(单位:万分之)
		private Long totleAmtLimit; // 每日限额
		private Long minAmt; // 单笔最低额度
		private Long maxAmt; // 单笔最高额度
		private Date beginTime; // 有效起始时间
		private Date endTime; // 有效截止时间
		private Integer percentage; // 流量占比
		private Date createTime; // 创建时间
		private Date updateTime; // 修改时间
		private String state; // 状态 0-停用 1-启用 2-暂停
		private String isDel; // 是否删除
		private String validIP; // IP白名单
		private String restrictState; // 限流状态0-停用；1-启用
		private String settleType; // 结算方式0-D0;1-D1;2-T0;3-T1

		/**
		 * 商户交易方式Id
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addRalMerProductId(Long ralMerProductId) {
			this.ralMerProductId = ralMerProductId;
			return this;
		}

		/**
		 * 商户主键ID
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addMchId(Long mchId) {
			this.mchId = mchId;
			return this;
		}

		/**
		 * 交易产品ID
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addProductId(Long productId) {
			this.productId = productId;
			return this;
		}

		/**
		 * 基准费率(单位:万分之)
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addFeeRate(Integer feeRate) {
			this.feeRate = feeRate;
			return this;
		}

		/**
		 * 每日限额
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addTotleAmtLimit(Long totleAmtLimit) {
			this.totleAmtLimit = totleAmtLimit;
			return this;
		}

		/**
		 * 单笔最低额度
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addMinAmt(Long minAmt) {
			this.minAmt = minAmt;
			return this;
		}

		/**
		 * 单笔最高额度
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addMaxAmt(Long maxAmt) {
			this.maxAmt = maxAmt;
			return this;
		}

		/**
		 * 有效起始时间
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addBeginTime(Date beginTime) {
			this.beginTime = beginTime;
			return this;
		}

		/**
		 * 有效截止时间
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addEndTime(Date endTime) {
			this.endTime = endTime;
			return this;
		}

		/**
		 * 流量占比
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addPercentage(Integer percentage) {
			this.percentage = percentage;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 修改时间
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		/**
		 * 状态 0-停用 1-启用 2-暂停
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 是否删除
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addIsDel(String isDel) {
			this.isDel = isDel;
			return this;
		}

		/**
		 * IP白名单
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addValidIP(String validIP) {
			this.validIP = validIP;
			return this;
		}

		/**
		 * 限流状态0-停用；1-启用
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addRestrictState(String restrictState) {
			this.restrictState = restrictState;
			return this;
		}

		/**
		 * 结算方式0-D0;1-D1;2-T0;3-T1
		 * 
		 * @return RalProductMerchantBuilder
		 */
		public RalProductMerchantBuilder addSettleType(String settleType) {
			this.settleType = settleType;
			return this;
		}

		public RalProductMerchant build() {
			return new RalProductMerchant(this);
		}
	}
}