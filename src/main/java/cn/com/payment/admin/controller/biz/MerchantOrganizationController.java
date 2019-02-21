package cn.com.payment.admin.controller.biz;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.payment.admin.contansts.Constants;
import cn.com.payment.admin.dto.PageEasyUi;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.MerchantInfo;
import cn.com.payment.admin.service.MerchantOrganizationService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("merchantOrganization")
public class MerchantOrganizationController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(MerchantOrganizationController.class.getName());
	@Autowired
	private MerchantOrganizationService merchantOrganizationService;

	/**
	 * 机构信息
	 * 
	 * @return
	 */
	@RequestMapping("toMerchantOrganizationDetail")
	@RequiresPermissions("merchantOrganization:view")
	public String toMerchantOrganizationDetail() {
		return PREFIX + "merchantOrganizationDetail";
	}

	/**
	 * 机构列表
	 * 
	 * @return
	 */
	@RequestMapping("toMerchantOrganizationPage")
	@RequiresPermissions("merchantOrganization:view")
	public String toMerchantOrganizationPage() {
		return PREFIX + "merchantOrganization";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getMerchantOrganizationList")
	@RequiresPermissions("merchantOrganization:view")
	public @ResponseBody List<MerchantInfo> getMerchantOrganizationList(MerchantInfo entity) {
		List<MerchantInfo> result = null;
		try {
			result = this.merchantOrganizationService.searchByProperty(entity);
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
	@RequestMapping("getMerchantOrganizationPage")
	@RequiresPermissions("merchantOrganization:view")
	public @ResponseBody PageEasyUi<MerchantInfo> getMerchantOrganizationPage(PageEasyUi<MerchantInfo> page,
			MerchantInfo entity) {
		PageEasyUi<MerchantInfo> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<MerchantInfo> list = this.merchantOrganizationService.searchByProperty(entity);
			result = new PageEasyUi<MerchantInfo>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	@RequestMapping("getProviderAgentList")
	@RequiresPermissions("providerAgent:view")
	public @ResponseBody List<MerchantInfo> getProviderAgentList() {
		MerchantInfo merchantInfo = new MerchantInfo();
		List<MerchantInfo> result = null;
		try {
			result = this.merchantOrganizationService.searchByProperty(merchantInfo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param merchantOrganization
	 * @return
	 */
	@RequestMapping("addMerchantOrganization")
	@RequiresPermissions("merchantOrganization:add")
	public @ResponseBody ResponseEntity<String> addMerchantOrganization(MerchantInfo merchantInfo) {
		if (CommonUtils.isEmpty(merchantInfo))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			this.merchantOrganizationService.create(merchantInfo);
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
	@RequestMapping("updateMerchantOrganization")
	@RequiresPermissions("merchantOrganization:update")
	public @ResponseBody ResponseEntity<String> updateMerchantOrganization(MerchantInfo merchantInfo) {
		if (CommonUtils.isEmpty(merchantInfo) || CommonUtils.isEmpty(merchantInfo.getMchId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			MerchantInfo data = this.merchantOrganizationService.searchById(merchantInfo.getMchId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(merchantInfo.getMchId()))
					data.setMchId(merchantInfo.getMchId());
				if (CommonUtils.isNotEmpty(merchantInfo.getOrgParentId()))
					data.setOrgParentId(merchantInfo.getOrgParentId());
				if (CommonUtils.isNotEmpty(merchantInfo.getChainParentId()))
					data.setChainParentId(merchantInfo.getChainParentId());
				if (CommonUtils.isNotEmpty(merchantInfo.getAccNo()))
					data.setAccNo(merchantInfo.getAccNo());
				if (CommonUtils.isNotEmpty(merchantInfo.getMchName()))
					data.setMchName(merchantInfo.getMchName());
				if (CommonUtils.isNotEmpty(merchantInfo.getMchDesc()))
					data.setMchDesc(merchantInfo.getMchDesc());
				if (CommonUtils.isNotEmpty(merchantInfo.getMchType()))
					data.setMchType(merchantInfo.getMchType());
				if (CommonUtils.isNotEmpty(merchantInfo.getMchNo()))
					data.setMchNo(merchantInfo.getMchNo());
				if (CommonUtils.isNotEmpty(merchantInfo.getMchKey()))
					data.setMchKey(merchantInfo.getMchKey());
				if (CommonUtils.isNotEmpty(merchantInfo.getMchRSAKey()))
					data.setMchRSAKey(merchantInfo.getMchRSAKey());
				if (CommonUtils.isNotEmpty(merchantInfo.getMchAPPId()))
					data.setMchAPPId(merchantInfo.getMchAPPId());
				if (CommonUtils.isNotEmpty(merchantInfo.getBalance()))
					data.setBalance(merchantInfo.getBalance());
				if (CommonUtils.isNotEmpty(merchantInfo.getIsDel()))
					data.setIsDel(merchantInfo.getIsDel());
				if (CommonUtils.isNotEmpty(merchantInfo.getState()))
					data.setState(merchantInfo.getState());
				if (CommonUtils.isNotEmpty(merchantInfo.getValidIP()))
					data.setValidIP(merchantInfo.getValidIP());
				if (CommonUtils.isNotEmpty(merchantInfo.getCreateTime()))
					data.setCreateTime(merchantInfo.getCreateTime());
				if (CommonUtils.isNotEmpty(merchantInfo.getUpdateTime()))
					data.setUpdateTime(merchantInfo.getUpdateTime());

				this.merchantOrganizationService.modify(data);
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
	@RequestMapping("deleteMerchantOrganization")
	@RequiresPermissions("merchantOrganization:delete")
	public @ResponseBody ResponseEntity<String> deleteMerchantOrganization(String param) {
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
			this.merchantOrganizationService.remove(ids);
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
	@RequestMapping("getMerchantOrganizationById")
	@RequiresPermissions("merchantOrganization:view")
	public @ResponseBody ResponseEntity getMerchantOrganizationById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			MerchantInfo merchantInfo = this.merchantOrganizationService.searchById(id);
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