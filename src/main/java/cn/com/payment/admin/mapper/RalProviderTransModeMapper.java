package cn.com.payment.admin.mapper;

import java.util.List;

import cn.com.payment.admin.exceptions.DBAccessException;
import cn.com.payment.admin.model.RalProviderTransMode;

/**
 * RalProviderTransModeMapper
 * 
 * Date:2019-1-10 22:23:54
 * 
 * @author dl
 */
public interface RalProviderTransModeMapper extends BaseMapper<RalProviderTransMode, Long> {
	
	public RalProviderTransMode selectOneByProviderTransModeCode(String providerTransModeCode) throws DBAccessException;

	public List<RalProviderTransMode> selectByProviderId(String providerCode) throws DBAccessException;
	
}