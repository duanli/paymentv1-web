package cn.com.payment.admin.controller.biz;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.payment.admin.annotation.SystemControllerLog;
import cn.com.payment.admin.contansts.Constants;
import cn.com.payment.admin.dto.PageEasyUi;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.MerchantInfo;
import cn.com.payment.admin.service.MerchantInfoService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.Md5;
import cn.com.payment.admin.utils.PageUtils;
import cn.com.payment.admin.utils.Snippet;

@Controller
@RequestMapping("merchantInfo")
public class MerchantInfoController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(MerchantInfoController.class.getName());
	@Autowired
	private MerchantInfoService merchantInfoService;

	/**
	 * 商户信息页面
	 * 
	 * @return
	 */
	@RequestMapping("merchant")
	@RequiresPermissions("merchant:view")
	public String toMerchantInfoDetail(Model model) {
		Long merId = (Long) SecurityUtils.getSubject().getSession().getAttribute("merId");
		try {
			MerchantInfo data = this.merchantInfoService.searchById(merId);
			if (CommonUtils.isEmpty(data))
				return "402";
			model.addAttribute("mchNo", data.getMchNo());
			model.addAttribute("mchName", data.getMchName());
			model.addAttribute("mchDesc", data.getMchDesc());
			model.addAttribute("contacts", data.getContacts());
			model.addAttribute("contactsCell", data.getContactsCell());
			model.addAttribute("email", data.getEmail());

			String authState = "";
			if ("0".equals(data.getAuthState()))
				authState = "未审核";
			else if ("1".equals(data.getAuthState()))
				authState = "审核通过";
			else if ("2".equals(data.getAuthState()))
				authState = "审核失败";
			else
				authState = "未知状态";
			model.addAttribute("authState", authState);

			String state = "";
			if ("0".equals(data.getAuthState()))
				state = "未激活";
			else if ("1".equals(data.getAuthState()))
				state = "已激活";
			else if ("2".equals(data.getAuthState()))
				state = "停用";
			else
				state = "未知状态";
			model.addAttribute("state", state);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return PREFIX + "merchantInfoDetail";
	}
	/**
	 * 商户信息页面
	 * 
	 * @return
	 */
	@RequestMapping("merchantAccInfo")
	@RequiresPermissions("merchant:view")
	public String toMerchantAccInfo(Model model) {
		Long merId = (Long) SecurityUtils.getSubject().getSession().getAttribute("merId");
		try {
			MerchantInfo data = this.merchantInfoService.searchById(merId);
			if (CommonUtils.isEmpty(data))
				return "402";
			this.merchantInfoService.getMerchantAccInfo(model, data);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return PREFIX + "merchantInfoAccInfo";
	}
	/**
	 * 商户列表页
	 * 
	 * @return
	 */
	@RequestMapping("toMerchantInfoPage")
	@RequiresPermissions("merchantInfo:view")
	public String toMerchantInfoPage() {
		return PREFIX + "merchantInfo";
	}

	/**
	 * 商户安全配置
	 * 
	 * @return
	 */
	@RequestMapping("toMerchantSecure")
	@RequiresPermissions("merchantInfo:view")
	public String toMerchantInfoSecure(Model model) {
		Long merId = (Long) SecurityUtils.getSubject().getSession().getAttribute("merId");
		try {
			MerchantInfo data = this.merchantInfoService.searchById(merId);
			if (CommonUtils.isEmpty(data))
				return "402";
			model.addAttribute("googleAuthFlag", data.getGoogleAuthFlag());
			model.addAttribute("googleAuthUrl", data.getGoogleAuthUrl());
			model.addAttribute("googleAuthKey", data.getGoogleAuthKey());
			model.addAttribute("APPID", data.getMchAPPId());
		} catch (BaseException e) {
			e.printStackTrace();
		}

		return PREFIX + "merchantInfoSecure";
	}
	
	/**
	 * 根据id获取信息
	 * 
	 * @param id
	 * @return
	 */
	@SystemControllerLog(description="google验证器绑定",type="0")
	@SuppressWarnings("rawtypes")
	@RequestMapping("googleAuth")
	@RequiresPermissions("merchantInfo:view")
	public @ResponseBody ResponseEntity googleAuth(String googleCode) {
		if (CommonUtils.isEmpty(googleCode))
			return new ResponseEntity<String>("请输入google验证码", HttpStatus.BAD_REQUEST);
		Long merId = (Long) SecurityUtils.getSubject().getSession().getAttribute("merId");
		try {
			MerchantInfo merchantInfo = this.merchantInfoService.searchById(merId);
			if (CommonUtils.isEmpty(merchantInfo))
				return new ResponseEntity<String>("数据不存在", HttpStatus.NO_CONTENT);
			// 验证GOOGLE验证码
			boolean result = Snippet.auth(Long.valueOf(googleCode), merchantInfo.getGoogleAuthKey());
			if (result) {
				merchantInfo.setGoogleAuthFlag("1");
				merchantInfoService.modify(merchantInfo);
				return new ResponseEntity<String>("绑定成功", HttpStatus.OK);
			}else 
				return new ResponseEntity<String>("验证失败", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 根据id获取信息
	 * 
	 * @param id
	 * @return
	 */
	@SystemControllerLog(description="设置支付密码",type="0")
	@SuppressWarnings("rawtypes")
	@RequestMapping("setPayPassWord")
	@RequiresPermissions("merchantInfo:view")
	public @ResponseBody ResponseEntity setPayPassWord(String pswd, String rePswd,String googleCode) {
		if (CommonUtils.isEmpty(pswd))
			return new ResponseEntity<String>("新密码为空", HttpStatus.BAD_REQUEST);
		if (CommonUtils.isEmpty(rePswd))
			return new ResponseEntity<String>("确认密码为空", HttpStatus.BAD_REQUEST);
		if (!pswd.equals(rePswd))
			return new ResponseEntity<String>("两次输入的密码不一致", HttpStatus.BAD_REQUEST);
		if (CommonUtils.isEmpty(googleCode))
			return new ResponseEntity<String>("请输入google验证码", HttpStatus.BAD_REQUEST);
		Long merId = (Long) SecurityUtils.getSubject().getSession().getAttribute("merId");
		try {
			MerchantInfo merchantInfo = this.merchantInfoService.searchById(merId);
			if (CommonUtils.isEmpty(merchantInfo))
				return new ResponseEntity<String>("数据不存在", HttpStatus.NO_CONTENT);
			// 验证GOOGLE验证码
			boolean result = Snippet.auth(Long.valueOf(googleCode), merchantInfo.getGoogleAuthKey());
			if (result) {
				merchantInfo.setMchPayPassWord(Md5.md5(pswd));
				merchantInfoService.modify(merchantInfo);
				return new ResponseEntity<String>("修改密码成功", HttpStatus.OK);
			}else 
				return new ResponseEntity<String>("验证失败", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/**
	 * 根据id获取信息
	 * 
	 * @param id
	 * @return
	 */
	@SystemControllerLog(description="查看商户密钥",type="0")
	@SuppressWarnings("rawtypes")
	@RequestMapping("lookMchKey")
	@RequiresPermissions("merchantInfo:view")
	public @ResponseBody ResponseEntity lookMchKey(String googleCode) {
		if (CommonUtils.isEmpty(googleCode))
			return new ResponseEntity<String>("请输入google验证码", HttpStatus.BAD_REQUEST);
		Long merId = (Long) SecurityUtils.getSubject().getSession().getAttribute("merId");
		try {
			MerchantInfo merchantInfo = this.merchantInfoService.searchById(merId);
			if (CommonUtils.isEmpty(merchantInfo))
				return new ResponseEntity<String>("数据不存在", HttpStatus.NO_CONTENT);
			// 验证GOOGLE验证码
			boolean result = Snippet.auth(Long.valueOf(googleCode), merchantInfo.getGoogleAuthKey());
			if (result)
				return new ResponseEntity<String>(merchantInfo.getMchKey(), HttpStatus.OK);
			else 
				return new ResponseEntity<String>("验证失败", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		} 
		catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getMerchantList")
	@RequiresPermissions("merchant:view")
	public @ResponseBody List<MerchantInfo> getMerchantInfoList(MerchantInfo entity) {
		List<MerchantInfo> result = null;
		try {
			result = this.merchantInfoService.searchByProperty(entity);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getMerchantInfoPage")
	@RequiresPermissions("merchantInfo:view")
	public @ResponseBody PageEasyUi<MerchantInfo> getMerchantInfoPage(PageEasyUi<MerchantInfo> page,
			MerchantInfo entity) {
		PageEasyUi<MerchantInfo> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<MerchantInfo> list = this.merchantInfoService.searchByProperty(entity);
			result = new PageEasyUi<MerchantInfo>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param merchantInfo
	 * @return
	 */
	@SystemControllerLog(description="添加商户",type="2")
	@RequestMapping("addMerchantInfo")
	@RequiresPermissions("merchantInfo:add")
	public @ResponseBody ResponseEntity<String> addMerchantInfo(MerchantInfo merchantInfo) {
		if (CommonUtils.isEmpty(merchantInfo))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);
		if (CommonUtils.isEmpty(merchantInfo.getMchName()))
			return new ResponseEntity<String>("请输入商户名称", HttpStatus.BAD_REQUEST);
		if (CommonUtils.isEmpty(merchantInfo.getMchType()))
			return new ResponseEntity<String>("请输入商户类型", HttpStatus.BAD_REQUEST);
		if (CommonUtils.isEmpty(merchantInfo.getAuthState()))
			return new ResponseEntity<String>("请输入商户认证状态", HttpStatus.BAD_REQUEST);
		if (CommonUtils.isEmpty(merchantInfo.getState()))
			return new ResponseEntity<String>("请输入商户启用状态", HttpStatus.BAD_REQUEST);

		try {
			// 生成商户账号
			this.merchantInfoService.createMerchantInfo(merchantInfo);
			return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping("updateMerchantInfo")
	@RequiresPermissions("merchantInfo:update")
	public @ResponseBody ResponseEntity<String> updateMerchantInfo(MerchantInfo merchantInfo) {
		if (CommonUtils.isEmpty(merchantInfo) || CommonUtils.isEmpty(merchantInfo.getMchId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			MerchantInfo data = this.merchantInfoService.searchById(merchantInfo.getMchId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(merchantInfo.getOrgParentId()))
					data.setOrgParentId(merchantInfo.getOrgParentId());
				if (CommonUtils.isNotEmpty(merchantInfo.getChainParentId()))
					data.setChainParentId(merchantInfo.getChainParentId());
				if (CommonUtils.isNotEmpty(merchantInfo.getMchName()))
					data.setMchName(merchantInfo.getMchName());
				if (CommonUtils.isNotEmpty(merchantInfo.getMchDesc()))
					data.setMchDesc(merchantInfo.getMchDesc());
				if (CommonUtils.isNotEmpty(merchantInfo.getMchType()))
					data.setMchType(merchantInfo.getMchType());
				if (CommonUtils.isNotEmpty(merchantInfo.getContacts()))
					data.setContacts(merchantInfo.getContacts());
				if (CommonUtils.isNotEmpty(merchantInfo.getContactsCell()))
					data.setContactsCell(merchantInfo.getContactsCell());
				if (CommonUtils.isNotEmpty(merchantInfo.getEmail()))
					data.setEmail(merchantInfo.getEmail());
				if (CommonUtils.isNotEmpty(merchantInfo.getIsDel()))
					data.setIsDel(merchantInfo.getIsDel());
				if (CommonUtils.isNotEmpty(merchantInfo.getState()))
					data.setState(merchantInfo.getState());
				if (CommonUtils.isNotEmpty(merchantInfo.getAuthState()))
					data.setAuthState(merchantInfo.getAuthState());
				if (CommonUtils.isNotEmpty(merchantInfo.getValidIP()))
					data.setValidIP(merchantInfo.getValidIP());
				this.merchantInfoService.modify(data);
				return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
			} else
				return new ResponseEntity<String>("数据不存在！", HttpStatus.BAD_REQUEST);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 删除数据
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping("deleteMerchantInfo")
	@RequiresPermissions("merchantInfo:delete")
	public @ResponseBody ResponseEntity<String> deleteMerchantInfo(String param) {
		if (CommonUtils.isEmpty(param))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		Long[] ids = null;
		try {
			String[] params = param.split(",");
			ids = new Long[params.length];
			for (int i = 0, len = params.length; i < len; i++) {
				ids[i] = Long.valueOf(params[i]);
			}
		} catch (NumberFormatException e1) {
			return new ResponseEntity<String>("参数格式错误！", HttpStatus.BAD_REQUEST);
		}

		try {
			this.merchantInfoService.remove(ids);
			return new ResponseEntity<String>(Constants.PASS_OK, HttpStatus.OK);
		} catch (BaseException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 根据id获取信息
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("getMerchantInfoById")
	@RequiresPermissions("merchantInfo:view")
	public @ResponseBody ResponseEntity getMerchantInfoById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			MerchantInfo merchantInfo = this.merchantInfoService.searchById(id);
			if (null != merchantInfo)
				return new ResponseEntity<MerchantInfo>(merchantInfo, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}