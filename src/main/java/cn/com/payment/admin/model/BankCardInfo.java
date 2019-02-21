package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * BankCardInfo
 *
 * Date:2019-1-20 11:05:18
 * @author dl
 */
public class BankCardInfo implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	  /** 
	   *记录编号
	   */
  	   private Long cardId;
	  /** 
	   *银行卡名称
	   */
  	   private String cardName;
	  /** 
	   *银行卡头
	   */
  	   private String cardHead;
	  /** 
	   *卡类银行型
	   */
  	   private String cardType;
	  /** 
	   *银行编号
	   */
  	   private String bankCode;
	  /** 
	   *银行名称
	   */
  	   private String bankName;
	  /** 
	   *银行名称-银联
	   */
  	   private String bankNameOrgin;
	  /** 
	   *当前状态
	   */
  	   private String state;
	  /** 
	   *长度
	   */
  	   private Double cardLength;
	  /** 
	   *bin长度
	   */
  	   private Double binLength;
	  /** 
	   *更新时间
	   */
  	   private Date updateTime;
	  /** 
	   *写入时间
	   */
  	   private Date writeTime;
	  /** 
	   *logourl地址
	   */
  	   private String logo;
	  /** 
	   *背景色
	   */
  	   private String backColor;
	  /** 
	   *限额
	   */
  	   private String limitation;
  
  
  public BankCardInfo(){}
  public BankCardInfo(Long cardId,String cardName,String cardHead,String cardType,String bankCode,String bankName,String bankNameOrgin,String state,Double cardLength,Double binLength,Date updateTime,Date writeTime,String logo,String backColor,String limitation){
  	   this.cardId = cardId;
  	   this.cardName = cardName;
  	   this.cardHead = cardHead;
  	   this.cardType = cardType;
  	   this.bankCode = bankCode;
  	   this.bankName = bankName;
  	   this.bankNameOrgin = bankNameOrgin;
  	   this.state = state;
  	   this.cardLength = cardLength;
  	   this.binLength = binLength;
  	   this.updateTime = updateTime;
  	   this.writeTime = writeTime;
  	   this.logo = logo;
  	   this.backColor = backColor;
  	   this.limitation = limitation;
  }
 
 	private BankCardInfo(BankCardInfoBuilder builder){
  	   this.cardId = builder.cardId;
  	   this.cardName = builder.cardName;
  	   this.cardHead = builder.cardHead;
  	   this.cardType = builder.cardType;
  	   this.bankCode = builder.bankCode;
  	   this.bankName = builder.bankName;
  	   this.bankNameOrgin = builder.bankNameOrgin;
  	   this.state = builder.state;
  	   this.cardLength = builder.cardLength;
  	   this.binLength = builder.binLength;
  	   this.updateTime = builder.updateTime;
  	   this.writeTime = builder.writeTime;
  	   this.logo = builder.logo;
  	   this.backColor = builder.backColor;
  	   this.limitation = builder.limitation;
	 }
 
  	  /**
	   * 记录编号
	   * @return cardId
	   */
	  public Long getCardId(){
	      return cardId;
	  }
	  /**
	   * 记录编号
	   * @param cardId 
	   */
	  public void setCardId(Long cardId){
	      this.cardId = cardId;
	  }
  	  /**
	   * 银行卡名称
	   * @return cardName
	   */
	  public String getCardName(){
	      return cardName;
	  }
	  /**
	   * 银行卡名称
	   * @param cardName 
	   */
	  public void setCardName(String cardName){
	      this.cardName = cardName;
	  }
  	  /**
	   * 银行卡头
	   * @return cardHead
	   */
	  public String getCardHead(){
	      return cardHead;
	  }
	  /**
	   * 银行卡头
	   * @param cardHead 
	   */
	  public void setCardHead(String cardHead){
	      this.cardHead = cardHead;
	  }
  	  /**
	   * 卡类银行型
	   * @return cardType
	   */
	  public String getCardType(){
	      return cardType;
	  }
	  /**
	   * 卡类银行型
	   * @param cardType 
	   */
	  public void setCardType(String cardType){
	      this.cardType = cardType;
	  }
  	  /**
	   * 银行编号
	   * @return bankCode
	   */
	  public String getBankCode(){
	      return bankCode;
	  }
	  /**
	   * 银行编号
	   * @param bankCode 
	   */
	  public void setBankCode(String bankCode){
	      this.bankCode = bankCode;
	  }
  	  /**
	   * 银行名称
	   * @return bankName
	   */
	  public String getBankName(){
	      return bankName;
	  }
	  /**
	   * 银行名称
	   * @param bankName 
	   */
	  public void setBankName(String bankName){
	      this.bankName = bankName;
	  }
  	  /**
	   * 银行名称-银联
	   * @return bankNameOrgin
	   */
	  public String getBankNameOrgin(){
	      return bankNameOrgin;
	  }
	  /**
	   * 银行名称-银联
	   * @param bankNameOrgin 
	   */
	  public void setBankNameOrgin(String bankNameOrgin){
	      this.bankNameOrgin = bankNameOrgin;
	  }
  	  /**
	   * 当前状态
	   * @return state
	   */
	  public String getState(){
	      return state;
	  }
	  /**
	   * 当前状态
	   * @param state 
	   */
	  public void setState(String state){
	      this.state = state;
	  }
  	  /**
	   * 长度
	   * @return cardLength
	   */
	  public Double getCardLength(){
	      return cardLength;
	  }
	  /**
	   * 长度
	   * @param cardLength 
	   */
	  public void setCardLength(Double cardLength){
	      this.cardLength = cardLength;
	  }
  	  /**
	   * bin长度
	   * @return binLength
	   */
	  public Double getBinLength(){
	      return binLength;
	  }
	  /**
	   * bin长度
	   * @param binLength 
	   */
	  public void setBinLength(Double binLength){
	      this.binLength = binLength;
	  }
  	  /**
	   * 更新时间
	   * @return updateTime
	   */
	  public Date getUpdateTime(){
	      return updateTime;
	  }
	  /**
	   * 更新时间
	   * @param updateTime 
	   */
	  public void setUpdateTime(Date updateTime){
	      this.updateTime = updateTime;
	  }
  	  /**
	   * 写入时间
	   * @return writeTime
	   */
	  public Date getWriteTime(){
	      return writeTime;
	  }
	  /**
	   * 写入时间
	   * @param writeTime 
	   */
	  public void setWriteTime(Date writeTime){
	      this.writeTime = writeTime;
	  }
  	  /**
	   * logourl地址
	   * @return logo
	   */
	  public String getLogo(){
	      return logo;
	  }
	  /**
	   * logourl地址
	   * @param logo 
	   */
	  public void setLogo(String logo){
	      this.logo = logo;
	  }
  	  /**
	   * 背景色
	   * @return backColor
	   */
	  public String getBackColor(){
	      return backColor;
	  }
	  /**
	   * 背景色
	   * @param backColor 
	   */
	  public void setBackColor(String backColor){
	      this.backColor = backColor;
	  }
  	  /**
	   * 限额
	   * @return limitation
	   */
	  public String getLimitation(){
	      return limitation;
	  }
	  /**
	   * 限额
	   * @param limitation 
	   */
	  public void setLimitation(String limitation){
	      this.limitation = limitation;
	  }
 
 	 public static class BankCardInfoBuilder{
		private Long cardId; // 记录编号
		private String cardName; // 银行卡名称
		private String cardHead; // 银行卡头
		private String cardType; // 卡类银行型
		private String bankCode; // 银行编号
		private String bankName; // 银行名称
		private String bankNameOrgin; // 银行名称-银联
		private String state; // 当前状态
		private Double cardLength; // 长度
		private Double binLength; // bin长度
		private Date updateTime; // 更新时间
		private Date writeTime; // 写入时间
		private String logo; // logourl地址
		private String backColor; // 背景色
		private String limitation; // 限额
		 /**
	   * 记录编号
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addCardId(Long cardId) {
			this.cardId = cardId;
			return this;
		}
		 /**
	   * 银行卡名称
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addCardName(String cardName) {
			this.cardName = cardName;
			return this;
		}
		 /**
	   * 银行卡头
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addCardHead(String cardHead) {
			this.cardHead = cardHead;
			return this;
		}
		 /**
	   * 卡类银行型
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addCardType(String cardType) {
			this.cardType = cardType;
			return this;
		}
		 /**
	   * 银行编号
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addBankCode(String bankCode) {
			this.bankCode = bankCode;
			return this;
		}
		 /**
	   * 银行名称
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addBankName(String bankName) {
			this.bankName = bankName;
			return this;
		}
		 /**
	   * 银行名称-银联
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addBankNameOrgin(String bankNameOrgin) {
			this.bankNameOrgin = bankNameOrgin;
			return this;
		}
		 /**
	   * 当前状态
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addState(String state) {
			this.state = state;
			return this;
		}
		 /**
	   * 长度
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addCardLength(Double cardLength) {
			this.cardLength = cardLength;
			return this;
		}
		 /**
	   * bin长度
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addBinLength(Double binLength) {
			this.binLength = binLength;
			return this;
		}
		 /**
	   * 更新时间
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}
		 /**
	   * 写入时间
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addWriteTime(Date writeTime) {
			this.writeTime = writeTime;
			return this;
		}
		 /**
	   * logourl地址
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addLogo(String logo) {
			this.logo = logo;
			return this;
		}
		 /**
	   * 背景色
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addBackColor(String backColor) {
			this.backColor = backColor;
			return this;
		}
		 /**
	   * 限额
	   * @return BankCardInfoBuilder
	   */
		public BankCardInfoBuilder addLimitation(String limitation) {
			this.limitation = limitation;
			return this;
		}
	
		public BankCardInfo build(){
			return new BankCardInfo(this);
		}
	 }
}