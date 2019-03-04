package cn.com.payment.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.MerchantBalanceAdjustmentMapper;
import cn.com.payment.admin.mapper.MerchantInfoMapper;
import cn.com.payment.admin.mapper.RalMerchantTransModeMapper;
import cn.com.payment.admin.model.MerchantBalanceAdjustment;
import cn.com.payment.admin.model.MerchantInfo;
import cn.com.payment.admin.model.RalMerchantTransMode;
import cn.com.payment.admin.service.MerchantBalanceAdjustmentService;
import cn.com.payment.admin.utils.CommonUtils;

/**
 * MerchantBalanceAdjustmentServiceImpl
 *
 * Date:2019-2-14 22:10:01
 * 
 * @author dl
 */
@Service
public class MerchantBalanceAdjustmentServiceImpl extends BaseServiceImpl<MerchantBalanceAdjustment, Long>
		implements MerchantBalanceAdjustmentService {
	@Autowired
	private MerchantBalanceAdjustmentMapper merchantBalanceAdjustmentMapper;
	@Autowired
	private MerchantInfoMapper merchantInfoMapper;
	@Autowired
	private RalMerchantTransModeMapper ralMerchantTransModeMapper;

	@Override
	public BaseMapper<MerchantBalanceAdjustment, Long> getBaseMapper() {
		return this.merchantBalanceAdjustmentMapper;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void adjustBalance(MerchantBalanceAdjustment merchantBalanceAdjustment) throws BaseException, Exception {
		// 调整通道账户余额
		RalMerchantTransMode ralMerchantTransMode = ralMerchantTransModeMapper
				.selectOne(merchantBalanceAdjustment.getRalAccProductId());
		if (CommonUtils.isEmpty(ralMerchantTransMode))
			throw new BaseException("通道账户不存在");
		ralMerchantTransMode.setCashOutBalance(
				ralMerchantTransMode.getCashOutBalance() + merchantBalanceAdjustment.getAdjustAmount());
		ralMerchantTransModeMapper.update(ralMerchantTransMode);
		// 调整总余额
		MerchantInfo merchantInfo = merchantInfoMapper.selectOne(merchantBalanceAdjustment.getMchId());
		if (CommonUtils.isEmpty(ralMerchantTransMode))
			throw new BaseException("商户不存在");
		merchantBalanceAdjustment.setBeforBalance(merchantInfo.getBalanceValid());
		merchantInfo.setBalanceValid(merchantInfo.getBalanceValid()+merchantBalanceAdjustment.getAdjustAmount());
		merchantInfoMapper.update(merchantInfo);
		merchantBalanceAdjustment.setAfterBalance(merchantInfo.getBalanceValid());
		merchantBalanceAdjustmentMapper.save(merchantBalanceAdjustment);
		
	}
}