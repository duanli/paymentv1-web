package cn.com.payment.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.com.payment.admin.common.MchTypeEnum;
import cn.com.payment.admin.controller.context.PasswordHelper;
import cn.com.payment.admin.dto.IResponse;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.mapper.AdminMapper;
import cn.com.payment.admin.mapper.AdminRoleMapper;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.mapper.MerchantInfoMapper;
import cn.com.payment.admin.mapper.RalAccountTransModeMapper;
import cn.com.payment.admin.model.Admin;
import cn.com.payment.admin.model.AdminRole;
import cn.com.payment.admin.model.MerchantInfo;
import cn.com.payment.admin.model.RalAccountTransMode;
import cn.com.payment.admin.service.MerchantInfoService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.DateUtils;
import cn.com.payment.admin.utils.Md5;
import cn.com.payment.admin.utils.RandomNumberGenerator;
import cn.com.payment.admin.utils.Snippet;

/**
 * MerchantInfoServiceImpl
 *
 * Date:2019-1-30 14:24:59
 * 
 * @author dl
 */
@Service
public class MerchantInfoServiceImpl extends BaseServiceImpl<MerchantInfo, Long> implements MerchantInfoService {
	@Autowired
	private MerchantInfoMapper merchantInfoMapper;

	@Autowired
	private AdminMapper AdminMapper;

	@Autowired
	private AdminRoleMapper adminRoleMapper;

	@Autowired
	private RalAccountTransModeMapper ralAccountTransModeMapper;

	@Override
	public BaseMapper<MerchantInfo, Long> getBaseMapper() {
		return this.merchantInfoMapper;
	}

	@Override
	public MerchantInfo searcheOneByMchNo(String mchNo) throws BaseException {
		MerchantInfo merchantAccount = merchantInfoMapper.selectOneByMchNo(mchNo);
		if (CommonUtils.isEmpty(merchantAccount))
			throw new BaseException(IResponse.DATA_NOT_FONUD, "mchNo不存在");
		return merchantAccount;
	}

	@Override
	public MerchantInfo createMerchantInfo(MerchantInfo merchantInfo) throws BaseException {
		// 生成商户号、商户密钥
		merchantInfo.setMchNo(this.genMchNo(merchantInfo.getMchType()));
		merchantInfo.setMchKey(RandomNumberGenerator.getRandomString(32));
		merchantInfo.setMchAPPId(this.genAPPId(merchantInfo.getMchType()));
		merchantInfo.setMchPayPassWord(Md5.md5("12345678"));// 初始密码12345678
		// google auth
		Map<String, String> googleAuthInfo = Snippet.genSecret(merchantInfo.getMchNo());
		merchantInfo.setGoogleAuthFlag("0");
		merchantInfo.setGoogleAuthKey(googleAuthInfo.get("secret"));
		merchantInfo.setGoogleAuthUrl(googleAuthInfo.get("url"));
		// 账户余额初始化
		merchantInfo.setBalanceFreeze(0L);
		merchantInfo.setBalance(0L);
		merchantInfo.setBalanceUnaccounted(0L);
		merchantInfo.setBalanceValid(0L);
		// 保存商户信息
		this.merchantInfoMapper.save(merchantInfo);
		// 创建登录用户
		this.createAdminUser(merchantInfo);
		return merchantInfo;
	}

	/**
	 * @param type 0-机构 1-商户 2- 连锁
	 * @return
	 * @throws BaseException
	 */
	public String genMchNo(String type) throws BaseException {

		String mchNo = "";
		if (MchTypeEnum.GENARAL_MERCHNANT.getType().equals(type))
			mchNo = "501066" + DateUtils.getNowDate("yyMMddHHmm") + RandomNumberGenerator.generateNumber(6);
		else if (MchTypeEnum.ORG_MERCHNANT.getType().equals(type))
			mchNo = "601066" + DateUtils.getNowDate("yyMMddHHmm") + RandomNumberGenerator.generateNumber(6);
		else if (MchTypeEnum.CHAIN_MERCHNANT.getType().equals(type))
			mchNo = "801066" + DateUtils.getNowDate("yyMMddHHmm") + RandomNumberGenerator.generateNumber(6);
		else
			mchNo = "901066" + DateUtils.getNowDate("yyMMddHHmm") + RandomNumberGenerator.generateNumber(6);
		return mchNo;

	}

