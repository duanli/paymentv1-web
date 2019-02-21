package cn.com.payment.admin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * TransRecordDpay
 *
 * Date:2019-1-30 14:24:59
 * 
 * @author dl
 */
public class TransRecordDpay implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 内部交易Id
	 */
	private Long transId;
	/**
	 * 交易品牌编号
	 */
	private Long transBrandId;
	/**
	 * 交易品牌名称
	 */
	private String transBrandName;
	/**
	 * 交易方式code
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
	 * 服务商名称
	 */
	private String providerName;
	/**
	 * 账户产品关联ID
	 */
	private Long providerAccId;
	/**
	 * 服务商账号
	 */
	private String providerMchNo;
	/**
	 * 交易产品编号
	 */
	private Long productId;
	/**
	 * 交易产品名称
	 */
	private String productName;
	/**
	 * 银行编码
	 */
	private String bankCode;
	/**
	 * 银行账户所属银行名
	 */
	private String bankName;
	/**
	 * 银行账户类型 0-公 1-私
	 */
	private String accountType;
	/**
	 * 卡类型：借记卡、贷记卡
	 */
	private String bankCardType;
	/**
	 * 银行卡ID
	 */
	private Long bankId;
	/**
	 * 银行卡号
	 */
	private String bankCardNo;
	/**
	 * 开户名
	 */
	private String realName;
	/**
	 * 交易金额-单位分
	 */
	private Long amount;
	/**
	 * 交易流水号
	 */
	private String outTradeNo;
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
	 * 订单类型: 0-代付1-代收2-代扣
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
	 * 手续费
	 */
	private Integer fee;
	/**
	 * 清算状态0-未通知1-已通知 9-通知失败
	 */
	private String noticetate;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改日期
	 */
	private Date updateTime;

	public TransRecordDpay() {
	}

	public TransRecordDpay(Long transId, Long transBrandId, String transBrandName, Long transModeId,
			String transModeName, Long merParentId, Long merId, Long providerId, String providerName,
			Long providerAccId, String providerMchNo, Long productId, String productName, String bankCode,
			String bankName, String accountType, String bankCardType, Long bankId, String bankCardNo, String realName,
			Long amount, String outTradeNo, String state, String stateMsg, String stateRemark, String type,
			String srcOutTradeNo, String outTransactionId, String terminalIP, String goodsName, String goodsDesc,
			String bizOrderNo, String notifyUrl, String resultUrl, String payWayUserId, String spTransactionId,
			Date spTransTime, String spTransDate, String spRespCode, String spRespMsg, Integer fee, String noticetate,
			Date createTime, Date updateTime) {
		this.transId = transId;
		this.transBrandId = transBrandId;
		this.transBrandName = transBrandName;
		this.transModeId = transModeId;
		this.transModeName = transModeName;
		this.merParentId = merParentId;
		this.merId = merId;
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerAccId = providerAccId;
		this.providerMchNo = providerMchNo;
		this.productId = productId;
		this.productName = productName;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.accountType = accountType;
		this.bankCardType = bankCardType;
		this.bankId = bankId;
		this.bankCardNo = bankCardNo;
		this.realName = realName;
		this.amount = amount;
		this.outTradeNo = outTradeNo;
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
		this.fee = fee;
		this.noticetate = noticetate;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	private TransRecordDpay(TransRecordDpayBuilder builder) {
		this.transId = builder.transId;
		this.transBrandId = builder.transBrandId;
		this.transBrandName = builder.transBrandName;
		this.transModeId = builder.transModeId;
		this.transModeName = builder.transModeName;
		this.merParentId = builder.merParentId;
		this.merId = builder.merId;
		this.providerId = builder.providerId;
		this.providerName = builder.providerName;
		this.providerAccId = builder.providerAccId;
		this.providerMchNo = builder.providerMchNo;
		this.productId = builder.productId;
		this.productName = builder.productName;
		this.bankCode = builder.bankCode;
		this.bankName = builder.bankName;
		this.accountType = builder.accountType;
		this.bankCardType = builder.bankCardType;
		this.bankId = builder.bankId;
		this.bankCardNo = builder.bankCardNo;
		this.realName = builder.realName;
		this.amount = builder.amount;
		this.outTradeNo = builder.outTradeNo;
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
		this.fee = builder.fee;
		this.noticetate = builder.noticetate;
		this.createTime = builder.createTime;
		this.updateTime = builder.updateTime;
	}

	/**
	 * 内部交易Id
	 * 
	 * @return transId
	 */
	public Long getTransId() {
		return transId;
	}

	/**
	 * 内部交易Id
	 * 
	 * @param transId
	 */
	public void setTransId(Long transId) {
		this.transId = transId;
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
	 * 交易方式code
	 * 
	 * @return transModeId
	 */
	public Long getTransModeId() {
		return transModeId;
	}

	/**
	 * 交易方式code
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
	 * 银行编码
	 * 
	 * @return bankCode
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * 银行编码
	 * 
	 * @param bankCode
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * 银行账户所属银行名
	 * 
	 * @return bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * 银行账户所属银行名
	 * 
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * 银行账户类型 0-公 1-私
	 * 
	 * @return accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * 银行账户类型 0-公 1-私
	 * 
	 * @param accountType
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * 卡类型：借记卡、贷记卡
	 * 
	 * @return bankCardType
	 */
	public String getBankCardType() {
		return bankCardType;
	}

	/**
	 * 卡类型：借记卡、贷记卡
	 * 
	 * @param bankCardType
	 */
	public void setBankCardType(String bankCardType) {
		this.bankCardType = bankCardType;
	}

	/**
	 * 银行卡ID
	 * 
	 * @return bankId
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * 银行卡ID
	 * 
	 * @param bankId
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * 银行卡号
	 * 
	 * @return bankCardNo
	 */
	public String getBankCardNo() {
		return bankCardNo;
	}

	/**
	 * 银行卡号
	 * 
	 * @param bankCardNo
	 */
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	/**
	 * 开户名
	 * 
	 * @return realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * 开户名
	 * 
	 * @param realName
	 */
	public void setRealName(String realName) {
		this.realName = realName;
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
	 * 订单类型: 0-代付1-代收2-代扣
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 订单类型: 0-代付1-代收2-代扣
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
	 * 手续费
	 * 
	 * @return fee
	 */
	public Integer getFee() {
		return fee;
	}

	/**
	 * 手续费
	 * 
	 * @param fee
	 */
	public void setFee(Integer fee) {
		this.fee = fee;
	}

	/**
	 * 清算状态0-未通知1-已通知 9-通知失败
	 * 
	 * @return noticetate
	 */
	public String getNoticetate() {
		return noticetate;
	}

	/**
	 * 清算状态0-未通知1-已通知 9-通知失败
	 * 
	 * @param noticetate
	 */
	public void setNoticetate(String noticetate) {
		this.noticetate = noticetate;
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

	public static class TransRecordDpayBuilder {
		private Long transId; // 内部交易Id
		private Long transBrandId; // 交易品牌编号
		private String transBrandName; // 交易品牌名称
		private Long transModeId; // 交易方式code
		private String transModeName; // 交易方式名称
		private Long merParentId; // 父商户编号
		private Long merId; // 商户编号
		private Long providerId; // 服务商编号
		private String providerName; // 服务商名称
		private Long providerAccId; // 账户产品关联ID
		private String providerMchNo; // 服务商账号
		private Long productId; // 交易产品编号
		private String productName; // 交易产品名称
		private String bankCode; // 银行编码
		private String bankName; // 银行账户所属银行名
		private String accountType; // 银行账户类型 0-公 1-私
		private String bankCardType; // 卡类型：借记卡、贷记卡
		private Long bankId; // 银行卡ID
		private String bankCardNo; // 银行卡号
		private String realName; // 开户名
		private Long amount; // 交易金额-单位分
		private String outTradeNo; // 交易流水号
		private String state; // 状态0000-已受理(状态不明) 0001-成功 0002-失败 0003-等待 0004-关闭 -1-未知状态
		private String stateMsg; // 支付状态描述
		private String stateRemark; // 支付状态备注
		private String type; // 订单类型: 0-代付1-代收2-代扣
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
		private Integer fee; // 手续费
		private String noticetate; // 清算状态0-未通知1-已通知 9-通知失败
		private Date createTime; // 创建时间
		private Date updateTime; // 修改日期

		/**
		 * 内部交易Id
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addTransId(Long transId) {
			this.transId = transId;
			return this;
		}

		/**
		 * 交易品牌编号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addTransBrandId(Long transBrandId) {
			this.transBrandId = transBrandId;
			return this;
		}

		/**
		 * 交易品牌名称
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addTransBrandName(String transBrandName) {
			this.transBrandName = transBrandName;
			return this;
		}

		/**
		 * 交易方式code
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addTransModeId(Long transModeId) {
			this.transModeId = transModeId;
			return this;
		}

		/**
		 * 交易方式名称
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addTransModeName(String transModeName) {
			this.transModeName = transModeName;
			return this;
		}

		/**
		 * 父商户编号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addMerParentId(Long merParentId) {
			this.merParentId = merParentId;
			return this;
		}

		/**
		 * 商户编号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addMerId(Long merId) {
			this.merId = merId;
			return this;
		}

		/**
		 * 服务商编号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addProviderId(Long providerId) {
			this.providerId = providerId;
			return this;
		}

		/**
		 * 服务商名称
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addProviderName(String providerName) {
			this.providerName = providerName;
			return this;
		}

		/**
		 * 账户产品关联ID
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addProviderAccId(Long providerAccId) {
			this.providerAccId = providerAccId;
			return this;
		}

		/**
		 * 服务商账号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addProviderMchNo(String providerMchNo) {
			this.providerMchNo = providerMchNo;
			return this;
		}

		/**
		 * 交易产品编号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addProductId(Long productId) {
			this.productId = productId;
			return this;
		}

		/**
		 * 交易产品名称
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addProductName(String productName) {
			this.productName = productName;
			return this;
		}

		/**
		 * 银行编码
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addBankCode(String bankCode) {
			this.bankCode = bankCode;
			return this;
		}

		/**
		 * 银行账户所属银行名
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addBankName(String bankName) {
			this.bankName = bankName;
			return this;
		}

		/**
		 * 银行账户类型 0-公 1-私
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addAccountType(String accountType) {
			this.accountType = accountType;
			return this;
		}

		/**
		 * 卡类型：借记卡、贷记卡
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addBankCardType(String bankCardType) {
			this.bankCardType = bankCardType;
			return this;
		}

		/**
		 * 银行卡ID
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addBankId(Long bankId) {
			this.bankId = bankId;
			return this;
		}

		/**
		 * 银行卡号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addBankCardNo(String bankCardNo) {
			this.bankCardNo = bankCardNo;
			return this;
		}

		/**
		 * 开户名
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addRealName(String realName) {
			this.realName = realName;
			return this;
		}

		/**
		 * 交易金额-单位分
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addAmount(Long amount) {
			this.amount = amount;
			return this;
		}

		/**
		 * 交易流水号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addOutTradeNo(String outTradeNo) {
			this.outTradeNo = outTradeNo;
			return this;
		}

		/**
		 * 状态0000-已受理(状态不明) 0001-成功 0002-失败 0003-等待 0004-关闭 -1-未知状态
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addState(String state) {
			this.state = state;
			return this;
		}

		/**
		 * 支付状态描述
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addStateMsg(String stateMsg) {
			this.stateMsg = stateMsg;
			return this;
		}

		/**
		 * 支付状态备注
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addStateRemark(String stateRemark) {
			this.stateRemark = stateRemark;
			return this;
		}

		/**
		 * 订单类型: 0-代付1-代收2-代扣
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addType(String type) {
			this.type = type;
			return this;
		}

		/**
		 * 原交易流水号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addSrcOutTradeNo(String srcOutTradeNo) {
			this.srcOutTradeNo = srcOutTradeNo;
			return this;
		}

		/**
		 * 三方交易流水号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addOutTransactionId(String outTransactionId) {
			this.outTransactionId = outTransactionId;
			return this;
		}

		/**
		 * 请求ip地址
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addTerminalIP(String terminalIP) {
			this.terminalIP = terminalIP;
			return this;
		}

		/**
		 * 商品名称
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addGoodsName(String goodsName) {
			this.goodsName = goodsName;
			return this;
		}

		/**
		 * 商品描述
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addGoodsDesc(String goodsDesc) {
			this.goodsDesc = goodsDesc;
			return this;
		}

		/**
		 * 业务系统订单号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addBizOrderNo(String bizOrderNo) {
			this.bizOrderNo = bizOrderNo;
			return this;
		}

		/**
		 * 结果通知Url
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addNotifyUrl(String notifyUrl) {
			this.notifyUrl = notifyUrl;
			return this;
		}

		/**
		 * 交易结果返回页面
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addResultUrl(String resultUrl) {
			this.resultUrl = resultUrl;
			return this;
		}

		/**
		 * 支付通道用户标识
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addPayWayUserId(String payWayUserId) {
			this.payWayUserId = payWayUserId;
			return this;
		}

		/**
		 * 服务商交易流水号
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addSpTransactionId(String spTransactionId) {
			this.spTransactionId = spTransactionId;
			return this;
		}

		/**
		 * 服务商交易时间
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addSpTransTime(Date spTransTime) {
			this.spTransTime = spTransTime;
			return this;
		}

		/**
		 * 服务商交易请求日期
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addSpTransDate(String spTransDate) {
			this.spTransDate = spTransDate;
			return this;
		}

		/**
		 * 服务商返回码
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addSpRespCode(String spRespCode) {
			this.spRespCode = spRespCode;
			return this;
		}

		/**
		 * 服务商返回码描述
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addSpRespMsg(String spRespMsg) {
			this.spRespMsg = spRespMsg;
			return this;
		}

		/**
		 * 手续费
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addFee(Integer fee) {
			this.fee = fee;
			return this;
		}

		/**
		 * 清算状态0-未通知1-已通知 9-通知失败
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addNoticetate(String noticetate) {
			this.noticetate = noticetate;
			return this;
		}

		/**
		 * 创建时间
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addCreateTime(Date createTime) {
			this.createTime = createTime;
			return this;
		}

		/**
		 * 修改日期
		 * 
		 * @return TransRecordDpayBuilder
		 */
		public TransRecordDpayBuilder addUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
			return this;
		}

		public TransRecordDpay build() {
			return new TransRecordDpay(this);
		}
	}
}