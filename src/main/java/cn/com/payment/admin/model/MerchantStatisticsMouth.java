package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * MerchantStatisticsMouth
 *
 * Date:2019-2-14 22:10:01
 * @author dl
 */
public class MerchantStatisticsMouth implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	  /** 
	   *统计主键ID
	   */
  	   private Long sdId;
	  /** 
	   *商户主键ID
	   */
  	   private Long mchId;
	  /** 
	   *统计日期
	   */
  	   private Date sdMouth;
	  /** 
	   *总支付笔数
	   */
  	   private Integer payCountTotal;
	  /** 
	   *总支付金额
	   */
  	   private Long payAmountTotal;
	  /** 
	   *成功总笔数
	   */
  	   private Integer payCountSucc;
	  /** 
	   *成功总金额
	   */
  	   private Long payAmountSucc;
	  /** 
	   *净入金额
	   */
  	   private Long realAmount;
	  /** 
	   *手续费
	   */
  	   private Long totleFee;
	  /** 
	   *退款总笔数
	   */
  	   private Integer refundCount;
	  /** 
	   *退款总金额
	   */
  	   private Long refundAmount;
	  /** 
	   *状态 0-停用 1-启用 2-暂停
	   */
  	   private String state;
	  /** 
	   *创建时间
	   */
  	   private Date createTime;
	  /** 
	   *修改时间
	   */
  	   private Date updateTime;
  
  
  public MerchantStatisticsMouth(){}
  public MerchantStatisticsMouth(Long sdId,Long mchId,Date sdMouth,Integer payCountTotal,Long payAmountTotal,Integer payCountSucc,Long payAmountSucc,Long realAmount,Long totleFee,Integer refundCount,Long refundAmount,String state,Date createTime,Date updateTime){
  	   this.sdId = sdId;
  	   this.mchId = mchId;
  	   this.sdMouth = sdMouth;
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
 
 	private MerchantStatisticsMouth(MerchantStatisticsMouthBuilder builder){
  	   this.sdId = builder.sdId;
  	   this.mchId = builder.mchId;
  	   this.sdMouth = builder.sdMouth;
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
	   * @return sdId
	   */
	  public Long getSdId(){
	      return sdId;
	  }
	  /**
	   * 统计主键ID
	   * @param sdId 
	   */
	  public void setSdId(Long sdId){
	      this.sdId = sdId;
	  }
  	  /**
	   * 商户主键ID
	   * @return mchId
	   */
	  public Long getMchId(){
	      return mchId;
	  }
	  /**
	   * 商户主键ID
	   * @param mchId 
	   */
	  public void setMchId(Long mchId){
	      this.mchId = mchId;
	  }
  	  /**
	   * 统计日期
	   * @return sdMouth
	   */
	  public Date getSdMouth(){
	      return sdMouth;
	  }
	  /**
	   * 统计日期
	   * @param sdMouth 
	   */
	  public void setSdMouth(Date sdMouth){
	      this.sdMouth = sdMouth;
	  }
  	  /**
	   * 总支付笔数
	   * @return payCountTotal
	   */
	  public Integer getPayCountTotal(){
	      return payCountTotal;
	  }
	  /**
	   * 总支付笔数
	   * @param payCountTotal 
	   */
	  public void setPayCountTotal(Integer payCountTotal){
	      this.payCountTotal = payCountTotal;
	  }
  	  /**
	   * 总支付金额
	   * @return payAmountTotal
	   */
	  public Long getPayAmountTotal(){
	      return payAmountTotal;
	  }
	  /**
	   * 总支付金额
	   * @param payAmountTotal 
	   */
	  public void setPayAmountTotal(Long payAmountTotal){
	      this.payAmountTotal = payAmountTotal;
	  }
  	  /**
	   * 成功总笔数
	   * @return payCountSucc
	   */
	  public Integer getPayCountSucc(){
	      return payCountSucc;
	  }
	  /**
	   * 成功总笔数
	   * @param payCountSucc 
	   */
	  public void setPayCountSucc(Integer payCountSucc){
	      this.payCountSucc = payCountSucc;
	  }
  	  /**
	   * 成功总金额
	   * @return payAmountSucc
	   */
	  public Long getPayAmountSucc(){
	      return payAmountSucc;
	  }
	  /**
	   * 成功总金额
	   * @param payAmountSucc 
	   */
	  public void setPayAmountSucc(Long payAmountSucc){
	      this.payAmountSucc = payAmountSucc;
	  }
  	  /**
	   * 净入金额
	   * @return realAmount
	   */
	  public Long getRealAmount(){
	      return realAmount;
	  }
	  /**
	   * 净入金额
	   * @param realAmount 
	   */
	  public void setRealAmount(Long realAmount){
	      this.realAmount = realAmount;
	  }
  	  /**
	   * 手续费
	   * @return totleFee
	   */
	  public Long getTotleFee(){
	      return totleFee;
	  }
	  /**
	   * 手续费
	   * @param totleFee 
	   */
	  public void setTotleFee(Long totleFee){
	      this.totleFee = totleFee;
	  }
  	  /**
	   * 退款总笔数
	   * @return refundCount
	   */
	  public Integer getRefundCount(){
	      return refundCount;
	  }
	  /**
	   * 退款总笔数
	   * @param refundCount 
	   */
	  public void setRefundCount(Integer refundCount){
	      this.refundCount = refundCount;
	  }
  	  /**
	   * 退款总金额
	   * @return refundAmount
	   */
	  public Long getRefundAmount(){
	      return refundAmount;
	  }
	  /**
	   * 退款总金额
	   * @param refundAmount 
	   */
	  public void setRefundAmount(Long refundAmount){
	      this.refundAmount = refundAmount;
	  }
  	  /**
	   * 状态 0-停用 1-启用 2-暂停
	   * @return state
	   */
	  public String getState(){
	      return state;
	  }
	  /**
	   * 状态 0-停用 1-启用 2-暂停
	   * @param state 
	   */
	  public void setState(String state){
	      this.state = state;
	  }
  	  /**
	   * 创建时间
	   * @return createTime
	   */
	  public Date getCreateTime(){
	      return createTime;
	  }
	  /**
	   * 创建时间
	   * @param createTime 
	   */
	  public void setCreateTime(Date createTime){
	      this.createTime = createTime;
	  }
  	  /**
	   * 修改时间
	   * @return updateTime
	   */
	  public Date getUpdateTime(){
	      return updateTime;
	  }
	  /**
	   * 修改时间
	   * @param updateTime 
	   */
	  public void setUpdateTime(Date updateTime){
	      this.updateTime = updateTime;
	  }
 
 	 public static class MerchantStatisticsMouthBuilder{
		private Long sdId; // 统计主键ID
		private Long mchId; // 商户主键ID
		private Date sdMouth; // 统计日期
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
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addSdId(Long sdId) {
			this.sdId = sdId;
			return this;
		}
		 /**
	   * 商户主键ID
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addMchId(Long mchId) {
			this.mchId = mchId;
			return this;
		}
		 /**
	   * 统计日期
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addSdMouth(Date sdMouth) {
			this.sdMouth = sdMouth;
			return this;
		}
		 /**
	   * 总支付笔数
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addPayCountTotal(Integer payCountTotal) {
			this.payCountTotal = payCountTotal;
			return this;
		}
		 /**
	   * 总支付金额
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addPayAmountTotal(Long payAmountTotal) {
			this.payAmountTotal = payAmountTotal;
			return this;
		}
		 /**
	   * 成功总笔数
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addPayCountSucc(Integer payCountSucc) {
			this.payCountSucc = payCountSucc;
			return this;
		}
		 /**
	   * 成功总金额
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addPayAmountSucc(Long payAmountSucc) {
			this.payAmountSucc = payAmountSucc;
			return this;
		}
		 /**
	   * 净入金额
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addRealAmount(Long realAmount) {
			this.realAmount = realAmount;
			return this;
		}
		 /**
	   * 手续费
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addTotleFee(Long totleFee) {
			this.totleFee = totleFee;
			return this;
		}
		 /**
	   * 退款总笔数
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addRefundCount(Integer refundCount) {
			this.refundCount = refundCount;
			return this;
		}
		 /**
	   * 退款总金额
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addRefundAmount(Long refundAmount) {
			this.refundAmount = refundAmount;
			return this;
		}
		 /**
	   * 状态 0-停用 1-启用 2-暂停
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addState(String state) {
			this.state = state;
			return this;
		}
		 /**
	   * 创建时间
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}
		 /**
	   * 修改时间
	   * @return MerchantStatisticsMouthBuilder
	   */
		public MerchantStatisticsMouthBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}
	
		public MerchantStatisticsMouth build(){
			return new MerchantStatisticsMouth(this);
		}
	 }
}