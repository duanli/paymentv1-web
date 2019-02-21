package cn.com.payment.admin.model;

import java.io.Serializable;

/**
 * BankBankinfo
 *
 * Date:2019-1-20 11:05:18
 * @author dl
 */
public class BankBankinfo implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	  /** 
	   *
	   */
  	   private Long id;
	  /** 
	   *银行编号
	   */
  	   private String code;
	  /** 
	   *银行名称
	   */
  	   private String name;
  
  
  public BankBankinfo(){}
  public BankBankinfo(Long id,String code,String name){
  	   this.id = id;
  	   this.code = code;
  	   this.name = name;
  }
 
 	private BankBankinfo(BankBankinfoBuilder builder){
  	   this.id = builder.id;
  	   this.code = builder.code;
  	   this.name = builder.name;
	 }
 
  	  /**
	   * 
	   * @return id
	   */
	  public Long getId(){
	      return id;
	  }
	  /**
	   * 
	   * @param id 
	   */
	  public void setId(Long id){
	      this.id = id;
	  }
  	  /**
	   * 银行编号
	   * @return code
	   */
	  public String getCode(){
	      return code;
	  }
	  /**
	   * 银行编号
	   * @param code 
	   */
	  public void setCode(String code){
	      this.code = code;
	  }
  	  /**
	   * 银行名称
	   * @return name
	   */
	  public String getName(){
	      return name;
	  }
	  /**
	   * 银行名称
	   * @param name 
	   */
	  public void setName(String name){
	      this.name = name;
	  }
 
 	 public static class BankBankinfoBuilder{
		private Long id; // 
		private String code; // 银行编号
		private String name; // 银行名称
		 /**
	   * 
	   * @return BankBankinfoBuilder
	   */
		public BankBankinfoBuilder addId(Long id) {
			this.id = id;
			return this;
		}
		 /**
	   * 银行编号
	   * @return BankBankinfoBuilder
	   */
		public BankBankinfoBuilder addCode(String code) {
			this.code = code;
			return this;
		}
		 /**
	   * 银行名称
	   * @return BankBankinfoBuilder
	   */
		public BankBankinfoBuilder addName(String name) {
			this.name = name;
			return this;
		}
	
		public BankBankinfo build(){
			return new BankBankinfo(this);
		}
	 }
}