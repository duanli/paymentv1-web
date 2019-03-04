package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * RalMerchantTransMode
 *
 * Date:2019-3-2 15:09:00
 * 
 * @author dl
 */
public class RalMerchantTransMode implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 商户交易方式Id
	 */
	private Long ralMerTransModeId;
	/**
	 * 商户主键ID
	 */
	private Long mchId;
	/**
	 * 交易方式Id
	 */
	private Long transModeId;
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
	 * 限流状态0-停用；1-启用
	 */
	private String restrictState;
	/**
	 * IP白名单
	 */
	private String validIP;
	/**
	 * 结算方式0-D0;1-D1;2-T0;3-T1
	 */
	private String settleType;

	private Long cashOutBalance;

	private TransMode transMode;
	private MerchantInfo merchantInfo;

	public RalMerchantTransMode() {
	}

	public RalMerchantTransMode(Long ralMerTransModeId, Long mchId, Long transModeId, Integer feeRate,
			Long totleAmtLimit, Long minAmt, Long maxAmt, Date beginTime, Date endTime, Date createTime,
			Date updateTime, String state, String isDel, String restrictState, String validIP, String settleType) {
		this.ralMerTransModeId = ralMerTransModeId;
		this.mchId = mchId;
		this.transModeId = transModeId;
		this.feeRate = feeRate;
		this.totleAmtLimit = totleAmtLimit;
		this.minAmt = minAmt;
		this.maxAmt = maxAmt;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.state = state;
		this.isDel = isDel;
		this.restrictState = restrictState;
		this.validIP = validIP;
		this.settleType = settleType;
	}

	private RalMerchantTransMode(RalMerchantTransModeBuilder builder) {
		this.ralMerTransModeId = builder.ralMerTransModeId;
		this.mchId = builder.mchId;
		this.transModeId = builder.transModeId;
		this.feeRate = builder.feeRate;
		this.totleAmtLimit = builder.totleAmtLimit;
		this.minAmt = builder.minAmt;
		this.maxAmt = builder.maxAmt;
		this.beginTime = builder.beginTime;
		this.endTime = builder.endTime;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
		this.state = builder.state;
		this.isDel = builder.isDel;
		this.restrictState = builder.restrictState;
		this.validIP = builder.validIP;
		this.settleType = builder.settleType;
	}

	public Long getCashOutBalance() {
		return cashOutBalance;
	}

	public void setCashOutBalance(Long cashOutBalance) {
		this.cashOutBalance = cashOutBalance;
	}

	public TransMode getTransMode() {
		return transMode;
	}

	public void setTransMode(TransMode transMode) {
		this.transMode = transMode;
	}

	public MerchantInfo getMerchantInfo() {
		return merchantInfo;
	}

	public void setMerchantInfo(MerchantInfo merchantInfo) {
		this.merchantInfo = merchantInfo;
	}

	/**
	 * 商户交易方式Id
	 * 
	 * @return ralMerTransModeId
	 */
	public Long getRalMerTransModeId() {
		return ralMerTransModeId;
	}

	/**
	 * 商户交易方式Id
	 * 
	 * @param ralMerTransModeId
	 */
	public void setRalMerTransModeId(Long ralMerTransModeId) {
		this.ralMerTransModeId = ralMerTransModeId;
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
	 * 交易方式Id
	 * 
	 * @return transModeId
	 */
	public Long getTransModeId() {
		return transModeId;
	}

	/**
	 * 交易方式Id
	 * 
	 * @param transModeId
	 */
	public void setTransModeId(Long transModeId) {
		this.transModeId = transModeId;
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

	public static class RalMerchantTransModeBuilder {
		private Long ralMerTransModeId; // 商户交易方式Id
		private Long mchId; // 商户主键ID
		private Long transModeId; // 交易方式Id
		private Integer feeRate; // 基准费率(单位:万分之)
		private Long totleAmtLimit; // 每日限额
		private Long minAmt; // 单笔最低额度
		private Long maxAmt; // 单笔最高额度
		private Date beginTime; // 有效起始时间
		private Date endTime; // 有效截止时间
		private Date createTime; // 创建时间
		private Date updateTime; // 修改时间
		private String state; // 状态 0-停用 1-启用 2-暂停
		private String isDel; // 是否删除
		private String restrictState; // 限流状态0-停用；1-启用
		private String validIP; // IP白名单
		private String settleType; // 结算方式0-D0;1-D1;2-T0;3-T1

		/**
		 * 商户交易方式Id
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addRalMerTransModeId(Long ralMerTransModeId) {
			this.ralMerTransModeId = ralMerTransModeId;
			return this;
		}

		/**
		 * 商户主键ID
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addMchId(Long mchId) {
			this.mchId = mchId;
			return this;
		}

		/**
		 * 交易方式Id
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addTransModeId(Long transModeId) {
			this.transModeId = transModeId;
			return this;
		}

		/**
		 * 基准费率(单位:万分之)
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addFeeRate(Integer feeRate) {
			this.feeRate = feeRate;
			return this;
		}

		/**
		 * 每日限额
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addTotleAmtLimit(Long totleAmtLimit) {
			this.totleAmtLimit = totleAmtLimit;
			return this;
		}

		/**
		 * 单笔最低额度
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addMinAmt(Long minAmt) {
			this.minAmt = minAmt;
			return this;
		}

		/**
		 * 单笔最高额度
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addMaxAmt(Long maxAmt) {
			this.maxAmt = maxAmt;
			return this;
		}

		/**
		 * 有效起始时间
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addBeginTime(Date beginTime) {
			this.beginTime = beginTime;
			return this;
		}

		/**
		 * 有效截止时间
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addEndTime(Date endTime) {
			this.endTime = endTime;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 修改时间
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		/**
		 * 状态 0-停用 1-启用 2-暂停
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 是否删除
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addIsDel(String isDel) {
			this.isDel = isDel;
			return this;
		}

		/**
		 * 限流状态0-停用；1-启用
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addRestrictState(String restrictState) {
			this.restrictState = restrictState;
			return this;
		}

		/**
		 * IP白名单
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addValidIP(String validIP) {
			this.validIP = validIP;
			return this;
		}

		/**
		 * 结算方式0-D0;1-D1;2-T0;3-T1
		 * 
		 * @return RalMerchantTransModeBuilder
		 */
		public RalMerchantTransModeBuilder addSettleType(String settleType) {
			this.settleType = settleType;
			return this;
		}

		public RalMerchantTransMode build() {
			return new RalMerchantTransMode(this);
		}
	}
}