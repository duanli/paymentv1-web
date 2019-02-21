package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * MerchantSettlement
 *
 * Date:2019-2-14 22:10:01
 * @author dl
 */
public class MerchantSettlement implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	  /** 
	   *结算主键ID
	   */
  	   private Long settleId;
	  /** 
	   *商户主键ID
	   */
  	   private Long mchId;
	  /** 
	   *结算日期
	   */
  	   private Date settleDate;
	  /** 
	   *交易日期
	   */
  	   private Date payDate;
	  /** 
	   *结算方式0-D0;1-D1;2-T0;3-T1
	   */
  	   private String settleType;
	  /** 
	   *结算金额
	   */
  	   private Long settleAmount;
	  /** 
	   *状态 0-未结算 1-结算成功 2-结算中
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
  
  
  public MerchantSettlement(){}
  public MerchantSettlement(Long settleId,Long mchId,Date settleDate,Date payDate,String settleType,Long settleAmount,String state,Date createTime,Date updateTime){
  	   this.settleId = settleId;
  	   this.mchId = mchId;
  	   this.settleDate = settleDate;
  	   this.payDate = payDate;
  	   this.settleType = settleType;
  	   this.settleAmount = settleAmount;
  	   this.state = state;
  	   this.createTime = createTime;
  	   this.updateTime = updateTime;
  }
 
 	private MerchantSettlement(MerchantSettlementBuilder builder){
  	   this.settleId = builder.settleId;
  	   this.mchId = builder.mchId;
  	   this.settleDate = builder.settleDate;
  	   this.payDate = builder.payDate;
  	   this.settleType = builder.settleType;
  	   this.settleAmount = builder.settleAmount;
  	   this.state = builder.state;
  	   this.createTime = builder.createTime;
  	   this.updateTime = builder.updateTime;
	 }
 
  	  /**
	   * 结算主键ID
	   * @return settleId
	   */
	  public Long getSettleId(){
	      return settleId;
	  }
	  /**
	   * 结算主键ID
	   * @param settleId 
	   */
	  public void setSettleId(Long settleId){
	      this.settleId = settleId;
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
	   * 结算日期
	   * @return settleDate
	   */
	  public Date getSettleDate(){
	      return settleDate;
	  }
	  /**
	   * 结算日期
	   * @param settleDate 
	   */
	  public void setSettleDate(Date settleDate){
	      this.settleDate = settleDate;
	  }
  	  /**
	   * 交易日期
	   * @return payDate
	   */
	  public Date getPayDate(){
	      return payDate;
	  }
	  /**
	   * 交易日期
	   * @param payDate 
	   */
	  public void setPayDate(Date payDate){
	      this.payDate = payDate;
	  }
  	  /**
	   * 结算方式0-D0;1-D1;2-T0;3-T1
	   * @return settleType
	   */
	  public String getSettleType(){
	      return settleType;
	  }
	  /**
	   * 结算方式0-D0;1-D1;2-T0;3-T1
	   * @param settleType 
	   */
	  public void setSettleType(String settleType){
	      this.settleType = settleType;
	  }
  	  /**
	   * 结算金额
	   * @return settleAmount
	   */
	  public Long getSettleAmount(){
	      return settleAmount;
	  }
	  /**
	   * 结算金额
	   * @param settleAmount 
	   */
	  public void setSettleAmount(Long settleAmount){
	      this.settleAmount = settleAmount;
	  }
  	  /**
	   * 状态 0-未结算 1-结算成功 2-结算中
	   * @return state
	   */
	  public String getState(){
	      return state;
	  }
	  /**
	   * 状态 0-未结算 1-结算成功 2-结算中
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
 
 	 public static class MerchantSettlementBuilder{
		private Long settleId; // 结算主键ID
		private Long mchId; // 商户主键ID
		private Date settleDate; // 结算日期
		private Date payDate; // 交易日期
		private String settleType; // 结算方式0-D0;1-D1;2-T0;3-T1
		private Long settleAmount; // 结算金额
		private String state; // 状态 0-未结算 1-结算成功 2-结算中
		private Date createTime; // 创建时间
		private Date updateTime; // 修改时间
		 /**
	   * 结算主键ID
	   * @return MerchantSettlementBuilder
	   */
		public MerchantSettlementBuilder addSettleId(Long settleId) {
			this.settleId = settleId;
			return this;
		}
		 /**
	   * 商户主键ID
	   * @return MerchantSettlementBuilder
	   */
		public MerchantSettlementBuilder addMchId(Long mchId) {
			this.mchId = mchId;
			return this;
		}
		 /**
	   * 结算日期
	   * @return MerchantSettlementBuilder
	   */
		public MerchantSettlementBuilder addSettleDate(Date settleDate) {
			this.settleDate = settleDate;
			return this;
		}
		 /**
	   * 交易日期
	   * @return MerchantSettlementBuilder
	   */
		public MerchantSettlementBuilder addPayDate(Date payDate) {
			this.payDate = payDate;
			return this;
		}
		 /**
	   * 结算方式0-D0;1-D1;2-T0;3-T1
	   * @return MerchantSettlementBuilder
	   */
		public MerchantSettlementBuilder addSettleType(String settleType) {
			this.settleType = settleType;
			return this;
		}
		 /**
	   * 结算金额
	   * @return MerchantSettlementBuilder
	   */
		public MerchantSettlementBuilder addSettleAmount(Long settleAmount) {
			this.settleAmount = settleAmount;
			return this;
		}
		 /**
	   * 状态 0-未结算 1-结算成功 2-结算中
	   * @return MerchantSettlementBuilder
	   */
		public MerchantSettlementBuilder addState(String state) {
			this.state = state;
			return this;
		}
		 /**
	   * 创建时间
	   * @return MerchantSettlementBuilder
	   */
		public MerchantSettlementBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}
		 /**
	   * 修改时间
	   * @return MerchantSettlementBuilder
	   */
		public MerchantSettlementBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}
	
		public MerchantSettlement build(){
			return new MerchantSettlement(this);
		}
	 }
}