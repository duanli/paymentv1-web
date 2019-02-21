package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * TransBrand
 *
 * Date:2019-1-30 14:14:58
 * 
 * @author dl
 */
public class TransBrand implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 交易品牌Id
	 */
	private Long transBrandId;
	/**
	 * 交易品牌编号
	 */
	private String transBrandCode;
	/**
	 * 交易品牌名称
	 */
	private String transBrandName;
	/**
	 * 状态
	 */
	private String state;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改日期
	 */
	private Date updateTime;

	public TransBrand() {
	}

	public TransBrand(Long transBrandId, String transBrandCode, String transBrandName, String state, String remark,
			Date createTime, Date updateTime) {
		this.transBrandId = transBrandId;
		this.transBrandCode = transBrandCode;
		this.transBrandName = transBrandName;
		this.state = state;
		this.remark = remark;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	private TransBrand(TransBrandBuilder builder) {
		this.transBrandId = builder.transBrandId;
		this.transBrandCode = builder.transBrandCode;
		this.transBrandName = builder.transBrandName;
		this.state = builder.state;
		this.remark = builder.remark;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
	}

	/**
	 * 交易品牌Id
	 * 
	 * @return transBrandId
	 */
	public Long getTransBrandId() {
		return transBrandId;
	}

	/**
	 * 交易品牌Id
	 * 
	 * @param transBrandId
	 */
	public void setTransBrandId(Long transBrandId) {
		this.transBrandId = transBrandId;
	}

	/**
	 * 交易品牌编号
	 * 
	 * @return transBrandCode
	 */
	public String getTransBrandCode() {
		return transBrandCode;
	}

	/**
	 * 交易品牌编号
	 * 
	 * @param transBrandCode
	 */
	public void setTransBrandCode(String transBrandCode) {
		this.transBrandCode = transBrandCode;
	}

	/**
	 * 交易品牌名称
	 * 
	 * @return transBrandName
	 */
	public String getTransBrandName() {
		return transBrandName;
	}

	/**
	 * 交易品牌名称
	 * 
	 * @param transBrandName
	 */
	public void setTransBrandName(String transBrandName) {
		this.transBrandName = transBrandName;
	}

	/**
	 * 状态
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 状态
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 备注
	 * 
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * 修改日期
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 修改日期
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static class TransBrandBuilder {
		private Long transBrandId; // 交易品牌Id
		private String transBrandCode; // 交易品牌编号
		private String transBrandName; // 交易品牌名称
		private String state; // 状态
		private String remark; // 备注
		private Date createTime; // 创建时间
		private Date updateTime; // 修改日期

		/**
		 * 交易品牌Id
		 * 
		 * @return TransBrandBuilder
		 */
		public TransBrandBuilder addTransBrandId(Long transBrandId) {
			this.transBrandId = transBrandId;
			return this;
		}

		/**
		 * 交易品牌编号
		 * 
		 * @return TransBrandBuilder
		 */
		public TransBrandBuilder addTransBrandCode(String transBrandCode) {
			this.transBrandCode = transBrandCode;
			return this;
		}

		/**
		 * 交易品牌名称
		 * 
		 * @return TransBrandBuilder
		 */
		public TransBrandBuilder addTransBrandName(String transBrandName) {
			this.transBrandName = transBrandName;
			return this;
		}

		/**
		 * 状态
		 * 
		 * @return TransBrandBuilder
		 */
		public TransBrandBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 备注
		 * 
		 * @return TransBrandBuilder
		 */
		public TransBrandBuilder addRemark(String remark) {
			this.remark = remark;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return TransBrandBuilder
		 */
		public TransBrandBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 修改日期
		 * 
		 * @return TransBrandBuilder
		 */
		public TransBrandBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		public TransBrand build() {
			return new TransBrand(this);
		}
	}
}