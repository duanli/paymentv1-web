package cn.com.payment.admin.mapper;

import cn.com.payment.admin.exceptions.DBAccessException;
import cn.com.payment.admin.model.ProviderAgent;
/**
 * ProviderAgentMapper
 
 * Date:2019-1-10 22:23:54
 * @author dl
 */
public interface ProviderAgentMapper extends BaseMapper<ProviderAgent,Long>{
	
	public ProviderAgent selectOneByCode(String providerAgentCode) throws DBAccessException;

}