	/**
	 * @param type 0-机构 1-商户 2- 连锁
	 * @return
	 * @throws BaseException
	 */
	public String genAPPId(String type) throws BaseException {

		String appId = "";
		if (MchTypeEnum.GENARAL_MERCHNANT.getType().equals(type))
			appId = "1005" + DateUtils.getNowDate("yyMMddHHmm") + RandomNumberGenerator.generateNumber(6);
		else if (MchTypeEnum.ORG_MERCHNANT.getType().equals(type))
			appId = "1006" + DateUtils.getNowDate("yyMMddHHmm") + RandomNumberGenerator.generateNumber(6);
		else if (MchTypeEnum.CHAIN_MERCHNANT.getType().equals(type))
			appId = "1007" + DateUtils.getNowDate("yyMMddHHmm") + RandomNumberGenerator.generateNumber(6);
		else
			appId = "1008" + DateUtils.getNowDate("yyMMddHHmm") + RandomNumberGenerator.generateNumber(6);
		return appId;

	}

	/**
	 * @param type 0-机构 1-商户 2- 连锁
	 * @return
	 * @throws BaseException
	 */
	public Long getRoleId(String type) throws BaseException {

		Long roleId = 1L;
		if (MchTypeEnum.GENARAL_MERCHNANT.getType().equals(type))
			roleId = 29L;
		else if (MchTypeEnum.ORG_MERCHNANT.getType().equals(type))
			roleId = 28L;
		else if (MchTypeEnum.CHAIN_MERCHNANT.getType().equals(type))
			roleId = 28L;
		else
			roleId = 29L;
		return roleId;

	}

	public void createAdminUser(MerchantInfo merchantInfo) throws BaseException {
		Admin admin = new Admin();
		admin.setEmail(merchantInfo.getEmail());
		admin.setMerId(merchantInfo.getMchId());
		admin.setPswd("123456");
		admin.setUserName(merchantInfo.getContactsCell() + RandomNumberGenerator.getRandomString(5));
		admin.setCellPhone(merchantInfo.getContactsCell());
		admin.setLocked(false);
		admin.setName(merchantInfo.getContacts());
		admin.setRemark(MchTypeEnum.getStateMsg(merchantInfo.getMchType()));
		// 加密
		new PasswordHelper().encryptPasswor(admin);
		// 保存用户数据
		AdminMapper.save(admin);
		// 分配用户角色
		adminRoleMapper.save(new AdminRole(admin.getId(), this.getRoleId(merchantInfo.getMchType())));
	}

	@Override
	public String getMerchantAccInfo(Model model, MerchantInfo merchantInfo) throws BaseException {
		// 设置余额信息
		model.addAttribute("balance", merchantInfo.getBalance());
		model.addAttribute("balanceValid", merchantInfo.getBalanceValid());
		model.addAttribute("balanceFreeze", merchantInfo.getBalanceFreeze());
		model.addAttribute("balanceUnaccounted", merchantInfo.getBalanceUnaccounted());
		// 设置今日统计

		model.addAttribute("todayCnt", merchantInfo.getBalance());
		model.addAttribute("todayAmount", merchantInfo.getBalance());
		model.addAttribute("todayFee", merchantInfo.getBalance());
		model.addAttribute("todayIncome", merchantInfo.getBalance());
		// 设置交易方式交易数据
		List<RalAccountTransMode> list = ralAccountTransModeMapper.selectByMchId(merchantInfo.getMchId());
		model.addAttribute("transModeList", list);
		return null;
	}

//	@Override
//	public List<ComboTreeBase> searchMerchantAccTree() throws BaseException {
//		List<ComboTreeBase> result = new ArrayList<ComboTreeBase>();
//		List<MerchantInfo> list = merchantInfoMapper.searchMerchantAccTree();
//		if (CommonUtils.isNotEmpty(list)) {
//			for (MerchantInfo item : list) {
//				ComboTreeBase comboTreeP = new ComboTreeBase();
//				comboTreeP.setId(item.getMerNo());
//				comboTreeP.setText(item.getMerName());
//				comboTreeP.setState("closed");
//				if (CommonUtils.isNotEmpty(item.getMerchantAccount())) {
//					List<ComboTreeBase> merchantAccList = new ArrayList<ComboTreeBase>();
//					for (MerchantAccount merchantAccount : item.getMerchantAccount()) {
//						ComboTreeBase comboTreeC = new ComboTreeBase();
//						comboTreeC.setId(merchantAccount.getMchNo());
//						comboTreeC.setText(merchantAccount.getMchNo());
//						merchantAccList.add(comboTreeC);
//					}
//					comboTreeP.setChildren(merchantAccList);
//				}
//				result.add(comboTreeP);
//			}
//		}
//		return result;
//	}

}