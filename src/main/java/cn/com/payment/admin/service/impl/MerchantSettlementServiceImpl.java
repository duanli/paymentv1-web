package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.MerchantSettlementMapper;
import cn.com.payment.admin.model.MerchantSettlement;
import cn.com.payment.admin.service.MerchantSettlementService;


/**
 * MerchantSettlementServiceImpl
 *
 * Date:2019-2-14 22:10:01
 * @author dl
 */
@Service
public class MerchantSettlementServiceImpl extends BaseServiceImpl<MerchantSettlement, Long> 
	implements MerchantSettlementService{
	@Autowired
	private MerchantSettlementMapper merchantSettlementMapper;
	@Override
	public BaseMapper<MerchantSettlement, Long> getBaseMapper() {
		return this.merchantSettlementMapper;
	}
}