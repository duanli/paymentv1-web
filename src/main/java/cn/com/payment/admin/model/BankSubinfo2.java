package cn.com.payment.admin.model;

import java.io.Serializable;

/**
 * BankSubinfo2
 *
 * Date:2019-1-20 11:05:18
 * @author dl
 */
public class BankSubinfo2 implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	  /** 
	   *
	   */
  	   private Long id;
	  /** 
	   *
	   */
  	   private String subBankName;
	  /** 
	   *
	   */
  	   private String lineNo;
	  /** 
	   *
	   */
  	   private String bankCode;
	  /** 
	   *
	   */
  	   private String areaCode;
	  /** 
	   *
	   */
  	   private String bankName;
	  /** 
	   *
	   */
  	   private String district;
	  /** 
	   *
	   */
  	   private String levelName;
	  /** 
	   *
	   */
  	   private String cityName;
	  /** 
	   *
	   */
  	   private String provinceName;
	  /** 
	   *
	   */
  	   private String provinceNameAlias;
	  /** 
	   *
	   */
  	   private String areaId;
	  /** 
	   *
	   */
  	   private String contry;
	  /** 
	   *
	   */
  	   private String bankNo;
	  /** 
	   *
	   */
  	   private String bankGroup;
  
  
  public BankSubinfo2(){}
  public BankSubinfo2(Long id,String subBankName,String lineNo,String bankCode,String areaCode,String bankName,String district,String levelName,String cityName,String provinceName,String provinceNameAlias,String areaId,String contry,String bankNo,String bankGroup){
  	   this.id = id;
  	   this.subBankName = subBankName;
  	   this.lineNo = lineNo;
  	   this.bankCode = bankCode;
  	   this.areaCode = areaCode;
  	   this.bankName = bankName;
  	   this.district = district;
  	   this.levelName = levelName;
  	   this.cityName = cityName;
  	   this.provinceName = provinceName;
  	   this.provinceNameAlias = provinceNameAlias;
  	   this.areaId = areaId;
  	   this.contry = contry;
  	   this.bankNo = bankNo;
  	   this.bankGroup = bankGroup;
  }
 
 	private BankSubinfo2(BankSubinfo2Builder builder){
  	   this.id = builder.id;
  	   this.subBankName = builder.subBankName;
  	   this.lineNo = builder.lineNo;
  	   this.bankCode = builder.bankCode;
  	   this.areaCode = builder.areaCode;
  	   this.bankName = builder.bankName;
  	   this.district = builder.district;
  	   this.levelName = builder.levelName;
  	   this.cityName = builder.cityName;
  	   this.provinceName = builder.provinceName;
  	   this.provinceNameAlias = builder.provinceNameAlias;
  	   this.areaId = builder.areaId;
  	   this.contry = builder.contry;
  	   this.bankNo = builder.bankNo;
  	   this.bankGroup = builder.bankGroup;
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
  	  /**
	   * 
	   * @return bankCode
	   */
	  public String getBankCode(){
	      return bankCode;
	  }
	  /**
	   * 
	   * @param bankCode 
	   */
	  public void setBankCode(String bankCode){
	      this.bankCode = bankCode;
	  }
  	  /**
	   * 
	   * @return areaCode
	   */
	  public String getAreaCode(){
	      return areaCode;
	  }
	  /**
	   * 
	   * @param areaCode 
	   */
	  public void setAreaCode(String areaCode){
	      this.areaCode = areaCode;
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
	   * @return district
	   */
	  public String getDistrict(){
	      return district;
	  }
	  /**
	   * 
	   * @param district 
	   */
	  public void setDistrict(String district){
	      this.district = district;
	  }
  	  /**
	   * 
	   * @return levelName
	   */
	  public String getLevelName(){
	      return levelName;
	  }
	  /**
	   * 
	   * @param levelName 
	   */
	  public void setLevelName(String levelName){
	      this.levelName = levelName;
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
	   * @return provinceNameAlias
	   */
	  public String getProvinceNameAlias(){
	      return provinceNameAlias;
	  }
	  /**
	   * 
	   * @param provinceNameAlias 
	   */
	  public void setProvinceNameAlias(String provinceNameAlias){
	      this.provinceNameAlias = provinceNameAlias;
	  }
  	  /**
	   * 
	   * @return areaId
	   */
	  public String getAreaId(){
	      return areaId;
	  }
	  /**
	   * 
	   * @param areaId 
	   */
	  public void setAreaId(String areaId){
	      this.areaId = areaId;
	  }
  	  /**
	   * 
	   * @return contry
	   */
	  public String getContry(){
	      return contry;
	  }
	  /**
	   * 
	   * @param contry 
	   */
	  public void setContry(String contry){
	      this.contry = contry;
	  }
  	  /**
	   * 
	   * @return bankNo
	   */
	  public String getBankNo(){
	      return bankNo;
	  }
	  /**
	   * 
	   * @param bankNo 
	   */
	  public void setBankNo(String bankNo){
	      this.bankNo = bankNo;
	  }
  	  /**
	   * 
	   * @return bankGroup
	   */
	  public String getBankGroup(){
	      return bankGroup;
	  }
	  /**
	   * 
	   * @param bankGroup 
	   */
	  public void setBankGroup(String bankGroup){
	      this.bankGroup = bankGroup;
	  }
 
 	 public static class BankSubinfo2Builder{
		private Long id; // 
		private String subBankName; // 
		private String lineNo; // 
		private String bankCode; // 
		private String areaCode; // 
		private String bankName; // 
		private String district; // 
		private String levelName; // 
		private String cityName; // 
		private String provinceName; // 
		private String provinceNameAlias; // 
		private String areaId; // 
		private String contry; // 
		private String bankNo; // 
		private String bankGroup; // 
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addId(Long id) {
			this.id = id;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addSubBankName(String subBankName) {
			this.subBankName = subBankName;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addLineNo(String lineNo) {
			this.lineNo = lineNo;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addBankCode(String bankCode) {
			this.bankCode = bankCode;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addAreaCode(String areaCode) {
			this.areaCode = areaCode;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addBankName(String bankName) {
			this.bankName = bankName;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addDistrict(String district) {
			this.district = district;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addLevelName(String levelName) {
			this.levelName = levelName;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addCityName(String cityName) {
			this.cityName = cityName;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addProvinceName(String provinceName) {
			this.provinceName = provinceName;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addProvinceNameAlias(String provinceNameAlias) {
			this.provinceNameAlias = provinceNameAlias;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addAreaId(String areaId) {
			this.areaId = areaId;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addContry(String contry) {
			this.contry = contry;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addBankNo(String bankNo) {
			this.bankNo = bankNo;
			return this;
		}
		 /**
	   * 
	   * @return BankSubinfo2Builder
	   */
		public BankSubinfo2Builder addBankGroup(String bankGroup) {
			this.bankGroup = bankGroup;
			return this;
		}
	
		public BankSubinfo2 build(){
			return new BankSubinfo2(this);
		}
	 }
}