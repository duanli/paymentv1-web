package cn.com.payment.admin.mapper;

import org.springframework.dao.DataAccessException;

import cn.com.payment.admin.model.TransRecordScan;

/**
 * TransRecordScanMapper
 * 
 * Date:2019-1-10 22:23:54
 * 
 * @author dl
 */
public interface TransRecordScanMapper extends BaseMapper<TransRecordScan, Long> {

	public TransRecordScan selectOneByBizOrderNo(String bizOrderNo) throws DataAccessException;

	public TransRecordScan selectOneByOutTradeNo(String outTradeNo) throws DataAccessException;
	
	public TransRecordScan selectOneByBizOrderNoForUpdate(String bizOrderNo) throws DataAccessException;

	public TransRecordScan selectOneByOutTradeNoForUpdate(String outTradeNo) throws DataAccessException;

	public TransRecordScan selectOneBySpTransactionId(String spTransactionId) throws DataAccessException;

}