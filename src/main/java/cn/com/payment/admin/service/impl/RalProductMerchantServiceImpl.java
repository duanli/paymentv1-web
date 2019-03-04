package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.RalProductMerchantMapper;
import cn.com.payment.admin.model.RalProductMerchant;
import cn.com.payment.admin.service.RalProductMerchantService;

/**
 * RalProductMerchantServiceImpl
 *
 * Date:2019-3-2 15:09:00
 * 
 * @author dl
 */
@Service
public class RalProductMerchantServiceImpl extends BaseServiceImpl<RalProductMerchant, Long>
		implements RalProductMerchantService {
	@Autowired
	private RalProductMerchantMapper ralProductMerchantMapper;

	@Override
	public BaseMapper<RalProductMerchant, Long> getBaseMapper() {
		return this.ralProductMerchantMapper;
	}
}