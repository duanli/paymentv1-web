package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * TransMode
 *
 * Date:2019-1-30 14:14:58
 * 
 * @author dl
 */
public class TransMode implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 交易方式Id
	 */
	private Long transModeId;
	/**
	 * 交易品牌Id
	 */
	private Long transBrandId;
	/**
	 * 交易方式编号
	 */
	private String transModeCode;
	/**
	 * 交易方式名称
	 */
	private String transModeName;
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

	private TransBrand transBrand;

	public TransMode() {
	}

	public TransMode(Long transModeId, Long transBrandId, String transModeCode, String transModeName, String state,
			String remark, Date createTime, Date updateTime) {
		this.transModeId = transModeId;
		this.transBrandId = transBrandId;
		this.transModeCode = transModeCode;
		this.transModeName = transModeName;
		this.state = state;
		this.remark = remark;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	private TransMode(TransModeBuilder builder) {
		this.transModeId = builder.transModeId;
		this.transBrandId = builder.transBrandId;
		this.transModeCode = builder.transModeCode;
		this.transModeName = builder.transModeName;
		this.state = builder.state;
		this.remark = builder.remark;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
	}

	public TransBrand getTransBrand() {
		return transBrand;
	}

	public void setTransBrand(TransBrand transBrand) {
		this.transBrand = transBrand;
	}

	/**
	 * 交易方式Id
	 * 
	 * @return transModeId
	 */
	public Long getTransModeId() {
		return transModeId;
	}

	/**
	 * 交易方式Id
	 * 
	 * @param transModeId
	 */
	public void setTransModeId(Long transModeId) {
		this.transModeId = transModeId;
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
	 * 交易方式编号
	 * 
	 * @return transModeCode
	 */
	public String getTransModeCode() {
		return transModeCode;
	}

	/**
	 * 交易方式编号
	 * 
	 * @param transModeCode
	 */
	public void setTransModeCode(String transModeCode) {
		this.transModeCode = transModeCode;
	}

	/**
	 * 交易方式名称
	 * 
	 * @return transModeName
	 */
	public String getTransModeName() {
		return transModeName;
	}

	/**
	 * 交易方式名称
	 * 
	 * @param transModeName
	 */
	public void setTransModeName(String transModeName) {
		this.transModeName = transModeName;
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

	public static class TransModeBuilder {
		private Long transModeId; // 交易方式Id
		private Long transBrandId; // 交易品牌Id
		private String transModeCode; // 交易方式编号
		private String transModeName; // 交易方式名称
		private String state; // 状态
		private String remark; // 备注
		private Date createTime; // 创建时间
		private Date updateTime; // 修改日期

		/**
		 * 交易方式Id
		 * 
		 * @return TransModeBuilder
		 */
		public TransModeBuilder addTransModeId(Long transModeId) {
			this.transModeId = transModeId;
			return this;
		}

		/**
		 * 交易品牌Id
		 * 
		 * @return TransModeBuilder
		 */
		public TransModeBuilder addTransBrandId(Long transBrandId) {
			this.transBrandId = transBrandId;
			return this;
		}

		/**
		 * 交易方式编号
		 * 
		 * @return TransModeBuilder
		 */
		public TransModeBuilder addTransModeCode(String transModeCode) {
			this.transModeCode = transModeCode;
			return this;
		}

		/**
		 * 交易方式名称
		 * 
		 * @return TransModeBuilder
		 */
		public TransModeBuilder addTransModeName(String transModeName) {
			this.transModeName = transModeName;
			return this;
		}

		/**
		 * 状态
		 * 
		 * @return TransModeBuilder
		 */
		public TransModeBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 备注
		 * 
		 * @return TransModeBuilder
		 */
		public TransModeBuilder addRemark(String remark) {
			this.remark = remark;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return TransModeBuilder
		 */
		public TransModeBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 修改日期
		 * 
		 * @return TransModeBuilder
		 */
		public TransModeBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		public TransMode build() {
			return new TransMode(this);
		}
	}
}