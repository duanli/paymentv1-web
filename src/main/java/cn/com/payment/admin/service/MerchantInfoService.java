package cn.com.payment.admin.service;

import org.springframework.ui.Model;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.MerchantInfo;

/**
 * MerchantInfoService
 *
 * Date:2019-1-30 14:24:59
 * 
 * @author dl
 */
public interface MerchantInfoService extends BaseService<MerchantInfo, Long> {

	public MerchantInfo searcheOneByMchNo(String mchNo) throws BaseException;

	public MerchantInfo createMerchantInfo(MerchantInfo merchantInfo) throws BaseException;
	
	public String getMerchantAccInfo(Model model,MerchantInfo merchantInfo) throws BaseException;

//	public boolean googleCodeValid(String googleCode, MerchantInfo merchantInfo) throws BaseException;

}