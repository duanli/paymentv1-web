package cn.com.payment.admin.model;

import java.io.Serializable;

/**
 * BankSubinfo
 *
 * Date:2019-1-20 11:05:18
 * @author dl
 */
public class BankSubinfo implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	  /** 
	   *主键id
	   */
  	   private Long id;
	  /** 
	   *
	   */
  	   private String provinceId;
	  /** 
	   *
	   */
  	   private String cityId;
	  /** 
	   *
	   */
  	   private String provinceName;
	  /** 
	   *
	   */
  	   private String cityName;
	  /** 
	   *
	   */
  	   private String bankId;
	  /** 
	   *
	   */
  	   private String bankName;
	  /** 
	   *
	   */
  	   private String subBankName;
	  /** 
	   *
	   */
  	   private String lineNo;
  
  
  public BankSubinfo(){}
  public BankSubinfo(Long id,String provinceId,String cityId,String provinceName,String cityName,String bankId,String bankName,String subBankName,String lineNo){
  	   this.id = id;
  	   this.provinceId = provinceId;
  	   this.cityId = cityId;
  	   this.provinceName = provinceName;
  	   this.cityName = cityName;
  	   this.bankId = bankId;
  	   this.bankName = bankName;
  	   this.subBankName = subBankName;
  	   this.lineNo = lineNo;
  }
 
 	private BankSubinfo(BankSubinfoBuilder builder){
  	   this.id = builder.id;
  	   this.provinceId = builder.provinceId;
  	   this.cityId = builder.cityId;
  	   this.provinceName = builder.provinceName;
  	   this.cityName = builder.cityName;
  	   this.bankId = builder.bankId;
  	   this.bankName = builder.bankName;
  	   this.subBankName = builder.subBankName;
  	   this.lineNo = builder.lineNo;
	 }
 
  	  /**
	   * 主键id
	   * @return id
	   */
	  public Long getId(){
	      return id;
	  }
	  /**
	   * 主键id
	   * @param id 
	   */
	  public void setId(Long id){
	      this.id = id;
	  }
  	  /**
	   * 
	   * @return provinceId
	   */
	  public String getProvinceId(){
	      return provinceId;
	  }
	  /**
	   * 
	   * @param provinceId 
	   */
	  public void setProvinceId(String provinceId){
	      this.provinceId = provinceId;
	  }
  	  /**
	   * 
	   * @return cityId
	   */
	  public String getCityId(){
	      return cityId;
	  }
	  /**
	   * 
	   * @param cityId 
	   */
	  public void setCityId(String cityId){
	      this.cityId = cityId;
	  }
  	  /**
	   * 
	   * @return provinceName
	   */
	  public String getProvinceName(){
	      return provinceName;
	  }
	  /**
	   * 
	   * @param provinceName 
	   */
	  public void setProvinceName(String provinceName){
	      this.provinceName = provinceName;
	  }
  	  /**
	   * 
	   * @return cityName
	   */
	  public String getCityName(){
	      return cityName;
	  }
	  /**
	   * 
	   * @param cityName 
	   */
	  public void setCityName(String cityName){
	      this.cityName = cityName;
	  }
  	  /**
	   * 
	   * @return bankId
	   */
	  public String getBankId(){
	      return bankId;
	  }
	  /**
	   * 
	   * @param bankId 
	   */
	  public void setBankId(String bankId){
	      this.bankId = bankId;
	  }
  	  /**
	   * 
	   * @return bankName
	   */
	  public String getBankName(){
	      return bankName;
	  }
	  /**
	   * 
	   * @param bankName 
	   */
	  public void setBankName(String bankName){
	      this.bankName = bankName;
	  }
  	  /**
	   * 
	   * @return subBankName
	   */
	  public String getSubBankName(){
	      return subBankName;
	  }
	  /**
	   * 
	   * @param subBankName 
	   */
	  public void setSubBankName(String subBankName){
	      this.subBankName = subBankName;
	  }
  	  /**
	   * 
	   * @return lineNo
	   */
	  public String getLineNo(){
	      return lineNo;
	  }
	  /**
	   * 
	   * @param lineNo 
	   */
	  public void setLineNo(String lineNo){
	      this.lineNo = lineNo;
	  }
 
 	 public static class BankSubinfoBuilder{
		private Long id; // 主键id
		private String provinceId; // 
		private String cityId; // 
		private String provinceName; // 
		private String cityName; // 
		private String bankId; // 
		private String bankName; // 
		private String subBankName; // 
		private String lineNo; // 
		 /**
	   * 主键id
	   * @return BankSubinfoBuilder
	   */
		public BankSubinfoBuilder addId(Long id) {
			this.id = id;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfoBuilder
	   */
		public BankSubinfoBuilder addProvinceId(String provinceId) {
			this.provinceId = provinceId;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfoBuilder
	   */
		public BankSubinfoBuilder addCityId(String cityId) {
			this.cityId = cityId;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfoBuilder
	   */
		public BankSubinfoBuilder addProvinceName(String provinceName) {
			this.provinceName = provinceName;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfoBuilder
	   */
		public BankSubinfoBuilder addCityName(String cityName) {
			this.cityName = cityName;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfoBuilder
	   */
		public BankSubinfoBuilder addBankId(String bankId) {
			this.bankId = bankId;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfoBuilder
	   */
		public BankSubinfoBuilder addBankName(String bankName) {
			this.bankName = bankName;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfoBuilder
	   */
		public BankSubinfoBuilder addSubBankName(String subBankName) {
			this.subBankName = subBankName;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfoBuilder
	   */
		public BankSubinfoBuilder addLineNo(String lineNo) {
			this.lineNo = lineNo;
			return this;
		}
	
		public BankSubinfo build(){
			return new BankSubinfo(this);
		}
	 }
}