package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * MerchantBalanceAdjustment
 *
 * Date:2019-2-14 22:10:00
 * @author dl
 */
public class MerchantBalanceAdjustment implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	  /** 
	   *主键ID
	   */
  	   private Long adjustId;
	  /** 
	   *账户关联ID
	   */
  	   private Long ralAccProductId;
	  /** 
	   *调账人ID
	   */
  	   private Long operatorId;
	  /** 
	   *调整方式0-扣减1-增加
	   */
  	   private String adjustType;
	  /** 
	   *调账前余额
	   */
  	   private Long beforBalance;
	  /** 
	   *调账后余额
	   */
  	   private Long afterBalance;
	  /** 
	   *调账金额
	   */
  	   private Long adjustAmount;
	  /** 
	   *状态 0-无效1-有效
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
  
  
  public MerchantBalanceAdjustment(){}
  public MerchantBalanceAdjustment(Long adjustId,Long ralAccProductId,Long operatorId,String adjustType,Long beforBalance,Long afterBalance,Long adjustAmount,String state,Date createTime,Date updateTime){
  	   this.adjustId = adjustId;
  	   this.ralAccProductId = ralAccProductId;
  	   this.operatorId = operatorId;
  	   this.adjustType = adjustType;
  	   this.beforBalance = beforBalance;
  	   this.afterBalance = afterBalance;
  	   this.adjustAmount = adjustAmount;
  	   this.state = state;
  	   this.createTime = createTime;
  	   this.updateTime = updateTime;
  }
 
 	private MerchantBalanceAdjustment(MerchantBalanceAdjustmentBuilder builder){
  	   this.adjustId = builder.adjustId;
  	   this.ralAccProductId = builder.ralAccProductId;
  	   this.operatorId = builder.operatorId;
  	   this.adjustType = builder.adjustType;
  	   this.beforBalance = builder.beforBalance;
  	   this.afterBalance = builder.afterBalance;
  	   this.adjustAmount = builder.adjustAmount;
  	   this.state = builder.state;
  	   this.createTime = builder.createTime;
  	   this.updateTime = builder.updateTime;
	 }
 
  	  /**
	   * 主键ID
	   * @return adjustId
	   */
	  public Long getAdjustId(){
	      return adjustId;
	  }
	  /**
	   * 主键ID
	   * @param adjustId 
	   */
	  public void setAdjustId(Long adjustId){
	      this.adjustId = adjustId;
	  }
  	  /**
	   * 账户关联ID
	   * @return ralAccProductId
	   */
	  public Long getRalAccProductId(){
	      return ralAccProductId;
	  }
	  /**
	   * 账户关联ID
	   * @param ralAccProductId 
	   */
	  public void setRalAccProductId(Long ralAccProductId){
	      this.ralAccProductId = ralAccProductId;
	  }
  	  /**
	   * 调账人ID
	   * @return operatorId
	   */
	  public Long getOperatorId(){
	      return operatorId;
	  }
	  /**
	   * 调账人ID
	   * @param operatorId 
	   */
	  public void setOperatorId(Long operatorId){
	      this.operatorId = operatorId;
	  }
  	  /**
	   * 调整方式0-扣减1-增加
	   * @return adjustType
	   */
	  public String getAdjustType(){
	      return adjustType;
	  }
	  /**
	   * 调整方式0-扣减1-增加
	   * @param adjustType 
	   */
	  public void setAdjustType(String adjustType){
	      this.adjustType = adjustType;
	  }
  	  /**
	   * 调账前余额
	   * @return beforBalance
	   */
	  public Long getBeforBalance(){
	      return beforBalance;
	  }
	  /**
	   * 调账前余额
	   * @param beforBalance 
	   */
	  public void setBeforBalance(Long beforBalance){
	      this.beforBalance = beforBalance;
	  }
  	  /**
	   * 调账后余额
	   * @return afterBalance
	   */
	  public Long getAfterBalance(){
	      return afterBalance;
	  }
	  /**
	   * 调账后余额
	   * @param afterBalance 
	   */
	  public void setAfterBalance(Long afterBalance){
	      this.afterBalance = afterBalance;
	  }
  	  /**
	   * 调账金额
	   * @return adjustAmount
	   */
	  public Long getAdjustAmount(){
	      return adjustAmount;
	  }
	  /**
	   * 调账金额
	   * @param adjustAmount 
	   */
	  public void setAdjustAmount(Long adjustAmount){
	      this.adjustAmount = adjustAmount;
	  }
  	  /**
	   * 状态 0-无效1-有效
	   * @return state
	   */
	  public String getState(){
	      return state;
	  }
	  /**
	   * 状态 0-无效1-有效
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
 
 	 public static class MerchantBalanceAdjustmentBuilder{
		private Long adjustId; // 主键ID
		private Long ralAccProductId; // 账户关联ID
		private Long operatorId; // 调账人ID
		private String adjustType; // 调整方式0-扣减1-增加
		private Long beforBalance; // 调账前余额
		private Long afterBalance; // 调账后余额
		private Long adjustAmount; // 调账金额
		private String state; // 状态 0-无效1-有效
		private Date createTime; // 创建时间
		private Date updateTime; // 修改时间
		 /**
	   * 主键ID
	   * @return MerchantBalanceAdjustmentBuilder
	   */
		public MerchantBalanceAdjustmentBuilder addAdjustId(Long adjustId) {
			this.adjustId = adjustId;
			return this;
		}
		 /**
	   * 账户关联ID
	   * @return MerchantBalanceAdjustmentBuilder
	   */
		public MerchantBalanceAdjustmentBuilder addRalAccProductId(Long ralAccProductId) {
			this.ralAccProductId = ralAccProductId;
			return this;
		}
		 /**
	   * 调账人ID
	   * @return MerchantBalanceAdjustmentBuilder
	   */
		public MerchantBalanceAdjustmentBuilder addOperatorId(Long operatorId) {
			this.operatorId = operatorId;
			return this;
		}
		 /**
	   * 调整方式0-扣减1-增加
	   * @return MerchantBalanceAdjustmentBuilder
	   */
		public MerchantBalanceAdjustmentBuilder addAdjustType(String adjustType) {
			this.adjustType = adjustType;
			return this;
		}
		 /**
	   * 调账前余额
	   * @return MerchantBalanceAdjustmentBuilder
	   */
		public MerchantBalanceAdjustmentBuilder addBeforBalance(Long beforBalance) {
			this.beforBalance = beforBalance;
			return this;
		}
		 /**
	   * 调账后余额
	   * @return MerchantBalanceAdjustmentBuilder
	   */
		public MerchantBalanceAdjustmentBuilder addAfterBalance(Long afterBalance) {
			this.afterBalance = afterBalance;
			return this;
		}
		 /**
	   * 调账金额
	   * @return MerchantBalanceAdjustmentBuilder
	   */
		public MerchantBalanceAdjustmentBuilder addAdjustAmount(Long adjustAmount) {
			this.adjustAmount = adjustAmount;
			return this;
		}
		 /**
	   * 状态 0-无效1-有效
	   * @return MerchantBalanceAdjustmentBuilder
	   */
		public MerchantBalanceAdjustmentBuilder addState(String state) {
			this.state = state;
			return this;
		}
		 /**
	   * 创建时间
	   * @return MerchantBalanceAdjustmentBuilder
	   */
		public MerchantBalanceAdjustmentBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}
		 /**
	   * 修改时间
	   * @return MerchantBalanceAdjustmentBuilder
	   */
		public MerchantBalanceAdjustmentBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}
	
		public MerchantBalanceAdjustment build(){
			return new MerchantBalanceAdjustment(this);
		}
	 }
}