package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.ProviderAgentMapper;
import cn.com.payment.admin.model.ProviderAgent;
import cn.com.payment.admin.service.ProviderAgentService;


/**
 * ProviderAgentServiceImpl
 *
 * Date:2019-1-10 22:46:51
 * @author dl
 */
@Service
public class ProviderAgentServiceImpl extends BaseServiceImpl<ProviderAgent, Long> 
	implements ProviderAgentService{
	@Autowired
	private ProviderAgentMapper providerAgentMapper;
	@Override
	public BaseMapper<ProviderAgent, Long> getBaseMapper() {
		return this.providerAgentMapper;
	}
}