package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

import cn.com.payment.admin.utils.CommonUtils;

/**
 * RalAccountTransMode
 *
 * Date:2019-2-14 22:10:01
 * 
 * @author dl
 */
public class RalAccountTransModeForMer implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 商户交易方式Id
	 */
	private Long ralAccProductId;
	/**
	 * 基准费率(单位:万分之)
	 */
	private Integer feeRate;
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
	 * 流量占比
	 */
	private Integer percentage;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 状态 0-停用 1-启用 2-暂停
	 */
	private String state;
	/**
	 * 是否删除
	 */
	private String isDel;
	/**
	 * IP白名单
	 */
	private String validIP;
	/**
	 * 限流状态0-停用；1-启用
	 */
	private String restrictState;
	/**
	 * 结算方式0-D0;1-D1;2-T0;3-T1
	 */
	private String settleType;
	/**
	 * 账户余额每个通道产品余额
	 */
	private Long balance;
	/**
	 * 未入账余额
	 */
	private Long balanceUnaccounted;
	/**
	 * 冻结余额
	 */
	private Long balanceFreeze;
	/**
	 * 可用余额
	 */
	private Long balanceValid;

	private String merName;

	private String productName;

	public RalAccountTransModeForMer() {
	}

	public RalAccountTransModeForMer(RalAccountTransMode ralAccountTransMode) {
		this.ralAccProductId = ralAccountTransMode.getRalAccProductId();
		this.feeRate = ralAccountTransMode.getFeeRate();
		this.totleAmtLimit = ralAccountTransMode.getTotleAmtLimit();
		this.minAmt = ralAccountTransMode.getMinAmt();
		this.maxAmt = ralAccountTransMode.getMaxAmt();
		this.percentage = ralAccountTransMode.getPercentage();
		this.createTime = ralAccountTransMode.getCreateTime();
		this.updateTime = ralAccountTransMode.getUpdateTime();
		this.state = ralAccountTransMode.getState();
		this.isDel = ralAccountTransMode.getIsDel();
		this.validIP = ralAccountTransMode.getValidIP();
		this.restrictState = ralAccountTransMode.getRestrictState();
		this.settleType = ralAccountTransMode.getSettleType();
		this.balance = ralAccountTransMode.getBalance();
		this.balanceUnaccounted = ralAccountTransMode.getBalanceUnaccounted();
		this.balanceFreeze = ralAccountTransMode.getBalanceFreeze();
		this.balanceValid = ralAccountTransMode.getBalanceValid();
		this.merName = CommonUtils.isEmpty(ralAccountTransMode.getMerchantInfo()) ? ""
				: ralAccountTransMode.getMerchantInfo().getMchName();
		this.productName = CommonUtils.isEmpty(ralAccountTransMode.getRalProviderTransMode()) ? ""
				: ralAccountTransMode.getRalProviderTransMode().getProductName();
	}

	public RalAccountTransModeForMer(Long ralAccProductId, Long mchId, Long providerAccId, Long productId,
			Integer feeRate, Long totleAmtLimit, Long minAmt, Long maxAmt, Integer percentage, Date createTime,
			Date updateTime, String state, String isDel, String validIP, String restrictState, String settleType,
			Long balance, Long balanceUnaccounted, Long balanceFreeze, Long balanceValid) {
		this.ralAccProductId = ralAccProductId;
		this.feeRate = feeRate;
		this.totleAmtLimit = totleAmtLimit;
		this.minAmt = minAmt;
		this.maxAmt = maxAmt;
		this.percentage = percentage;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.state = state;
		this.isDel = isDel;
		this.validIP = validIP;
		this.restrictState = restrictState;
		this.settleType = settleType;
		this.balance = balance;
		this.balanceUnaccounted = balanceUnaccounted;
		this.balanceFreeze = balanceFreeze;
		this.balanceValid = balanceValid;
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 商户交易方式Id
	 * 
	 * @return ralAccProductId
	 */
	public Long getRalAccProductId() {
		return ralAccProductId;
	}

	/**
	 * 商户交易方式Id
	 * 
	 * @param ralAccProductId
	 */
	public void setRalAccProductId(Long ralAccProductId) {
		this.ralAccProductId = ralAccProductId;
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
	 * 流量占比
	 * 
	 * @return percentage
	 */
	public Integer getPercentage() {
		return percentage;
	}

	/**
	 * 流量占比
	 * 
	 * @param percentage
	 */
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
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
	 * 是否删除
	 * 
	 * @return isDel
	 */
	public String getIsDel() {
		return isDel;
	}

	/**
	 * 是否删除
	 * 
	 * @param isDel
	 */
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	/**
	 * IP白名单
	 * 
	 * @return validIP
	 */
	public String getValidIP() {
		return validIP;
	}

	/**
	 * IP白名单
	 * 
	 * @param validIP
	 */
	public void setValidIP(String validIP) {
		this.validIP = validIP;
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

	/**
	 * 结算方式0-D0;1-D1;2-T0;3-T1
	 * 
	 * @return settleType
	 */
	public String getSettleType() {
		return settleType;
	}

	/**
	 * 结算方式0-D0;1-D1;2-T0;3-T1
	 * 
	 * @param settleType
	 */
	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	/**
	 * 账户余额每个通道产品余额
	 * 
	 * @return balance
	 */
	public Long getBalance() {
		return balance;
	}

	/**
	 * 账户余额每个通道产品余额
	 * 
	 * @param balance
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}

	/**
	 * 未入账余额
	 * 
	 * @return balanceUnaccounted
	 */
	public Long getBalanceUnaccounted() {
		return balanceUnaccounted;
	}

	/**
	 * 未入账余额
	 * 
	 * @param balanceUnaccounted
	 */
	public void setBalanceUnaccounted(Long balanceUnaccounted) {
		this.balanceUnaccounted = balanceUnaccounted;
	}

	/**
	 * 冻结余额
	 * 
	 * @return balanceFreeze
	 */
	public Long getBalanceFreeze() {
		return balanceFreeze;
	}

	/**
	 * 冻结余额
	 * 
	 * @param balanceFreeze
	 */
	public void setBalanceFreeze(Long balanceFreeze) {
		this.balanceFreeze = balanceFreeze;
	}

	/**
	 * 可用余额
	 * 
	 * @return balanceValid
	 */
	public Long getBalanceValid() {
		return balanceValid;
	}

	/**
	 * 可用余额
	 * 
	 * @param balanceValid
	 */
	public void setBalanceValid(Long balanceValid) {
		this.balanceValid = balanceValid;
	}

}