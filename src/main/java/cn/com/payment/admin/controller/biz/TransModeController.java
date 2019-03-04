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
import cn.com.payment.admin.model.TransBrand;
import cn.com.payment.admin.model.TransMode;
import cn.com.payment.admin.service.TransBrandService;
import cn.com.payment.admin.service.TransModeService;
import cn.com.payment.admin.utils.CommonUtils;
import cn.com.payment.admin.utils.PageUtils;

@Controller
@RequestMapping("transMode")
public class TransModeController {
	private static final String PREFIX = "bas/";
	private static final Logger logger = LoggerFactory.getLogger(TransModeController.class.getName());
	@Autowired
	private TransModeService transModeService;
	@Autowired
	private TransBrandService transBrandService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("toTransModePage")
	@RequiresPermissions("transMode:view")
	public String toTransModePage() {
		return PREFIX + "transMode";
	}

	/**
	 * 获取分页数据
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getTransModePage")
	@RequiresPermissions("transMode:view")
	public @ResponseBody PageEasyUi<TransMode> getTransModePage(PageEasyUi<TransMode> page, TransMode entity) {
		PageEasyUi<TransMode> result = null;
		try {
			PageUtils.initPages(page.getPageNumber(), page.getPageSize());
			List<TransMode> list = this.transModeService.searchByProperty(entity);
			result = new PageEasyUi<TransMode>(list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	@RequestMapping("getTransModeList")
	@RequiresPermissions("transMode:view")
	public @ResponseBody List<TransMode> getTransModeList() {
		List<TransMode> result = null;
		try {
			result = this.transModeService.searchByProperty(null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 新建数据
	 * 
	 * @param transMode
	 * @return
	 */
	@RequestMapping("addTransMode")
	@RequiresPermissions("transMode:add")
	public @ResponseBody ResponseEntity<String> addTransMode(TransMode transMode) {
		if (CommonUtils.isEmpty(transMode))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			// 查询指定支付品牌
			TransBrand transBrand = transBrandService.searchById(transMode.getTransModeId());
			if (CommonUtils.isNotEmpty(transBrand))
				transMode.setTransModeName(transBrand.getTransBrandName());
			this.transModeService.create(transMode);
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
	@RequestMapping("updateTransMode")
	@RequiresPermissions("transMode:update")
	public @ResponseBody ResponseEntity<String> updateTransMode(TransMode transMode) {
		if (CommonUtils.isEmpty(transMode) || CommonUtils.isEmpty(transMode.getTransModeId()))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			TransMode data = this.transModeService.searchById(transMode.getTransModeId());
			if (CommonUtils.isNotEmpty(data)) {
				if (CommonUtils.isNotEmpty(transMode.getTransModeCode()))
					data.setTransModeCode(transMode.getTransModeCode());
				if (CommonUtils.isNotEmpty(transMode.getTransModeName()))
					data.setTransModeName(transMode.getTransModeName());
				if (CommonUtils.isNotEmpty(transMode.getState()))
					data.setState(transMode.getState());
				if (CommonUtils.isNotEmpty(transMode.getRemark()))
					data.setRemark(transMode.getRemark());

				this.transModeService.modify(data);
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
	@RequestMapping("deleteTransMode")
	@RequiresPermissions("transMode:delete")
	public @ResponseBody ResponseEntity<String> deleteTransMode(String param) {
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
			this.transModeService.remove(ids);
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
	@RequestMapping("getTransModeById")
	@RequiresPermissions("transMode:view")
	public @ResponseBody ResponseEntity getTransModeById(Long id) {
		if (CommonUtils.isEmpty(id))
			return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);

		try {
			TransMode transMode = this.transModeService.searchById(id);
			if (null != transMode)
				return new ResponseEntity<TransMode>(transMode, HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<String>(Constants.EX_APP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}