package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * RalProviderTransMode
 *
 * Date:2019-1-30 14:24:59
 * 
 * @author dl
 */
public class RalProviderTransMode implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 服务商交易方式Id
	 */
	private Long productId;

	private String productName;
	/**
	 * 服务商主键ID
	 */
	private Long providerId;
	/**
	 * 交易方式Id
	 */
	private Long transModeId;
	/**
	 * 交易流水号开头
	 */
	private String transRecordPrefix;
	/**
	 * 接口名
	 */
	private String serviceName;
	/**
	 * 方法名
	 */
	private String methodName;
	/**
	 * 参数类型
	 */
	private String paramClass;
	/**
	 * 描述
	 */
	private String desc;
	/**
	 * 服务商提交参数扩展json
	 */
	private String submitParamJson;
	/**
	 * 基准费率(单位:万分之)
	 */
	private Integer feeRate;
	/**
	 * 状态 0-停用 1-启用 2-暂停
	 */
	private String state;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改日期
	 */
	private Date updateTime;
	/**
	 * 每日限额
	 */
	private Long totleAmtLimit;
	/**
	 * 单笔最低额度
	 */
	private Long minAmt;
	/**
	 * 单笔最高额度
	 */
	private Long maxAmt;
	/**
	 * 限流状态0-停用；1-启用
	 */
	private String restrictState;

	private TransMode transMode;

	private String transModeName;

	private String providerAlias;

	public RalProviderTransMode() {
	}

	public RalProviderTransMode(Long productId, Long providerId, Long transModeId, String transRecordPrefix,
			String serviceName, String methodName, String paramClass, String desc, String submitParamJson,
			Integer feeRate, String state, Date createTime, Date updateTime, Long totleAmtLimit, Long minAmt,
			Long maxAmt, String restrictState) {
		this.productId = productId;
		this.providerId = providerId;
		this.transModeId = transModeId;
		this.transRecordPrefix = transRecordPrefix;
		this.serviceName = serviceName;
		this.methodName = methodName;
		this.paramClass = paramClass;
		this.desc = desc;
		this.submitParamJson = submitParamJson;
		this.feeRate = feeRate;
		this.state = state;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.totleAmtLimit = totleAmtLimit;
		this.minAmt = minAmt;
		this.maxAmt = maxAmt;
		this.restrictState = restrictState;
	}

	private RalProviderTransMode(RalProviderTransModeBuilder builder) {
		this.productId = builder.productId;
		this.providerId = builder.providerId;
		this.transModeId = builder.transModeId;
		this.transRecordPrefix = builder.transRecordPrefix;
		this.serviceName = builder.serviceName;
		this.methodName = builder.methodName;
		this.paramClass = builder.paramClass;
		this.desc = builder.desc;
		this.submitParamJson = builder.submitParamJson;
		this.feeRate = builder.feeRate;
		this.state = builder.state;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
		this.totleAmtLimit = builder.totleAmtLimit;
		this.minAmt = builder.minAmt;
		this.maxAmt = builder.maxAmt;
		this.restrictState = builder.restrictState;
	}

	public String getTransModeName() {
		return transModeName;
	}

	public void setTransModeName(String transModeName) {
		this.transModeName = transModeName;
	}

	public String getProviderAlias() {
		return providerAlias;
	}

	public void setProviderAlias(String providerAlias) {
		this.providerAlias = providerAlias;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public TransMode getTransMode() {
		return transMode;
	}

	public void setTransMode(TransMode transMode) {
		this.transMode = transMode;
	}

	/**
	 * 服务商交易方式Id
	 * 
	 * @return productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * 服务商交易方式Id
	 * 
	 * @param productId
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * 服务商主键ID
	 * 
	 * @return providerId
	 */
	public Long getProviderId() {
		return providerId;
	}

	/**
	 * 服务商主键ID
	 * 
	 * @param providerId
	 */
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
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
	 * 交易流水号开头
	 * 
	 * @return transRecordPrefix
	 */
	public String getTransRecordPrefix() {
		return transRecordPrefix;
	}

	/**
	 * 交易流水号开头
	 * 
	 * @param transRecordPrefix
	 */
	public void setTransRecordPrefix(String transRecordPrefix) {
		this.transRecordPrefix = transRecordPrefix;
	}

	/**
	 * 接口名
	 * 
	 * @return serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * 接口名
	 * 
	 * @param serviceName
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * 方法名
	 * 
	 * @return methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * 方法名
	 * 
	 * @param methodName
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * 参数类型
	 * 
	 * @return paramClass
	 */
	public String getParamClass() {
		return paramClass;
	}

	/**
	 * 参数类型
	 * 
	 * @param paramClass
	 */
	public void setParamClass(String paramClass) {
		this.paramClass = paramClass;
	}

	/**
	 * 描述
	 * 
	 * @return desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 描述
	 * 
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 服务商提交参数扩展json
	 * 
	 * @return submitParamJson
	 */
	public String getSubmitParamJson() {
		return submitParamJson;
	}

	/**
	 * 服务商提交参数扩展json
	 * 
	 * @param submitParamJson
	 */
	public void setSubmitParamJson(String submitParamJson) {
		this.submitParamJson = submitParamJson;
	}

	/**
	 * 基准费率(单位:万分之)
	 * 
	 * @return feeRate
	 */
	public Integer getFeeRate() {
		return feeRate;
	}

	/**
	 * 基准费率(单位:万分之)
	 * 
	 * @param feeRate
	 */
	public void setFeeRate(Integer feeRate) {
		this.feeRate = feeRate;
	}

	/**
	 * 状态 0-停用 1-启用 2-暂停
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 状态 0-停用 1-启用 2-暂停
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
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

	/**
	 * 每日限额
	 * 
	 * @return totleAmtLimit
	 */
	public Long getTotleAmtLimit() {
		return totleAmtLimit;
	}

	/**
	 * 每日限额
	 * 
	 * @param totleAmtLimit
	 */
	public void setTotleAmtLimit(Long totleAmtLimit) {
		this.totleAmtLimit = totleAmtLimit;
	}

	/**
	 * 单笔最低额度
	 * 
	 * @return minAmt
	 */
	public Long getMinAmt() {
		return minAmt;
	}

	/**
	 * 单笔最低额度
	 * 
	 * @param minAmt
	 */
	public void setMinAmt(Long minAmt) {
		this.minAmt = minAmt;
	}

	/**
	 * 单笔最高额度
	 * 
	 * @return maxAmt
	 */
	public Long getMaxAmt() {
		return maxAmt;
	}

	/**
	 * 单笔最高额度
	 * 
	 * @param maxAmt
	 */
	public void setMaxAmt(Long maxAmt) {
		this.maxAmt = maxAmt;
	}

	/**
	 * 限流状态0-停用；1-启用
	 * 
	 * @return restrictState
	 */
	public String getRestrictState() {
		return restrictState;
	}

	/**
	 * 限流状态0-停用；1-启用
	 * 
	 * @param restrictState
	 */
	public void setRestrictState(String restrictState) {
		this.restrictState = restrictState;
	}

	public static class RalProviderTransModeBuilder {
		private Long productId; // 服务商交易方式Id
		private Long providerId; // 服务商主键ID
		private Long transModeId; // 交易方式Id
		private String transRecordPrefix; // 交易流水号开头
		private String serviceName; // 接口名
		private String methodName; // 方法名
		private String paramClass; // 参数类型
		private String desc; // 描述
		private String submitParamJson; // 服务商提交参数扩展json
		private Integer feeRate; // 基准费率(单位:万分之)
		private String state; // 状态 0-停用 1-启用 2-暂停
		private Date createTime; // 创建时间
		private Date updateTime; // 修改日期
		private Long totleAmtLimit; // 每日限额
		private Long minAmt; // 单笔最低额度
		private Long maxAmt; // 单笔最高额度
		private String restrictState; // 限流状态0-停用；1-启用

		/**
		 * 服务商交易方式Id
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addProductId(Long productId) {
			this.productId = productId;
			return this;
		}

		/**
		 * 服务商主键ID
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addProviderId(Long providerId) {
			this.providerId = providerId;
			return this;
		}

		/**
		 * 交易方式Id
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addTransModeId(Long transModeId) {
			this.transModeId = transModeId;
			return this;
		}

		/**
		 * 交易流水号开头
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addTransRecordPrefix(String transRecordPrefix) {
			this.transRecordPrefix = transRecordPrefix;
			return this;
		}

		/**
		 * 接口名
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addServiceName(String serviceName) {
			this.serviceName = serviceName;
			return this;
		}

		/**
		 * 方法名
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addMethodName(String methodName) {
			this.methodName = methodName;
			return this;
		}

		/**
		 * 参数类型
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addParamClass(String paramClass) {
			this.paramClass = paramClass;
			return this;
		}

		/**
		 * 描述
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addDesc(String desc) {
			this.desc = desc;
			return this;
		}

		/**
		 * 服务商提交参数扩展json
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addSubmitParamJson(String submitParamJson) {
			this.submitParamJson = submitParamJson;
			return this;
		}

		/**
		 * 基准费率(单位:万分之)
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addFeeRate(Integer feeRate) {
			this.feeRate = feeRate;
			return this;
		}

		/**
		 * 状态 0-停用 1-启用 2-暂停
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 修改日期
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		/**
		 * 每日限额
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addTotleAmtLimit(Long totleAmtLimit) {
			this.totleAmtLimit = totleAmtLimit;
			return this;
		}

		/**
		 * 单笔最低额度
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addMinAmt(Long minAmt) {
			this.minAmt = minAmt;
			return this;
		}

		/**
		 * 单笔最高额度
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addMaxAmt(Long maxAmt) {
			this.maxAmt = maxAmt;
			return this;
		}

		/**
		 * 限流状态0-停用；1-启用
		 * 
		 * @return RalProviderTransModeBuilder
		 */
		public RalProviderTransModeBuilder addRestrictState(String restrictState) {
			this.restrictState = restrictState;
			return this;
		}

		public RalProviderTransMode build() {
			return new RalProviderTransMode(this);
		}
	}
}