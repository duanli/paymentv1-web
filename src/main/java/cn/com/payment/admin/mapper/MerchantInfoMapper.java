package cn.com.payment.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.payment.admin.exceptions.DBAccessException;
import cn.com.payment.admin.model.MerchantInfo;

/**
 * MerchantInfoMapper
 * 
 * Date:2019-1-30 14:24:59
 * 
 * @author dl
 */
public interface MerchantInfoMapper extends BaseMapper<MerchantInfo, Long> {

	public MerchantInfo selectOneByMchNo(@Param("mchNo") String mchNo) throws DBAccessException;

	public MerchantInfo selectOneByAccNo(@Param("accNo") String accNo) throws DBAccessException;

	public List<MerchantInfo> searchMerchantAccTree() throws DBAccessException;

}