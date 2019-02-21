package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.MerchantInfoMapper;
import cn.com.payment.admin.model.MerchantInfo;
import cn.com.payment.admin.service.MerchantOrganizationService;


/**
 * MerchantOrganizationServiceImpl
 *
 * Date:2019-1-30 14:24:59
 * @author dl
 */
@Service
public class MerchantOrganizationServiceImpl extends BaseServiceImpl<MerchantInfo, Long> 
	implements MerchantOrganizationService{
	@Autowired
	private MerchantInfoMapper merchantInfoMapper;

	@Override
	public BaseMapper<MerchantInfo, Long> getBaseMapper() {
		return merchantInfoMapper;
	}
}