package cn.com.payment.admin.mapper;

import java.util.List;

import cn.com.payment.admin.exceptions.DBAccessException;
import cn.com.payment.admin.model.Provider;

/**
 * ProviderMapper
 * 
 * Date:2019-1-10 22:23:54
 * 
 * @author dl
 */
public interface ProviderMapper extends BaseMapper<Provider, Long> {

	public List<Provider> selectProviderAccTree(Provider provider) throws DBAccessException;

	public List<Provider> selectProviderTransModeTree(Provider provider) throws DBAccessException;
}