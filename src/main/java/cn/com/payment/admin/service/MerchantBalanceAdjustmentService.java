package cn.com.payment.admin.service;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.MerchantBalanceAdjustment;

/**
 * MerchantBalanceAdjustmentService
 *
 * Date:2019-2-14 22:10:01
 * 
 * @author dl
 */
public interface MerchantBalanceAdjustmentService extends BaseService<MerchantBalanceAdjustment, Long> {
	public void adjustBalance(MerchantBalanceAdjustment merchantBalanceAdjustment) throws BaseException, Exception;
}