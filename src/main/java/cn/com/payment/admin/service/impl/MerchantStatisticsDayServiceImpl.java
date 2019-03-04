package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.MerchantStatisticsDayMapper;
import cn.com.payment.admin.model.MerchantStatisticsDay;
import cn.com.payment.admin.service.MerchantStatisticsDayService;

/**
 * MerchantStatisticsDayServiceImpl
 *
 * Date:2019-3-2 15:09:00
 * 
 * @author dl
 */
@Service
public class MerchantStatisticsDayServiceImpl extends BaseServiceImpl<MerchantStatisticsDay, Long>
		implements MerchantStatisticsDayService {
	@Autowired
	private MerchantStatisticsDayMapper merchantStatisticsDayMapper;

	@Override
	public BaseMapper<MerchantStatisticsDay, Long> getBaseMapper() {
		return this.merchantStatisticsDayMapper;
	}
}