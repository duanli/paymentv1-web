package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * TransRecordScan
 *
 * Date:2019-1-30 14:24:59
 * 
 * @author dl
 */
public class TransRecordScan implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 内部交易Id
	 */
	private Long id;
	/**
	 * 交易品牌编号
	 */
	private Long transBrandId;
	/**
	 * 交易品牌名称
	 */
	private String transBrandName;
	/**
	 * 交易方式id
	 */
	private Long transModeId;
	/**
	 * 交易方式名称
	 */
	private String transModeName;
	/**
	 * 父商户编号
	 */
	private Long merParentId;
	/**
	 * 商户编号
	 */
	private Long merId;
	/**
	 * 服务商编号
	 */
	private Long providerId;
	/**
	 * 账户产品关联ID
	 */
	private Long providerAccId;
	/**
	 * 服务商账号
	 */
	private String providerMchNo;
	/**
	 * 服务商名称
	 */
	private String providerName;
	/**
	 * 交易产品编号
	 */
	private Long productId;
	/**
	 * 交易产品名称
	 */
	private String productName;

	private Long ralAccProductId;
	/**
	 * 交易流水号
	 */
	private String outTradeNo;
	/**
	 * 交易金额-单位分
	 */
	private Long amount;
	/**
	 * 实到金额
	 */
	private Long actulAmt;
	/**
	 * 状态0000-已受理(状态不明) 0001-成功 0002-失败 0003-等待 0004-关闭 -1-未知状态
	 */
	private String state;
	/**
	 * 支付状态描述
	 */
	private String stateMsg;
	/**
	 * 支付状态备注
	 */
	private String stateRemark;
	/**
	 * 订单类型: 0-预支付 1-支付 2-转账 3-退款
	 */
	private String type;
	/**
	 * 原交易流水号
	 */
	private String srcOutTradeNo;
	/**
	 * 三方交易流水号
	 */
	private String outTransactionId;
	/**
	 * 请求ip地址
	 */
	private String terminalIP;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品描述
	 */
	private String goodsDesc;
	/**
	 * 业务系统订单号
	 */
	private String bizOrderNo;
	/**
	 * 结果通知Url
	 */
	private String notifyUrl;
	/**
	 * 交易结果返回页面
	 */
	private String resultUrl;
	/**
	 * 支付通道用户标识
	 */
	private String payWayUserId;
	/**
	 * 服务商交易流水号
	 */
	private String spTransactionId;
	/**
	 * 服务商交易时间
	 */
	private Date spTransTime;
	/**
	 * 服务商交易请求日期
	 */
	private String spTransDate;
	/**
	 * 服务商返回码
	 */
	private String spRespCode;
	/**
	 * 服务商返回码描述
	 */
	private String spRespMsg;
	/**
	 * 成本手续费
	 */
	private Long providerFee;
	/**
	 * 成本手续费率
	 */
	private Integer providerFeeRate;
	/**
	 * 商户手续费
	 */
	private Long merFee;
	/**
	 * 商户手续费率
	 */
	private Integer merfeeRate;
	/**
	 * 通知状态0-未通知 1-已通知 9-通知势必
	 */
	private String noticeState;
	/**
	 * 分账状态0-未分1-已分2-异常
	 */
	private String settleState;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改日期
	 */
	private Date updateTime;

	private RalAccountTransMode ralAccountTransMode;

	public TransRecordScan() {
	}

	public TransRecordScan(Long id, Long transBrandId, String transBrandName, Long transModeId, String transModeName,
			Long merParentId, Long merId, Long providerId, Long providerAccId, String providerMchNo,
			String providerName, Long productId, String productName, Long ralAccProductId, String outTradeNo,
			Long amount, Long actulAmt, String state, String stateMsg, String stateRemark, String type,
			String srcOutTradeNo, String outTransactionId, String terminalIP, String goodsName, String goodsDesc,
			String bizOrderNo, String notifyUrl, String resultUrl, String payWayUserId, String spTransactionId,
			Date spTransTime, String spTransDate, String spRespCode, String spRespMsg, Long providerFee,
			Integer providerFeeRate, Long merFee, Integer merfeeRate, String noticeState, String settleState,
			Date createTime, Date updateTime) {
		this.id = id;
		this.transBrandId = transBrandId;
		this.transBrandName = transBrandName;
		this.transModeId = transModeId;
		this.transModeName = transModeName;
		this.merParentId = merParentId;
		this.merId = merId;
		this.providerId = providerId;
		this.providerAccId = providerAccId;
		this.providerMchNo = providerMchNo;
		this.providerName = providerName;
		this.productId = productId;
		this.productName = productName;
		this.ralAccProductId = ralAccProductId;
		this.outTradeNo = outTradeNo;
		this.amount = amount;
		this.actulAmt = actulAmt;
		this.state = state;
		this.stateMsg = stateMsg;
		this.stateRemark = stateRemark;
		this.type = type;
		this.srcOutTradeNo = srcOutTradeNo;
		this.outTransactionId = outTransactionId;
		this.terminalIP = terminalIP;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.bizOrderNo = bizOrderNo;
		this.notifyUrl = notifyUrl;
		this.resultUrl = resultUrl;
		this.payWayUserId = payWayUserId;
		this.spTransactionId = spTransactionId;
		this.spTransTime = spTransTime;
		this.spTransDate = spTransDate;
		this.spRespCode = spRespCode;
		this.spRespMsg = spRespMsg;
		this.providerFee = providerFee;
		this.providerFeeRate = providerFeeRate;
		this.merFee = merFee;
		this.merfeeRate = merfeeRate;
		this.noticeState = noticeState;
		this.settleState = settleState;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	private TransRecordScan(TransRecordScanBuilder builder) {
		this.id = builder.id;
		this.transBrandId = builder.transBrandId;
		this.transBrandName = builder.transBrandName;
		this.transModeId = builder.transModeId;
		this.transModeName = builder.transModeName;
		this.merParentId = builder.merParentId;
		this.merId = builder.merId;
		this.providerId = builder.providerId;
		this.providerAccId = builder.providerAccId;
		this.providerMchNo = builder.providerMchNo;
		this.providerName = builder.providerName;
		this.productId = builder.productId;
		this.productName = builder.productName;
		this.ralAccProductId = builder.ralAccProductId;
		this.outTradeNo = builder.outTradeNo;
		this.amount = builder.amount;
		this.actulAmt = builder.actulAmt;
		this.state = builder.state;
		this.stateMsg = builder.stateMsg;
		this.stateRemark = builder.stateRemark;
		this.type = builder.type;
		this.srcOutTradeNo = builder.srcOutTradeNo;
		this.outTransactionId = builder.outTransactionId;
		this.terminalIP = builder.terminalIP;
		this.goodsName = builder.goodsName;
		this.goodsDesc = builder.goodsDesc;
		this.bizOrderNo = builder.bizOrderNo;
		this.notifyUrl = builder.notifyUrl;
		this.resultUrl = builder.resultUrl;
		this.payWayUserId = builder.payWayUserId;
		this.spTransactionId = builder.spTransactionId;
		this.spTransTime = builder.spTransTime;
		this.spTransDate = builder.spTransDate;
		this.spRespCode = builder.spRespCode;
		this.spRespMsg = builder.spRespMsg;
		this.providerFee = builder.providerFee;
		this.providerFeeRate = builder.providerFeeRate;
		this.merFee = builder.merFee;
		this.merfeeRate = builder.merfeeRate;
		this.noticeState = builder.noticeState;
		this.settleState = builder.settleState;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
	}

	public RalAccountTransMode getRalAccountTransMode() {
		return ralAccountTransMode;
	}

	public void setRalAccountTransMode(RalAccountTransMode ralAccountTransMode) {
		this.ralAccountTransMode = ralAccountTransMode;
	}

	public Long getRalAccProductId() {
		return ralAccProductId;
	}

	public void setRalAccProductId(Long ralAccProductId) {
		this.ralAccProductId = ralAccProductId;
	}

	/**
	 * 内部交易Id
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 内部交易Id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 交易品牌编号
	 * 
	 * @return transBrandId
	 */
	public Long getTransBrandId() {
		return transBrandId;
	}

	/**
	 * 交易品牌编号
	 * 
	 * @param transBrandId
	 */
	public void setTransBrandId(Long transBrandId) {
		this.transBrandId = transBrandId;
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
	 * 交易方式id
	 * 
	 * @return transModeId
	 */
	public Long getTransModeId() {
		return transModeId;
	}

	/**
	 * 交易方式id
	 * 
	 * @param transModeId
	 */
	public void setTransModeId(Long transModeId) {
		this.transModeId = transModeId;
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
	 * 父商户编号
	 * 
	 * @return merParentId
	 */
	public Long getMerParentId() {
		return merParentId;
	}

	/**
	 * 父商户编号
	 * 
	 * @param merParentId
	 */
	public void setMerParentId(Long merParentId) {
		this.merParentId = merParentId;
	}

	/**
	 * 商户编号
	 * 
	 * @return merId
	 */
	public Long getMerId() {
		return merId;
	}

	/**
	 * 商户编号
	 * 
	 * @param merId
	 */
	public void setMerId(Long merId) {
		this.merId = merId;
	}

	/**
	 * 服务商编号
	 * 
	 * @return providerId
	 */
	public Long getProviderId() {
		return providerId;
	}

	/**
	 * 服务商编号
	 * 
	 * @param providerId
	 */
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	/**
	 * 账户产品关联ID
	 * 
	 * @return providerAccId
	 */
	public Long getProviderAccId() {
		return providerAccId;
	}

	/**
	 * 账户产品关联ID
	 * 
	 * @param providerAccId
	 */
	public void setProviderAccId(Long providerAccId) {
		this.providerAccId = providerAccId;
	}

	/**
	 * 服务商账号
	 * 
	 * @return providerMchNo
	 */
	public String getProviderMchNo() {
		return providerMchNo;
	}

	/**
	 * 服务商账号
	 * 
	 * @param providerMchNo
	 */
	public void setProviderMchNo(String providerMchNo) {
		this.providerMchNo = providerMchNo;
	}

	/**
	 * 服务商名称
	 * 
	 * @return providerName
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * 服务商名称
	 * 
	 * @param providerName
	 */
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	/**
	 * 交易产品编号
	 * 
	 * @return productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * 交易产品编号
	 * 
	 * @param productId
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * 交易产品名称
	 * 
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * 交易产品名称
	 * 
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 交易流水号
	 * 
	 * @return outTradeNo
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 * 交易流水号
	 * 
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	/**
	 * 交易金额-单位分
	 * 
	 * @return amount
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * 交易金额-单位分
	 * 
	 * @param amount
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	/**
	 * 实到金额
	 * 
	 * @return actulAmt
	 */
	public Long getActulAmt() {
		return actulAmt;
	}

	/**
	 * 实到金额
	 * 
	 * @param actulAmt
	 */
	public void setActulAmt(Long actulAmt) {
		this.actulAmt = actulAmt;
	}

	/**
	 * 状态0000-已受理(状态不明) 0001-成功 0002-失败 0003-等待 0004-关闭 -1-未知状态
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 状态0000-已受理(状态不明) 0001-成功 0002-失败 0003-等待 0004-关闭 -1-未知状态
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 支付状态描述
	 * 
	 * @return stateMsg
	 */
	public String getStateMsg() {
		return stateMsg;
	}

	/**
	 * 支付状态描述
	 * 
	 * @param stateMsg
	 */
	public void setStateMsg(String stateMsg) {
		this.stateMsg = stateMsg;
	}

	/**
	 * 支付状态备注
	 * 
	 * @return stateRemark
	 */
	public String getStateRemark() {
		return stateRemark;
	}

	/**
	 * 支付状态备注
	 * 
	 * @param stateRemark
	 */
	public void setStateRemark(String stateRemark) {
		this.stateRemark = stateRemark;
	}

	/**
	 * 订单类型: 0-预支付 1-支付 2-转账 3-退款
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 订单类型: 0-预支付 1-支付 2-转账 3-退款
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 原交易流水号
	 * 
	 * @return srcOutTradeNo
	 */
	public String getSrcOutTradeNo() {
		return srcOutTradeNo;
	}

	/**
	 * 原交易流水号
	 * 
	 * @param srcOutTradeNo
	 */
	public void setSrcOutTradeNo(String srcOutTradeNo) {
		this.srcOutTradeNo = srcOutTradeNo;
	}

	/**
	 * 三方交易流水号
	 * 
	 * @return outTransactionId
	 */
	public String getOutTransactionId() {
		return outTransactionId;
	}

	/**
	 * 三方交易流水号
	 * 
	 * @param outTransactionId
	 */
	public void setOutTransactionId(String outTransactionId) {
		this.outTransactionId = outTransactionId;
	}

	/**
	 * 请求ip地址
	 * 
	 * @return terminalIP
	 */
	public String getTerminalIP() {
		return terminalIP;
	}

	/**
	 * 请求ip地址
	 * 
	 * @param terminalIP
	 */
	public void setTerminalIP(String terminalIP) {
		this.terminalIP = terminalIP;
	}

	/**
	 * 商品名称
	 * 
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * 商品名称
	 * 
	 * @param goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * 商品描述
	 * 
	 * @return goodsDesc
	 */
	public String getGoodsDesc() {
		return goodsDesc;
	}

	/**
	 * 商品描述
	 * 
	 * @param goodsDesc
	 */
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	/**
	 * 业务系统订单号
	 * 
	 * @return bizOrderNo
	 */
	public String getBizOrderNo() {
		return bizOrderNo;
	}

	/**
	 * 业务系统订单号
	 * 
	 * @param bizOrderNo
	 */
	public void setBizOrderNo(String bizOrderNo) {
		this.bizOrderNo = bizOrderNo;
	}

	/**
	 * 结果通知Url
	 * 
	 * @return notifyUrl
	 */
	public String getNotifyUrl() {
		return notifyUrl;
	}

	/**
	 * 结果通知Url
	 * 
	 * @param notifyUrl
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	/**
	 * 交易结果返回页面
	 * 
	 * @return resultUrl
	 */
	public String getResultUrl() {
		return resultUrl;
	}

	/**
	 * 交易结果返回页面
	 * 
	 * @param resultUrl
	 */
	public void setResultUrl(String resultUrl) {
		this.resultUrl = resultUrl;
	}

	/**
	 * 支付通道用户标识
	 * 
	 * @return payWayUserId
	 */
	public String getPayWayUserId() {
		return payWayUserId;
	}

	/**
	 * 支付通道用户标识
	 * 
	 * @param payWayUserId
	 */
	public void setPayWayUserId(String payWayUserId) {
		this.payWayUserId = payWayUserId;
	}

	/**
	 * 服务商交易流水号
	 * 
	 * @return spTransactionId
	 */
	public String getSpTransactionId() {
		return spTransactionId;
	}

	/**
	 * 服务商交易流水号
	 * 
	 * @param spTransactionId
	 */
	public void setSpTransactionId(String spTransactionId) {
		this.spTransactionId = spTransactionId;
	}

	/**
	 * 服务商交易时间
	 * 
	 * @return spTransTime
	 */
	public Date getSpTransTime() {
		return spTransTime;
	}

	/**
	 * 服务商交易时间
	 * 
	 * @param spTransTime
	 */
	public void setSpTransTime(Date spTransTime) {
		this.spTransTime = spTransTime;
	}

	/**
	 * 服务商交易请求日期
	 * 
	 * @return spTransDate
	 */
	public String getSpTransDate() {
		return spTransDate;
	}

	/**
	 * 服务商交易请求日期
	 * 
	 * @param spTransDate
	 */
	public void setSpTransDate(String spTransDate) {
		this.spTransDate = spTransDate;
	}

	/**
	 * 服务商返回码
	 * 
	 * @return spRespCode
	 */
	public String getSpRespCode() {
		return spRespCode;
	}

	/**
	 * 服务商返回码
	 * 
	 * @param spRespCode
	 */
	public void setSpRespCode(String spRespCode) {
		this.spRespCode = spRespCode;
	}

	/**
	 * 服务商返回码描述
	 * 
	 * @return spRespMsg
	 */
	public String getSpRespMsg() {
		return spRespMsg;
	}

	/**
	 * 服务商返回码描述
	 * 
	 * @param spRespMsg
	 */
	public void setSpRespMsg(String spRespMsg) {
		this.spRespMsg = spRespMsg;
	}

	/**
	 * 成本手续费
	 * 
	 * @return providerFee
	 */
	public Long getProviderFee() {
		return providerFee;
	}

	/**
	 * 成本手续费
	 * 
	 * @param providerFee
	 */
	public void setProviderFee(Long providerFee) {
		this.providerFee = providerFee;
	}

	/**
	 * 成本手续费率
	 * 
	 * @return providerFeeRate
	 */
	public Integer getProviderFeeRate() {
		return providerFeeRate;
	}

	/**
	 * 成本手续费率
	 * 
	 * @param providerFeeRate
	 */
	public void setProviderFeeRate(Integer providerFeeRate) {
		this.providerFeeRate = providerFeeRate;
	}

	/**
	 * 商户手续费
	 * 
	 * @return merFee
	 */
	public Long getMerFee() {
		return merFee;
	}

	/**
	 * 商户手续费
	 * 
	 * @param merFee
	 */
	public void setMerFee(Long merFee) {
		this.merFee = merFee;
	}

	/**
	 * 商户手续费率
	 * 
	 * @return merfeeRate
	 */
	public Integer getMerfeeRate() {
		return merfeeRate;
	}

	/**
	 * 商户手续费率
	 * 
	 * @param merfeeRate
	 */
	public void setMerfeeRate(Integer merfeeRate) {
		this.merfeeRate = merfeeRate;
	}

	/**
	 * 通知状态0-未通知 1-已通知 9-通知势必
	 * 
	 * @return noticeState
	 */
	public String getNoticeState() {
		return noticeState;
	}

	/**
	 * 通知状态0-未通知 1-已通知 9-通知势必
	 * 
	 * @param noticeState
	 */
	public void setNoticeState(String noticeState) {
		this.noticeState = noticeState;
	}

	/**
	 * 分账状态0-未分1-已分2-异常
	 * 
	 * @return settleState
	 */
	public String getSettleState() {
		return settleState;
	}

	/**
	 * 分账状态0-未分1-已分2-异常
	 * 
	 * @param settleState
	 */
	public void setSettleState(String settleState) {
		this.settleState = settleState;
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

	public static class TransRecordScanBuilder {
		private Long id; // 内部交易Id
		private Long transBrandId; // 交易品牌编号
		private String transBrandName; // 交易品牌名称
		private Long transModeId; // 交易方式id
		private String transModeName; // 交易方式名称
		private Long merParentId; // 父商户编号
		private Long merId; // 商户编号
		private Long providerId; // 服务商编号
		private Long providerAccId; // 账户产品关联ID
		private String providerMchNo; // 服务商账号
		private String providerName; // 服务商名称
		private Long productId; // 交易产品编号
		private String productName; // 交易产品名称
		private Long ralAccProductId;
		private String outTradeNo; // 交易流水号
		private Long amount; // 交易金额-单位分
		private Long actulAmt; // 实到金额
		private String state; // 状态0000-已受理(状态不明) 0001-成功 0002-失败 0003-等待 0004-关闭 -1-未知状态
		private String stateMsg; // 支付状态描述
		private String stateRemark; // 支付状态备注
		private String type; // 订单类型: 0-预支付 1-支付 2-转账 3-退款
		private String srcOutTradeNo; // 原交易流水号
		private String outTransactionId; // 三方交易流水号
		private String terminalIP; // 请求ip地址
		private String goodsName; // 商品名称
		private String goodsDesc; // 商品描述
		private String bizOrderNo; // 业务系统订单号
		private String notifyUrl; // 结果通知Url
		private String resultUrl; // 交易结果返回页面
		private String payWayUserId; // 支付通道用户标识
		private String spTransactionId; // 服务商交易流水号
		private Date spTransTime; // 服务商交易时间
		private String spTransDate; // 服务商交易请求日期
		private String spRespCode; // 服务商返回码
		private String spRespMsg; // 服务商返回码描述
		private Long providerFee; // 成本手续费
		private Integer providerFeeRate; // 成本手续费率
		private Long merFee; // 商户手续费
		private Integer merfeeRate; // 商户手续费率
		private String noticeState; // 通知状态0-未通知 1-已通知 9-通知势必
		private String settleState; // 分账状态0-未分1-已分2-异常
		private Date createTime; // 创建时间
		private Date updateTime; // 修改日期

		/**
		 * 内部交易Id
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addId(Long id) {
			this.id = id;
			return this;
		}

		/**
		 * 交易品牌编号
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addTransBrandId(Long transBrandId) {
			this.transBrandId = transBrandId;
			return this;
		}

		/**
		 * 交易品牌名称
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addTransBrandName(String transBrandName) {
			this.transBrandName = transBrandName;
			return this;
		}

		/**
		 * 交易方式id
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addTransModeId(Long transModeId) {
			this.transModeId = transModeId;
			return this;
		}

		/**
		 * 交易方式名称
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addTransModeName(String transModeName) {
			this.transModeName = transModeName;
			return this;
		}

		/**
		 * 父商户编号
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addMerParentId(Long merParentId) {
			this.merParentId = merParentId;
			return this;
		}

		/**
		 * 商户编号
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addMerId(Long merId) {
			this.merId = merId;
			return this;
		}

		/**
		 * 服务商编号
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addProviderId(Long providerId) {
			this.providerId = providerId;
			return this;
		}

		/**
		 * 账户产品关联ID
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addProviderAccId(Long providerAccId) {
			this.providerAccId = providerAccId;
			return this;
		}

		/**
		 * 服务商账号
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addProviderMchNo(String providerMchNo) {
			this.providerMchNo = providerMchNo;
			return this;
		}

		/**
		 * 服务商名称
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addProviderName(String providerName) {
			this.providerName = providerName;
			return this;
		}

		/**
		 * 交易产品编号
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addProductId(Long productId) {
			this.productId = productId;
			return this;
		}

		/**
		 * 交易产品名称
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addProductName(String productName) {
			this.productName = productName;
			return this;
		}

		public TransRecordScanBuilder addRalAccProductId(Long ralAccProductId) {
			this.ralAccProductId = ralAccProductId;
			return this;
		}

		/**
		 * 交易流水号
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addOutTradeNo(String outTradeNo) {
			this.outTradeNo = outTradeNo;
			return this;
		}

		/**
		 * 交易金额-单位分
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addAmount(Long amount) {
			this.amount = amount;
			return this;
		}

		/**
		 * 实到金额
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addActulAmt(Long actulAmt) {
			this.actulAmt = actulAmt;
			return this;
		}

		/**
		 * 状态0000-已受理(状态不明) 0001-成功 0002-失败 0003-等待 0004-关闭 -1-未知状态
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 支付状态描述
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addStateMsg(String stateMsg) {
			this.stateMsg = stateMsg;
			return this;
		}

		/**
		 * 支付状态备注
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addStateRemark(String stateRemark) {
			this.stateRemark = stateRemark;
			return this;
		}

		/**
		 * 订单类型: 0-预支付 1-支付 2-转账 3-退款
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addType(String type) {
			this.type = type;
			return this;
		}

		/**
		 * 原交易流水号
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addSrcOutTradeNo(String srcOutTradeNo) {
			this.srcOutTradeNo = srcOutTradeNo;
			return this;
		}

		/**
		 * 三方交易流水号
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addOutTransactionId(String outTransactionId) {
			this.outTransactionId = outTransactionId;
			return this;
		}

		/**
		 * 请求ip地址
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addTerminalIP(String terminalIP) {
			this.terminalIP = terminalIP;
			return this;
		}

		/**
		 * 商品名称
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addGoodsName(String goodsName) {
			this.goodsName = goodsName;
			return this;
		}

		/**
		 * 商品描述
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addGoodsDesc(String goodsDesc) {
			this.goodsDesc = goodsDesc;
			return this;
		}

		/**
		 * 业务系统订单号
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addBizOrderNo(String bizOrderNo) {
			this.bizOrderNo = bizOrderNo;
			return this;
		}

		/**
		 * 结果通知Url
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addNotifyUrl(String notifyUrl) {
			this.notifyUrl = notifyUrl;
			return this;
		}

		/**
		 * 交易结果返回页面
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addResultUrl(String resultUrl) {
			this.resultUrl = resultUrl;
			return this;
		}

		/**
		 * 支付通道用户标识
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addPayWayUserId(String payWayUserId) {
			this.payWayUserId = payWayUserId;
			return this;
		}

		/**
		 * 服务商交易流水号
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addSpTransactionId(String spTransactionId) {
			this.spTransactionId = spTransactionId;
			return this;
		}

		/**
		 * 服务商交易时间
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addSpTransTime(Date spTransTime) {
			this.spTransTime = spTransTime;
			return this;
		}

		/**
		 * 服务商交易请求日期
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addSpTransDate(String spTransDate) {
			this.spTransDate = spTransDate;
			return this;
		}

		/**
		 * 服务商返回码
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addSpRespCode(String spRespCode) {
			this.spRespCode = spRespCode;
			return this;
		}

		/**
		 * 服务商返回码描述
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addSpRespMsg(String spRespMsg) {
			this.spRespMsg = spRespMsg;
			return this;
		}

		/**
		 * 成本手续费
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addProviderFee(Long providerFee) {
			this.providerFee = providerFee;
			return this;
		}

		/**
		 * 成本手续费率
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addProviderFeeRate(Integer providerFeeRate) {
			this.providerFeeRate = providerFeeRate;
			return this;
		}

		/**
		 * 商户手续费
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addMerFee(Long merFee) {
			this.merFee = merFee;
			return this;
		}

		/**
		 * 商户手续费率
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addMerfeeRate(Integer merfeeRate) {
			this.merfeeRate = merfeeRate;
			return this;
		}

		/**
		 * 通知状态0-未通知 1-已通知 9-通知势必
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addNoticeState(String noticeState) {
			this.noticeState = noticeState;
			return this;
		}

		/**
		 * 分账状态0-未分1-已分2-异常
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addSettleState(String settleState) {
			this.settleState = settleState;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 修改日期
		 * 
		 * @return TransRecordScanBuilder
		 */
		public TransRecordScanBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		public TransRecordScan build() {
			return new TransRecordScan(this);
		}
	}
}