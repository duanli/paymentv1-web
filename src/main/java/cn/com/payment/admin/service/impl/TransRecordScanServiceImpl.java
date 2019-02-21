package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.TransRecordScanMapper;
import cn.com.payment.admin.model.TransRecordScan;
import cn.com.payment.admin.service.TransRecordScanService;


/**
 * TransRecordScanServiceImpl
 *
 * Date:2019-1-10 22:46:51
 * @author dl
 */
@Service
public class TransRecordScanServiceImpl extends BaseServiceImpl<TransRecordScan, Long> 
	implements TransRecordScanService{
	@Autowired
	private TransRecordScanMapper transRecordScanMapper;
	@Override
	public BaseMapper<TransRecordScan, Long> getBaseMapper() {
		return this.transRecordScanMapper;
	}
}