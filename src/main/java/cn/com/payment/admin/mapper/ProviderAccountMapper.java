package cn.com.payment.admin.mapper;

import java.util.List;

import cn.com.payment.admin.exceptions.DBAccessException;
import cn.com.payment.admin.model.ProviderAccount;

/**
 * ProviderAccountMapper
 * 
 * Date:2019-1-10 22:23:54
 * 
 * @author dl
 */
public interface ProviderAccountMapper extends BaseMapper<ProviderAccount, Long> {
	
	public ProviderAccount selectOneByProviderMchNo(String providerMchNo) throws DBAccessException;
	
	public List<ProviderAccount> selectByProviderId(String providerId) throws DBAccessException;
	
}