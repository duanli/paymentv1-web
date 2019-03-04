package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ProviderStatisticsDays
 *
 * Date:2019-3-2 15:09:00
 * 
 * @author dl
 */
public class ProviderStatisticsDays implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 统计主键ID
	 */
	private Long sdId;
	/**
	 * 交易方式Id
	 */
	private Long transModeId;
	/**
	 * 服务商交易方式Id
	 */
	private Long productId;
	/**
	 * 支付账户主键
	 */
	private Long providerAccId;
	/**
	 * 统计年份
	 */
	private String sdYear;
	/**
	 * 统计月份
	 */
	private String sdMouth;
	/**
	 * 统计日期
	 */
	private Date sdDay;
	/**
	 * 总支付笔数
	 */
	private Integer payCountTotal;
	/**
	 * 总支付金额
	 */
	private Long payAmountTotal;
	/**
	 * 成功总笔数
	 */
	private Integer payCountSucc;
	/**
	 * 成功总金额
	 */
	private Long payAmountSucc;
	/**
	 * 净入金额
	 */
	private Long realAmount;
	/**
	 * 手续费
	 */
	private Long totleFee;
	/**
	 * 退款总笔数
	 */
	private Integer refundCount;
	/**
	 * 退款总金额
	 */
	private Long refundAmount;
	/**
	 * 状态 0-停用 1-启用 2-暂停
	 */
	private String state;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

	public ProviderStatisticsDays() {
	}

	public ProviderStatisticsDays(Long sdId, Long transModeId, Long productId, Long providerAccId, String sdYear,
			String sdMouth, Date sdDay, Integer payCountTotal, Long payAmountTotal, Integer payCountSucc,
			Long payAmountSucc, Long realAmount, Long totleFee, Integer refundCount, Long refundAmount, String state,
			Date createTime, Date updateTime) {
		this.sdId = sdId;
		this.transModeId = transModeId;
		this.productId = productId;
		this.providerAccId = providerAccId;
		this.sdYear = sdYear;
		this.sdMouth = sdMouth;
		this.sdDay = sdDay;
		this.payCountTotal = payCountTotal;
		this.payAmountTotal = payAmountTotal;
		this.payCountSucc = payCountSucc;
		this.payAmountSucc = payAmountSucc;
		this.realAmount = realAmount;
		this.totleFee = totleFee;
		this.refundCount = refundCount;
		this.refundAmount = refundAmount;
		this.state = state;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	private ProviderStatisticsDays(ProviderStatisticsDaysBuilder builder) {
		this.sdId = builder.sdId;
		this.transModeId = builder.transModeId;
		this.productId = builder.productId;
		this.providerAccId = builder.providerAccId;
		this.sdYear = builder.sdYear;
		this.sdMouth = builder.sdMouth;
		this.sdDay = builder.sdDay;
		this.payCountTotal = builder.payCountTotal;
		this.payAmountTotal = builder.payAmountTotal;
		this.payCountSucc = builder.payCountSucc;
		this.payAmountSucc = builder.payAmountSucc;
		this.realAmount = builder.realAmount;
		this.totleFee = builder.totleFee;
		this.refundCount = builder.refundCount;
		this.refundAmount = builder.refundAmount;
		this.state = builder.state;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
	}

	/**
	 * 统计主键ID
	 * 
	 * @return sdId
	 */
	public Long getSdId() {
		return sdId;
	}

	/**
	 * 统计主键ID
	 * 
	 * @param sdId
	 */
	public void setSdId(Long sdId) {
		this.sdId = sdId;
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
	 * 服务商交易方式Id
	 * 
	 * @return productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * 服务商交易方式Id
	 * 
	 * @param productId
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
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
	 * 统计年份
	 * 
	 * @return sdYear
	 */
	public String getSdYear() {
		return sdYear;
	}

	/**
	 * 统计年份
	 * 
	 * @param sdYear
	 */
	public void setSdYear(String sdYear) {
		this.sdYear = sdYear;
	}

	/**
	 * 统计月份
	 * 
	 * @return sdMouth
	 */
	public String getSdMouth() {
		return sdMouth;
	}

	/**
	 * 统计月份
	 * 
	 * @param sdMouth
	 */
	public void setSdMouth(String sdMouth) {
		this.sdMouth = sdMouth;
	}

	/**
	 * 统计日期
	 * 
	 * @return sdDay
	 */
	public Date getSdDay() {
		return sdDay;
	}

	/**
	 * 统计日期
	 * 
	 * @param sdDay
	 */
	public void setSdDay(Date sdDay) {
		this.sdDay = sdDay;
	}

	/**
	 * 总支付笔数
	 * 
	 * @return payCountTotal
	 */
	public Integer getPayCountTotal() {
		return payCountTotal;
	}

	/**
	 * 总支付笔数
	 * 
	 * @param payCountTotal
	 */
	public void setPayCountTotal(Integer payCountTotal) {
		this.payCountTotal = payCountTotal;
	}

	/**
	 * 总支付金额
	 * 
	 * @return payAmountTotal
	 */
	public Long getPayAmountTotal() {
		return payAmountTotal;
	}

	/**
	 * 总支付金额
	 * 
	 * @param payAmountTotal
	 */
	public void setPayAmountTotal(Long payAmountTotal) {
		this.payAmountTotal = payAmountTotal;
	}

	/**
	 * 成功总笔数
	 * 
	 * @return payCountSucc
	 */
	public Integer getPayCountSucc() {
		return payCountSucc;
	}

	/**
	 * 成功总笔数
	 * 
	 * @param payCountSucc
	 */
	public void setPayCountSucc(Integer payCountSucc) {
		this.payCountSucc = payCountSucc;
	}

	/**
	 * 成功总金额
	 * 
	 * @return payAmountSucc
	 */
	public Long getPayAmountSucc() {
		return payAmountSucc;
	}

	/**
	 * 成功总金额
	 * 
	 * @param payAmountSucc
	 */
	public void setPayAmountSucc(Long payAmountSucc) {
		this.payAmountSucc = payAmountSucc;
	}

	/**
	 * 净入金额
	 * 
	 * @return realAmount
	 */
	public Long getRealAmount() {
		return realAmount;
	}

	/**
	 * 净入金额
	 * 
	 * @param realAmount
	 */
	public void setRealAmount(Long realAmount) {
		this.realAmount = realAmount;
	}

	/**
	 * 手续费
	 * 
	 * @return totleFee
	 */
	public Long getTotleFee() {
		return totleFee;
	}

	/**
	 * 手续费
	 * 
	 * @param totleFee
	 */
	public void setTotleFee(Long totleFee) {
		this.totleFee = totleFee;
	}

	/**
	 * 退款总笔数
	 * 
	 * @return refundCount
	 */
	public Integer getRefundCount() {
		return refundCount;
	}

	/**
	 * 退款总笔数
	 * 
	 * @param refundCount
	 */
	public void setRefundCount(Integer refundCount) {
		this.refundCount = refundCount;
	}

	/**
	 * 退款总金额
	 * 
	 * @return refundAmount
	 */
	public Long getRefundAmount() {
		return refundAmount;
	}

	/**
	 * 退款总金额
	 * 
	 * @param refundAmount
	 */
	public void setRefundAmount(Long refundAmount) {
		this.refundAmount = refundAmount;
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

	public static class ProviderStatisticsDaysBuilder {
		private Long sdId; // 统计主键ID
		private Long transModeId; // 交易方式Id
		private Long productId; // 服务商交易方式Id
		private Long providerAccId; // 支付账户主键
		private String sdYear; // 统计年份
		private String sdMouth; // 统计月份
		private Date sdDay; // 统计日期
		private Integer payCountTotal; // 总支付笔数
		private Long payAmountTotal; // 总支付金额
		private Integer payCountSucc; // 成功总笔数
		private Long payAmountSucc; // 成功总金额
		private Long realAmount; // 净入金额
		private Long totleFee; // 手续费
		private Integer refundCount; // 退款总笔数
		private Long refundAmount; // 退款总金额
		private String state; // 状态 0-停用 1-启用 2-暂停
		private Date createTime; // 创建时间
		private Date updateTime; // 修改时间

		/**
		 * 统计主键ID
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addSdId(Long sdId) {
			this.sdId = sdId;
			return this;
		}

		/**
		 * 交易方式Id
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addTransModeId(Long transModeId) {
			this.transModeId = transModeId;
			return this;
		}

		/**
		 * 服务商交易方式Id
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addProductId(Long productId) {
			this.productId = productId;
			return this;
		}

		/**
		 * 支付账户主键
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addProviderAccId(Long providerAccId) {
			this.providerAccId = providerAccId;
			return this;
		}

		/**
		 * 统计年份
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addSdYear(String sdYear) {
			this.sdYear = sdYear;
			return this;
		}

		/**
		 * 统计月份
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addSdMouth(String sdMouth) {
			this.sdMouth = sdMouth;
			return this;
		}

		/**
		 * 统计日期
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addSdDay(Date sdDay) {
			this.sdDay = sdDay;
			return this;
		}

		/**
		 * 总支付笔数
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addPayCountTotal(Integer payCountTotal) {
			this.payCountTotal = payCountTotal;
			return this;
		}

		/**
		 * 总支付金额
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addPayAmountTotal(Long payAmountTotal) {
			this.payAmountTotal = payAmountTotal;
			return this;
		}

		/**
		 * 成功总笔数
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addPayCountSucc(Integer payCountSucc) {
			this.payCountSucc = payCountSucc;
			return this;
		}

		/**
		 * 成功总金额
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addPayAmountSucc(Long payAmountSucc) {
			this.payAmountSucc = payAmountSucc;
			return this;
		}

		/**
		 * 净入金额
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addRealAmount(Long realAmount) {
			this.realAmount = realAmount;
			return this;
		}

		/**
		 * 手续费
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addTotleFee(Long totleFee) {
			this.totleFee = totleFee;
			return this;
		}

		/**
		 * 退款总笔数
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addRefundCount(Integer refundCount) {
			this.refundCount = refundCount;
			return this;
		}

		/**
		 * 退款总金额
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addRefundAmount(Long refundAmount) {
			this.refundAmount = refundAmount;
			return this;
		}

		/**
		 * 状态 0-停用 1-启用 2-暂停
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 修改时间
		 * 
		 * @return ProviderStatisticsDaysBuilder
		 */
		public ProviderStatisticsDaysBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		public ProviderStatisticsDays build() {
			return new ProviderStatisticsDays(this);
		}
	}
}