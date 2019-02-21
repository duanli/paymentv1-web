package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.MerchantBalanceAdjustmentMapper;
import cn.com.payment.admin.model.MerchantBalanceAdjustment;
import cn.com.payment.admin.service.MerchantBalanceAdjustmentService;


/**
 * MerchantBalanceAdjustmentServiceImpl
 *
 * Date:2019-2-14 22:10:01
 * @author dl
 */
@Service
public class MerchantBalanceAdjustmentServiceImpl extends BaseServiceImpl<MerchantBalanceAdjustment, Long> 
	implements MerchantBalanceAdjustmentService{
	@Autowired
	private MerchantBalanceAdjustmentMapper merchantBalanceAdjustmentMapper;
	@Override
	public BaseMapper<MerchantBalanceAdjustment, Long> getBaseMapper() {
		return this.merchantBalanceAdjustmentMapper;
	}
}