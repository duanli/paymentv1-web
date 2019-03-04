package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.RalMerchantTransModeMapper;
import cn.com.payment.admin.model.RalMerchantTransMode;
import cn.com.payment.admin.service.RalMerchantTransModeService;

/**
 * RalMerchantTransModeServiceImpl
 *
 * Date:2019-3-2 15:09:00
 * 
 * @author dl
 */
@Service
public class RalMerchantTransModeServiceImpl extends BaseServiceImpl<RalMerchantTransMode, Long>
		implements RalMerchantTransModeService {
	@Autowired
	private RalMerchantTransModeMapper ralMerchantTransModeMapper;

	@Override
	public BaseMapper<RalMerchantTransMode, Long> getBaseMapper() {
		return this.ralMerchantTransModeMapper;
	}
}