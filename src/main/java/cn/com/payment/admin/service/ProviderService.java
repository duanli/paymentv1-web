package cn.com.payment.admin.service;

import java.util.List;

import cn.com.payment.admin.dto.ComboTreeBase;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.Provider;

/**
 * ProviderService
 *
 * Date:2019-1-10 22:43:30
 * @author dl
 */
public interface ProviderService extends BaseService<Provider,Long>{
	
	public List<ComboTreeBase> searchProviderAccTree(Provider provider) throws BaseException;

	public List<ComboTreeBase> searchProviderTransModeTree(Provider provider) throws BaseException;

	
	
}