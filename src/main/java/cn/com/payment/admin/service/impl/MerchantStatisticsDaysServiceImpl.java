package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.MerchantStatisticsDaysMapper;
import cn.com.payment.admin.model.MerchantStatisticsDays;
import cn.com.payment.admin.service.MerchantStatisticsDaysService;


/**
 * MerchantStatisticsDaysServiceImpl
 *
 * Date:2019-2-14 22:10:01
 * @author dl
 */
@Service
public class MerchantStatisticsDaysServiceImpl extends BaseServiceImpl<MerchantStatisticsDays, Long> 
	implements MerchantStatisticsDaysService{
	@Autowired
	private MerchantStatisticsDaysMapper merchantStatisticsDaysMapper;
	@Override
	public BaseMapper<MerchantStatisticsDays, Long> getBaseMapper() {
		return this.merchantStatisticsDaysMapper;
	}
}