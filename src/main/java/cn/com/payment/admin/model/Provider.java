package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Provider
 *
 * Date:2019-1-30 14:14:58
 * 
 * @author dl
 */
public class Provider implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private Long providerId;
	/**
	 * 主键ID
	 */
	private Long providerAgentId;
	/**
	 * 交易服务商编号
	 */
	private String providerNo;
	/**
	 * 交易服务商简称
	 */
	private String providerAlias;
	/**
	 * 交易服务商名称
	 */
	private String providerName;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 服务地址
	 */
	private String serverUrl;
	/**
	 * 服务编号
	 */
	private String serverNo;

	private List<ProviderAccount> providerAccounts;

	private List<RalProviderTransMode> ralProviderTransModes;

	public Provider() {
	}

	public Provider(Long providerId, Long providerAgentId, String providerNo, String providerAlias, String providerName,
			String createTime, Date updateTime, String serverUrl, String serverNo) {
		this.providerId = providerId;
		this.providerAgentId = providerAgentId;
		this.providerNo = providerNo;
		this.providerAlias = providerAlias;
		this.providerName = providerName;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.serverUrl = serverUrl;
		this.serverNo = serverNo;
	}

	private Provider(ProviderBuilder builder) {
		this.providerId = builder.providerId;
		this.providerAgentId = builder.providerAgentId;
		this.providerNo = builder.providerNo;
		this.providerAlias = builder.providerAlias;
		this.providerName = builder.providerName;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
		this.serverUrl = builder.serverUrl;
		this.serverNo = builder.serverNo;
	}

	public List<RalProviderTransMode> getRalProviderTransModes() {
		return ralProviderTransModes;
	}

	public void setRalProviderTransModes(List<RalProviderTransMode> ralProviderTransModes) {
		this.ralProviderTransModes = ralProviderTransModes;
	}

	public List<ProviderAccount> getProviderAccounts() {
		return providerAccounts;
	}

	public void setProviderAccounts(List<ProviderAccount> providerAccounts) {
		this.providerAccounts = providerAccounts;
	}

	/**
	 * 主键ID
	 * 
	 * @return providerId
	 */
	public Long getProviderId() {
		return providerId;
	}

	/**
	 * 主键ID
	 * 
	 * @param providerId
	 */
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
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
	 * @return providerNo
	 */
	public String getProviderNo() {
		return providerNo;
	}

	/**
	 * 交易服务商编号
	 * 
	 * @param providerNo
	 */
	public void setProviderNo(String providerNo) {
		this.providerNo = providerNo;
	}

	/**
	 * 交易服务商简称
	 * 
	 * @return providerAlias
	 */
	public String getProviderAlias() {
		return providerAlias;
	}

	/**
	 * 交易服务商简称
	 * 
	 * @param providerAlias
	 */
	public void setProviderAlias(String providerAlias) {
		this.providerAlias = providerAlias;
	}

	/**
	 * 交易服务商名称
	 * 
	 * @return providerName
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * 交易服务商名称
	 * 
	 * @param providerName
	 */
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	/**
	 * 创建时间
	 * 
	 * @return createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * 修改时间
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 修改时间
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 服务地址
	 * 
	 * @return serverUrl
	 */
	public String getServerUrl() {
		return serverUrl;
	}

	/**
	 * 服务地址
	 * 
	 * @param serverUrl
	 */
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	/**
	 * 服务编号
	 * 
	 * @return serverNo
	 */
	public String getServerNo() {
		return serverNo;
	}

	/**
	 * 服务编号
	 * 
	 * @param serverNo
	 */
	public void setServerNo(String serverNo) {
		this.serverNo = serverNo;
	}

	public static class ProviderBuilder {
		private Long providerId; // 主键ID
		private Long providerAgentId; // 主键ID
		private String providerNo; // 交易服务商编号
		private String providerAlias; // 交易服务商简称
		private String providerName; // 交易服务商名称
		private String createTime; // 创建时间
		private Date updateTime; // 修改时间
		private String serverUrl; // 服务地址
		private String serverNo; // 服务编号

		/**
		 * 主键ID
		 * 
		 * @return ProviderBuilder
		 */
		public ProviderBuilder addProviderId(Long providerId) {
			this.providerId = providerId;
			return this;
		}

		/**
		 * 主键ID
		 * 
		 * @return ProviderBuilder
		 */
		public ProviderBuilder addProviderAgentId(Long providerAgentId) {
			this.providerAgentId = providerAgentId;
			return this;
		}

		/**
		 * 交易服务商编号
		 * 
		 * @return ProviderBuilder
		 */
		public ProviderBuilder addProviderNo(String providerNo) {
			this.providerNo = providerNo;
			return this;
		}

		/**
		 * 交易服务商简称
		 * 
		 * @return ProviderBuilder
		 */
		public ProviderBuilder addProviderAlias(String providerAlias) {
			this.providerAlias = providerAlias;
			return this;
		}

		/**
		 * 交易服务商名称
		 * 
		 * @return ProviderBuilder
		 */
		public ProviderBuilder addProviderName(String providerName) {
			this.providerName = providerName;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return ProviderBuilder
		 */
		public ProviderBuilder addCreateTime(String createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 修改时间
		 * 
		 * @return ProviderBuilder
		 */
		public ProviderBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		/**
		 * 服务地址
		 * 
		 * @return ProviderBuilder
		 */
		public ProviderBuilder addServerUrl(String serverUrl) {
			this.serverUrl = serverUrl;
			return this;
		}

		/**
		 * 服务编号
		 * 
		 * @return ProviderBuilder
		 */
		public ProviderBuilder addServerNo(String serverNo) {
			this.serverNo = serverNo;
			return this;
		}

		public Provider build() {
			return new Provider(this);
		}
	}
}