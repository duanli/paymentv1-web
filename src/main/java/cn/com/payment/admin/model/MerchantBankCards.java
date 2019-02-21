package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * MerchantBankCards
 *
 * Date:2019-1-30 14:14:58
 * @author dl
 */
public class MerchantBankCards implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	  /** 
	   *银行卡主键
	   */
  	   private Long bankCardId;
	  /** 
	   *商户主键ID
	   */
  	   private Long mchId;
	  /** 
	   *卡用途0-结算1-代付2-代扣
	   */
  	   private String useType;
	  /** 
	   *银行编码
	   */
  	   private String bankCode;
	  /** 
	   *银行账户所属银行名
	   */
  	   private String bankName;
	  /** 
	   *银行账户类型 0-公 1-私
	   */
  	   private String bankAccType;
	  /** 
	   *卡类型：借记卡、贷记卡
	   */
  	   private String bankCardType;
	  /** 
	   *银行账户绑定的银行卡预留手机号
	   */
  	   private String bankReservedPhone;
	  /** 
	   *银行卡号
	   */
  	   private String bankCardNo;
	  /** 
	   *开户省份编号
	   */
  	   private String bankProvince;
	  /** 
	   *开户城市
	   */
  	   private String bankCity;
	  /** 
	   *联行号
	   */
  	   private Long bankLineNo;
	  /** 
	   *支行名称
	   */
  	   private String subBankName;
	  /** 
	   *身份证号
	   */
  	   private String idCardNo;
	  /** 
	   *真实姓名
	   */
  	   private String realName;
	  /** 
	   *状态0-未启用;1-启用2-暂停
	   */
  	   private String state;
	  /** 
	   *创建时间
	   */
  	   private Date createTime;
	  /** 
	   *更新时间
	   */
  	   private Date updateTime;
  
  
  public MerchantBankCards(){}
  public MerchantBankCards(Long bankCardId,Long mchId,String useType,String bankCode,String bankName,String bankAccType,String bankCardType,String bankReservedPhone,String bankCardNo,String bankProvince,String bankCity,Long bankLineNo,String subBankName,String idCardNo,String realName,String state,Date createTime,Date updateTime){
  	   this.bankCardId = bankCardId;
  	   this.mchId = mchId;
  	   this.useType = useType;
  	   this.bankCode = bankCode;
  	   this.bankName = bankName;
  	   this.bankAccType = bankAccType;
  	   this.bankCardType = bankCardType;
  	   this.bankReservedPhone = bankReservedPhone;
  	   this.bankCardNo = bankCardNo;
  	   this.bankProvince = bankProvince;
  	   this.bankCity = bankCity;
  	   this.bankLineNo = bankLineNo;
  	   this.subBankName = subBankName;
  	   this.idCardNo = idCardNo;
  	   this.realName = realName;
  	   this.state = state;
  	   this.createTime = createTime;
  	   this.updateTime = updateTime;
  }
 
 	private MerchantBankCards(MerchantBankCardsBuilder builder){
  	   this.bankCardId = builder.bankCardId;
  	   this.mchId = builder.mchId;
  	   this.useType = builder.useType;
  	   this.bankCode = builder.bankCode;
  	   this.bankName = builder.bankName;
  	   this.bankAccType = builder.bankAccType;
  	   this.bankCardType = builder.bankCardType;
  	   this.bankReservedPhone = builder.bankReservedPhone;
  	   this.bankCardNo = builder.bankCardNo;
  	   this.bankProvince = builder.bankProvince;
  	   this.bankCity = builder.bankCity;
  	   this.bankLineNo = builder.bankLineNo;
  	   this.subBankName = builder.subBankName;
  	   this.idCardNo = builder.idCardNo;
  	   this.realName = builder.realName;
  	   this.state = builder.state;
  	   this.createTime = builder.createTime;
  	   this.updateTime = builder.updateTime;
	 }
 
  	  /**
	   * 银行卡主键
	   * @return bankCardId
	   */
	  public Long getBankCardId(){
	      return bankCardId;
	  }
	  /**
	   * 银行卡主键
	   * @param bankCardId 
	   */
	  public void setBankCardId(Long bankCardId){
	      this.bankCardId = bankCardId;
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
	   * 卡用途0-结算1-代付2-代扣
	   * @return useType
	   */
	  public String getUseType(){
	      return useType;
	  }
	  /**
	   * 卡用途0-结算1-代付2-代扣
	   * @param useType 
	   */
	  public void setUseType(String useType){
	      this.useType = useType;
	  }
  	  /**
	   * 银行编码
	   * @return bankCode
	   */
	  public String getBankCode(){
	      return bankCode;
	  }
	  /**
	   * 银行编码
	   * @param bankCode 
	   */
	  public void setBankCode(String bankCode){
	      this.bankCode = bankCode;
	  }
  	  /**
	   * 银行账户所属银行名
	   * @return bankName
	   */
	  public String getBankName(){
	      return bankName;
	  }
	  /**
	   * 银行账户所属银行名
	   * @param bankName 
	   */
	  public void setBankName(String bankName){
	      this.bankName = bankName;
	  }
  	  /**
	   * 银行账户类型 0-公 1-私
	   * @return bankAccType
	   */
	  public String getBankAccType(){
	      return bankAccType;
	  }
	  /**
	   * 银行账户类型 0-公 1-私
	   * @param bankAccType 
	   */
	  public void setBankAccType(String bankAccType){
	      this.bankAccType = bankAccType;
	  }
  	  /**
	   * 卡类型：借记卡、贷记卡
	   * @return bankCardType
	   */
	  public String getBankCardType(){
	      return bankCardType;
	  }
	  /**
	   * 卡类型：借记卡、贷记卡
	   * @param bankCardType 
	   */
	  public void setBankCardType(String bankCardType){
	      this.bankCardType = bankCardType;
	  }
  	  /**
	   * 银行账户绑定的银行卡预留手机号
	   * @return bankReservedPhone
	   */
	  public String getBankReservedPhone(){
	      return bankReservedPhone;
	  }
	  /**
	   * 银行账户绑定的银行卡预留手机号
	   * @param bankReservedPhone 
	   */
	  public void setBankReservedPhone(String bankReservedPhone){
	      this.bankReservedPhone = bankReservedPhone;
	  }
  	  /**
	   * 银行卡号
	   * @return bankCardNo
	   */
	  public String getBankCardNo(){
	      return bankCardNo;
	  }
	  /**
	   * 银行卡号
	   * @param bankCardNo 
	   */
	  public void setBankCardNo(String bankCardNo){
	      this.bankCardNo = bankCardNo;
	  }
  	  /**
	   * 开户省份编号
	   * @return bankProvince
	   */
	  public String getBankProvince(){
	      return bankProvince;
	  }
	  /**
	   * 开户省份编号
	   * @param bankProvince 
	   */
	  public void setBankProvince(String bankProvince){
	      this.bankProvince = bankProvince;
	  }
  	  /**
	   * 开户城市
	   * @return bankCity
	   */
	  public String getBankCity(){
	      return bankCity;
	  }
	  /**
	   * 开户城市
	   * @param bankCity 
	   */
	  public void setBankCity(String bankCity){
	      this.bankCity = bankCity;
	  }
  	  /**
	   * 联行号
	   * @return bankLineNo
	   */
	  public Long getBankLineNo(){
	      return bankLineNo;
	  }
	  /**
	   * 联行号
	   * @param bankLineNo 
	   */
	  public void setBankLineNo(Long bankLineNo){
	      this.bankLineNo = bankLineNo;
	  }
  	  /**
	   * 支行名称
	   * @return subBankName
	   */
	  public String getSubBankName(){
	      return subBankName;
	  }
	  /**
	   * 支行名称
	   * @param subBankName 
	   */
	  public void setSubBankName(String subBankName){
	      this.subBankName = subBankName;
	  }
  	  /**
	   * 身份证号
	   * @return idCardNo
	   */
	  public String getIdCardNo(){
	      return idCardNo;
	  }
	  /**
	   * 身份证号
	   * @param idCardNo 
	   */
	  public void setIdCardNo(String idCardNo){
	      this.idCardNo = idCardNo;
	  }
  	  /**
	   * 真实姓名
	   * @return realName
	   */
	  public String getRealName(){
	      return realName;
	  }
	  /**
	   * 真实姓名
	   * @param realName 
	   */
	  public void setRealName(String realName){
	      this.realName = realName;
	  }
  	  /**
	   * 状态0-未启用;1-启用2-暂停
	   * @return state
	   */
	  public String getState(){
	      return state;
	  }
	  /**
	   * 状态0-未启用;1-启用2-暂停
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
 
 	 public static class MerchantBankCardsBuilder{
		private Long bankCardId; // 银行卡主键
		private Long mchId; // 商户主键ID
		private String useType; // 卡用途0-结算1-代付2-代扣
		private String bankCode; // 银行编码
		private String bankName; // 银行账户所属银行名
		private String bankAccType; // 银行账户类型 0-公 1-私
		private String bankCardType; // 卡类型：借记卡、贷记卡
		private String bankReservedPhone; // 银行账户绑定的银行卡预留手机号
		private String bankCardNo; // 银行卡号
		private String bankProvince; // 开户省份编号
		private String bankCity; // 开户城市
		private Long bankLineNo; // 联行号
		private String subBankName; // 支行名称
		private String idCardNo; // 身份证号
		private String realName; // 真实姓名
		private String state; // 状态0-未启用;1-启用2-暂停
		private Date createTime; // 创建时间
		private Date updateTime; // 更新时间
		 /**
	   * 银行卡主键
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addBankCardId(Long bankCardId) {
			this.bankCardId = bankCardId;
			return this;
		}
		 /**
	   * 商户主键ID
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addMchId(Long mchId) {
			this.mchId = mchId;
			return this;
		}
		 /**
	   * 卡用途0-结算1-代付2-代扣
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addUseType(String useType) {
			this.useType = useType;
			return this;
		}
		 /**
	   * 银行编码
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addBankCode(String bankCode) {
			this.bankCode = bankCode;
			return this;
		}
		 /**
	   * 银行账户所属银行名
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addBankName(String bankName) {
			this.bankName = bankName;
			return this;
		}
		 /**
	   * 银行账户类型 0-公 1-私
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addBankAccType(String bankAccType) {
			this.bankAccType = bankAccType;
			return this;
		}
		 /**
	   * 卡类型：借记卡、贷记卡
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addBankCardType(String bankCardType) {
			this.bankCardType = bankCardType;
			return this;
		}
		 /**
	   * 银行账户绑定的银行卡预留手机号
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addBankReservedPhone(String bankReservedPhone) {
			this.bankReservedPhone = bankReservedPhone;
			return this;
		}
		 /**
	   * 银行卡号
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addBankCardNo(String bankCardNo) {
			this.bankCardNo = bankCardNo;
			return this;
		}
		 /**
	   * 开户省份编号
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addBankProvince(String bankProvince) {
			this.bankProvince = bankProvince;
			return this;
		}
		 /**
	   * 开户城市
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addBankCity(String bankCity) {
			this.bankCity = bankCity;
			return this;
		}
		 /**
	   * 联行号
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addBankLineNo(Long bankLineNo) {
			this.bankLineNo = bankLineNo;
			return this;
		}
		 /**
	   * 支行名称
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addSubBankName(String subBankName) {
			this.subBankName = subBankName;
			return this;
		}
		 /**
	   * 身份证号
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addIdCardNo(String idCardNo) {
			this.idCardNo = idCardNo;
			return this;
		}
		 /**
	   * 真实姓名
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addRealName(String realName) {
			this.realName = realName;
			return this;
		}
		 /**
	   * 状态0-未启用;1-启用2-暂停
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addState(String state) {
			this.state = state;
			return this;
		}
		 /**
	   * 创建时间
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}
		 /**
	   * 更新时间
	   * @return MerchantBankCardsBuilder
	   */
		public MerchantBankCardsBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}
	
		public MerchantBankCards build(){
			return new MerchantBankCards(this);
		}
	 }
}