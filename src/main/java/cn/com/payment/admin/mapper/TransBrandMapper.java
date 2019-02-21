package cn.com.payment.admin.mapper;

import cn.com.payment.admin.exceptions.DBAccessException;
import cn.com.payment.admin.model.TransBrand;
/**
 * TransBrandMapper
 
 * Date:2019-1-10 22:23:54
 * @author dl
 */
public interface TransBrandMapper extends BaseMapper<TransBrand,Long>{
	
	public TransBrand  selectByTransBrandCode (String transBrandCode) throws DBAccessException;
	
}