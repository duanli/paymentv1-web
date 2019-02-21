package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.MerchantBankCardsMapper;
import cn.com.payment.admin.model.MerchantBankCards;
import cn.com.payment.admin.service.MerchantBankCardsService;


/**
 * MerchantBankCardsServiceImpl
 *
 * Date:2019-1-10 22:46:51
 * @author dl
 */
@Service
public class MerchantBankCardsServiceImpl extends BaseServiceImpl<MerchantBankCards, Long> 
	implements MerchantBankCardsService{
	@Autowired
	private MerchantBankCardsMapper merchantBankCardsMapper;
	@Override
	public BaseMapper<MerchantBankCards, Long> getBaseMapper() {
		return this.merchantBankCardsMapper;
	}
}