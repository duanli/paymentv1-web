package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.ProviderStatisticsDaysMapper;
import cn.com.payment.admin.model.ProviderStatisticsDays;
import cn.com.payment.admin.service.ProviderStatisticsDaysService;

/**
 * ProviderStatisticsDaysServiceImpl
 *
 * Date:2019-3-2 15:09:00
 * 
 * @author dl
 */
@Service
public class ProviderStatisticsDaysServiceImpl extends BaseServiceImpl<ProviderStatisticsDays, Long>
		implements ProviderStatisticsDaysService {
	@Autowired
	private ProviderStatisticsDaysMapper providerStatisticsDaysMapper;

	@Override
	public BaseMapper<ProviderStatisticsDays, Long> getBaseMapper() {
		return this.providerStatisticsDaysMapper;
	}
}