package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.MerchantStatisticsMouthMapper;
import cn.com.payment.admin.model.MerchantStatisticsMouth;
import cn.com.payment.admin.service.MerchantStatisticsMouthService;


/**
 * MerchantStatisticsMouthServiceImpl
 *
 * Date:2019-2-14 22:10:01
 * @author dl
 */
@Service
public class MerchantStatisticsMouthServiceImpl extends BaseServiceImpl<MerchantStatisticsMouth, Long> 
	implements MerchantStatisticsMouthService{
	@Autowired
	private MerchantStatisticsMouthMapper merchantStatisticsMouthMapper;
	@Override
	public BaseMapper<MerchantStatisticsMouth, Long> getBaseMapper() {
		return this.merchantStatisticsMouthMapper;
	}
}