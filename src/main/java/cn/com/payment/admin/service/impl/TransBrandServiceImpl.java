package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.TransBrandMapper;
import cn.com.payment.admin.model.TransBrand;
import cn.com.payment.admin.service.TransBrandService;

/**
 * TransBrandServiceImpl
 *
 * Date:2019-1-10 22:46:51
 * 
 * @author dl
 */
@Service
public class TransBrandServiceImpl extends BaseServiceImpl<TransBrand, Long> implements TransBrandService {
	@Autowired
	private TransBrandMapper transBrandMapper;

	@Override
	public BaseMapper<TransBrand, Long> getBaseMapper() {
		return this.transBrandMapper;
	}

	@Override
	public TransBrand searchByTransBrandCode(String transBrandCode) throws BaseException {
		return transBrandMapper.selectByTransBrandCode(transBrandCode);
	}
}