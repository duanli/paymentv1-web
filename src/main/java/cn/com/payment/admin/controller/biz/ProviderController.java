package cn.com.payment.admin.controller.biz;

import java.util.ArrayList;
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
import cn.com.payment.admin.dto.ComboTreeBase;
import cn.com.payment.admin.dto.PageEasyUi;
import cn.com.payment.admin.exceptions.BaseException;
import cn.com.payment.admin.model.Provider;
import cn.com.payment.admin.service.ProviderService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("provider")
public class ProviderController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(ProviderController.class.getName());
	@Autowired
	private ProviderService providerService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toProviderPage")
	@RequiresPermissions("provider:view")
	public String toProviderPage() {
		return PREFIX + "provider";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getProviderPage")
	@RequiresPermissions("provider:view")
	public @ResponseBody PageEasyUi<Provider> getProviderPage(PageEasyUi<Provider> page, Provider entity) {
		PageEasyUi<Provider> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<Provider> list = this.providerService.searchByProperty(entity);
			result = new PageEasyUi<Provider>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	@RequestMapping("getProviderList")
	@RequiresPermissions("provider:view")
	public @ResponseBody List<Provider> getProviderList() {
		Provider provider = new Provider();
		List<Provider> result = null;
		try {
			result = this.providerService.searchByProperty(provider);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	@RequestMapping("getProviderAccTree")
	@RequiresPermissions("provider:view")
	public @ResponseBody List<ComboTreeBase> getProviderAccTree() {
		Provider provider = new Provider();
		List<ComboTreeBase> result = new ArrayList<ComboTreeBase>() ;
		try {
			result = this.providerService.searchProviderAccTree(provider);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
	
	@RequestMapping("getProviderTransModeTree")
	@RequiresPermissions("provider:view")
	public @ResponseBody List<ComboTreeBase> getProviderTransModeTree() {
		Provider provider = new Provider();
		List<ComboTreeBase> result = new ArrayList<ComboTreeBase>();
		try {
			result = this.providerService.searchProviderTransModeTree(provider);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
	/**
	 * 新建数据
	 * 
	 * @param provider
	 * @return
	 */
	@RequestMapping("addProvider")
	@RequiresPermissions("provider:add")
	public @ResponseBody ResponseEntity<String> addProvider(Provider provider) {
		if (CommonUtils.isEmpty(provider))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			this.providerService.create(provider);
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
	@RequestMapping("updateProvider")
	@RequiresPermissions("provider:update")
	public @ResponseBody ResponseEntity<String> updateProvider(Provider provider) {
		if (CommonUtils.isEmpty(provider) || CommonUtils.isEmpty(provider.getProviderId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			Provider data = this.providerService.searchById(provider.getProviderId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(provider.getProviderId()))
					data.setProviderId(provider.getProviderId());
				if (CommonUtils.isNotEmpty(provider.getProviderAgentId()))
					data.setProviderAgentId(provider.getProviderAgentId());
				if (CommonUtils.isNotEmpty(provider.getProviderId()))
					data.setProviderId(provider.getProviderId());
				if (CommonUtils.isNotEmpty(provider.getProviderNo()))
					data.setProviderNo(provider.getProviderNo());
				if (CommonUtils.isNotEmpty(provider.getProviderAlias()))
					data.setProviderAlias(provider.getProviderAlias());
				if (CommonUtils.isNotEmpty(provider.getProviderName()))
					data.setProviderName(provider.getProviderName());
				if (CommonUtils.isNotEmpty(provider.getCreateTime()))
					data.setCreateTime(provider.getCreateTime());
				if (CommonUtils.isNotEmpty(provider.getUpdateTime()))
					data.setUpdateTime(provider.getUpdateTime());
				if (CommonUtils.isNotEmpty(provider.getServerUrl()))
					data.setServerUrl(provider.getServerUrl());
				if (CommonUtils.isNotEmpty(provider.getServerNo()))
					data.setServerNo(provider.getServerNo());

				this.providerService.modify(data);
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
	@RequestMapping("deleteProvider")
	@RequiresPermissions("provider:delete")
	public @ResponseBody ResponseEntity<String> deleteProvider(String param) {
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
			this.providerService.remove(ids);
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
	@RequestMapping("getProviderById")
	@RequiresPermissions("provider:view")
	public @ResponseBody ResponseEntity getProviderById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			Provider provider = this.providerService.searchById(id);
			if (null != provider)
				return new ResponseEntity<Provider>(provider, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}