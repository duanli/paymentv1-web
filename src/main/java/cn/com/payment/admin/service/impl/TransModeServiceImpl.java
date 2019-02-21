package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.TransModeMapper;
import cn.com.payment.admin.model.TransMode;
import cn.com.payment.admin.service.TransModeService;


/**
 * TransModeServiceImpl
 *
 * Date:2019-1-10 22:46:51
 * @author dl
 */
@Service
public class TransModeServiceImpl extends BaseServiceImpl<TransMode, Long> 
	implements TransModeService{
	@Autowired
	private TransModeMapper transModeMapper;
	@Override
	public BaseMapper<TransMode, Long> getBaseMapper() {
		return this.transModeMapper;
	}
}