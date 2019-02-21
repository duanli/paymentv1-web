package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.TransRecordDpayMapper;
import cn.com.payment.admin.model.TransRecordDpay;
import cn.com.payment.admin.service.TransRecordDpayService;


/**
 * TransRecordDpayServiceImpl
 *
 * Date:2019-1-10 22:46:51
 * @author dl
 */
@Service
public class TransRecordDpayServiceImpl extends BaseServiceImpl<TransRecordDpay, Long> 
	implements TransRecordDpayService{
	@Autowired
	private TransRecordDpayMapper transRecordDpayMapper;
	@Override
	public BaseMapper<TransRecordDpay, Long> getBaseMapper() {
		return this.transRecordDpayMapper;
	}
}