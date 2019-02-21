package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ProviderAgent
 *
 * Date:2019-1-30 14:14:58
 * 
 * @author dl
 */
public class ProviderAgent implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long providerAgentId;
	/**
	 * 交易服务商编号
	 */
	private String providerAgentCode;
	/**
	 * 交易服务商名称
	 */
	private String providerAgentName;
	/**
	 * 状态0-未启用1-启用2-暂停
	 */
	private String state;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	public ProviderAgent() {
	}

	public ProviderAgent(Long providerAgentId, String providerAgentCode, String providerAgentName, String state,
			Date createTime, Date updateTime) {
		this.providerAgentId = providerAgentId;
		this.providerAgentCode = providerAgentCode;
		this.providerAgentName = providerAgentName;
		this.state = state;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	private ProviderAgent(ProviderAgentBuilder builder) {
		this.providerAgentId = builder.providerAgentId;
		this.providerAgentCode = builder.providerAgentCode;
		this.providerAgentName = builder.providerAgentName;
		this.state = builder.state;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
	}

	/**
	 * 主键ID
	 * 
	 * @return providerAgentId
	 */
	public Long getProviderAgentId() {
		return providerAgentId;
	}

	/**
	 * 主键ID
	 * 
	 * @param providerAgentId
	 */
	public void setProviderAgentId(Long providerAgentId) {
		this.providerAgentId = providerAgentId;
	}

	/**
	 * 交易服务商编号
	 * 
	 * @return providerAgentCode
	 */
	public String getProviderAgentCode() {
		return providerAgentCode;
	}

	/**
	 * 交易服务商编号
	 * 
	 * @param providerAgentCode
	 */
	public void setProviderAgentCode(String providerAgentCode) {
		this.providerAgentCode = providerAgentCode;
	}

	/**
	 * 交易服务商名称
	 * 
	 * @return providerAgentName
	 */
	public String getProviderAgentName() {
		return providerAgentName;
	}

	/**
	 * 交易服务商名称
	 * 
	 * @param providerAgentName
	 */
	public void setProviderAgentName(String providerAgentName) {
		this.providerAgentName = providerAgentName;
	}

	/**
	 * 状态0-未启用1-启用2-暂停
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 状态0-未启用1-启用2-暂停
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
	 * 更新时间
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 更新时间
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static class ProviderAgentBuilder {
		private Long providerAgentId; // 主键ID
		private String providerAgentCode; // 交易服务商编号
		private String providerAgentName; // 交易服务商名称
		private String state; // 状态0-未启用1-启用2-暂停
		private Date createTime; // 创建时间
		private Date updateTime; // 更新时间

		/**
		 * 主键ID
		 * 
		 * @return ProviderAgentBuilder
		 */
		public ProviderAgentBuilder addProviderAgentId(Long providerAgentId) {
			this.providerAgentId = providerAgentId;
			return this;
		}

		/**
		 * 交易服务商编号
		 * 
		 * @return ProviderAgentBuilder
		 */
		public ProviderAgentBuilder addProviderAgentCode(String providerAgentCode) {
			this.providerAgentCode = providerAgentCode;
			return this;
		}

		/**
		 * 交易服务商名称
		 * 
		 * @return ProviderAgentBuilder
		 */
		public ProviderAgentBuilder addProviderAgentName(String providerAgentName) {
			this.providerAgentName = providerAgentName;
			return this;
		}

		/**
		 * 状态0-未启用1-启用2-暂停
		 * 
		 * @return ProviderAgentBuilder
		 */
		public ProviderAgentBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return ProviderAgentBuilder
		 */
		public ProviderAgentBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 更新时间
		 * 
		 * @return ProviderAgentBuilder
		 */
		public ProviderAgentBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		public ProviderAgent build() {
			return new ProviderAgent(this);
		}
	}
}