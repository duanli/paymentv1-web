package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * MerchantInfo
 *
 * Date:2019-2-14 22:10:01
 * @author dl
 */
public class MerchantInfo implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	  /** 
	   *商户主键ID
	   */
  	   private Long mchId;
	  /** 
	   *机构父ID
	   */
  	   private Long orgParentId;
	  /** 
	   *父商户ID
	   */
  	   private Long chainParentId;
	  /** 
	   *商户账号
	   */
  	   private String accNo;
	  /** 
	   *商户名称
	   */
  	   private String mchName;
	  /** 
	   *商户描述
	   */
  	   private String mchDesc;
	  /** 
	   *商户类型0-普通商户1-连锁商户2-拓展机构3-连锁门店
	   */
  	   private String mchType;
	  /** 
	   *联系人
	   */
  	   private String contacts;
	  /** 
	   *联系人电话
	   */
  	   private String contactsCell;
	  /** 
	   *邮箱
	   */
  	   private String email;
	  /** 
	   *接入商户号
	   */
  	   private String mchNo;
	  /** 
	   *接入商户密钥
	   */
  	   private String mchKey;
	  /** 
	   *商户公钥
	   */
  	   private String mchRSAKey;
	  /** 
	   *接入应用号
	   */
  	   private String mchAPPId;
	  /** 
	   *支付密码
	   */
  	   private String mchPayPassWord;
	  /** 
	   *google验证url
	   */
  	   private String googleAuthUrl;
	  /** 
	   *google验证密钥
	   */
  	   private String googleAuthKey;
	  /** 
	   *google激活标识0-未激活1-激活2-作废
	   */
  	   private String googleAuthFlag;
	  /** 
	   *未入账余额
	   */
  	   private Long balanceUnaccounted;
	  /** 
	   *冻结余额
	   */
  	   private Long balanceFreeze;
	  /** 
	   *可用余额
	   */
  	   private Long balanceValid;
	  /** 
	   *账户总余额
	   */
  	   private Long balance;
	  /** 
	   *是否删除
	   */
  	   private String isDel;
	  /** 
	   *状态 0-停用 1-启用 2-暂停
	   */
  	   private String state;
	  /** 
	   *审核状态0-待审核1-审核通过2-不通过
	   */
  	   private String authState;
	  /** 
	   *IP白名单
	   */
  	   private String validIP;
	  /** 
	   *创建时间
	   */
  	   private Date createTime;
	  /** 
	   *修改时间
	   */
  	   private Date updateTime;
  
  
  public MerchantInfo(){}
  public MerchantInfo(Long mchId,Long orgParentId,Long chainParentId,String accNo,String mchName,String mchDesc,String mchType,String contacts,String contactsCell,String email,String mchNo,String mchKey,String mchRSAKey,String mchAPPId,String mchPayPassWord,String googleAuthUrl,String googleAuthKey,String googleAuthFlag,Long balanceUnaccounted,Long balanceFreeze,Long balanceValid,Long balance,String isDel,String state,String authState,String validIP,Date createTime,Date updateTime){
  	   this.mchId = mchId;
  	   this.orgParentId = orgParentId;
  	   this.chainParentId = chainParentId;
  	   this.accNo = accNo;
  	   this.mchName = mchName;
  	   this.mchDesc = mchDesc;
  	   this.mchType = mchType;
  	   this.contacts = contacts;
  	   this.contactsCell = contactsCell;
  	   this.email = email;
  	   this.mchNo = mchNo;
  	   this.mchKey = mchKey;
  	   this.mchRSAKey = mchRSAKey;
  	   this.mchAPPId = mchAPPId;
  	   this.mchPayPassWord = mchPayPassWord;
  	   this.googleAuthUrl = googleAuthUrl;
  	   this.googleAuthKey = googleAuthKey;
  	   this.googleAuthFlag = googleAuthFlag;
  	   this.balanceUnaccounted = balanceUnaccounted;
  	   this.balanceFreeze = balanceFreeze;
  	   this.balanceValid = balanceValid;
  	   this.balance = balance;
  	   this.isDel = isDel;
  	   this.state = state;
  	   this.authState = authState;
  	   this.validIP = validIP;
  	   this.createTime = createTime;
  	   this.updateTime = updateTime;
  }
 
 	private MerchantInfo(MerchantInfoBuilder builder){
  	   this.mchId = builder.mchId;
  	   this.orgParentId = builder.orgParentId;
  	   this.chainParentId = builder.chainParentId;
  	   this.accNo = builder.accNo;
  	   this.mchName = builder.mchName;
  	   this.mchDesc = builder.mchDesc;
  	   this.mchType = builder.mchType;
  	   this.contacts = builder.contacts;
  	   this.contactsCell = builder.contactsCell;
  	   this.email = builder.email;
  	   this.mchNo = builder.mchNo;
  	   this.mchKey = builder.mchKey;
  	   this.mchRSAKey = builder.mchRSAKey;
  	   this.mchAPPId = builder.mchAPPId;
  	   this.mchPayPassWord = builder.mchPayPassWord;
  	   this.googleAuthUrl = builder.googleAuthUrl;
  	   this.googleAuthKey = builder.googleAuthKey;
  	   this.googleAuthFlag = builder.googleAuthFlag;
  	   this.balanceUnaccounted = builder.balanceUnaccounted;
  	   this.balanceFreeze = builder.balanceFreeze;
  	   this.balanceValid = builder.balanceValid;
  	   this.balance = builder.balance;
  	   this.isDel = builder.isDel;
  	   this.state = builder.state;
  	   this.authState = builder.authState;
  	   this.validIP = builder.validIP;
  	   this.createTime = builder.createTime;
  	   this.updateTime = builder.updateTime;
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
	   * 机构父ID
	   * @return orgParentId
	   */
	  public Long getOrgParentId(){
	      return orgParentId;
	  }
	  /**
	   * 机构父ID
	   * @param orgParentId 
	   */
	  public void setOrgParentId(Long orgParentId){
	      this.orgParentId = orgParentId;
	  }
  	  /**
	   * 父商户ID
	   * @return chainParentId
	   */
	  public Long getChainParentId(){
	      return chainParentId;
	  }
	  /**
	   * 父商户ID
	   * @param chainParentId 
	   */
	  public void setChainParentId(Long chainParentId){
	      this.chainParentId = chainParentId;
	  }
  	  /**
	   * 商户账号
	   * @return accNo
	   */
	  public String getAccNo(){
	      return accNo;
	  }
	  /**
	   * 商户账号
	   * @param accNo 
	   */
	  public void setAccNo(String accNo){
	      this.accNo = accNo;
	  }
  	  /**
	   * 商户名称
	   * @return mchName
	   */
	  public String getMchName(){
	      return mchName;
	  }
	  /**
	   * 商户名称
	   * @param mchName 
	   */
	  public void setMchName(String mchName){
	      this.mchName = mchName;
	  }
  	  /**
	   * 商户描述
	   * @return mchDesc
	   */
	  public String getMchDesc(){
	      return mchDesc;
	  }
	  /**
	   * 商户描述
	   * @param mchDesc 
	   */
	  public void setMchDesc(String mchDesc){
	      this.mchDesc = mchDesc;
	  }
  	  /**
	   * 商户类型0-普通商户1-连锁商户2-拓展机构3-连锁门店
	   * @return mchType
	   */
	  public String getMchType(){
	      return mchType;
	  }
	  /**
	   * 商户类型0-普通商户1-连锁商户2-拓展机构3-连锁门店
	   * @param mchType 
	   */
	  public void setMchType(String mchType){
	      this.mchType = mchType;
	  }
  	  /**
	   * 联系人
	   * @return contacts
	   */
	  public String getContacts(){
	      return contacts;
	  }
	  /**
	   * 联系人
	   * @param contacts 
	   */
	  public void setContacts(String contacts){
	      this.contacts = contacts;
	  }
  	  /**
	   * 联系人电话
	   * @return contactsCell
	   */
	  public String getContactsCell(){
	      return contactsCell;
	  }
	  /**
	   * 联系人电话
	   * @param contactsCell 
	   */
	  public void setContactsCell(String contactsCell){
	      this.contactsCell = contactsCell;
	  }
  	  /**
	   * 邮箱
	   * @return email
	   */
	  public String getEmail(){
	      return email;
	  }
	  /**
	   * 邮箱
	   * @param email 
	   */
	  public void setEmail(String email){
	      this.email = email;
	  }
  	  /**
	   * 接入商户号
	   * @return mchNo
	   */
	  public String getMchNo(){
	      return mchNo;
	  }
	  /**
	   * 接入商户号
	   * @param mchNo 
	   */
	  public void setMchNo(String mchNo){
	      this.mchNo = mchNo;
	  }
  	  /**
	   * 接入商户密钥
	   * @return mchKey
	   */
	  public String getMchKey(){
	      return mchKey;
	  }
	  /**
	   * 接入商户密钥
	   * @param mchKey 
	   */
	  public void setMchKey(String mchKey){
	      this.mchKey = mchKey;
	  }
  	  /**
	   * 商户公钥
	   * @return mchRSAKey
	   */
	  public String getMchRSAKey(){
	      return mchRSAKey;
	  }
	  /**
	   * 商户公钥
	   * @param mchRSAKey 
	   */
	  public void setMchRSAKey(String mchRSAKey){
	      this.mchRSAKey = mchRSAKey;
	  }
  	  /**
	   * 接入应用号
	   * @return mchAPPId
	   */
	  public String getMchAPPId(){
	      return mchAPPId;
	  }
	  /**
	   * 接入应用号
	   * @param mchAPPId 
	   */
	  public void setMchAPPId(String mchAPPId){
	      this.mchAPPId = mchAPPId;
	  }
  	  /**
	   * 支付密码
	   * @return mchPayPassWord
	   */
	  public String getMchPayPassWord(){
	      return mchPayPassWord;
	  }
	  /**
	   * 支付密码
	   * @param mchPayPassWord 
	   */
	  public void setMchPayPassWord(String mchPayPassWord){
	      this.mchPayPassWord = mchPayPassWord;
	  }
  	  /**
	   * google验证url
	   * @return googleAuthUrl
	   */
	  public String getGoogleAuthUrl(){
	      return googleAuthUrl;
	  }
	  /**
	   * google验证url
	   * @param googleAuthUrl 
	   */
	  public void setGoogleAuthUrl(String googleAuthUrl){
	      this.googleAuthUrl = googleAuthUrl;
	  }
  	  /**
	   * google验证密钥
	   * @return googleAuthKey
	   */
	  public String getGoogleAuthKey(){
	      return googleAuthKey;
	  }
	  /**
	   * google验证密钥
	   * @param googleAuthKey 
	   */
	  public void setGoogleAuthKey(String googleAuthKey){
	      this.googleAuthKey = googleAuthKey;
	  }
  	  /**
	   * google激活标识0-未激活1-激活2-作废
	   * @return googleAuthFlag
	   */
	  public String getGoogleAuthFlag(){
	      return googleAuthFlag;
	  }
	  /**
	   * google激活标识0-未激活1-激活2-作废
	   * @param googleAuthFlag 
	   */
	  public void setGoogleAuthFlag(String googleAuthFlag){
	      this.googleAuthFlag = googleAuthFlag;
	  }
  	  /**
	   * 未入账余额
	   * @return balanceUnaccounted
	   */
	  public Long getBalanceUnaccounted(){
	      return balanceUnaccounted;
	  }
	  /**
	   * 未入账余额
	   * @param balanceUnaccounted 
	   */
	  public void setBalanceUnaccounted(Long balanceUnaccounted){
	      this.balanceUnaccounted = balanceUnaccounted;
	  }
  	  /**
	   * 冻结余额
	   * @return balanceFreeze
	   */
	  public Long getBalanceFreeze(){
	      return balanceFreeze;
	  }
	  /**
	   * 冻结余额
	   * @param balanceFreeze 
	   */
	  public void setBalanceFreeze(Long balanceFreeze){
	      this.balanceFreeze = balanceFreeze;
	  }
  	  /**
	   * 可用余额
	   * @return balanceValid
	   */
	  public Long getBalanceValid(){
	      return balanceValid;
	  }
	  /**
	   * 可用余额
	   * @param balanceValid 
	   */
	  public void setBalanceValid(Long balanceValid){
	      this.balanceValid = balanceValid;
	  }
  	  /**
	   * 账户总余额
	   * @return balance
	   */
	  public Long getBalance(){
	      return balance;
	  }
	  /**
	   * 账户总余额
	   * @param balance 
	   */
	  public void setBalance(Long balance){
	      this.balance = balance;
	  }
  	  /**
	   * 是否删除
	   * @return isDel
	   */
	  public String getIsDel(){
	      return isDel;
	  }
	  /**
	   * 是否删除
	   * @param isDel 
	   */
	  public void setIsDel(String isDel){
	      this.isDel = isDel;
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
	   * 审核状态0-待审核1-审核通过2-不通过
	   * @return authState
	   */
	  public String getAuthState(){
	      return authState;
	  }
	  /**
	   * 审核状态0-待审核1-审核通过2-不通过
	   * @param authState 
	   */
	  public void setAuthState(String authState){
	      this.authState = authState;
	  }
  	  /**
	   * IP白名单
	   * @return validIP
	   */
	  public String getValidIP(){
	      return validIP;
	  }
	  /**
	   * IP白名单
	   * @param validIP 
	   */
	  public void setValidIP(String validIP){
	      this.validIP = validIP;
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
 
 	 public static class MerchantInfoBuilder{
		private Long mchId; // 商户主键ID
		private Long orgParentId; // 机构父ID
		private Long chainParentId; // 父商户ID
		private String accNo; // 商户账号
		private String mchName; // 商户名称
		private String mchDesc; // 商户描述
		private String mchType; // 商户类型0-普通商户1-连锁商户2-拓展机构3-连锁门店
		private String contacts; // 联系人
		private String contactsCell; // 联系人电话
		private String email; // 邮箱
		private String mchNo; // 接入商户号
		private String mchKey; // 接入商户密钥
		private String mchRSAKey; // 商户公钥
		private String mchAPPId; // 接入应用号
		private String mchPayPassWord; // 支付密码
		private String googleAuthUrl; // google验证url
		private String googleAuthKey; // google验证密钥
		private String googleAuthFlag; // google激活标识0-未激活1-激活2-作废
		private Long balanceUnaccounted; // 未入账余额
		private Long balanceFreeze; // 冻结余额
		private Long balanceValid; // 可用余额
		private Long balance; // 账户总余额
		private String isDel; // 是否删除
		private String state; // 状态 0-停用 1-启用 2-暂停
		private String authState; // 审核状态0-待审核1-审核通过2-不通过
		private String validIP; // IP白名单
		private Date createTime; // 创建时间
		private Date updateTime; // 修改时间
		 /**
	   * 商户主键ID
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addMchId(Long mchId) {
			this.mchId = mchId;
			return this;
		}
		 /**
	   * 机构父ID
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addOrgParentId(Long orgParentId) {
			this.orgParentId = orgParentId;
			return this;
		}
		 /**
	   * 父商户ID
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addChainParentId(Long chainParentId) {
			this.chainParentId = chainParentId;
			return this;
		}
		 /**
	   * 商户账号
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addAccNo(String accNo) {
			this.accNo = accNo;
			return this;
		}
		 /**
	   * 商户名称
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addMchName(String mchName) {
			this.mchName = mchName;
			return this;
		}
		 /**
	   * 商户描述
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addMchDesc(String mchDesc) {
			this.mchDesc = mchDesc;
			return this;
		}
		 /**
	   * 商户类型0-普通商户1-连锁商户2-拓展机构3-连锁门店
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addMchType(String mchType) {
			this.mchType = mchType;
			return this;
		}
		 /**
	   * 联系人
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addContacts(String contacts) {
			this.contacts = contacts;
			return this;
		}
		 /**
	   * 联系人电话
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addContactsCell(String contactsCell) {
			this.contactsCell = contactsCell;
			return this;
		}
		 /**
	   * 邮箱
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addEmail(String email) {
			this.email = email;
			return this;
		}
		 /**
	   * 接入商户号
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addMchNo(String mchNo) {
			this.mchNo = mchNo;
			return this;
		}
		 /**
	   * 接入商户密钥
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addMchKey(String mchKey) {
			this.mchKey = mchKey;
			return this;
		}
		 /**
	   * 商户公钥
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addMchRSAKey(String mchRSAKey) {
			this.mchRSAKey = mchRSAKey;
			return this;
		}
		 /**
	   * 接入应用号
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addMchAPPId(String mchAPPId) {
			this.mchAPPId = mchAPPId;
			return this;
		}
		 /**
	   * 支付密码
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addMchPayPassWord(String mchPayPassWord) {
			this.mchPayPassWord = mchPayPassWord;
			return this;
		}
		 /**
	   * google验证url
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addGoogleAuthUrl(String googleAuthUrl) {
			this.googleAuthUrl = googleAuthUrl;
			return this;
		}
		 /**
	   * google验证密钥
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addGoogleAuthKey(String googleAuthKey) {
			this.googleAuthKey = googleAuthKey;
			return this;
		}
		 /**
	   * google激活标识0-未激活1-激活2-作废
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addGoogleAuthFlag(String googleAuthFlag) {
			this.googleAuthFlag = googleAuthFlag;
			return this;
		}
		 /**
	   * 未入账余额
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addBalanceUnaccounted(Long balanceUnaccounted) {
			this.balanceUnaccounted = balanceUnaccounted;
			return this;
		}
		 /**
	   * 冻结余额
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addBalanceFreeze(Long balanceFreeze) {
			this.balanceFreeze = balanceFreeze;
			return this;
		}
		 /**
	   * 可用余额
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addBalanceValid(Long balanceValid) {
			this.balanceValid = balanceValid;
			return this;
		}
		 /**
	   * 账户总余额
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addBalance(Long balance) {
			this.balance = balance;
			return this;
		}
		 /**
	   * 是否删除
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addIsDel(String isDel) {
			this.isDel = isDel;
			return this;
		}
		 /**
	   * 状态 0-停用 1-启用 2-暂停
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addState(String state) {
			this.state = state;
			return this;
		}
		 /**
	   * 审核状态0-待审核1-审核通过2-不通过
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addAuthState(String authState) {
			this.authState = authState;
			return this;
		}
		 /**
	   * IP白名单
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addValidIP(String validIP) {
			this.validIP = validIP;
			return this;
		}
		 /**
	   * 创建时间
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}
		 /**
	   * 修改时间
	   * @return MerchantInfoBuilder
	   */
		public MerchantInfoBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}
	
		public MerchantInfo build(){
			return new MerchantInfo(this);
		}
	 }
}