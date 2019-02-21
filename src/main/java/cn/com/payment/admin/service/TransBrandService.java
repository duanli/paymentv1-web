package cn.com.payment.admin.service;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.TransBrand;

/**
 * TransBrandService
 *
 * Date:2019-1-10 22:43:30
 * @author dl
 */
public interface TransBrandService extends BaseService<TransBrand,Long>{
	
	public TransBrand  searchByTransBrandCode (String transBrandCode) throws BaseException;

}