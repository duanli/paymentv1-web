package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.RalProviderTransModeMapper;
import cn.com.payment.admin.model.RalProviderTransMode;
import cn.com.payment.admin.service.RalProviderTransModeService;


/**
 * RalProviderTransModeServiceImpl
 *
 * Date:2019-1-10 22:46:51
 * @author dl
 */
@Service
public class RalProviderTransModeServiceImpl extends BaseServiceImpl<RalProviderTransMode, Long> 
	implements RalProviderTransModeService{
	@Autowired
	private RalProviderTransModeMapper ralProviderTransModeMapper;
	@Override
	public BaseMapper<RalProviderTransMode, Long> getBaseMapper() {
		return this.ralProviderTransModeMapper;
	}
}