package cn.com.payment.admin.service;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.ProviderAccount;

/**
 * ProviderAccountService
 *
 * Date:2019-1-10 22:43:30
 * @author dl
 */
public interface ProviderAccountService extends BaseService<ProviderAccount,Long>{

	public ProviderAccount searchByProviderMchNo(String providerMchNo) throws BaseException;
	
}