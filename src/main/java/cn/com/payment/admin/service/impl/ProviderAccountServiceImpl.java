package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.ProviderAccountMapper;
import cn.com.payment.admin.model.ProviderAccount;
import cn.com.payment.admin.service.ProviderAccountService;


/**
 * ProviderAccountServiceImpl
 *
 * Date:2019-1-10 22:46:51
 * @author dl
 */
@Service
public class ProviderAccountServiceImpl extends BaseServiceImpl<ProviderAccount, Long> 
	implements ProviderAccountService{
	@Autowired
	private ProviderAccountMapper providerAccountMapper;
	@Override
	public BaseMapper<ProviderAccount, Long> getBaseMapper() {
		return this.providerAccountMapper;
	}
	
	public ProviderAccount searchByProviderMchNo(String providerMchNo) throws BaseException{
		return providerAccountMapper.selectOneByProviderMchNo(providerMchNo);
	}
}